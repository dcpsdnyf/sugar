package com.sugar.manage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sugar.common.utils.CookieUtils;
import com.sugar.common.utils.JsonUtil;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.service.IUserRoleSV;
import com.sugar.manage.service.IUserSV;
import com.sugar.manage.vo.TSugarProjectVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private IUserSV userSV;

    @Autowired
    private IUserRoleSV userRoleSV;


    /**
     * 项目进度初始化界面
     * @return
     */
    @RequestMapping("/init")
    public String initSugarManage(HttpServletResponse response, HttpServletRequest request, TUser tUser){
        String cookie = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if(!StringUtils.isBlank(cookie)){

        }else {
            tUser = userSV.getUserList(tUser);
            if(tUser != null){
                CookieUtils.setCookie(response, "SUGAR_USER_ID","" + tUser.getId());
            }
        }
        return "/sugarManage/sugarManage";
    }

    /**
     * 获取项目列表信息记录
     * @return
     */
    @RequestMapping("/getSugarProjectList")
    @ResponseBody
    public String getSugarProjectList(HttpServletRequest request, TSugarProjectVO projectVO, TUser user){

        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        user.setId(Integer.parseInt(userId));
        String userRole = userRoleSV.getUserRoleList(user);

        if(!StringUtils.isBlank(userRole)){
            projectVO.setRoleType(userRole);
        }

        List<TSugarProjectVO> sugarProjectList = sugarProjectSV.getSugarProjectList(projectVO);
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(sugarProjectList));
        if(array == null){
            return null;
        }
        return array.toString();
    }

    /**
     * 新增项目列表信息记录
     * @return
     */
    @RequestMapping("/newlyAdded")
    public String newlyAdded(HttpServletRequest request, TSugarProjectWithBLOBs record){
        // String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        // TUser user = new TUser();
        // user.setId(Integer.parseInt(userId));
        record.setStatus("01");
        sugarProjectSV.saveSugarProject(record);
        return "redirect:/sugarManage/init";
    }

    /**
     * 更新项目列表信息记录
     * @return
     */
    @RequestMapping("/Edit")
    public String updateSugarProject(TSugarProjectWithBLOBs tSugarProject, HttpServletResponse response) throws Exception {
        int a=sugarProjectSV.updateSugarProject(tSugarProject);
            if (a>0){
                JSONObject result=new JSONObject();
                result.put("success",Boolean.TRUE);
                JsonUtil.write(response,result);
            }
       return null;
    }
    @RequestMapping("/delete")
    public String deleteByPrimaryKey(TSugarProjectWithBLOBs tSugarProject, HttpServletResponse response) throws Exception {
        tSugarProject.setStatus("99");
        int a=sugarProjectSV.deleteByPrimaryKey(tSugarProject);
        if (a>0){
            JSONObject result=new JSONObject();
            result.put("success",Boolean.TRUE);
            JsonUtil.write(response,result);
        }
        return null;
    }

}
