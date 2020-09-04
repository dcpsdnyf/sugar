package com.sugar.manage.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sugar.common.AppBaseController;
import com.sugar.common.utils.CookieUtils;
import com.sugar.common.utils.ExcelUtils;
import com.sugar.common.utils.JsonUtil;
import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.dao.model.TUser;
import com.sugar.manage.dao.vo.TableDataInfo;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.service.IUserRoleSV;
import com.sugar.manage.service.IUserSV;
import com.sugar.manage.vo.RoleProjectVO;
import com.sugar.manage.vo.TSugarProjectVO;
import com.sugar.manage.vo.TUserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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


    /**
     * 项目进度初始化界面
     * @return
     */
    @RequestMapping("/init")
    public String initSugarManage(HttpServletResponse response, HttpServletRequest request, TUserVO tUser){
        if(!StringUtils.isBlank(tUser.getUserName()) || StringUtils.isNotBlank(tUser.getUserAccount())){
            TUser user = userSV.getUserList(tUser);
            if(tUser != null){
                CookieUtils.setCookie(response, "SUGAR_USER_ID","" + user.getId());
            }
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
            }

            String roleTypes = null;
            String projectIds = null;
            if(roleProjectVO!=null){
                roleTypes = roleProjectVO.getRoleTypes();
                projectIds = roleProjectVO.getProjectIds();
            }

            PageInfo<TSugarProjectWithBLOBs> page = sugarProjectSV.getSugarProjectList(projectVO);
            List<TSugarProjectWithBLOBs> list = page.getList();
            List<TSugarProjectVO> tSugarProjectVOSList = new ArrayList<>() ;
            if(!CollectionUtils.isEmpty(list)){
                for (TSugarProjectWithBLOBs t : list){
                    TSugarProjectVO tSugarProjectVO = ModelCopyUtil.copy(t, TSugarProjectVO.class);
                    tSugarProjectVO.setRoleType(roleTypes);
                    tSugarProjectVO.setProjectIds(projectIds);
                    tSugarProjectVOSList.add(tSugarProjectVO);
                }
            }

            tableDataInfo.setRows(tSugarProjectVOSList);
            tableDataInfo.setTotal(page.getTotal());
            tableDataInfo.setCode(200);
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
    public String newlyAdded(HttpServletRequest request, TSugarProjectWithBLOBs record){
        // String userId = CookieUtils.getCookie(request, "SUGAR_USER_ID");
        // TUser user = new TUser();
        // user.setId(Integer.parseInt(userId));
        record.setStatus("01");
        sugarProjectSV.saveSugarProject(record);
        return "redirect:/sugarManage/init";
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
}
