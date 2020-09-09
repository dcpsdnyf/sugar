package com.sugar.manage.vo;

import lombok.Data;

import java.util.Map;

@Data
public class RoleProjectVO {

    private String roleTypes;

    private String projectIds;


    private Map<String,String> roleTypeMap;

    private Map<String,String> projectIdMap;

    /**是否部门中层角色*/
    private boolean depMiddLelevel;

    /**是否商务经理角色*/
    private boolean businessManager;

    /**是否项目管理角色*/
    private boolean projectManagement;

    /**是否产品经理角色*/
    private boolean productManager;

    /**是否研发经理角色*/
    private boolean developManager;

    /**是否运营经理角色*/
    private boolean operateManager;

    /**是否运维经理角色*/
    private boolean maintainManager;

}
