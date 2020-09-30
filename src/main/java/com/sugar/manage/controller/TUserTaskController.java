package com.sugar.manage.controller;

import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.CookieUtils;
import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.vo.TUserTask;
import com.sugar.manage.dao.vo.TableDataInfo;
import com.sugar.manage.service.ITUserTaskService;
import com.sugar.manage.service.IUserRoleSV;
import com.sugar.manage.service.IUserSV;
import com.sugar.manage.vo.SysResult;
import com.sugar.util.ResultMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/TUserTaskController")
public class TUserTaskController {

@Autowired
private ITUserTaskService itUserTaskService;
@Autowired
private IUserSV userRoleSV;


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
        switch(task.getTaskName()){
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

        if (StringUtils.isBlank( tUserTask.getTaskPrincipal())) {
            return SysResult.success("负责人为空",null);
        }
        if (StringUtils.isBlank( tUserTask.getStartTime())) {
            return SysResult.success("开始时间为空",null);
        }
        if (StringUtils.isBlank( tUserTask.getProjectId())) {
            return SysResult.success("项目id为空",null);
        }
        //1.先判断该项目id的最新阶段，如果是被指派过的阶段则不允许新增
        List<String> hs = itUserTaskService.getAllTaskNameByProductId(tUserTask.getProjectId());

        if ("53".equals(userId) && hs.contains("1")) {
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

        tableDataInfo.setRows(tkuser.getList());
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
        tableDataInfo.setRows(tkuser.getList());
        tableDataInfo.setTotal(tkuser.getList().size());
        tableDataInfo.setCode(200);
        return tableDataInfo;
    }
}
