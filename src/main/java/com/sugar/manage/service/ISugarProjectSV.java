package com.sugar.manage.service;

import com.github.pagehelper.PageInfo;
import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.dto.TSugarProjectReqDTO;
import com.sugar.manage.dao.vo.GroupSugarList;
import com.sugar.manage.vo.TSugarProjectVO;

import java.util.List;

public interface ISugarProjectSV {

    /**
     * 获取项目列表信息
     * @param projectVO 参数对象
     * @return 返回信息
     */
    public PageInfo<TSugarProjectWithBLOBs> getSugarProjectList(TSugarProjectVO projectVO);

    public GroupSugarList getSugarProjectGroupList(TSugarProjectVO vo);

    /**
     * 保存及更新项目信息
     * @param vo 参数对象
     */
    public void saveSugarProject(TSugarProjectVO vo);

    public int updateSugarProject(TSugarProjectVO vo);

    public int deleteByPrimaryKey(TSugarProjectWithBLOBs tSugarProject);

    /**
     * 查询sugar管理列表
     *
     * @param sugarList sugar管理
     * @return sugar管理集合
     */
    public List<TSugarProjectWithBLOBs> selectSugarList(TSugarProjectWithBLOBs sugarList);


    /**
     * 根据平台名称去查询数据
     * @param platformName
     * @return
     */
    public TSugarProjectVO selectSugarProjectByName(String platformName);

    public TSugarProjectVO getSugarProjectById(TSugarProjectVO vo);
}
