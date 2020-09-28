package com.sugar.manage.service;

import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.vo.TUserVO;


public interface IUserSV {

    /**
     * 获取用户列表信息
     * @param tUser 参数对象
     * @return 返回信息
     */
    public TUser getUserList(TUserVO tUser);

    /**
     * 查询用户是否具有新增权限
     * @param user
     * @return
     */
    public boolean getAddAuthority(TUser user);

    public String getUserIdByUerName(String id);
}
