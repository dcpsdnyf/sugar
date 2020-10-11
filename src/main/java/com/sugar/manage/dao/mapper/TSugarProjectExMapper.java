package com.sugar.manage.dao.mapper;

import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TSugarProjectExMapper {

    /** 新增项目可返回主键 */
    public int insertSugarProject(TSugarProjectWithBLOBs sugarProject);
}