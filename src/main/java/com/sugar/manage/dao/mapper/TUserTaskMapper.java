package com.sugar.manage.dao.mapper;

import com.sugar.manage.dao.model.TUserTask;
import com.sugar.manage.dao.model.TUserTaskExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TUserTaskMapper {
    long countByExample(TUserTaskExample example);

    int deleteByExample(TUserTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserTask record);

    int insertSelective(TUserTask record);

    List<TUserTask> selectByExample(TUserTaskExample example);

    TUserTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserTask record, @Param("example") TUserTaskExample example);

    int updateByExample(@Param("record") TUserTask record, @Param("example") TUserTaskExample example);

    int updateByPrimaryKeySelective(TUserTask record);

    int updateByPrimaryKey(TUserTask record);
}