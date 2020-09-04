package com.sugar.manage.service;

import com.github.pagehelper.PageInfo;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.vo.TSugarProjectVO;

import java.util.List;

public interface ISugarProjectSV {

    /**
     * 获取项目列表信息
     * @param projectVO 参数对象
     * @return 返回信息
     */
    public PageInfo<TSugarProjectWithBLOBs> getSugarProjectList(TSugarProjectVO projectVO);

    /**
     * 保存及更新项目信息
     * @param record 参数对象
     */
    public void saveSugarProject(TSugarProjectWithBLOBs record);

    public int updateSugarProject(TSugarProjectWithBLOBs project);

    public int deleteByPrimaryKey(TSugarProjectWithBLOBs tSugarProject);

    /**
     * 查询sugar管理列表
     *
     * @param sugarList sugar管理
     * @return sugar管理集合
     */
    public List<TSugarProjectWithBLOBs> selectSugarList(TSugarProjectWithBLOBs sugarList);

}
