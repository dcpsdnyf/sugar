package com.sugar.manage.controller;

import com.sugar.common.utils.CookieUtils;
import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.vo.TUserTask;
import com.sugar.manage.service.ITUserTaskService;
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



    /**
     * 指派按钮回显数据
     * @return
     */
    @RequestMapping("/getRollBackInfo")
    @ResponseBody
    public ResultMessage getRollBackInfo(HttpServletRequest request, TUserTask tUserTask) {
        ResultMessage resultMessage = new ResultMessage();
        if (StringUtils.isBlank(tUserTask.getProjectId())) {
            resultMessage.setResultMassage("未获得项目id");
            resultMessage.setSuccess(false);
            return resultMessage;
        }
        TUser user = new TUser();
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if (StringUtils.isBlank(userId)) {
            resultMessage.setResultMassage("未获得用户信息，请登录");
            resultMessage.setSuccess(false);
            return resultMessage;
        }
        TUserTask task = itUserTaskService.getTaskInfoByUserIdAndProjectId(tUserTask.getProjectId(),userId);
        resultMessage.setResultMassage("指派信息获取成功");
        resultMessage.setSuccess(true);
        resultMessage.setData(task);
        return resultMessage;
    }

    @RequestMapping("/addEntrustInfo")
    @ResponseBody
    public SysResult addEntrustInfo(TUserTask tUserTask,HttpServletRequest request) {
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");

        ResultMessage resultMessage = new ResultMessage();
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


}
