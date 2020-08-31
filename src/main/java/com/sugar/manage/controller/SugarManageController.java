package com.sugar.manage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.vo.TSugarProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sugarManage
 * @description: 项目进度管理业务功能
 * @author: liangbq
 * @create: 2020-08-30 00:43
 */
@Controller
@RequestMapping("/sugarManage")
public class SugarManageController {

    @Autowired
    private ISugarProjectSV sugarProjectSV;

    /**
     * 项目进度初始化界面
     * @return
     */
    @RequestMapping("/init")
    public String initSugarManage(){

        return "/sugarManage/sugarManage";
    }

    /**
     * 获取项目列表信息记录
     * @return
     */
    @RequestMapping("/getSugarProjectList")
    @ResponseBody
    public String getSugarProjectList(){
        TSugarProjectVO projectVO = new TSugarProjectVO();
        List<TSugarProjectVO> sugarProjectList = sugarProjectSV.getSugarProjectList(projectVO);
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(sugarProjectList));
        return array.toString();
    }
    /**
     * 新增项目列表信息记录
     * @return
     */
    @RequestMapping("/newlyAdded")
    public String newlyAdded(TSugarProject tSugarProject){
        sugarProjectSV.saveSugarProject(tSugarProject);
        return "redirect:/sugarManage/init";
    }
}
