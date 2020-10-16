package com.sugar.manage.dao.mapper;

import com.sugar.manage.dao.model.TDelay;
import com.sugar.manage.dao.model.TDelayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDelayMapper {
    long countByExample(TDelayExample example);

    int deleteByExample(TDelayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDelay record);

    int insertSelective(TDelay record);

    List<TDelay> selectByExample(TDelayExample example);

    TDelay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDelay record, @Param("example") TDelayExample example);

    int updateByExample(@Param("record") TDelay record, @Param("example") TDelayExample example);

    int updateByPrimaryKeySelective(TDelay record);

    int updateByPrimaryKey(TDelay record);
}