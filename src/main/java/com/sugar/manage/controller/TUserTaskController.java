package com.sugar.manage.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.CookieUtils;
import com.sugar.common.utils.JsonUtil;
import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.dao.vo.TUserTask;
import com.sugar.manage.dao.vo.TableDataInfo;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.service.ITUserTaskService;
import com.sugar.manage.service.IUserSV;
import com.sugar.manage.vo.SysResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/TUserTaskController")
public class TUserTaskController {

@Autowired
private ITUserTaskService itUserTaskService;
@Autowired
private IUserSV userRoleSV;
@Autowired
private ISugarProjectSV iSugarProjectSV;


    /**
     * 指派按钮回显数据
     * @return
     */
    @RequestMapping("/getRollBackInfo")
    @ResponseBody
    public SysResult getRollBackInfo(HttpServletRequest request, TUserTask tUserTask) {
        if (StringUtils.isBlank(tUserTask.getProjectId())) {
            return SysResult.success("未获得项目id",null);
        }
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if (StringUtils.isBlank(userId)) {
            return SysResult.success("未获得用户信息，请登录",null);
        }
        TUserTask task = itUserTaskService.getTaskInfoByUserIdAndProjectId(tUserTask.getProjectId(),userId);
        if(task!=null) {
            if (StringUtils.isBlank(task.getProjectId()) && StringUtils.isBlank(task.getTaskPrincipal()) && StringUtils.isBlank(task.getStartTime())) {
                return SysResult.success("该用户没用指派权限", null);
            }
            switch (task.getTaskName()) {
                case "1":
                    task.setTaskName("商务进阶阶段");
                    break;
                case "2":
                    task.setTaskName("采购阶段");
                    break;
                case "3":
                    task.setTaskName("产品阶段");
                    break;
                case "4":
                    task.setTaskName("研发阶段");
                    break;
                case "5":
                    task.setTaskName("运营阶段");
                    break;
                case "6":
                    task.setTaskName("运维阶段");
                    break;
            }
        }
        return SysResult.success("成功",task);
    }

    @RequestMapping("/addEntrustInfo")
    @ResponseBody
    public SysResult addEntrustInfo(TUserTask tUserTask,HttpServletRequest request) {
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if (StringUtils.isBlank(userId)) {
            return SysResult.success("请先登入",null);
        }
       String roles = itUserTaskService.getAllTaskNameByProductId(Long.parseLong(userId));
       String[] roleIdArr = roles.split(",");
       boolean flag = Arrays.asList(roleIdArr).contains("9");
       if (!flag) {
           return SysResult.success("没有指派权限",null);
       }

        if (StringUtils.isBlank(tUserTask.getTaskPrincipal())) {
            return SysResult.success("负责人为空",null);
        }
        if (StringUtils.isBlank(tUserTask.getStartTime())) {
            return SysResult.success("开始时间为空",null);
        }
        if (StringUtils.isBlank(tUserTask.getProjectId())) {
            return SysResult.success("项目id为空",null);
        }
        //1.先判断该项目id的最新阶段，如果是被指派过的阶段则不允许新增
        List<String> hs = itUserTaskService.getAllTaskNameByProductId(tUserTask.getProjectId());

        if ("53".equals(userId) && hs.contains("1") || "33".equals(userId) && hs.contains("1")) {
            return SysResult.success("商机推进阶段已被指派过，无法重复指派",null);
        }
        if ("33".equals(userId) && hs.contains("1")) {
            return SysResult.success("商机推进阶段已被指派过，无法重复指派",null);
        }
        if ("80".equals(userId) && hs.contains("2")) {
            return SysResult.success("采购阶段已被指派过，无法重复指派",null);
        }
        if ("80".equals(userId) && hs.contains("3")) {
            return SysResult.success("产品阶段已被指派过，无法重复指派",null);
        }
        if ("80".equals(userId) && hs.contains("5")) {
            return SysResult.success("运营阶段已被指派过，无法重复指派",null);
        }
        if ("20".equals(userId) && hs.contains("4")) {
            return SysResult.success("研发阶段已被指派过，无法重复指派",null);
        }
        if ("20".equals(userId) && hs.contains("6")) {
            return SysResult.success("运维阶段已被指派过，无法重复指派",null);
        }
       int count = itUserTaskService.insertTUserTask(tUserTask);
        if (count<=0) {
            return SysResult.success("插入失败",null);
        }
        //1.根据用户id去用户表获取用户名
        String username =  userRoleSV.getUserIdByUerName(userId);
        if (StringUtils.isBlank(username)) {
            return SysResult.success("插入失败未获得登录信息",null);
        }
        //指派完以后顺便修改当前用户本任务的状态为完成
       itUserTaskService.changeTaskStatusByPrincipalAndProjectId("2",tUserTask.getProjectId(),username);
        return SysResult.success("插入成功",null);
    }

    /**
     * 查询已办任务
     * @return
     */
    @RequestMapping("/getDoneTask")
    @ResponseBody
    public TableDataInfo getDoneTask(HttpServletRequest request) {
        TableDataInfo tableDataInfo = new TableDataInfo();
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if (StringUtils.isBlank(userId)) {//如果未获得用户id不返回任何信息
            tableDataInfo.setRows(null);
            tableDataInfo.setTotal(0);
            tableDataInfo.setCode(400);
            return tableDataInfo;
        }
        //1.根据用户id去用户表获取用户名
       String username =  userRoleSV.getUserIdByUerName(userId);
        if (StringUtils.isBlank(username)) {
            tableDataInfo.setRows(null);
            tableDataInfo.setTotal(0);
            tableDataInfo.setCode(400);
            return tableDataInfo;
        }
        //1.用用户名去查询该用户的已办任务
        PageInfo<TUserTask> tkuser = itUserTaskService.getDoneTask(username);
        if (tkuser.getList().size() <= 0) {
            tableDataInfo.setRows(null);
            tableDataInfo.setTotal(0);
            tableDataInfo.setCode(400);
            return tableDataInfo;
        }
        List<Integer> projectIds = new ArrayList<>();
        for (TUserTask tk : tkuser.getList()) {
            if (StringUtils.isNotBlank(tk.getProjectId())) {
                projectIds.add(Integer.parseInt(tk.getProjectId()));
            }
        }
        List<TSugarProject> tsList = iSugarProjectSV.getProductHeaderByProjectIds(projectIds);
        if (tsList.size() <= 0) {
            tableDataInfo.setRows(null);
            tableDataInfo.setTotal(0);
            tableDataInfo.setCode(400);
            return tableDataInfo;
        }
        TSugarProject tsuger  = new TSugarProject();
        HashMap<String,TSugarProject> hsTPList = new HashMap<>();
        for (int i = 0;i < tsList.size();i++) {
            tsuger.setProductType(tsList.get(i).getProductType());
            tsuger.setPlatformName(tsList.get(i).getPlatformName());
            tsuger.setGroupName(tsList.get(i).getGroupName());

            hsTPList.put(String.valueOf(tsList.get(i).getId()),tsuger);
        }
        List<TUserTask> tkList = new ArrayList<>();
        for (TUserTask tku :tkuser.getList()) {
            TSugarProject tsugerp = hsTPList.get(tku.getProjectId());
            tku.setProductType(tsugerp.getProductType());
            tku.setPlatformName(tsugerp.getPlatformName());
            tku.setGroupName(tsugerp.getGroupName());
            tkList.add(tku);
        }
        tableDataInfo.setRows(tkList);
        tableDataInfo.setTotal(tkuser.getList().size());
        tableDataInfo.setCode(200);
        return tableDataInfo;
    }
    /**
     * 查询未办任务
     * @return
     */
    @RequestMapping("/getUndoTask")
    @ResponseBody
    public TableDataInfo getUndoTask(HttpServletRequest request) {
        TableDataInfo tableDataInfo = new TableDataInfo();
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if (StringUtils.isBlank(userId)) {//如果未获得用户id不返回任何信息
            tableDataInfo.setRows(null);
            tableDataInfo.setTotal(0);
            tableDataInfo.setCode(400);
            return tableDataInfo;
        }
        //1.根据用户id去用户表获取用户名
        String username =  userRoleSV.getUserIdByUerName(userId);
        if (StringUtils.isBlank(username)) {
            tableDataInfo.setRows(null);
            tableDataInfo.setTotal(0);
            tableDataInfo.setCode(400);
            return tableDataInfo;
        }
        //1.用用户名去查询该用户的未办任务
        PageInfo<TUserTask> tkuser = itUserTaskService.getUndoTask(username);
        if (tkuser.getList().size() <= 0) {
            tableDataInfo.setRows(null);
            tableDataInfo.setTotal(0);
            tableDataInfo.setCode(400);
            return tableDataInfo;
        }
        List<Integer> projectIds = new ArrayList<>();
        for (TUserTask tk : tkuser.getList()) {
            if (StringUtils.isNotBlank(tk.getProjectId())) {
                projectIds.add(Integer.parseInt(tk.getProjectId()));
            }
        }
        List<TSugarProject> tsList = iSugarProjectSV.getProductHeaderByProjectIds(projectIds);
        if (tsList.size() <= 0) {
            tableDataInfo.setRows(null);
            tableDataInfo.setTotal(0);
            tableDataInfo.setCode(400);
            return tableDataInfo;
        }
        TSugarProject tsuger  = new TSugarProject();
        HashMap<String,TSugarProject> hsTPList = new HashMap<>();
        for (int i = 0;i < tsList.size();i++) {
            tsuger.setProductType(tsList.get(i).getProductType());
            tsuger.setPlatformName(tsList.get(i).getPlatformName());
            tsuger.setGroupName(tsList.get(i).getGroupName());

            hsTPList.put(String.valueOf(tsList.get(i).getId()),tsuger);
        }
        List<TUserTask> tkList = new ArrayList<>();
        for (TUserTask tku :tkuser.getList()) {
            TSugarProject tsugerp = hsTPList.get(tku.getProjectId());
            tku.setProductType(tsugerp.getProductType());
            tku.setPlatformName(tsugerp.getPlatformName());
            tku.setGroupName(tsugerp.getGroupName());
            tkList.add(tku);
        }
        tableDataInfo.setRows(tkList);
        tableDataInfo.setTotal(tkuser.getList().size());
        tableDataInfo.setCode(200);
        return tableDataInfo;
    }
    /**
     * 申请延期接口
     * @return
     */
    @RequestMapping("/delay")
    @ResponseBody
    public String delay(TUserTask tUserTask,HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        if (StringUtils.isBlank(tUserTask.getProjectId())) {
            return null;
        }
        if (StringUtils.isBlank(tUserTask.getDelayDay())) {
            return null;
        }
        if (!this.isNumeric(tUserTask.getDelayDay())) {
            return null;
        }
       int count = itUserTaskService.delay(userId,tUserTask.getProjectId(),tUserTask.getDelayDay());
        if (count >0 ) {
            JSONObject result=new JSONObject();
            result.put("success",Boolean.TRUE);
            JsonUtil.write(response,result);
        }

        return null;
    }


    public  boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
