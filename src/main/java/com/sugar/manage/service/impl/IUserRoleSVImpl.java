package com.sugar.manage.service.impl;

import com.sugar.manage.dao.mapper.TRoleMapper;
import com.sugar.manage.dao.mapper.TUserRoleMapper;
import com.sugar.manage.dao.model.*;
import com.sugar.manage.service.IUserRoleSV;
import com.sugar.manage.vo.RoleProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public RoleProjectVO getUserRoleList(TUser user) {
        RoleProjectVO roleProjectVO = new RoleProjectVO();

        TUserRoleExample example = new TUserRoleExample();
        TUserRoleExample.Criteria sql = example.createCriteria();
        sql.andUserIdEqualTo(Long.parseLong(user.getId().toString()));
        this.initParam(sql, user);

        List<TUserRole> userRoleList = userRoleMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userRoleList)){

            List<Long> longList = new ArrayList<>();

            //String projectIds = "";
            Map<String,String> projectIdMap = new HashMap<>();
            for (TUserRole userRole : userRoleList){
                //projectIds += userRole.getProjectId()+",";
                projectIdMap.put(userRole.getProjectId()+"",userRole.getProjectId()+"");
                longList.add(userRole.getRoleId());
            }

            roleProjectVO.setProjectIdMap(projectIdMap);

            TRoleExample exampleRole = new TRoleExample();
            TRoleExample.Criteria sqlRole = exampleRole.createCriteria();
            sqlRole.andIdIn(longList);

            List<TRole> roleList = roleMapper.selectByExample(exampleRole);
            if(!CollectionUtils.isEmpty(roleList)){

                Map<String,String> roleTypeMap = new HashMap<>();
                //String roleType = "";
                for (TRole role : roleList){
                    //roleType += role.getRoleType() + ",";
                    roleTypeMap.put(role.getRoleType()+"",role.getRoleName());
                }
                roleProjectVO.setRoleTypeMap(roleTypeMap);

                if(roleTypeMap.containsKey("1")){
                    roleProjectVO.setDepMiddLelevel(true);
                }
                if(roleTypeMap.containsKey("2")){
                    roleProjectVO.setBusinessManager(true);
                }
                if(roleTypeMap.containsKey("3")){
                    roleProjectVO.setProjectManagement(true);
                }
                if(roleTypeMap.containsKey("4")){
                    roleProjectVO.setProductManager(true);
                }
                if(roleTypeMap.containsKey("5")){
                    roleProjectVO.setDevelopManager(true);
                }
                if(roleTypeMap.containsKey("6")){
                    roleProjectVO.setOperateManager(true);
                }
                if(roleTypeMap.containsKey("7")){
                    roleProjectVO.setMaintainManager(true);
                }
            }

        }
        return roleProjectVO;
    }
}
