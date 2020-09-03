package com.sugar.manage.service.impl;

import com.sugar.manage.dao.mapper.TUserMapper;
import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.model.TUserExample;
import com.sugar.manage.service.IUserSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class IUserSVImpl implements IUserSV {

    @Autowired
    private TUserMapper userMapper;

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
    public TUser getUserList(TUser user) {

        TUserExample example = new TUserExample();
        TUserExample.Criteria sql = example.createCriteria();
        if(user.getId() != null){
            sql.andIdEqualTo(user.getId());
        }
        if(user.getUserName() != null){
            sql.andUserNameEqualTo(user.getUserName());
        }
        if(user.getEnglishName() != null){
            sql.andEnglishNameEqualTo(user.getEnglishName());
        }
        this.initParam(sql, user);

        List<TUser> tUserList =  userMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(tUserList)){
            return tUserList.get(0);
        }

        return null;
    }

}
