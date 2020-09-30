package com.sugar.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.DateUtils;
import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.mapper.TSugarProjectMapper;
import com.sugar.manage.dao.mapper.TUserTaskMapper;
import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.dao.model.TSugarProjectExample;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.dao.vo.GroupSugarList;
import com.sugar.manage.dao.vo.TUserTask;
import com.sugar.manage.dto.TSugarProjectReqDTO;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.vo.FieldNameMaps;
import com.sugar.manage.vo.TSugarProjectVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: sugarManage
 * @description: 项目管理对接数据库层
 * @author: liangbq
 * @create: 2020-08-30 18:38
 */
@Service
public class ISugarProjectSVImpl implements ISugarProjectSV {

	@Autowired
	private TSugarProjectMapper sugarProjectMapper;
	@Autowired
    private TUserTaskMapper tUserTaskMapper;

	/**
	 * 初始化参数信息
	 *
	 * @param projectVO
	 */
	private void initParam(TSugarProjectExample.Criteria sql, TSugarProjectVO projectVO) {
		if (StringUtils.isBlank(projectVO.getCheckDeliver())) {

		}

	}

	/**
	 * 获取项目列表信息
	 *
	 * @param projectVO 参数对象
	 * @return 返回信息
	 */
	@Override
	public PageInfo<TSugarProjectWithBLOBs> getSugarProjectList(TSugarProjectVO projectVO) {
		TSugarProjectExample example = new TSugarProjectExample();
		TSugarProjectExample.Criteria sql = example.createCriteria();
		sql.andStatusEqualTo("01");

		//产品类型
		if (StringUtils.isNotBlank(projectVO.getProductType())) {
			sql.andProductTypeLike(projectVO.getProductType());
		}
		//平台名称
		if (StringUtils.isNotBlank(projectVO.getPlatformName())) {
			sql.andPlatformNameLike(projectVO.getPlatformName());
		}
		//集团名称
		if (StringUtils.isNotBlank(projectVO.getGroupName())) {
			sql.andGroupNameLike(projectVO.getGroupName());
		}


		this.initParam(sql, projectVO);
		//列表按照产品类型进行排序展示
		example.setOrderByClause(" product_type asc ");
		PageHelper.startPage(projectVO.getPage(), projectVO.getLimit());

		List<TSugarProjectWithBLOBs> sugarProject = sugarProjectMapper.selectByExampleWithBLOBs(example);
		//根据项目id获取任务表中最新负责人
        List<String>  ls= new ArrayList<>();
		if (sugarProject.size()>0) {
		    for (TSugarProjectWithBLOBs sugpj : sugarProject) {
              if (sugpj.getId() !=0 ) {
                  ls.add(String.valueOf(sugpj.getId()));
              }
            }
        }
		HashMap<String,String> hsmap = new HashMap<>();
        List<TUserTask> hsmp = tUserTaskMapper.getTkPrincipalByPjId(ls);
		if (hsmp.size()>0) {
		    for (int i = 0;i<hsmp.size();i++) {
                if (StringUtils.isNotBlank(hsmp.get(i).getProjectId())) {
                    hsmap.put(hsmp.get(i).getProjectId(),hsmp.get(i).getTaskPrincipal());
                }
            }
        }
		if (sugarProject.size()>0) {
		    for (int i = 0;i<sugarProject.size();i++) {
                sugarProject.get(i).setTaskPrincipal(hsmap.get(String.valueOf(sugarProject.get(i).getId())));
            }
        }
		if (!CollectionUtils.isEmpty(sugarProject)) {
			PageInfo<TSugarProjectWithBLOBs> pageInfo = new PageInfo<>(sugarProject);
			return pageInfo;
		}

		return new PageInfo<>();
	}

	/**
	 * 获取所有项目信息并分组
	 *
	 * @return
	 */
	@Override
	public GroupSugarList getSugarProjectGroupList() {

		TSugarProjectExample example = new TSugarProjectExample();
		TSugarProjectExample.Criteria sql = example.createCriteria();
		sql.andStatusEqualTo("01");
		List<TSugarProjectWithBLOBs> sugarProject = sugarProjectMapper.selectByExampleWithBLOBs(example);
		GroupSugarList groupSugarList = new GroupSugarList();
		if (!CollectionUtils.isEmpty(sugarProject)) {
			//产品类型
			groupSugarList.setProductType(sugarProject.stream().map(TSugarProjectWithBLOBs::getProductType).collect(Collectors.toList()));
			//平台名称
			groupSugarList.setPlatformName(sugarProject.stream().map(TSugarProjectWithBLOBs::getPlatformName).collect(Collectors.toList()));
			//集团名称
			groupSugarList.setGroupName(sugarProject.stream().map(TSugarProjectWithBLOBs::getGroupName).collect(Collectors.toList()));
		}
		return groupSugarList;
	}

	/**
	 * 保存及更新项目信息
	 *
	 * @param record 参数对象
	 */
	@Override
	public void saveSugarProject(TSugarProjectWithBLOBs record) {
      int  count = sugarProjectMapper.insert(record);
	    if (count>0) {
	        //再获取刚才插入数据的id
          Long id =  sugarProjectMapper.getProjectId(record.getTaskPrincipal());


            TUserTask tUserTask =new TUserTask();
            tUserTask.setTaskPrincipal(record.getTaskPrincipal());
            tUserTask.setStartTime(record.getStartTime());
            tUserTask.setTaskType("00");
            tUserTask.setTaskStatus("0");
            tUserTask.setTaskName("1");
            Date date = new Date(System.currentTimeMillis());
            tUserTask.setCreatedTime(date);
            if (id != 0) {
                tUserTask.setProjectId(String.valueOf(id));
            }
            tUserTaskMapper.insertTUserTask(tUserTask);
        }
	}

    @Override
    public int updateSugarProject(TSugarProjectReqDTO reqDTO){
        TSugarProjectWithBLOBs project = ModelCopyUtil.copy(reqDTO, TSugarProjectWithBLOBs.class);

        Map<String, String> businessPhaseFieldsMap = FieldNameMaps.businessPhaseFieldsMap;
        Map<String,String> purchasePhaseFieldsMap = FieldNameMaps.purchasePhaseFieldsMap;
        Map<String,String> productPhaseFieldsMap = FieldNameMaps.productPhaseFieldsMap;
        Map<String,String> developmentPhaseFieldsMap = FieldNameMaps.developmentPhaseFieldsMap;

        String fieldName = reqDTO.getFieldName();

        /*商机推进阶段*/
        if(businessPhaseFieldsMap.containsKey(fieldName)){
            if(StringUtils.isNotBlank(fieldName)){

                if(!"businessClue0".equals(fieldName)){
                    project.setBusinessClue0("");
                }
                if(!"businessDiscover10".equals(fieldName)){
                    project.setBusinessDiscover10("");
                }
                if(!"businessEstablish25".equals(fieldName)){
                    project.setBusinessEstablish25("");
                }
                if(!"businessEstablish50".equals(fieldName)){
                    project.setBusinessEstablish50("");
                }
                if(!"businessEstablish75".equals(fieldName)){
                    project.setBusinessEstablish75("");
                }
                if(!"businessWin100".equals(fieldName)){
                    project.setBusinessWin100("");
                }
                if(!"customerMaintainBackMoney".equals(fieldName)){
                    project.setCustomerMaintainBackMoney("");
                }
            }
        }

        /*采购阶段*/
        if(purchasePhaseFieldsMap.containsKey(fieldName)) {
            if(StringUtils.isNotBlank(fieldName)) {
                if(!"initialIntentionPlan".equals(fieldName)){
                    project.setInitialIntentionPlan("");
                }
                if(!"writeProjectProposal".equals(fieldName)){
                    project.setWriteProjectProposal("");
                }
                if(!"workingHoursAssess".equals(fieldName)){
                    project.setWorkingHoursAssess("");
                }
                if(!"businessNegotiation".equals(fieldName)){
                    project.setBusinessNegotiation("");
                }
                if(!"requestDraft".equals(fieldName)){
                    project.setRequestDraft("");
                }
                if(!"attendMeeting".equals(fieldName)){
                    project.setAttendMeeting("");
                }
                if(!"bidding".equals(fieldName)){
                    project.setBidding("");
                }
                if(!"requestOaApproval".equals(fieldName)){
                    project.setRequestOaApproval("");
                }
                if(!"contractDraft".equals(fieldName)){
                    project.setContractDraft("");
                }
                if(!"lawyerReview".equals(fieldName)){
                    project.setLawyerReview("");
                }
                if(!"contractOaApproval".equals(fieldName)){
                    project.setContractOaApproval("");
                }
                if(!"usageSeal".equals(fieldName)){
                    project.setUsageSeal("");
                }
                if(!"otherSeal".equals(fieldName)){
                    project.setOtherSeal("");
                }
                if(!"scan".equals(fieldName)){
                    project.setScan("");
                }
                if(!"generalDepartmentFile".equals(fieldName)){
                    project.setGeneralDepartmentFile("");
                }
                if(!"firstPayment".equals(fieldName)){
                    project.setFirstPayment("");
                }
                if(!"progressPayment".equals(fieldName)){
                    project.setProgressPayment("");
                }
                if(!"finalPayment".equals(fieldName)){
                    project.setFinalPayment("");
                }
            }

        }

        /*产品阶段*/
        if(productPhaseFieldsMap.containsKey(fieldName)){
            if(!"designBrief".equals(fieldName)){
                project.setDesignBrief("");
            }
            if(!"detailedDesign".equals(fieldName)){
                project.setDetailedDesign("");
            }
            if(!"uiDesign".equals(fieldName)){
                project.setUiDesign("");
            }
            if(!"requirementDesign".equals(fieldName)){
                project.setRequirementDesign("");
            }
            if(!"requirementsReview".equals(fieldName)){
                project.setRequirementsReview("");
            }
            if(!"demandOrderConfirm".equals(fieldName)){
                project.setDemandOrderConfirm("");
            }
            if(!"proCheckDeliver".equals(fieldName)){
                project.setProCheckDeliver("");
            }
        }

        /*研发阶段*/
        if(developmentPhaseFieldsMap.containsKey(fieldName)){
            if(!"technologySelection".equals(fieldName)){
                project.setTechnologySelection("");
            }
            if(!"environmentDeployment".equals(fieldName)){
                project.setEnvironmentDeployment("");
            }
            if(!"frameworkDesign".equals(fieldName)){
                project.setFrameworkDesign("");
            }
            if(!"developProgress10".equals(fieldName)){
                project.setDevelopProgress10("");
            }
            if(!"developProgress25".equals(fieldName)){
                project.setDevelopProgress25("");
            }
            if(!"developProgress50".equals(fieldName)){
                project.setDevelopProgress50("");
            }
            if(!"developProgress75".equals(fieldName)){
                project.setDevelopProgress75("");
            }
            if(!"developProgress100".equals(fieldName)){
                project.setDevelopProgress100("");
            }
            if(!"insideTest".equals(fieldName)){
                project.setInsideTest("");
            }
            if(!"customerTest".equals(fieldName)){
                project.setCustomerTest("");
            }
            if(!"implementDeliver".equals(fieldName)){
                project.setImplementDeliver("");
            }
            if(!"checkDeliver".equals(fieldName)){
                project.setCheckDeliver("");
            }
        }

        if(StringUtils.isBlank(project.getProductType())){
            project.setProductType(null);
        }
        if(StringUtils.isBlank(project.getPlatformName())){
            project.setPlatformName(null);
        }

        project.setUpdatedTime(DateUtils.getNowDate());

        sugarProjectMapper.updateByPrimaryKeySelective(project);
        return 1;
    }
    @Override
    public int deleteByPrimaryKey(TSugarProjectWithBLOBs project){
        sugarProjectMapper.updateByPrimaryKeySelective(project);
        return 1;
    }

	@Override
	public List<TSugarProjectWithBLOBs> selectSugarList(TSugarProjectWithBLOBs sugarList) {
		TSugarProjectExample example = new TSugarProjectExample();
		TSugarProjectExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("01");
		List<TSugarProjectWithBLOBs> sugarLists = sugarProjectMapper.selectByExampleWithBLOBs(example);

		return sugarLists;
	}

    @Override
    public List<TSugarProject> getProductHeaderByProjectIds(List<Integer> projectIds) {

        return sugarProjectMapper.getProductHeaderByProjectIds(projectIds);
    }

}
