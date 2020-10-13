package com.sugar.manage.dao.mapper;

import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TSugarProjectExMapper {

    /** 新增项目可返回主键 */
    public int insertSugarProject(TSugarProjectWithBLOBs sugarProject);

    Long getProjectId(String taskPrincipal);

    List<TSugarProject> getProductHeaderByProjectIds(@Param("projectIds") List<Integer> projectIds);
}