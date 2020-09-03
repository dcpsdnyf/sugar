package com.sugar.manage.service;

import com.sugar.manage.dao.model.TUser;


public interface IUserSV {

    /**
     * 获取用户列表信息
     * @param tUser 参数对象
     * @return 返回信息
     */
    public TUser getUserList(TUser tUser);
}
