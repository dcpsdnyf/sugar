package com.sugar.manage.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.CookieUtils;
import com.sugar.common.utils.DateUtils;
import com.sugar.common.utils.JsonUtil;
import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.vo.TUserTask;
import com.sugar.manage.dao.vo.TUserTaskVO;
import com.sugar.manage.dao.vo.TableDataInfo;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.service.ITUserTaskService;
import com.sugar.manage.service.IUserRoleSV;
import com.sugar.manage.service.IUserSV;
import com.sugar.manage.vo.RoleProjectVO;
import com.sugar.manage.vo.SysResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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
    private IUserRoleSV userRoleSVE;
	@Autowired
	private ISugarProjectSV iSugarProjectSV;


	/**
	 * 指派按钮回显数据
	 *
	 * @return
	 */
	@RequestMapping("/getRollBackInfo")
	@ResponseBody
	public SysResult getRollBackInfo(HttpServletRequest request, TUserTask tUserTask) {
		if (StringUtils.isBlank(tUserTask.getProjectId())) {
			return SysResult.success("未获得项目id", null);
		}
		String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
		if (StringUtils.isBlank(userId)) {
			return SysResult.success("未获得用户信息，请登录", null);
		}
		TUserTaskVO task = itUserTaskService.getTaskInfoByUserIdAndProjectId(tUserTask.getProjectId(), userId);
		if (task != null) {
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
		return SysResult.success("成功", task);
	}

	@RequestMapping("/addEntrustInfo")
	@ResponseBody
	public SysResult addEntrustInfo(TUserTaskVO tUserTaskVO, HttpServletRequest request) {
		String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
		if (StringUtils.isBlank(userId)) {
			return SysResult.success("请先登入", null);
		}
		String roles = itUserTaskService.getAllTaskNameByProductId(Long.parseLong(userId));
		String[] roleIdArr = roles.split(",");
		boolean flag = Arrays.asList(roleIdArr).contains("9");
		if (!flag) {
			return SysResult.success("没有指派权限", null);
		}

		if (StringUtils.isBlank(tUserTaskVO.getTaskPrincipal())) {
			return SysResult.success("负责人为空", null);
		}
		if (StringUtils.isBlank(tUserTaskVO.getEstimatedTime())) {
			return SysResult.success("预计时间为空", null);
		}
		if (StringUtils.isBlank(tUserTaskVO.getProjectId())) {
			return SysResult.success("项目id为空", null);
		}

		TUserTaskVO tUserTaskVOTemp = new TUserTaskVO();
		tUserTaskVOTemp.setTaskName(tUserTaskVO.getBigId());
		tUserTaskVOTemp.setProjectId(tUserTaskVO.getProjectId());
		tUserTaskVOTemp.setTaskType("01");
		/**查询该阶段是否被指派过*/
		List<TUserTaskVO> tUserTaskVOList = itUserTaskService.selectTUserTaskList(tUserTaskVOTemp);
		if(!CollectionUtils.isEmpty(tUserTaskVOList)){
			return SysResult.success("该阶段已被指派过，请勿重复指派", null);
		}

		TUserTask tUserTask = ModelCopyUtil.copy(tUserTaskVO, TUserTask.class);
		int count = itUserTaskService.insertTUserTask(tUserTask);
		if (count <= 0) {
			return SysResult.success("插入失败", null);
		}
		//1.根据用户id去用户表获取用户名
		String username = userRoleSV.getUserIdByUerName(userId);
		if (StringUtils.isBlank(username)) {
			return SysResult.success("插入失败未获得登录信息", null);
		}
		//指派完以后顺便修改当前用户本任务的状态为完成
		itUserTaskService.changeTaskStatusByPrincipalAndProjectId("2", tUserTask.getProjectId(), username);
		return SysResult.success("插入成功", null);
	}

	/**
	 * 查询已办任务
	 *
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
		String username = userRoleSV.getUserIdByUerName(userId);
		if (StringUtils.isBlank(username)) {
			tableDataInfo.setRows(null);
			tableDataInfo.setTotal(0);
			tableDataInfo.setCode(400);
			return tableDataInfo;
		}
		//1.用用户名去查询该用户的已办任务
		PageInfo<TUserTask> tkuser = itUserTaskService.getDoneTask(username);
		if (tkuser.getList() == null) {
			tableDataInfo.setRows(null);
			tableDataInfo.setTotal(0);
			tableDataInfo.setCode(400);
			return tableDataInfo;
		}
		if (tkuser.getList() == null) {
			tableDataInfo.setRows(null);
			tableDataInfo.setTotal(0);
			tableDataInfo.setCode(400);
			return tableDataInfo;
		}
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
		TSugarProject tsuger = null;
		HashMap<String, TSugarProject> hsTPList = new HashMap<>();
		for (int i = 0; i < tsList.size(); i++) {
			tsuger = new TSugarProject();
			tsuger.setProductType(tsList.get(i).getProductType());
			tsuger.setPlatformName(tsList.get(i).getPlatformName());
			tsuger.setGroupName(tsList.get(i).getGroupName());

			hsTPList.put(String.valueOf(tsList.get(i).getId()), tsuger);
		}
		List<TUserTask> tkList = new ArrayList<>();
		for (TUserTask tku : tkuser.getList()) {
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
	 *
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
		String username = userRoleSV.getUserIdByUerName(userId);
		if (StringUtils.isBlank(username)) {
			tableDataInfo.setRows(null);
			tableDataInfo.setTotal(0);
			tableDataInfo.setCode(400);
			return tableDataInfo;
		}
		//1.用用户名去查询该用户的未办任务
		PageInfo<TUserTask> tkuser = itUserTaskService.getUndoTask(username);
		if (tkuser.getList() == null) {
			tableDataInfo.setRows(null);
			tableDataInfo.setTotal(0);
			tableDataInfo.setCode(400);
			return tableDataInfo;
		}
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
		TSugarProject tsuger = null;
		HashMap<String, TSugarProject> hsTPList = new HashMap<>();
		for (int i = 0; i < tsList.size(); i++) {
			tsuger = new TSugarProject();
			tsuger.setProductType(tsList.get(i).getProductType());
			tsuger.setPlatformName(tsList.get(i).getPlatformName());
			tsuger.setGroupName(tsList.get(i).getGroupName());

			hsTPList.put(String.valueOf(tsList.get(i).getId()), tsuger);
		}
		List<TUserTask> tkList = new ArrayList<>();
		TUser user = new TUser();
		RoleProjectVO roleProjectVO = null;
		if (StringUtils.isNotBlank(userId)) {
			user.setId(Integer.parseInt(userId));
			roleProjectVO = userRoleSVE.getUserRoleList(user);
		}
		for (TUserTask tku : tkuser.getList()) {
			TSugarProject tsugerp = hsTPList.get(tku.getProjectId());
			tku.setProductType(tsugerp.getProductType());
			tku.setPlatformName(tsugerp.getPlatformName());
			tku.setGroupName(tsugerp.getGroupName());
			tku.setAppoint(roleProjectVO.isRoleAppoint());
            tku.setDelay(roleProjectVO.isRoleDelay());
			tkList.add(tku);
		}
		tableDataInfo.setRows(tkList);
		tableDataInfo.setTotal(tkuser.getList().size());
		tableDataInfo.setCode(200);
		return tableDataInfo;
	}

	/**
	 * 申请延期接口
	 *
	 * @return
	 */
	@RequestMapping("/delay")
	@ResponseBody
	public SysResult delay(TUserTask tUserTask, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
//		if (!this.isNumeric(tUserTask.getDelayDay())) {
//			return null;
//		}
		int count = itUserTaskService.delay(userId, tUserTask.getProjectId(), tUserTask.getDelayDay());
		if (count > 0) {
			return SysResult.success("成功", null);
		}

        return null;
    }
    /**
     * 审核申请延期接口
     * @return
     */
    @RequestMapping("/examine")
    @ResponseBody
    public String examine(String projectId,String staus,String taskName,HttpServletRequest request, HttpServletResponse response) throws Exception{
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        if (StringUtils.isBlank(projectId)) {
            return null;
        }
        if (StringUtils.isBlank(staus)) {
            return null;
        }
        int count=itUserTaskService.examine(userId,projectId,staus,taskName);
        if(count>0){
            JSONObject result=new JSONObject();
            result.put("success",Boolean.TRUE);
            JsonUtil.write(response,result);
        }
        if(count==-1){
            return "null";
        }
        return "false";
    }
//    public  boolean isNumeric(String str){
//        for (int i = 0; i < str.length(); i++){
//            if (!Character.isDigit(str.charAt(i))){
//                return false;
//            }
//        }
//        return true;
//    }

	/**
	 * 被指派人填写任务信息确认完成后更新到对应项目列表
	 */
	@RequestMapping("/updateUserTask")
	@ResponseBody
	public SysResult updateUserTask(TUserTaskVO tUserTaskVO) {

		TUserTask userTask = ModelCopyUtil.copy(tUserTaskVO, TUserTask.class);
		itUserTaskService.updateUserTask(userTask);

		return SysResult.success();
	}

	/**
	 * 更新用户任务为进行中
	 *
	 * @return
	 */
	@RequestMapping("/updateUserTaskToProgressing")
	@ResponseBody
	public SysResult updateUserTaskToProgressing(TUserTaskVO tUserTaskVO) {
		TUserTask userTask = ModelCopyUtil.copy(tUserTaskVO, TUserTask.class);
		if("00".equals(tUserTaskVO.getTaskType())){
			userTask.setTaskInfo("");
		}else {
			userTask.setTaskStatus("1");
			userTask.setUpdatedTime(DateUtils.getNowDate());
		}
		itUserTaskService.updateUserTaskToProgressing(userTask);
		return SysResult.success();
	}
}
