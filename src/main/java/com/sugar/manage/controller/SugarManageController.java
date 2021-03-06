package com.sugar.manage.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sugar.common.AppBaseController;
import com.sugar.common.utils.*;
import com.sugar.manage.dao.model.*;
import com.sugar.manage.dao.vo.GroupSugarList;
import com.sugar.manage.dao.vo.TStagePrincipalVO;
import com.sugar.manage.dao.vo.TUserTaskVO;
import com.sugar.manage.dao.vo.TableDataInfo;
import com.sugar.manage.service.*;
import com.sugar.manage.service.impl.ISugarProjectSVImpl;
import com.sugar.manage.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: sugarManage
 * @description: 项目进度管理业务功能
 * @author: liangbq
 * @create: 2020-08-30 00:43
 */
@Controller
@RequestMapping("/sugarManage")
@Slf4j
public class SugarManageController extends AppBaseController {

    @Autowired
    private ISugarProjectSV sugarProjectSV;

    @Autowired
    private IUserSV userSV;

    @Autowired
    private IUserRoleSV userRoleSV;

    @Autowired
    private ISugarProjectSVImpl iSugarProjectSV;

    @Autowired
    private ITUserTaskService itUserTaskService;

    @Autowired
    private IStagePrincipalSV iStagePrincipalSV;

    private Boolean isShow = false;

    /**
     * 项目进度初始化界面
     * @return
     */
    @RequestMapping("/init")
    public String initSugarManage(HttpServletResponse response, HttpServletRequest request, TUserVO tUser, Model model){
        RoleProjectVO roleProjectVO = null;
        TSugarProjectVO projectVO = new TSugarProjectVO();
        if(!StringUtils.isBlank(tUser.getUserName()) || StringUtils.isNotBlank(tUser.getUserAccount())){
            TUser user = userSV.getUserList(tUser);
            if(user!=null){
                model.addAttribute("userName",user.getUserName());

                roleProjectVO = userRoleSV.getUserRoleList(user);

                projectVO.setUserName(tUser.getUserName());
            }
            if(tUser != null){
                CookieUtils.setCookie(response, "SUGAR_USER_ID","" + user.getId());
            }
        }

        TUserRoleVO vo = new TUserRoleVO();
        vo.setRoleId("8");
        //查询有新增权限的用户
        List<TUserVO> authorityToAddUsers = userRoleSV.getAuthorityToAddUsers(vo);
        if(!CollectionUtils.isEmpty(authorityToAddUsers)){
            for(TUserVO userVO : authorityToAddUsers){
                if(StringUtils.isNotBlank(userVO.getUserName()) && userVO.getUserName().equals(tUser.getUserName())){
                    model.addAttribute("isShowLabel",isShow=true);
                }
            }
        }


        if(roleProjectVO!=null){
            projectVO.setViewAllProject(roleProjectVO.isViewAllProject());
        }

        //查询列表详情再分组
        GroupSugarList sugarProjectGroupList = iSugarProjectSV.getSugarProjectGroupList(projectVO);
        if(!CollectionUtils.isEmpty(sugarProjectGroupList.getProductType())){
            model.addAttribute("productType",sugarProjectGroupList.getProductType().stream().filter(productType -> StringUtils.isNotBlank(productType)).distinct().collect(Collectors.toList()));
        }
        if(!CollectionUtils.isEmpty(sugarProjectGroupList.getPlatformName())){
            model.addAttribute("platformName",sugarProjectGroupList.getPlatformName().stream().filter(platformName -> StringUtils.isNotBlank(platformName)).distinct().collect(Collectors.toList()));
        }
        if(!CollectionUtils.isEmpty(sugarProjectGroupList.getGroupName())){
            model.addAttribute("groupName",sugarProjectGroupList.getGroupName().stream().filter(groupName -> StringUtils.isNotBlank(groupName)).distinct().collect(Collectors.toList()));
        }

        return "sugarManage/sugarManage";
    }

    /**
     * 获取项目列表信息记录
     * @return
     */
    @RequestMapping("/getSugarProjectList")
    @ResponseBody
    public TableDataInfo getSugarProjectList(HttpServletRequest request, TSugarProjectVO projectVO){
        TableDataInfo tableDataInfo = new TableDataInfo();
        try {
            TUser user = new TUser();
            String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
            RoleProjectVO roleProjectVO = null;
            if(StringUtils.isNotBlank(userId)){
                user.setId(Integer.parseInt(userId));
                roleProjectVO = userRoleSV.getUserRoleList(user);


                TUserVO userVO = userSV.getUserById(Integer.parseInt(userId));
                if(userVO!=null){
                    projectVO.setUserName(userVO.getUserName());
                }

                projectVO.setViewAllProject(roleProjectVO.isViewAllProject());

                PageInfo<TSugarProjectWithBLOBs> page = sugarProjectSV.getSugarProjectList(projectVO);
                List<TSugarProjectWithBLOBs> list = page.getList();
                List<TSugarProjectVO> tSugarProjectVOSList = new ArrayList<>() ;
                if(!CollectionUtils.isEmpty(list)){
                    for (TSugarProjectWithBLOBs t : list){
                        TSugarProjectVO tSugarProjectVO = ModelCopyUtil.copy(t, TSugarProjectVO.class);

                        if(roleProjectVO!=null){

                            tSugarProjectVO.setAppoint(roleProjectVO.isRoleAppoint());

                            tSugarProjectVO.setDelay(roleProjectVO.isRoleDelay());
                        }

                        tSugarProjectVOSList.add(tSugarProjectVO);
                    }
                }

                tableDataInfo.setRows(tSugarProjectVOSList);
                tableDataInfo.setTotal(page.getTotal());
                tableDataInfo.setCode(200);
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }


        return tableDataInfo;
    }
    /**
     * 新增项目列表信息记录
     * @return
     */
    @RequestMapping("/newlyAdded")
    @ResponseBody
    public SysResult newlyAdded(HttpServletRequest request, TSugarProjectVO record){
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        try {
            if (StringUtils.isBlank(record.getTaskPrincipal())) {
                return SysResult.success("新增失败，负责人不能为空",null);
            }
            if (StringUtils.isBlank(record.getStartTime())) {
                return SysResult.success("新增失败，开始时间不能为空",null);
            }

            TStagePrincipalVO vo = new TStagePrincipalVO();
            vo.setStageNum("1");
            List<TStagePrincipal> principalList = iStagePrincipalSV.selectStagePrincipalList(vo);
            Map<String,String> principalMap = new HashMap<>();
            if(!CollectionUtils.isEmpty(principalList)){
                for(TStagePrincipal principal : principalList){
                    principalMap.put(principal.getPrincipalName(),principal.getPrincipalName());
                }
            }

            if(!principalMap.containsKey(record.getTaskPrincipal())){
                return SysResult.success("新增失败，阶段负责人信息有误",null);
            }

            if(StringUtils.isNotBlank(userId)){
                TUser user = new TUser();
                user.setId(Integer.parseInt(userId));
                boolean addAuthority = userSV.getAddAuthority(user);
                String uerName = userSV.getUserIdByUerName(userId);
                record.setAddProjectUsername(uerName);
                if(addAuthority){
                    record.setStatus("01");
                    record.setBusinessPrincipal(record.getTaskPrincipal());
                    record.setCreatedTime(DateUtils.getNowDate());
                    record.setCreatedStaff(userId);
                    sugarProjectSV.saveSugarProject(record);
                    return SysResult.success("新增成功",null);
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return SysResult.fail("新增失败,无新增权限");
    }

    @RequestMapping(value = "/exportSugarExcle")
    public void exportSupplierOrderReport(HttpServletRequest request, HttpServletResponse response, TSugarProjectWithBLOBs sugarList) {
        try{
            String fileName="管理列表.xls";
            List<String> titleLists = exportExcelHead();
            List<List<String>> rowLists = exportExcelData(sugarList);
            if(!CollectionUtils.isEmpty(titleLists) && !CollectionUtils.isEmpty(rowLists)) {
                XSSFWorkbook workbook = ExcelUtils.buildWorkBookForExport(titleLists, rowLists);
                writeExcelToResponse(response, workbook, fileName);
            }
        }catch (Exception e){
           log.error("导出列表异常", e);
        }
    }

    /**
     * 更新项目列表信息记录
     * @return
     */
    @RequestMapping("/Edit")
    @ResponseBody
    public SysResult updateSugarProject(TSugarProjectVO vo, HttpServletResponse response) throws Exception {
        String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        if(StringUtils.isBlank(userId)){
            return SysResult.fail("用户未登录");
        }
        String uerName = userSV.getUserIdByUerName(userId);

        TSugarProjectVO project = sugarProjectSV.getSugarProjectById(vo);
        if(project!=null){
            if(StringUtils.isNotBlank(uerName)){
                if(!uerName.equals(project.getAddProjectUsername())){
                    return SysResult.fail("您不是新增该项目的负责人，不能修改");
                }
            }
        }

        TStagePrincipalVO stagePrincipalVO = new TStagePrincipalVO();
        stagePrincipalVO.setStageNum("1");
        List<TStagePrincipal> principalList = iStagePrincipalSV.selectStagePrincipalList(stagePrincipalVO);
        Map<String,String> principalMap = new HashMap<>();
        if(!CollectionUtils.isEmpty(principalList)){
            for(TStagePrincipal principal : principalList){
                principalMap.put(principal.getPrincipalName(),principal.getPrincipalName());
            }
        }

        if(!principalMap.containsKey(vo.getTaskPrincipal())){
            return SysResult.fail("修改失败，阶段负责人信息有误");
        }

        vo.setUpdatedStaff(userId);
        int a=sugarProjectSV.updateSugarProject(vo);
        if (a>0){
            return SysResult.success("修改成功");
        }

       return SysResult.fail("修改失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public SysResult deleteByPrimaryKey(TSugarProjectWithBLOBs tSugarProject, HttpServletResponse response) throws Exception {
        tSugarProject.setStatus("99");
        int a=sugarProjectSV.deleteByPrimaryKey(tSugarProject);
        if (a>0){
            return SysResult.success("删除成功",null);
        }
        return SysResult.fail("删除失败");
    }

    /**
     * 导出excel头部内容
     * @return
     */
    private List<String> exportExcelHead(){
        List<String> titleList= new ArrayList<>();
        titleList.add("序号");
        titleList.add("产品类型");
        titleList.add("平台名称");
        titleList.add("商机线索开启");
        titleList.add("商机推进阶段1、商机线索0%");
        titleList.add("商机推进阶段2、商机发现10%");
        titleList.add("商机推进阶段3、商机确立25%");
        titleList.add("商机推进阶段4、商机确立50%");
        titleList.add("商机推进阶段5、商机确认75%");
        titleList.add("商机推进阶段6、商机赢取100%");
        titleList.add("商机推进阶段7、客户维护/回款阶段");
        titleList.add("商机关闭");
        titleList.add("初步意向方案（采购阶段）");
        titleList.add("写立项方案（采购阶段）");
        titleList.add("工时评估（采购阶段）");
        titleList.add("商务谈判（采购阶段）");
        titleList.add("请示拟写（采购阶段）");
        titleList.add("上会（采购阶段）");
        titleList.add("招投标（采购阶段）");
        titleList.add("请示OA审批（采购阶段）");
        titleList.add("合同拟写（采购阶段）");
        titleList.add("律师审核（采购阶段）");
        titleList.add("合同OA审批（采购阶段）");
        titleList.add("用章（采购阶段）");
        titleList.add("对方盖章（采购阶段）");
        titleList.add("扫描（采购阶段）");
        titleList.add("综合部归档（采购阶段）");
        titleList.add("首付款（采购阶段）");
        titleList.add("进度款（采购阶段）");
        titleList.add("尾款（采购阶段）");
        titleList.add("设计概要（产品阶段）");
        titleList.add("详细设计（产品阶段）");
        titleList.add("UI设计（产品阶段）");
        titleList.add("需求设计（产品阶段）");
        titleList.add("需求评审（产品阶段）");
        titleList.add("需求单确认（产品阶段）");
        titleList.add("验收（产品阶段）");
        titleList.add("技术选型（研发阶段）");
        titleList.add("环境部署（研发阶段）");
        titleList.add("框架设计（研发阶段）");
        titleList.add("开发进度10%（研发阶段）");
        titleList.add("开发进度25%（研发阶段）");
        titleList.add("开发进度50%（研发阶段）");
        titleList.add("开发进度75%（研发阶段）");
        titleList.add("开发进度100%（研发阶段）");
        titleList.add("内部测试优化（研发阶段）");
        titleList.add("客户测试优化（研发阶段）");
        titleList.add("实施交付（研发阶段）");
        titleList.add("验收（研发阶段）");
        titleList.add("运营阶段");
        titleList.add("运维阶段");
        return titleList;
    }

    /**
     * 导出excel头部内容对应的数据
     * @param sugarManage
     * @return
     */
    private List<List<String>> exportExcelData(TSugarProjectWithBLOBs sugarManage){
        List<List<String>> rowList=new ArrayList<>();
        //获取数据列表
        List<TSugarProjectWithBLOBs> list = sugarProjectSV.selectSugarList(sugarManage);
        List<String> row = null;
        int count=0;
        if(!CollectionUtils.isEmpty(list)){
            for(TSugarProjectWithBLOBs sugarLists :list){
                row = new ArrayList<>();
                count++;
                row.add(count+"");
                row.add(sugarLists.getProductType());
                row.add(sugarLists.getPlatformName());
                row.add(sugarLists.getBusinessClueOpen());
                row.add(sugarLists.getBusinessClue0());
                row.add(sugarLists.getBusinessDiscover10());
                row.add(sugarLists.getBusinessEstablish25());
                row.add(sugarLists.getBusinessEstablish50());
                row.add(sugarLists.getBusinessEstablish75());
                row.add(sugarLists.getBusinessWin100());
                row.add(sugarLists.getCustomerMaintainBackMoney());
                row.add(sugarLists.getBusinessClose());
                row.add(sugarLists.getInitialIntentionPlan());
                row.add(sugarLists.getWriteProjectProposal());
                row.add(sugarLists.getWorkingHoursAssess());
                row.add(sugarLists.getBusinessNegotiation());
                row.add(sugarLists.getRequestDraft());
                row.add(sugarLists.getAttendMeeting());
                row.add(sugarLists.getBidding());
                row.add(sugarLists.getRequestOaApproval());
                row.add(sugarLists.getContractDraft());
                row.add(sugarLists.getLawyerReview());
                row.add(sugarLists.getContractOaApproval());
                row.add(sugarLists.getUsageSeal());
                row.add(sugarLists.getOtherSeal());
                row.add(sugarLists.getScan());
                row.add(sugarLists.getGeneralDepartmentFile());
                row.add(sugarLists.getFirstPayment());
                row.add(sugarLists.getProgressPayment());
                row.add(sugarLists.getFinalPayment());
                row.add(sugarLists.getDesignBrief());
                row.add(sugarLists.getDetailedDesign());
                row.add(sugarLists.getUiDesign());
                row.add(sugarLists.getRequirementDesign());
                row.add(sugarLists.getRequirementsReview());
                row.add(sugarLists.getDemandOrderConfirm());
                row.add(sugarLists.getProCheckDeliver());
                row.add(sugarLists.getTechnologySelection());
                row.add(sugarLists.getEnvironmentDeployment());
                row.add(sugarLists.getFrameworkDesign());
                row.add(sugarLists.getDevelopProgress10());
                row.add(sugarLists.getDevelopProgress25());
                row.add(sugarLists.getDevelopProgress50());
                row.add(sugarLists.getDevelopProgress75());
                row.add(sugarLists.getDevelopProgress100());
                row.add(sugarLists.getInsideTest());
                row.add(sugarLists.getCustomerTest());
                row.add(sugarLists.getImplementDeliver());
                row.add(sugarLists.getCheckDeliver());
                row.add(sugarLists.getOperationPhase());
                row.add(sugarLists.getMaintainPhase());
                rowList.add(row);
            }
        }
        return rowList;
    }

    @RequestMapping("/echartForProject")
    @ResponseBody
    public List<TUserTaskVO> echartForProject(String platformName) throws ParseException {
        List<TUserTaskVO> result = new ArrayList<>();
        //List<ProjectChartVO> UserTaskTimes = new ArrayList<>();
        if(!StringUtils.isBlank(platformName)){
            //根据platFormName查询出Project
            TSugarProjectVO  sugarProject = iSugarProjectSV.selectSugarProjectByName(platformName);
            //取出ID去根据开始时间降序排序去查询t_user_task的数据列表
            if(sugarProject!=null){
                TUserTaskVO vo = new TUserTaskVO();
                vo.setTaskType("01");
                vo.setTaskStatus("2");//已完成
                vo.setProjectId(sugarProject.getId()+"");
                List<TUserTaskVO> tUserTasks = itUserTaskService.selectDoneSubTaskList(vo);

                if(!CollectionUtils.isEmpty(tUserTasks)){
                    //取出最后一条数据:大阶段开始的数据,取其开始时间      取出开始一条数据:大阶段目前处于位置,取其结束时间
                    Map<String, List<TUserTaskVO>> map = tUserTasks.stream().collect(Collectors.groupingBy(TUserTaskVO::getTaskName));

                    Set<Map.Entry<String, List<TUserTaskVO>>> entries = map.entrySet();
                    for (Map.Entry<String, List<TUserTaskVO>> entry : entries) {
                        TUserTaskVO taskVO = new TUserTaskVO();
                        taskVO.setTaskName(entry.getKey());
                        taskVO.setUserTaskVOList(entry.getValue());
                        result.add(taskVO);
                    }

//                    UserTaskTimes = new ArrayList<>();
//                    商机推进
//                    setUserTimes("1",map,UserTaskTimes);
//                    setUserTimes("2",map,UserTaskTimes);
//                    setUserTimes("3",map,UserTaskTimes);
//                    setUserTimes("4",map,UserTaskTimes);
//                    setUserTimes("5",map,UserTaskTimes);
//                    setUserTimes("6",map,UserTaskTimes);
                }

            }

        }
        return result;
    }

    private void setUserTimes(String key, Map<String,List<TUserTaskVO>> map,List<ProjectChartVO> UserTaskTimes){
        List<TUserTaskVO> tUserTasks = new ArrayList<>();
        ProjectChartVO chartVO = new ProjectChartVO();
        String[] projectStage = {"商机推进阶段","采购阶段","产品阶段","研发阶段", "运营阶段","运维阶段"};
        if(!CollectionUtils.isEmpty(map)) {
            //商机推进
            tUserTasks = map.get(key);
        }
        if (tUserTasks!=null && tUserTasks.size()!=0 &&  key.equals(tUserTasks.get(0).getTaskName())){
            chartVO.setTaskName(key);
            chartVO.setProjectStage(projectStage[Integer.parseInt(key)-1]);
            String startTime = simplify(tUserTasks.get(0).getStartTime());
            chartVO.setStartTime(startTime);
        }
        if ( tUserTasks!=null && tUserTasks.size()!=0 &&StringUtils.isBlank(tUserTasks.get(tUserTasks.size()-1).getEndTime())){
            String endTime = simplify(DateUtils.dateTimeNow("YYYY-MM-dd"));
            chartVO.setEndTime(endTime);
        }
        if(tUserTasks!=null && tUserTasks.size()!=0 && !StringUtils.isBlank(tUserTasks.get(tUserTasks.size()-1).getEndTime())){
            chartVO.setEndTime(tUserTasks.get(tUserTasks.size()-1).getEndTime());
        }
        if(chartVO!=null) {
            UserTaskTimes.add(chartVO);
        }
    }

    private String simplify(String date){
        int index1 =date.indexOf("-");
        int index2 =date.lastIndexOf("-");
        String time = "";
        if(date.indexOf(" ")!=-1){
            int index3 = date.indexOf(" ");
            time =" " + date.substring(index3+1);
        }
        int month;
        int day;

        int year=Integer.parseInt(date.substring(0,index1));
        if(date.substring(index1+1,index1+2).equals("0")){
            month=Integer.parseInt(date.substring(index1+2,index1+3));
        }else {
            month=Integer.parseInt(date.substring(index1+1,index1+3));
        }
        if(date.substring(index2+1,index2+2).equals("0")){
            day=Integer.parseInt(date.substring(index2+2,index2+3));
        }else{
            day=Integer.parseInt(date.substring(index2+1,index2+3));
        }
        String date1=(year+"-"+month+"-"+day)+""+time;
        return  date1;
    }
}
