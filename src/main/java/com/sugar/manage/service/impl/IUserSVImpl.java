package com.sugar.manage.service.impl;

import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.mapper.TRoleMapper;
import com.sugar.manage.dao.mapper.TUserExMapper;
import com.sugar.manage.dao.mapper.TUserMapper;
import com.sugar.manage.dao.mapper.TUserRoleMapper;
import com.sugar.manage.dao.model.*;
import com.sugar.manage.service.IUserSV;
import com.sugar.manage.vo.TUserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class IUserSVImpl implements IUserSV {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Autowired
    private TRoleMapper roleMapper;

    @Autowired
    private TUserExMapper tUserExMapper;

    /**
     * 初始化参数信息
     * @param user
     */
    private void initParam(TUserExample.Criteria sql, TUser user){
        /*if(StringUtils.isBlank(projectVO.getCheckDeliver())){

        }*/
    }

    /**
     * 查询用户列表
     * @param user
     */
    @Override
    public TUser getUserList(TUserVO user) {

        TUserExample example = new TUserExample();
        TUserExample.Criteria sql = example.createCriteria();
        if(user.getId() != null){
            sql.andIdEqualTo(user.getId());
        }
        if(StringUtils.isNotBlank(user.getUserName())){
            sql.andUserNameEqualTo(user.getUserName());
        }
        if(StringUtils.isNotBlank(user.getUserAccount())){
            sql.andEnglishNameEqualTo(user.getUserAccount());
        }


        List<TUser> tUserList =  userMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(tUserList)){
            return tUserList.get(0);
        }

        return null;
    }

    @Override
    public boolean getAddAuthority(TUser user) {
        TUserRoleExample tUserRoleExample = new TUserRoleExample();
        TUserRoleExample.Criteria sql = tUserRoleExample.createCriteria();
        if(user.getId()!=null){
            sql.andUserIdEqualTo(Long.parseLong(user.getId().toString()));
        }
        List<TUserRole> tUserRoleList = userRoleMapper.selectByExample(tUserRoleExample);
        List<Long> roleIdList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(tUserRoleList)){
            TUserRole userRole = tUserRoleList.get(0);
            String roleIds = userRole.getRoleId();  //结果以","隔开
            String[] roleIdArr = roleIds.split(",");
            for(String roleId:roleIdArr){
                roleIdList.add(Long.parseLong(roleId));
            }

            TRoleExample roleExample = new TRoleExample();
            TRoleExample.Criteria criteria = roleExample.createCriteria();
            criteria.andIdIn(roleIdList);

            List<TRole> tRolesList = roleMapper.selectByExample(roleExample);
            if(!CollectionUtils.isEmpty(tRolesList)){
                for(TRole role:tRolesList){
                    if("add".equals(role.getRoleType())){
                        return true;
                    }
                }
            }

        }

        return false;
    }

    @Override
    public String getUserIdByUerName(String id) {

        return tUserExMapper.getUserIdByUerName(id);
    }


    @Override
    public TUserVO getUserById(Integer id) {
        TUser user = userMapper.selectByPrimaryKey(id);
        if(user!=null){
            TUserVO userVO = ModelCopyUtil.copy(user, TUserVO.class);
            return  userVO;
        }
        return null;
    }
}
