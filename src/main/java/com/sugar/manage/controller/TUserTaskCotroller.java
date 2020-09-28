package com.sugar.manage.controller;

import com.sugar.common.utils.CookieUtils;
import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.vo.TUserTask;
import com.sugar.manage.service.ITUserTaskService;
import com.sugar.manage.service.IUserSV;
import com.sugar.util.ResultMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/TUserTaskCotroller")
public class TUserTaskCotroller {

@Autowired
private ITUserTaskService itUserTaskService;
@Autowired
private IUserSV iUserSV;

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

}
