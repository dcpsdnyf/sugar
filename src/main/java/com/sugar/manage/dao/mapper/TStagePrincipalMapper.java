package com.sugar.manage.dao.mapper;

import com.sugar.manage.dao.model.TStagePrincipal;
import com.sugar.manage.dao.model.TStagePrincipalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStagePrincipalMapper {
    long countByExample(TStagePrincipalExample example);

    int deleteByExample(TStagePrincipalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStagePrincipal record);

    int insertSelective(TStagePrincipal record);

    List<TStagePrincipal> selectByExample(TStagePrincipalExample example);

    TStagePrincipal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStagePrincipal record, @Param("example") TStagePrincipalExample example);

    int updateByExample(@Param("record") TStagePrincipal record, @Param("example") TStagePrincipalExample example);

    int updateByPrimaryKeySelective(TStagePrincipal record);

    int updateByPrimaryKey(TStagePrincipal record);
}