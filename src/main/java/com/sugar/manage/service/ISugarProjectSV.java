package com.sugar.manage.service;

import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.vo.TSugarProjectVO;

import java.util.List;

public interface ISugarProjectSV {

    /**
     * 获取项目列表信息
     * @param projectVO 参数对象
     * @return 返回信息
     */
    public List<TSugarProjectVO> getSugarProjectList(TSugarProjectVO projectVO);


    /**
     * 保存及更新项目信息
     * @param project 参数对象
     */
    public void saveSugarProject(TSugarProject project);
}
