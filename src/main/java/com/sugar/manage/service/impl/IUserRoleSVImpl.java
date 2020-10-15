package com.sugar.manage.service.impl;

import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.mapper.TRoleMapper;
import com.sugar.manage.dao.mapper.TUserMapper;
import com.sugar.manage.dao.mapper.TUserRoleMapper;
import com.sugar.manage.dao.model.*;
import com.sugar.manage.service.IUserRoleSV;
import com.sugar.manage.vo.RoleProjectVO;
import com.sugar.manage.vo.TUserRoleVO;
import com.sugar.manage.vo.TUserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class IUserRoleSVImpl implements IUserRoleSV {

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Autowired
    private TRoleMapper roleMapper;

    @Autowired
    private TUserMapper userMapper;

    /**
     * 初始化参数信息
     * @param user
     */
    private void initParam(TUserRoleExample.Criteria sql, TUser user){

    }

    /**
     * 根据用户查询角色列表
     * @param user
     * @return
     */
    @Override
    public RoleProjectVO getUserRoleList(TUser user) {
        RoleProjectVO roleProjectVO = new RoleProjectVO();

        TUserRoleExample example = new TUserRoleExample();
        TUserRoleExample.Criteria sql = example.createCriteria();
        sql.andUserIdEqualTo(Long.parseLong(user.getId().toString()));

        List<TUserRole> userRoleList = userRoleMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userRoleList)){

            TUserRole userRole = userRoleList.get(0);


            String roleIds = userRole.getRoleId();


            if(StringUtils.isNotBlank(roleIds)){
                String[] roleIdArr = roleIds.split(",");
                List<String> roleIdList = Arrays.asList(roleIdArr);
                //用于控制指派按钮是否显示
                if(roleIdList.contains("9")){
                    roleProjectVO.setRoleAppoint(true);
                }
                //用于控制申请延期按钮是否显示
                if(roleIdList.contains("10")){
                    roleProjectVO.setRoleDelay(true);
                }
                if(roleIdList.contains("11")){
                    roleProjectVO.setViewAllProject(true);
                }
            }



        }
        return roleProjectVO;
    }

    @Override
    public List<TUserVO> getAuthorityToAddUsers(TUserRoleVO vo) {
        List<TUserVO> userVOList = new ArrayList<>();

        TUserRoleExample example = new TUserRoleExample();
        TUserRoleExample.Criteria sql = example.createCriteria();
        if(StringUtils.isNotBlank(vo.getRoleId())){
            sql.andRoleIdLike("%" + vo.getRoleId() + "%");
        }

        List<TUserRole> userRoleList = userRoleMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userRoleList)){
            TUser user = null;
            List<String> roleIds = null;
            for(TUserRole userRole : userRoleList){
                if(StringUtils.isNotBlank(userRole.getRoleId())){
                    roleIds = Arrays.asList(userRole.getRoleId().split(","));

                    if(!CollectionUtils.isEmpty(roleIds)){
                        if(roleIds.contains("8") && userRole.getUserId()!=null){
                            user = userMapper.selectByPrimaryKey(userRole.getUserId().intValue());
                            if(user!=null){
                                TUserVO userVO = ModelCopyUtil.copy(user, TUserVO.class);
                                userVOList.add(userVO);
                            }
                        }
                    }

                }
            }
        }

        return userVOList;
    }
}
