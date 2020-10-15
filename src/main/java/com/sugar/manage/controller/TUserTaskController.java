package com.sugar.manage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.CookieUtils;
import com.sugar.common.utils.DateUtils;
import com.sugar.common.utils.JsonUtil;
import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.model.TUserTask;
import com.sugar.manage.dao.vo.TUserTaskVO;
import com.sugar.manage.service.*;
import com.sugar.manage.vo.RoleProjectVO;
import com.sugar.manage.vo.StageTimeVO;
import com.sugar.manage.vo.SysResult;
import com.sugar.manage.vo.TUserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/TUserTaskController")
public class TUserTaskController {

	@Autowired
	private ITUserTaskService itUserTaskService;
	@Autowired
	private IUserSV userSV;
	@Autowired
	private IUserRoleSV userRoleSVE;
	@Autowired
	private ISugarProjectSV iSugarProjectSV;
	@Autowired
	private StageTimeSV stageTimeSV;

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

		if("00".equals(task.getTaskType())){//指派下发的任务
			StageTimeVO vo = new StageTimeVO();
			vo.setStageType("02");
			List<StageTimeVO> stageTimeVOList = stageTimeSV.selectStageTimeList(vo);
			if(!CollectionUtils.isEmpty(stageTimeVOList)){
				StageTimeVO timeVO = stageTimeVOList.get(0);
				Integer day = timeVO.getStageDay();
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE,day);

				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
				String estimatedTime = sdf.format(calendar.getTime());
				task.setEstimatedTime(estimatedTime);

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
		if (!CollectionUtils.isEmpty(tUserTaskVOList)) {
			return SysResult.success("该阶段已被指派过，请勿重复指派", null);
		}

		TUserTask tUserTask = ModelCopyUtil.copy(tUserTaskVO, TUserTask.class);
		int count = itUserTaskService.insertTUserTask(tUserTask);
		if (count <= 0) {
			return SysResult.success("插入失败", null);
		}
		//1.根据用户id去用户表获取用户名
		String username = userSV.getUserIdByUerName(userId);
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
	public String getDoneTask(HttpServletRequest request, TUserTaskVO vo) {
		JSONArray array = new JSONArray();
		String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
		if (StringUtils.isNotBlank(userId)) {//如果未获得用户id不返回任何信息
			TUserVO userVO = userSV.getUserById(Integer.parseInt(userId));

			PageInfo<TUserTaskVO> doneTaskPage = new PageInfo<>();
			if (userVO != null && StringUtils.isNotBlank(userVO.getUserName())) {
				vo.setTaskPrincipal(userVO.getUserName());
				doneTaskPage = itUserTaskService.getDoneTask(vo);
			}
			if (!CollectionUtils.isEmpty(doneTaskPage.getList())) {
				array = JSONArray.parseArray(JSON.toJSONString(doneTaskPage.getList()));
			}
		}
		return array.toString();
	}

	/**
	 * 查询未办任务
	 *
	 * @return
	 */
	@RequestMapping("/getUndoTask")
	@ResponseBody
	public String getUndoTask(HttpServletRequest request, TUserTaskVO vo) {
		JSONArray array = new JSONArray();
		String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
		if (StringUtils.isNotBlank(userId)) {
			TUser user = new TUser();
			user.setId(Integer.parseInt(userId));
			RoleProjectVO roleProjectVO = userRoleSVE.getUserRoleList(user);

			TUserVO userVO = userSV.getUserById(Integer.parseInt(userId));

			PageInfo<TUserTaskVO> undoTaskPage = new PageInfo<>();

			if (userVO != null && StringUtils.isNotBlank(userVO.getUserName())) {
				vo.setTaskPrincipal(userVO.getUserName());
				undoTaskPage = itUserTaskService.getUndoTask(vo);
			}
			if (!CollectionUtils.isEmpty(undoTaskPage.getList())) {
				List<TUserTaskVO> userTaskVOList = new ArrayList<>();
				for (TUserTaskVO userTaskVO : undoTaskPage.getList()) {
					userTaskVO.setAppoint(roleProjectVO.isRoleAppoint());
					userTaskVO.setDelay(roleProjectVO.isRoleDelay());
					userTaskVOList.add(userTaskVO);
				}
				if (!CollectionUtils.isEmpty(userTaskVOList)) {
					array = JSONArray.parseArray(JSON.toJSONString(userTaskVOList));
				}

			}
		}
		return array.toString();
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
	 *
	 * @return
	 */
	@RequestMapping("/examine")
	@ResponseBody
	public String examine(String projectId, String staus, String taskName, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		int count = itUserTaskService.examine(userId, projectId, staus, taskName);
		if (count > 0) {
			JSONObject result = new JSONObject();
			result.put("success", Boolean.TRUE);
			JsonUtil.write(response, result);
		}
		if (count == -1) {
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

		itUserTaskService.updateUserTask(tUserTaskVO);

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
		userTask.setTaskStatus("1");
		userTask.setUpdatedTime(DateUtils.getNowDate());
		itUserTaskService.updateUserTaskToProgressing(userTask);
		return SysResult.success();
	}
}
