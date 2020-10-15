package com.sugar.manage.dao.mapper;

import com.sugar.manage.dao.model.StageTime;
import com.sugar.manage.dao.model.StageTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StageTimeMapper {
    long countByExample(StageTimeExample example);

    int deleteByExample(StageTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StageTime record);

    int insertSelective(StageTime record);

    List<StageTime> selectByExample(StageTimeExample example);

    StageTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StageTime record, @Param("example") StageTimeExample example);

    int updateByExample(@Param("record") StageTime record, @Param("example") StageTimeExample example);

    int updateByPrimaryKeySelective(StageTime record);

    int updateByPrimaryKey(StageTime record);
}