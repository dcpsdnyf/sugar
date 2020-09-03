package com.sugar.manage.dao.mapper;

import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.dao.model.TSugarProjectExample;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface TSugarProjectMapper {

    long countByExample(TSugarProjectExample example);

    int deleteByExample(TSugarProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSugarProjectWithBLOBs record);

    int insertSelective(TSugarProjectWithBLOBs record);

    List<TSugarProjectWithBLOBs> selectByExampleWithBLOBs(TSugarProjectExample example);

    List<TSugarProject> selectByExample(TSugarProjectExample example);

    TSugarProjectWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSugarProjectWithBLOBs record, @Param("example") TSugarProjectExample example);

    int updateByExampleWithBLOBs(@Param("record") TSugarProjectWithBLOBs record, @Param("example") TSugarProjectExample example);

    int updateByExample(@Param("record") TSugarProject record, @Param("example") TSugarProjectExample example);

    int updateByPrimaryKeySelective(TSugarProjectWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TSugarProjectWithBLOBs record);

    int updateByPrimaryKey(TSugarProject record);
}