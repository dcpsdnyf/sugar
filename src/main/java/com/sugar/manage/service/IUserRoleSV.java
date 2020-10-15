package com.sugar.manage.service;

import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.model.TUserRole;
import com.sugar.manage.vo.RoleProjectVO;
import com.sugar.manage.vo.TUserRoleVO;
import com.sugar.manage.vo.TUserVO;

import java.util.List;

public interface IUserRoleSV {

    /**
     * 根据用户获取角色列表及项目列表信息
     * @param user 参数对象
     * @return 返回信息
     */
    public RoleProjectVO getUserRoleList(TUser user);

    /**
     * 查询有新增权限的用户
     * @param vo
     * @return
     */
    public List<TUserVO> getAuthorityToAddUsers(TUserRoleVO vo);

}
