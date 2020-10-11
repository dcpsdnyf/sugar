package com.sugar.manage.service.impl;

import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.DateUtils;
import com.sugar.manage.dao.mapper.*;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.dao.vo.TDelay;
import com.sugar.manage.dao.vo.TUserTask;
import com.sugar.manage.service.ITUserTaskService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-09-28
 */
@Service
public class TUserTaskServiceImpl implements ITUserTaskService {
    @Autowired
    private TUserTaskMapper tUserTaskMapper;
    @Autowired
    private TUserRoleMapper tUserRoleMapper;
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private TDelayMapper tDelayMapper;
    @Autowired
    private TSugarProjectMapper tSugarProjectMapper;
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
     * @param tUserTask 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TUserTask> selectTUserTaskList(TUserTask tUserTask) {
        return tUserTaskMapper.selectTUserTaskList(tUserTask);
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

        if(!CollectionUtils.isEmpty(taskList)){
            for(TUserTask task:taskList){
                taskMap.put(task.getTaskName(),task.getTaskName());
            }
        }

        tUserTask.setCreatedTime(DateUtils.getNowDate());
        tUserTask.setStartTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm"));
        tUserTask.setStatus("01");
        tUserTask.setTaskType("01");
        tUserTask.setTaskStatus("0");
        if(CollectionUtils.isEmpty(taskList)){
            tUserTask.setTaskName("1");
            tUserTask.setTaskSubName("100");
            return tUserTaskMapper.insertTUserTask(tUserTask);
        }else if(!taskMap.containsKey("2")){
            tUserTask.setTaskName("2");
            tUserTask.setTaskSubName("201");
            return tUserTaskMapper.insertTUserTask(tUserTask);
        }else if(!taskMap.containsKey("3")){
            tUserTask.setTaskName("3");
            tUserTask.setTaskSubName("301");
            return tUserTaskMapper.insertTUserTask(tUserTask);
        }else if(!taskMap.containsKey("4")){
            tUserTask.setTaskName("4");
            tUserTask.setTaskSubName("401");
            return tUserTaskMapper.insertTUserTask(tUserTask);
        }else if(!taskMap.containsKey("5")){
            tUserTask.setTaskName("5");
            return tUserTaskMapper.insertTUserTask(tUserTask);
        }else if(!taskMap.containsKey("6")){
            tUserTask.setTaskName("6");
            return tUserTaskMapper.insertTUserTask(tUserTask);
        }

        return 0;
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
    public TUserTask getTaskInfoByUserIdAndProjectId(String projectId, String userId) {
        TUserTask task = new TUserTask();
        TUserTask tk = new TUserTask();
        if ("53".equals(userId) || "33".equals(userId)) {//如果是李佳娜、谢帅
            task = tUserTaskMapper.getTaskInfoByUserIdAndProjectIdtask1(projectId);
            if (task != null) {
                if ("100".equals(task.getTaskSubName())) {//这个task.gettasksubname需要从下级中获取
                    task.setTaskSubName("商机线索开启");
                }
                if ("101".equals(task.getTaskSubName())) {
                    task.setTaskSubName("商机线索0%");
                }
                if ("102".equals(task.getTaskSubName())) {
                    task.setTaskSubName("商机发现10%");
                }
                if ("103".equals(task.getTaskSubName())) {
                    task.setTaskSubName("商机确立25%");
                }
                if ("104".equals(task.getTaskSubName())) {
                    task.setTaskSubName("商机确立50%");
                }
                if ("105".equals(task.getTaskSubName())) {
                    task.setTaskSubName("商机确立75%");
                }
                if ("106".equals(task.getTaskSubName())) {
                    task.setTaskSubName("商机赢取100%");
                }
                if ("107".equals(task.getTaskSubName())) {
                    task.setTaskSubName("客户回款/维护阶段");
                }
                if ("108".equals(task.getTaskSubName())) {
                    task.setTaskSubName("商机关闭");
                }
                if ("109".equals(task.getTaskName())) {
                    task.setTaskName("商机推进阶段");
                }
                return task;
            }
            //如果为null说明只是新增没有指派过，就回显新增的负责人过去
            if (task == null) {
                tk= tUserTaskMapper.getOnlyAddPricipalTKName1(projectId);
                if (tk != null) {
                    if ("100".equals(tk.getTaskSubName())) {//这个task.gettasksubname需要从下级中获取
                        tk.setTaskSubName("商机线索开启");
                    }
                    if ("101".equals(tk.getTaskSubName())) {
                        tk.setTaskSubName("商机线索0%");
                    }
                    if ("102".equals(tk.getTaskSubName())) {
                        tk.setTaskSubName("商机发现10%");
                    }
                    if ("103".equals(tk.getTaskSubName())) {
                        tk.setTaskSubName("商机确立25%");
                    }
                    if ("104".equals(tk.getTaskSubName())) {
                        tk.setTaskSubName("商机确立50%");
                    }
                    if ("105".equals(tk.getTaskSubName())) {
                        tk.setTaskSubName("商机确立75%");
                    }
                    if ("106".equals(tk.getTaskSubName())) {
                        tk.setTaskSubName("商机赢取100%");
                    }
                    if ("107".equals(tk.getTaskSubName())) {
                        tk.setTaskSubName("客户回款/维护阶段");
                    }
                    if ("108".equals(tk.getTaskSubName())) {
                        tk.setTaskSubName("商机关闭");
                    }
                    if ("109".equals(tk.getTaskName())) {
                        tk.setTaskName("商机推进阶段");
                    }
                    return tk;
                }
            }
            return new TUserTask();
        }


        if ("80".equals(userId)) {//如果是尹罗琦
            List<TUserTask> tasklist = tUserTaskMapper.getTaskInfoByProductIdAndTaskType(projectId);
            HashMap<String, TUserTask> taskn = new HashMap<>();

            for (TUserTask tusk : tasklist) {
                taskn.put(tusk.getTaskName(), tusk);
            }
            if (taskn.containsKey("2")) {
                task.setTaskName("采购阶段");
                if ("201".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("初步意向方案");
                }
                if ("202".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("写立项方案");
                }
                if ("203".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("工时评估");
                }
                if ("204".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("商务谈判");
                }
                if ("205".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("请示拟写");
                }
                if ("206".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("上会");
                }
                if ("207".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("招投标");
                }
                if ("208".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("请示OA审批");
                }
                if ("209".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("合同拟写");
                }
                if ("210".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("律师审核");
                }
                if ("211".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("合同OA审批");
                }
                if ("212".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("用章");
                }
                if ("213".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("对方盖章");
                }
                if ("214".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("扫描");
                }
                if ("215".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("综合部归档");
                }
                if ("216".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("首付款");
                }
                if ("217".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("进度款");
                }
                if ("218".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("尾款");
                }

            }

            if (taskn.containsKey("3")) {
                task.setTaskName("产品阶段");
                if ("301".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("设计概要");
                }
                if ("302".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("详细设计");
                }
                if ("303".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("UI设计");
                }
                if ("304".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("需求设计");
                }
                if ("305".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("需求审批");
                }
                if ("306".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("需求单确认");
                }
                if ("307".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("验收");
                }

            }
            if (taskn.containsKey("5")) {
                task.setTaskName("运营阶段");
                task.setTaskSubName("运营阶段");
            }
            return task;
        }

        if ("20".equals(userId)) {//如果是黄斯南
            List<TUserTask> tasklist = tUserTaskMapper.getTaskInfoByProductIdAndTaskTypehsn(projectId);
            HashMap<String, TUserTask> taskn = new HashMap<>();
            for (TUserTask tusk : tasklist) {
                taskn.put(tusk.getTaskName(), tusk);
            }
            if (taskn.containsKey("4")) {
                task.setTaskName("研发阶段");
                if ("401".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("技术选型");
                }
                if ("402".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("环境部署");
                }
                if ("403".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("框架设计");
                }
                if ("404".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度10");
                }
                if ("405".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度25");
                }
                if ("406".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度50");
                }
                if ("407".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度75");
                }
                if ("408".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度100");
                }
                if ("409".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("内部测试优化");
                }
                if ("410".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("客户测试优化");
                }
                if ("411".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("实施交付");
                }
                if ("412".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("验收");
                }
            }
            if (taskn.containsKey("6")) {
                task.setTaskName("运维阶段");
                task.setTaskSubName("技术选型");
            }
            return task;
        }
        //如果是卢丽娜、张洋洋、姜仲一则返回一阶段信息
        if ("82".equals(userId) || "26".equals(userId) || "47".equals(userId)) {
            TUserTask ustk = tUserTaskMapper.getTaskInfoByProductId(projectId);
            return ustk;
        }
        return new TUserTask();
    }

    @Override
    public List<String> getAllTaskNameByProductId(String projectId) {

        return tUserTaskMapper.getAllTaskNameByProductId(projectId);
    }

    @Override
    public String getAllTaskNameByProductId(Long userId) {
        return tUserRoleMapper.getIsHasPowerToInsertTask(userId);
    }

    @Override
    public PageInfo<TUserTask> getDoneTask(String taskPrincipal) {
        List<TUserTask> doneTkuser = tUserTaskMapper.getDoneTask(taskPrincipal);
        if (!CollectionUtils.isEmpty(doneTkuser)) {
            PageInfo<TUserTask> pageInfo = new PageInfo<>(doneTkuser);
            return pageInfo;
        }
        return new PageInfo<>();
    }

    @Override
    public PageInfo<TUserTask> getUndoTask(String taskPrincipal) {
        List<TUserTask> unDoTkuser = tUserTaskMapper.getUndoTask(taskPrincipal);
        if (!CollectionUtils.isEmpty(unDoTkuser)) {
            PageInfo<TUserTask> pageInfo = new PageInfo<>(unDoTkuser);
            return pageInfo;
        }
        return new PageInfo<>();
    }

    @Override
    public int changeTaskStatusByPrincipalAndProjectId(String taskstatus, String projectId, String taskPrincipal) {
        return tUserTaskMapper.changeTaskStatusByPrincipalAndProjectId(taskstatus, projectId, taskPrincipal);
    }

    @Override
    public int delay(String userId, String projectId, String delayDay) throws ParseException {
        //1.先根据用户id获取用户名
        String userName = tUserMapper.getUserIdByUerName(userId);
        if (StringUtils.isBlank(userName)) {
            return 0;
        }
        //2.根据用户名与项目id获取该用户未完成的任务
        TUserTask tkuser = tUserTaskMapper.getTaskInfoByPrincipalAndPJId(userName,projectId);
        if (StringUtils.isBlank(tkuser.getStartTime())) {
            return 0;
        }
        //获取哪一个阶段
        if (StringUtils.isBlank(tkuser.getTaskName())) {
            return 0;
        }

        TDelay tDelay = new TDelay();
        tDelay.setDelayTime(delayDay);
        tDelay.setDelayPeopleName(userName);
        //1.查到谁给他指派的任务
        TUserTask tk =  tUserTaskMapper.getPrincipal(projectId,tkuser.getTaskName());
        tDelay.setAuditingPeopleName(tk.getTaskPrincipal());
        tDelay.setProjectId(projectId);
        tDelay.setTaskName(tkuser.getTaskName());
        tDelay.setAuditingStatus("1");//默认为1失败
        tDelay.setStatus("01");
      int count =  tDelayMapper.insertTDelay(tDelay);
        if (count > 0 ) {
            //延期成功后给上级派发任务
            //2.获取项目id,延期天数，延期人，延期任务名，并新增任务，指定负责人为tk.getTaskPrincipal();
            TUserTask tkuse = new TUserTask();
            tkuse.setDelayDay(delayDay);
            tkuse.setDelayPeople(userName);
            tkuse.setTaskName(tkuser.getTaskName());
            tkuse.setProjectId(projectId);
            tkuse.setTaskPrincipal(tk.getTaskPrincipal());
            tkuse.setStartTime(tk.getStartTime());
            tkuse.setTaskInfo("延期申请");
            tkuse.setTaskStatus("0");
           int coun = tUserTaskMapper.insertTUserTask(tkuse);
           if (coun > 0) {
               return 1;
           }

        }
        return 0;

    }
    @Override
    public int examine(String userId,String projectId,String staus) throws ParseException {
        //1.先根据用户id获取用户名
        String userName = tUserMapper.getUserIdByUerName(userId);
        if (StringUtils.isBlank(userName)) {
            return 0;
        }
        TDelay delay = new TDelay();
        delay.setProjectId(projectId);
        delay.setAuditingPeopleName(userName);
        delay.setStatus("99");
        if("0".equals(staus)) {
            delay.setAuditingStatus("0");
            int count = tDelayMapper.udaDelay(delay);
            if (count > 0) {
                List<TDelay> delayList = tDelayMapper.selectTDelayList(delay);
                TUserTask task = new TUserTask();
                for (TDelay s : delayList) {
                    task.setDelayDay(s.getDelayTime());
                    task.setDelayPeople(s.getDelayPeopleName());
                    task.setTaskPrincipal(s.getAuditingPeopleName());
                }
                task.setProjectId(projectId);
                task.setTaskInfo("延期申请");
                task.setStartTime(tUserTaskMapper.getProject(projectId,task.getTaskPrincipal(),task.getTaskInfo()).getStartTime());
                task.setEndTime(this.plusDay(Integer.parseInt(task.getDelayDay()),task.getStartTime()));
                task.setTaskStatus("2");
                count=tUserTaskMapper.updateTUserTask(task);
                if(count>0){
                    return 1;
                }else {
                    return 0;
                }
            }
        }
        else {
            delay.setAuditingStatus("1");
            int count = tDelayMapper.udaDelay(delay);
            List<TDelay> delayList = tDelayMapper.selectTDelayList(delay);
            TUserTask task = new TUserTask();
            for (TDelay s : delayList) {
                task.setDelayDay(s.getDelayTime());
                task.setDelayPeople(s.getDelayPeopleName());
                task.setTaskPrincipal(s.getAuditingPeopleName());
            }
            task.setProjectId(projectId);
            task.setTaskStatus("2");
            task.setTaskInfo("延期申请");
            tUserTaskMapper.updateTUserTask(task);
            return 0;
        }
        return 0;
    }

    @Override
    public List<TUserTask> selectTUserTaskByProId(Integer projectId) {
        TUserTask tUserTask = new TUserTask();
        tUserTask.setProjectId(String.valueOf(projectId));
        tUserTask.setTaskType("01");
        List<TUserTask> tUserTasks = tUserTaskMapper.selectTUserTaskOrderByDate(tUserTask);
        return tUserTasks;
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currdate = format.parse(newDate);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        currdate = ca.getTime();
        String enddate = format.format(currdate);
        return enddate;
    }

    @Override
    public void updateUserTask(TUserTask tUserTask) {
        tUserTask.setEndTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm"));
        tUserTask.setTaskStatus("2");
        tUserTaskMapper.updateTUserTaskById(tUserTask);
        String taskName = tUserTask.getTaskName();
        TSugarProjectWithBLOBs project = tSugarProjectMapper.selectByPrimaryKey(Integer.parseInt(tUserTask.getProjectId()));

        if("1".equals(tUserTask.getTaskName())){
            switch (tUserTask.getTaskSubName()){
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

                    TUserTask newUserTask = new TUserTask();
                    newUserTask.setTaskName("2");
                    newUserTask.setProjectId(tUserTask.getProjectId());
                    newUserTask.setTaskPrincipal("尹罗琦");
                    newUserTask.setTaskType("00");
                    newUserTask.setTaskStatus("0");
                    newUserTask.setStartTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm"));
                    newUserTask.setCreatedTime(DateUtils.getNowDate());
                    tUserTaskMapper.insertTUserTask(newUserTask);
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
        }else if("2".equals(tUserTask.getTaskName())){
            switch (tUserTask.getTaskSubName()){
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

                    TUserTask newUserTask = new TUserTask();
                    newUserTask.setTaskName("3");
                    newUserTask.setProjectId(tUserTask.getProjectId());
                    newUserTask.setTaskPrincipal("尹罗琦");
                    newUserTask.setTaskType("00");
                    newUserTask.setTaskStatus("0");
                    newUserTask.setStartTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm"));
                    newUserTask.setCreatedTime(DateUtils.getNowDate());
                    //自动开启产品阶段的第一步（设计概要）
                    tUserTaskMapper.insertTUserTask(newUserTask);
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
        }else if("3".equals(tUserTask.getTaskName())){
            switch (tUserTask.getTaskSubName()){
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

                    TUserTask newUserTask = new TUserTask();
                    newUserTask.setTaskName("4");
                    newUserTask.setProjectId(tUserTask.getProjectId());
                    newUserTask.setTaskPrincipal("黄斯楠");
                    newUserTask.setTaskType("00");
                    newUserTask.setTaskStatus("0");
                    newUserTask.setCreatedTime(DateUtils.getNowDate());
                    newUserTask.setStartTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm"));
                    //自动开启产品阶段的第一步（设计概要）
                    tUserTaskMapper.insertTUserTask(newUserTask);
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
        }else if("4".equals(tUserTask.getTaskName())){
            switch (tUserTask.getTaskSubName()){
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
                    break;
            }
        }else if("5".equals(tUserTask.getTaskName())){
            project.setOperationPhase(tUserTask.getTaskInfo());
        }else if("6".equals(tUserTask.getTaskName())){
            project.setMaintainPhase(tUserTask.getTaskInfo());
        }


        tSugarProjectMapper.updateByPrimaryKeyWithBLOBs(project);

        String taskSubName = tUserTask.getTaskSubName();
        //小阶段不是最后一个才新增
        if(!"108".equals(taskSubName) && !"218".equals(taskSubName) && !"307".equals(taskSubName) && !"412".equals(taskSubName) && !"5".equals(taskName) && !"6".equals(taskName)){
            if(StringUtils.isNotBlank(taskSubName)){
                tUserTask.setId(null);
                tUserTask.setTaskStatus("0");
                tUserTask.setStatus("01");
                int newTaskSubName = Integer.parseInt(taskSubName)+1;
                tUserTask.setTaskSubName(newTaskSubName+"");
                tUserTask.setTaskInfo(null);
                tUserTask.setCreatedTime(DateUtils.getNowDate());
                tUserTask.setStartTime(DateUtils.dateTimeNow("YYYY-MM-dd HH:mm"));
                tUserTask.setEndTime(null);

                //自动生成下一阶段任务
                tUserTaskMapper.insertTUserTask(tUserTask);
            }
        }



    }

    @Override
    public void updateUserTaskToProgressing(TUserTask tUserTask) {
        tUserTaskMapper.updateTUserTaskById(tUserTask);
    }
}





