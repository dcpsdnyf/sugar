package com.sugar.manage.service.impl;

import com.sugar.manage.dao.mapper.TRoleMapper;
import com.sugar.manage.dao.mapper.TUserRoleMapper;
import com.sugar.manage.dao.model.*;
import com.sugar.manage.service.IUserRoleSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class IUserRoleSVImpl implements IUserRoleSV {

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Autowired
    private TRoleMapper roleMapper;

    /**
     * 初始化参数信息
     * @param user
     */
    private void initParam(TUserRoleExample.Criteria sql, TUser user){
        /*if(StringUtils.isBlank(projectVO.getCheckDeliver())){

        }*/

    }

    /**
     * 根据用户查询角色列表
     * @param user
     * @return
     */
    @Override
    public String getUserRoleList(TUser user) {

        TUserRoleExample example = new TUserRoleExample();
        TUserRoleExample.Criteria sql = example.createCriteria();
        sql.andUserIdEqualTo(Long.parseLong(user.getId().toString()));
        this.initParam(sql, user);

        List<TUserRole> userRoleList = userRoleMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userRoleList)){

            List<Long> longList = new ArrayList<>();

            for (TUserRole userRole : userRoleList){
                longList.add(userRole.getRoleId());
            }

            TRoleExample exampleRole = new TRoleExample();
            TRoleExample.Criteria sqlRole = exampleRole.createCriteria();
            sqlRole.andIdIn(longList);

            List<TRole> roleList = roleMapper.selectByExample(exampleRole);
            if(!CollectionUtils.isEmpty(roleList)){
                String roleType = "";
                for (TRole role : roleList){
                    roleType += role.getRoleType() + ",";
                }
                return roleType;
            }

        }
        return null;
    }
}
