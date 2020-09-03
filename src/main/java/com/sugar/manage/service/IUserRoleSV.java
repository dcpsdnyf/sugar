package com.sugar.manage.service;

import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.model.TUserRole;

import java.util.List;

public interface IUserRoleSV {

    /**
     * 根据用户获取角色列表信息
     * @param user 参数对象
     * @return 返回信息
     */
    public String getUserRoleList(TUser user);

}
