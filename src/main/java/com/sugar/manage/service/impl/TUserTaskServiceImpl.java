package com.sugar.manage.service.impl;

import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.DateUtils;
import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.mapper.*;
import com.sugar.manage.dao.model.*;
import com.sugar.manage.dao.vo.TDelayVO;
import com.sugar.manage.dao.vo.TUserTaskVO;
import com.sugar.manage.service.ITUserTaskService;
import com.sugar.manage.vo.StageTimeVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-09-28
 */
@Service
public class TUserTaskServiceImpl implements ITUserTaskService {
	@Autowired
	private TUserTaskExMapper tUserTaskMapper;
	@Autowired
	private TUserRoleMapper tUserRoleMapper;
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TDelayExMapper tDelayMapper;
	@Autowired
	private TSugarProjectMapper tSugarProjectMapper;
	@Autowired
	private TUserTaskMapper taskMapper;
	@Autowired
	private TStagePrincipalMapper stagePrincipalMapper;
	@Autowired
	private StageTimeMapper stageTimeMapper;
	@Autowired
	private TUserExMapper tUserExMapper;
	@Autowired
	private TUserRoleExMapper userRoleExMapper;
	@Autowired
	private TDelayMapper delayMapper;

	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	@Override
	public TUserTask selectTUserTaskById(Long id) {
		return tUserTaskMapper.selectTUserTaskById(id);
	}

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param tUserTaskVO 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<TUserTaskVO> selectTUserTaskList(TUserTaskVO tUserTaskVO) {
        TUserTask tUserTask = ModelCopyUtil.copy(tUserTaskVO, TUserTask.class);
        List<TUserTask> tUserTaskList = tUserTaskMapper.selectTUserTaskList(tUserTask);
        if(!CollectionUtils.isEmpty(tUserTaskList)){
            List<TUserTaskVO> tUserTaskVOList = ModelCopyUtil.copyToList(tUserTaskList, TUserTaskVO.class);
            return tUserTaskVOList;
        }
        return null;
	}

	/**
	 * 用户指派生成任务数据
	 *
	 * @param tUserTask
	 * @return 结果
	 */
	@Override
	public int insertTUserTask(TUserTask tUserTask) {
		TUserTask hadUserTask = new TUserTask();
		hadUserTask.setProjectId(tUserTask.getProjectId());
		hadUserTask.setTaskType("01");
		//查询任务列表是否有任务数据
		List<TUserTask> taskList = tUserTaskMapper.selectTUserTaskList(hadUserTask);
		HashMap<String, String> taskMap = new HashMap<>();

		if (!CollectionUtils.isEmpty(taskList)) {
			for (TUserTask task : taskList) {
				taskMap.put(task.getTaskName(), task.getTaskName());
			}
		}

		TSugarProjectWithBLOBs project = tSugarProjectMapper.selectByPrimaryKey(Integer.parseInt(tUserTask.getProjectId()));

		if (project != null) {
			tUserTask.setPrincipal(tUserTask.getTaskPrincipal());
			tUserTask.setGroupName(project.getGroupName());
			tUserTask.setProductType(project.getProductType());
			tUserTask.setPlatformName(project.getPlatformName());
		}
		tUserTask.setCreatedTime(DateUtils.getNowDate());
		tUserTask.setStartTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm:ss"));
		tUserTask.setStatus("01");
		tUserTask.setTaskType("01");
		tUserTask.setTaskStatus("0");
		if (CollectionUtils.isEmpty(taskList)) {
			tUserTask.setTaskName("1");
			tUserTask.setTaskSubName("100");
			if(project!=null){
				project.setTaskPrincipal(tUserTask.getTaskPrincipal());
				project.setBusinessPrincipal(tUserTask.getTaskPrincipal());
			}
			taskMapper.insertSelective(tUserTask);
		} else if (!taskMap.containsKey("2")) {
			tUserTask.setTaskName("2");
			tUserTask.setTaskSubName("201");
			if(project!=null){
				project.setPurchasePrincipal(tUserTask.getTaskPrincipal());
			}
			taskMapper.insertSelective(tUserTask);
		} else if (!taskMap.containsKey("3")) {
			tUserTask.setTaskName("3");
			tUserTask.setTaskSubName("301");
			project.setProductPrincipal(tUserTask.getTaskPrincipal());
			taskMapper.insertSelective(tUserTask);
		} else if (!taskMap.containsKey("4")) {
			tUserTask.setTaskName("4");
			tUserTask.setTaskSubName("401");
			if(project!=null){
				project.setDevelopmentPrincipal(tUserTask.getTaskPrincipal());
			}
			taskMapper.insertSelective(tUserTask);
		} else if (!taskMap.containsKey("5")) {
			tUserTask.setTaskName("5");
			if(project!=null){
				project.setOperationPrincipal(tUserTask.getTaskPrincipal());
			}
			taskMapper.insertSelective(tUserTask);
		} else if (!taskMap.containsKey("6")) {
			tUserTask.setTaskName("6");
			if(project!=null){
				project.setOperationMaintainPrincipal(tUserTask.getTaskPrincipal());
			}
			taskMapper.insertSelective(tUserTask);
		}


		return tSugarProjectMapper.updateByPrimaryKeyWithBLOBs(project);
	}

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param tUserTask 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateTUserTask(TUserTask tUserTask) {
		return tUserTaskMapper.updateTUserTask(tUserTask);
	}

	/**
	 * 删除【请填写功能名称】对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
  /*  @Override
    public int deleteTUserTaskByIds(String ids)
    {
        return tUserTaskMapper.deleteTUserTaskByIds(Convert.toStrArray(ids));
    }*/

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	@Override
	public int deleteTUserTaskById(Long id) {
		return tUserTaskMapper.deleteTUserTaskById(id);
	}

	@Override
	public TUserTaskVO getTaskInfoByUserIdAndProjectId(String projectId, String userId) {
        TUserTaskVO task = new TUserTaskVO();
		List<TUserTask> tUserTaskList = null;
		if(StringUtils.isNotBlank(userId)){
			TUser user = tUserMapper.selectByPrimaryKey(Integer.parseInt(userId));
			if(user!=null){
				TUserTaskExample example = new TUserTaskExample();
				TUserTaskExample.Criteria sql = example.createCriteria();
				if(StringUtils.isNotBlank(projectId)){
					sql.andProjectIdEqualTo(projectId);
				}
				if(StringUtils.isNotBlank(user.getUserName())){
					sql.andTaskPrincipalEqualTo(user.getUserName());
				}
				sql.andTaskTypeEqualTo("00");//指派下发的任务
                example.setOrderByClause(" CREATED_TIME desc ");
                tUserTaskList = taskMapper.selectByExample(example);

                List<TUserTask> taskDoneList = new ArrayList<>();//已指派
                List<TUserTask> taskUnDoneList = new ArrayList<>();//未指派

				TUserTask tUserTask = null;
                if(!CollectionUtils.isEmpty(tUserTaskList)){

					taskUnDoneList = tUserTaskList.stream()
							.filter((TUserTask t) -> "0".equals(t.getTaskStatus()))
							.collect(Collectors.toList());

					taskDoneList = tUserTaskList.stream()
							.filter((TUserTask t) -> "2".equals(t.getTaskStatus()))
							.collect(Collectors.toList());

					//未指派最新的任务
					if(!CollectionUtils.isEmpty(taskUnDoneList)){
						tUserTask = tUserTaskList.get(0);
						task = this.setTuserTaskVO(tUserTask);
					}else if(!CollectionUtils.isEmpty(taskDoneList)) {

						TUserTask userTask = taskDoneList.get(0);
						example = new TUserTaskExample();
						sql = example.createCriteria();
						sql.andProjectIdEqualTo(projectId);
						sql.andTaskTypeEqualTo("01");
						sql.andTaskNameEqualTo(userTask.getTaskName());
						example.setOrderByClause(" CREATED_TIME asc ");
						tUserTaskList = taskMapper.selectByExample(example);
						if(!CollectionUtils.isEmpty(tUserTaskList)){
							tUserTask = tUserTaskList.get(0);
							task = this.setTuserTaskVO(tUserTask);
							task.setTaskType("01");
						}

					}
                }
            }

		}

		return task;
	}

	@Override
	public List<String> getAllTaskNameByProductId(String projectId) {

		return tUserTaskMapper.getAllTaskNameByProductId(projectId);
	}

	@Override
	public String getAllTaskNameByProductId(Long userId) {
		return userRoleExMapper.getIsHasPowerToInsertTask(userId);
	}

	@Override
	public PageInfo<TUserTaskVO> getDoneTask(TUserTaskVO vo) {
		TUserTaskExample example = new TUserTaskExample();
		TUserTaskExample.Criteria sql = example.createCriteria();
		
		if(StringUtils.isNotBlank(vo.getTaskPrincipal())){
			sql.andTaskPrincipalEqualTo(vo.getTaskPrincipal());
		}
		sql.andTaskStatusEqualTo("2");
		example.setOrderByClause(" CREATED_TIME DESC ");
//		PageHelper.startPage(vo.getPage(),vo.getLimit());
		List<TUserTask> tUserTasks = taskMapper.selectByExample(example);
		PageInfo<TUserTask> page = new PageInfo<>(tUserTasks);
		if (!CollectionUtils.isEmpty(tUserTasks)) {
			List<TUserTaskVO> userTaskVOList = ModelCopyUtil.copyToList(tUserTasks, TUserTaskVO.class);
			PageInfo<TUserTaskVO> pageInfo = new PageInfo<>(userTaskVOList);
			return pageInfo;
		}
		return new PageInfo<>();
	}

	@Override
	public PageInfo<TUserTaskVO> getUndoTask(TUserTaskVO vo) {
		TUserTaskExample example = new TUserTaskExample();
		TUserTaskExample.Criteria sql = example.createCriteria();

		if(StringUtils.isNotBlank(vo.getTaskPrincipal())){
			sql.andTaskPrincipalEqualTo(vo.getTaskPrincipal());
		}
		sql.andTaskStatusNotEqualTo("2");
		example.setOrderByClause(" CREATED_TIME DESC ");
		//PageHelper.startPage(vo.getPage(),vo.getLimit());
		List<TUserTask> tUserTasks = taskMapper.selectByExample(example);

		if (!CollectionUtils.isEmpty(tUserTasks)) {
			List<TUserTaskVO> userTaskVOList = ModelCopyUtil.copyToList(tUserTasks, TUserTaskVO.class);
			PageInfo<TUserTaskVO> pageInfo = new PageInfo<>(userTaskVOList);
			return pageInfo;
		}
		return new PageInfo<>();
	}

	@Override
	public int changeTaskStatusByPrincipalAndProjectId(String taskstatus, String projectId, String taskPrincipal) {
		return tUserTaskMapper.changeTaskStatusByPrincipalAndProjectId(taskstatus, projectId, taskPrincipal);
	}

	@Override
	public int delay(TUserTaskVO tUserTaskVO) throws ParseException {
		//1.先根据用户id获取用户名
		String userName = tUserExMapper.getUserIdByUerName(tUserTaskVO.getUserId());
		if (StringUtils.isBlank(userName)) {
			return 0;
		}
		tUserTaskVO.setUserName(userName);

		//2.根据用户名与项目id,大阶段id，小阶段id,获取该用户未完成的任务
		TUserTask tkuser = tUserTaskMapper.getTaskInfoByPrincipalAndPJId(tUserTaskVO);
		if (StringUtils.isBlank(tkuser.getStartTime())) {
			return 0;
		}
		//获取哪一个阶段
		if (StringUtils.isBlank(tkuser.getTaskName())) {
			return 0;
		}
		TDelay tDelay = new TDelay();
		tDelay.setDelayTime(tUserTaskVO.getDelayDay());
		tDelay.setDelayPeopleName(userName);
		//1.查到谁给他指派的任务
		TUserTask tk = tUserTaskMapper.getPrincipal(tUserTaskVO);
		if(tk!=null){
			tDelay.setAuditingPeopleName(tk.getTaskPrincipal());
		}
		tDelay.setProjectId(tUserTaskVO.getProjectId());
		tDelay.setTaskName(tUserTaskVO.getTaskName());
		tDelay.setTaskSubName(tUserTaskVO.getTaskSubName());
		tDelay.setAuditingStatus("1");//默认为1失败
		tDelay.setStatus("01");
		tDelay.setCreatedTime(DateUtils.getNowDate());
		int count = delayMapper.insertSelective(tDelay);
		if (count > 0) {
			//延期成功后给上级派发任务
			//2.获取项目id,延期天数，延期人，延期任务名，并新增任务，指定负责人为tk.getTaskPrincipal();
			TUserTask tkuse = new TUserTask();
			tkuse.setProductType(tkuser.getProductType());
			tkuse.setPlatformName(tkuser.getPlatformName());
			tkuse.setGroupName(tkuser.getGroupName());
			tkuse.setDelayDay(tUserTaskVO.getDelayDay());//延期到的时间
			tkuse.setDelayPeople(userName);//申请人
			tkuse.setProjectId(tUserTaskVO.getProjectId());//项目id
			tkuse.setTaskPrincipal(tk.getTaskPrincipal());//要审批的负责人
			tkuse.setPrincipal(tkuser.getTaskPrincipal());//现阶段负责人
			tkuse.setStartTime(tkuser.getStartTime());//小阶段开始时间
			tkuse.setEstimatedTime(tkuser.getEstimatedTime());//小阶段计划完成时间
			tkuse.setTaskInfo("任务延期申请至:"+tUserTaskVO.getDelayDay());
			tkuse.setTaskStatus("0");
			tkuse.setTaskName(tUserTaskVO.getTaskName());//大阶段id
			tkuse.setTaskSubName(tUserTaskVO.getTaskSubName());//小阶段id
			tkuse.setCreatedTime(DateUtils.getNowDate());
			int coun = taskMapper.insertSelective(tkuse);
			if (coun > 0) {
				return 1;
			}

		}
		return 0;

	}

	@Override
	public int examine(TUserTaskVO taskVO) throws ParseException {
		//1.先根据用户id获取用户名
		String userName = tUserExMapper.getUserIdByUerName(taskVO.getUserId());
		if (StringUtils.isBlank(userName)) {
			return 0;
		}

		TUserTask tUserTask = ModelCopyUtil.copy(taskVO, TUserTask.class);
		tUserTask.setTaskStatus("2");//已完成

		TDelay temp = new TDelay();
		temp.setProjectId(taskVO.getProjectId());
		temp.setTaskName(taskVO.getTaskName());
		temp.setTaskSubName(taskVO.getTaskSubName());

		TDelayExample example = new TDelayExample();
		TDelayExample.Criteria sql = example.createCriteria();
		if(StringUtils.isNotBlank(taskVO.getProjectId())){
			sql.andProjectIdEqualTo(taskVO.getProjectId());
		}
		if(StringUtils.isNotBlank(taskVO.getTaskName())){
			sql.andTaskNameEqualTo(taskVO.getTaskName());
		}
		if(StringUtils.isNotBlank(taskVO.getTaskSubName())){
			sql.andTaskSubNameEqualTo(taskVO.getTaskSubName());
		}
		if(StringUtils.isNotBlank(userName)){
			sql.andAuditingPeopleNameEqualTo(userName);//审批人
		}
		example.setOrderByClause(" CREATED_TIME DESC ");
		//查询申请延期的数据记录
		List<TDelay> tDelayList = delayMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(tDelayList)){
			TDelay delay = tDelayList.get(0);

			TUserTaskExample taskExample = new TUserTaskExample();
			TUserTaskExample.Criteria criteria = taskExample.createCriteria();

			criteria.andProjectIdEqualTo(taskVO.getProjectId());
			criteria.andTaskNameEqualTo(taskVO.getTaskName());
			criteria.andTaskSubNameEqualTo(taskVO.getTaskSubName());
			criteria.andTaskPrincipalEqualTo(delay.getDelayPeopleName());//申请延期的人(现在负责任务的人)
			criteria.andTaskStatusNotEqualTo("2");

			//查询申请延期的任务
			List<TUserTask> userTaskList = taskMapper.selectByExample(taskExample);
			if(!CollectionUtils.isEmpty(userTaskList)){

				TUserTask task = userTaskList.get(0);//申请延期的任务
				TUserTask tipTask = ModelCopyUtil.copy(task, TUserTask.class);
				tipTask.setId(null);
				tipTask.setTaskStatus("2");//完成状态
				tipTask.setCreatedTime(DateUtils.getNowDate());


				if("0".equals(taskVO.getAuditingStatus())){//通过

					tUserTask.setTaskInfo(tUserTask.getTaskInfo() + ",已通过审核");


					task.setEstimatedTime(delay.getDelayTime());//更新计划完成时间
					taskMapper.updateByPrimaryKeySelective(task);

					delay.setAuditingStatus("0");//该条延期申请记录改为审核通过(不通过不更新该字段)
					delayMapper.updateByPrimaryKeySelective(delay);

					tipTask.setTaskInfo(tUserTask.getTaskInfo());//给申请人的提示
					taskMapper.insertSelective(tipTask);

					return taskMapper.updateByPrimaryKeySelective(tUserTask);//更新该条记录为完成状态
				}else if("1".equals(taskVO.getAuditingStatus())){//不通过
					tUserTask.setTaskInfo(tUserTask.getTaskInfo() + ",未通过审核");

					tipTask.setTaskInfo(tUserTask.getTaskInfo());
					taskMapper.insertSelective(tipTask);//给申请人的提示

					return taskMapper.updateByPrimaryKeySelective(tUserTask);//更新该条记录为完成状态
				}


			}

		}
		return 0;
	}

	@Override
	public List<TUserTaskVO> selectDoneSubTaskList(TUserTaskVO vo) {
		TUserTaskExample example = new TUserTaskExample();
		TUserTaskExample.Criteria sql = example.createCriteria();
		if(StringUtils.isNotBlank(vo.getProjectId())){
			sql.andProjectIdEqualTo(vo.getProjectId());
		}
		if(StringUtils.isNotBlank(vo.getTaskType())){
			sql.andTaskTypeEqualTo(vo.getTaskType());
		}
		if(StringUtils.isNotBlank(vo.getTaskStatus())){
			sql.andTaskStatusEqualTo(vo.getTaskStatus());
		}

		example.setOrderByClause(" TASK_SUB_NAME ASC,CREATED_TIME ASC ");

		List<TUserTaskVO> userTaskVOS = null;
		List<TUserTask> userTaskList = taskMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(userTaskList)){
			userTaskVOS = ModelCopyUtil.copyToList(userTaskList, TUserTaskVO.class);
		}

		return userTaskVOS;
	}

	/**
	 * 16      * 指定日期加上天数后的日期
	 * 17      * @param num 为增加的天数
	 * 18      * @param newDate 创建时间
	 * 19      * @return
	 * 20      * @throws ParseException
	 * 21
	 */
	public String plusDay(int num, String newDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date currdate = format.parse(newDate);
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
		currdate = ca.getTime();
		String enddate = format.format(currdate);
		return enddate;
	}

	@Override
	public void updateUserTask(TUserTaskVO vo) {
		TUserTask tUserTask = ModelCopyUtil.copy(vo, TUserTask.class);
		tUserTask.setEndTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm"));
		tUserTask.setTaskStatus("2");
		taskMapper.updateByPrimaryKeySelective(tUserTask);
		String taskName = tUserTask.getTaskName();
		TSugarProjectWithBLOBs project = tSugarProjectMapper.selectByPrimaryKey(Integer.parseInt(tUserTask.getProjectId()));

		if ("1".equals(tUserTask.getTaskName())) {
			switch (tUserTask.getTaskSubName()) {
				case "100":
					project.setBusinessClueOpen(tUserTask.getTaskInfo());
					break;
				case "101":
					project.setBusinessClueOpen(null);
					project.setBusinessClue0(tUserTask.getTaskInfo());
					break;
				case "102":
					project.setBusinessClue0(null);
					project.setBusinessDiscover10(tUserTask.getTaskInfo());
					break;
				case "103": //自动开启采购阶段第一步
					project.setBusinessDiscover10(null);
					project.setBusinessEstablish25(tUserTask.getTaskInfo());

					TUserTask newUserTask = this.generateAppointTask(tUserTask);
					if(newUserTask!=null){
						taskMapper.insertSelective(newUserTask);
						project.setPurchasePrincipal(newUserTask.getTaskPrincipal());
					}
					break;
				case "104":
					project.setBusinessEstablish25(null);
					project.setBusinessEstablish50(tUserTask.getTaskInfo());
					break;
				case "105":
					project.setBusinessEstablish50(null);
					project.setBusinessEstablish75(tUserTask.getTaskInfo());
					break;
				case "106":
					project.setBusinessEstablish75(null);
					project.setBusinessWin100(tUserTask.getTaskInfo());
					break;
				case "107":
					project.setBusinessWin100(null);
					project.setCustomerMaintainBackMoney(tUserTask.getTaskInfo());
					break;
				case "108":
					project.setCustomerMaintainBackMoney(null);
					project.setBusinessClose(tUserTask.getTaskInfo());
					break;
			}
		} else if ("2".equals(tUserTask.getTaskName())) {
			switch (tUserTask.getTaskSubName()) {
				case "201":
					project.setInitialIntentionPlan(tUserTask.getTaskInfo());
					break;
				case "202":
					project.setInitialIntentionPlan(null);
					project.setWriteProjectProposal(tUserTask.getTaskInfo());
					break;
				case "203":
					project.setWriteProjectProposal(null);
					project.setWorkingHoursAssess(tUserTask.getTaskInfo());
					break;
				case "204":
					project.setWorkingHoursAssess(null);
					project.setBusinessNegotiation(tUserTask.getTaskInfo());
					break;
				case "205":
					project.setBusinessNegotiation(null);
					project.setRequestDraft(tUserTask.getTaskInfo());
					break;
				case "206":
					project.setRequestDraft(null);
					project.setAttendMeeting(tUserTask.getTaskInfo());
					break;
				case "207":
					project.setAttendMeeting(null);
					project.setBidding(tUserTask.getTaskInfo());
					break;
				case "208":
					project.setBidding(null);
					project.setRequestOaApproval(tUserTask.getTaskInfo());
					break;
				case "209":
					project.setRequestOaApproval(null);
					project.setContractDraft(tUserTask.getTaskInfo());

					TUserTask newUserTask = this.generateAppointTask(tUserTask);
					if(newUserTask!=null){
						taskMapper.insertSelective(newUserTask);
						project.setProductPrincipal(newUserTask.getTaskPrincipal());
					}
					break;
				case "210":
					project.setContractDraft(null);
					project.setLawyerReview(tUserTask.getTaskInfo());
					break;
				case "211":
					project.setLawyerReview(null);
					project.setContractOaApproval(tUserTask.getTaskInfo());
					break;
				case "212":
					project.setContractOaApproval(null);
					project.setUsageSeal(tUserTask.getTaskInfo());
					break;
				case "213":
					project.setUsageSeal(null);
					project.setOtherSeal(tUserTask.getTaskInfo());
					break;
				case "214":
					project.setOtherSeal(null);
					project.setScan(tUserTask.getTaskInfo());
					break;
				case "215":
					project.setScan(null);
					project.setGeneralDepartmentFile(tUserTask.getTaskInfo());
					break;
				case "216":
					project.setGeneralDepartmentFile(null);
					project.setFirstPayment(tUserTask.getTaskInfo());
					break;
				case "217":
					project.setFirstPayment(null);
					project.setProgressPayment(tUserTask.getTaskInfo());
					break;
				case "218":
					project.setProgressPayment(null);
					project.setFinalPayment(tUserTask.getTaskInfo());
					break;
			}
		} else if ("3".equals(tUserTask.getTaskName())) {
			switch (tUserTask.getTaskSubName()) {
				case "301":
					project.setDesignBrief(tUserTask.getTaskInfo());
					break;
				case "302":
					project.setDesignBrief(null);
					project.setDetailedDesign(tUserTask.getTaskInfo());
					break;
				case "303":
					project.setDetailedDesign(null);
					project.setUiDesign(tUserTask.getTaskInfo());

					TUserTask newUserTask = this.generateAppointTask(tUserTask);
					if(newUserTask!=null){
						taskMapper.insertSelective(newUserTask);
						project.setDevelopmentPrincipal(newUserTask.getTaskPrincipal());
					}
					break;
				case "304":
					project.setUiDesign(null);
					project.setRequirementDesign(tUserTask.getTaskInfo());
					break;
				case "305":
					project.setRequirementDesign(null);
					project.setRequirementsReview(tUserTask.getTaskInfo());
					break;
				case "306":
					project.setRequirementsReview(null);
					project.setDemandOrderConfirm(tUserTask.getTaskInfo());
					break;
				case "307":
					project.setDemandOrderConfirm(null);
					project.setProCheckDeliver(tUserTask.getTaskInfo());
					break;
			}
		} else if ("4".equals(tUserTask.getTaskName())) {
			switch (tUserTask.getTaskSubName()) {
				case "401":
					project.setTechnologySelection(tUserTask.getTaskInfo());
					break;
				case "402":
					project.setTechnologySelection(null);
					project.setEnvironmentDeployment(tUserTask.getTaskInfo());
					break;
				case "403":
					project.setEnvironmentDeployment(null);
					project.setFrameworkDesign(tUserTask.getTaskInfo());
					break;
				case "404":
					project.setFrameworkDesign(null);
					project.setDevelopProgress10(tUserTask.getTaskInfo());
					break;
				case "405":
					project.setDevelopProgress10(null);
					project.setDevelopProgress25(tUserTask.getTaskInfo());
					break;
				case "406":
					project.setDevelopProgress25(null);
					project.setDevelopProgress50(tUserTask.getTaskInfo());
					break;
				case "407":
					project.setDevelopProgress50(null);
					project.setDevelopProgress75(tUserTask.getTaskInfo());
					break;
				case "408":
					project.setDevelopProgress75(null);
					project.setDevelopProgress100(tUserTask.getTaskInfo());
					break;
				case "409":
					project.setDevelopProgress100(null);
					project.setInsideTest(tUserTask.getTaskInfo());
					break;
				case "410":
					project.setInsideTest(null);
					project.setCustomerTest(tUserTask.getTaskInfo());
					break;
				case "411":
					project.setCustomerTest(null);
					project.setImplementDeliver(tUserTask.getTaskInfo());
					break;
				case "412":
					project.setImplementDeliver(null);
					project.setCheckDeliver(tUserTask.getTaskInfo());

					TUserTask newUserTask = this.generateAppointTask(tUserTask);
					if(newUserTask!=null){
						taskMapper.insertSelective(newUserTask);
						project.setOperationPrincipal(newUserTask.getTaskPrincipal());
					}
					break;
			}
		} else if ("5".equals(tUserTask.getTaskName())) {
			project.setOperationPhase(tUserTask.getTaskInfo());

			TUserTask newUserTask = this.generateAppointTask(tUserTask);
			if(newUserTask!=null){
				taskMapper.insertSelective(newUserTask);
				project.setOperationMaintainPrincipal(newUserTask.getTaskPrincipal());
			}
		} else if ("6".equals(tUserTask.getTaskName())) {
			project.setMaintainPhase(tUserTask.getTaskInfo());
		}


		tSugarProjectMapper.updateByPrimaryKeyWithBLOBs(project);

		String taskSubName = tUserTask.getTaskSubName();
		//小阶段不是最后一个才新增
		if (!"108".equals(taskSubName) && !"218".equals(taskSubName) && !"307".equals(taskSubName) && !"412".equals(taskSubName) && !"5".equals(taskName) && !"6".equals(taskName)) {
			if (StringUtils.isNotBlank(taskSubName)) {
				TUserTask newTask = ModelCopyUtil.copy(vo, TUserTask.class);
				newTask.setId(null);
				newTask.setTaskStatus("0");
				newTask.setStatus("01");
				int newTaskSubName = Integer.parseInt(taskSubName) + 1;
				newTask.setTaskSubName(newTaskSubName + "");
				newTask.setTaskInfo(null);
				newTask.setCreatedTime(DateUtils.getNowDate());
				newTask.setStartTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm:ss"));
				newTask.setEndTime(null);

				StageTimeVO timeVO = new StageTimeVO();
				timeVO.setStageType("02");
				StageTimeVO stage = this.getDefaultRequireForSubStage(timeVO);
				if(stage!=null && stage.getStageDay()!=null){
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.DATE,stage.getStageDay());

					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					String estimatedTime = sdf.format(calendar.getTime());
					newTask.setEstimatedTime(estimatedTime);
				}


				//自动生成下一阶段任务
				taskMapper.insertSelective(newTask);
			}
		}


	}

	@Override
	public void updateUserTaskToProgressing(TUserTask tUserTask) {
		taskMapper.updateByPrimaryKeySelective(tUserTask);
	}

	private TUserTaskVO setTuserTaskVO(TUserTask obj){
		TUserTaskVO taskVO = new TUserTaskVO();
		if(obj==null){
			return taskVO;
		}
        taskVO = ModelCopyUtil.copy(obj, TUserTaskVO.class);
        switch (obj.getTaskName()){
			case "1":
				taskVO.setTaskName("商机推进阶段");
				taskVO.setBigId("1");
				break;
			case "2":
				taskVO.setTaskName("采购阶段");
				taskVO.setBigId("2");
				break;
			case "3":
				taskVO.setTaskName("产品阶段");
				taskVO.setBigId("3");
				break;
			case "4":
				taskVO.setTaskName("研发阶段");
				taskVO.setBigId("4");
				break;
			case "5":
				taskVO.setTaskName("运营阶段");
				taskVO.setBigId("5");
				break;
			case "6":
				taskVO.setTaskName("运维阶段");
				taskVO.setBigId("6");
				break;
		}
		return taskVO;

	}

	/** 生成指派任务 */
	private TUserTask generateAppointTask(TUserTask task){
		if(task!=null){
			TStagePrincipalExample example = new TStagePrincipalExample();
			TStagePrincipalExample.Criteria sql = example.createCriteria();
			if(StringUtils.isNotBlank(task.getTaskName())){
				sql.andStageNumEqualTo((Integer.parseInt(task.getTaskName())+1)+"");
			}
			List<TStagePrincipal> principalList = stagePrincipalMapper.selectByExample(example);
			if(!CollectionUtils.isEmpty(principalList)){
				TUserTask newUserTask = new TUserTask();
				if(StringUtils.isNotBlank(task.getTaskName())){
					newUserTask.setTaskName((Integer.parseInt(task.getTaskName())+1)+"");
				}
				newUserTask.setProjectId(task.getProjectId());
				newUserTask.setTaskPrincipal(principalList.get(0).getPrincipalName());
				newUserTask.setPrincipal(principalList.get(0).getPrincipalName());
				newUserTask.setTaskType("00");
				newUserTask.setTaskStatus("0");
				newUserTask.setStartTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm:ss"));
				newUserTask.setCreatedTime(DateUtils.getNowDate());
				newUserTask.setPlatformName(task.getPlatformName());
				newUserTask.setGroupName(task.getGroupName());
				newUserTask.setProductType(task.getProductType());
				return newUserTask;
			}
		}
		return null;
	}

	/** 查询默认小阶段完成需要天数 */
	private StageTimeVO getDefaultRequireForSubStage(StageTimeVO vo){
		StageTimeExample example = new StageTimeExample();
		StageTimeExample.Criteria sql = example.createCriteria();
		if(StringUtils.isNotBlank(vo.getStageType())){
			sql.andStageTypeEqualTo(vo.getStageType());
		}

		StageTimeVO timeVO = null;
		List<StageTime> stageTimeList = stageTimeMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(stageTimeList)){
			timeVO = ModelCopyUtil.copy(stageTimeList.get(0), StageTimeVO.class);
		}

		return timeVO;
	}
}





