package com.sugar.manage.service.impl;

import com.sugar.manage.dao.mapper.TRoleMapper;
import com.sugar.manage.dao.mapper.TUserRoleMapper;
import com.sugar.manage.dao.model.*;
import com.sugar.manage.service.IUserRoleSV;
import com.sugar.manage.vo.RoleProjectVO;
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

            TUserRole userRole = userRoleList.get(0);
            List<Long> roleIdList = new ArrayList<>();

            String roleIds = userRole.getRoleId();

            String projectIds = userRole.getProjectId();

            String[] roleIdArr = roleIds.split(",");
            String[] projectIdArr = projectIds.split(",");
            //用于控制指派按钮是否显示
            if(Arrays.asList(roleIdArr).contains("9")){
                roleProjectVO.setRoleAppoint(true);
            }
            //用于控制申请延期按钮是否显示
            if(Arrays.asList(roleIdArr).contains("10")){
                roleProjectVO.setRoleDelay(true);
            }
            /*项目id*/
            Map<String,String> projectIdMap = new HashMap<>();
            for (String projectId : projectIdArr){
                projectIdMap.put(projectId+"",projectId+"");
            }
            roleProjectVO.setProjectIdMap(projectIdMap);

            /*角色id*/
            for(String roleId:roleIdArr){
                roleIdList.add(Long.parseLong(roleId));
            }


            TRoleExample exampleRole = new TRoleExample();
            TRoleExample.Criteria sqlRole = exampleRole.createCriteria();
            sqlRole.andIdIn(roleIdList);

            List<TRole> roleList = roleMapper.selectByExample(exampleRole);
            if(!CollectionUtils.isEmpty(roleList)){

                Map<String,String> roleTypeMap = new HashMap<>();
                for (TRole role : roleList){
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
