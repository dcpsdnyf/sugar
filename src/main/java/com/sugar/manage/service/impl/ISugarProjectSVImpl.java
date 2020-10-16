package com.sugar.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.DateUtils;
import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.mapper.TSugarProjectExMapper;
import com.sugar.manage.dao.mapper.TSugarProjectMapper;
import com.sugar.manage.dao.mapper.TUserTaskExMapper;
import com.sugar.manage.dao.mapper.TUserTaskMapper;
import com.sugar.manage.dao.model.*;
import com.sugar.manage.dao.vo.GroupSugarList;
import com.sugar.manage.dto.TSugarProjectReqDTO;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.vo.TSugarProjectVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
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
    private TUserTaskExMapper tUserTaskMapper;
    @Autowired
    private TSugarProjectExMapper sugarProjectExMapper;
    @Autowired
    private TUserTaskMapper taskMapper;

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

        if(!projectVO.isViewAllProject()){
            TUserTaskExample taskExample = new TUserTaskExample();
            TUserTaskExample.Criteria criteria = taskExample.createCriteria();
            criteria.andTaskPrincipalEqualTo(projectVO.getUserName());
            criteria.andStatusEqualTo("01");
            List<TUserTask> userTaskList = taskMapper.selectByExample(taskExample);

            if(!CollectionUtils.isEmpty(userTaskList)){
                List<Integer> projectIdList = new ArrayList<>();
                for(TUserTask userTask : userTaskList){
                    if(StringUtils.isNotBlank(userTask.getProjectId())){
                        projectIdList.add(Integer.parseInt(userTask.getProjectId()));
                    }
                }
                sql.andIdIn(projectIdList);
            }else {
                return new PageInfo<>();
            }
        }

		//列表按照产品类型进行排序展示
		example.setOrderByClause(" product_type asc ");
		PageHelper.startPage(projectVO.getPage(), projectVO.getLimit());

		List<TSugarProjectWithBLOBs> sugarProject = sugarProjectMapper.selectByExampleWithBLOBs(example);

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
	public GroupSugarList getSugarProjectGroupList(TSugarProjectVO projectVO) {
        GroupSugarList groupSugarList = new GroupSugarList();

		TSugarProjectExample example = new TSugarProjectExample();
		TSugarProjectExample.Criteria sql = example.createCriteria();
		sql.andStatusEqualTo("01");

        if(!projectVO.isViewAllProject()){
            TUserTaskExample taskExample = new TUserTaskExample();
            TUserTaskExample.Criteria criteria = taskExample.createCriteria();
            if(StringUtils.isNotBlank(projectVO.getUserName())){
                criteria.andTaskPrincipalEqualTo(projectVO.getUserName());
            }
            criteria.andStatusEqualTo("01");
            List<TUserTask> userTaskList = taskMapper.selectByExample(taskExample);

            if(!CollectionUtils.isEmpty(userTaskList)){
                List<Integer> projectIdList = new ArrayList<>();
                for(TUserTask userTask : userTaskList){
                    if(StringUtils.isNotBlank(userTask.getProjectId())){
                        projectIdList.add(Integer.parseInt(userTask.getProjectId()));
                    }
                }
                sql.andIdIn(projectIdList);
            }else {
                return groupSugarList;
            }
        }

		List<TSugarProjectWithBLOBs> sugarProject = sugarProjectMapper.selectByExampleWithBLOBs(example);

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
	 * @param vo 参数对象
	 */
	@Override
	public void saveSugarProject(TSugarProjectVO vo) {
        TSugarProjectWithBLOBs record = ModelCopyUtil.copy(vo, TSugarProjectWithBLOBs.class);

        int  count = sugarProjectExMapper.insertSugarProject(record);
	    if (count>0) {

            TUserTask tUserTask =new TUserTask();
            tUserTask.setPrincipal(record.getTaskPrincipal());
            tUserTask.setTaskPrincipal(record.getTaskPrincipal());
            tUserTask.setStartTime(record.getStartTime());
            tUserTask.setTaskType("00");
            tUserTask.setTaskStatus("0");
            tUserTask.setTaskName("1");
            tUserTask.setStatus("01");
            tUserTask.setCreatedTime(DateUtils.getNowDate());
            tUserTask.setProjectId(record.getId()+"");
            tUserTask.setPlatformName(record.getPlatformName());
            tUserTask.setProductType(record.getProductType());
            tUserTask.setGroupName(record.getGroupName());

            taskMapper.insertSelective(tUserTask);
        }
	}

    @Override
    public int updateSugarProject(TSugarProjectVO vo){
        TSugarProjectWithBLOBs project = ModelCopyUtil.copy(vo, TSugarProjectWithBLOBs.class);
        if(vo.getId()==null){
            return 0;
        }

        //查询商机阶段经理负责人,若该阶段未指派，则重新生成指派任务,原来的指派任务状态改为删除状态,
        //若该阶段已指派,不更新商机阶段负责人

        TUserTaskExample example = new TUserTaskExample();
        TUserTaskExample.Criteria sql = example.createCriteria();

        sql.andStatusEqualTo("01");
        sql.andProjectIdEqualTo(vo.getId()+"");
        sql.andTaskTypeEqualTo("00");
        sql.andTaskNameEqualTo("1");
        sql.andTaskStatusNotEqualTo("2");
        List<TUserTask> userTaskList = taskMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userTaskList)){
            TUserTask task = userTaskList.get(0);
            if(StringUtils.isNotBlank(vo.getTaskPrincipal())){
                if(!vo.getTaskPrincipal().equals(task.getTaskPrincipal())){
                    task.setStatus("99");
                    taskMapper.updateByPrimaryKeySelective(task);


                    TUserTask newTask = ModelCopyUtil.copy(task, TUserTask.class);
                    newTask.setId(null);
                    newTask.setStatus("01");
                    newTask.setCreatedTime(DateUtils.getNowDate());
                    newTask.setPrincipal(vo.getTaskPrincipal());
                    newTask.setTaskPrincipal(vo.getTaskPrincipal());
                    taskMapper.insertSelective(newTask);
                }
            }

        }else {
            project.setTaskPrincipal(null);//设置为null不更新原来的
        }

        if(StringUtils.isBlank(project.getProductType())){
            project.setProductType(null);
        }
        if(StringUtils.isBlank(project.getPlatformName())){
            project.setPlatformName(null);
        }
        if(StringUtils.isBlank(project.getGroupName())){
            project.setGroupName(null);
        }
        if(StringUtils.isBlank(project.getTaskPrincipal())){
            project.setTaskPrincipal(null);
        }
        if(StringUtils.isNotBlank(project.getTaskPrincipal())){
            project.setBusinessPrincipal(project.getTaskPrincipal());
        }


        project.setUpdatedTime(DateUtils.getNowDate());

        return sugarProjectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public int deleteByPrimaryKey(TSugarProjectWithBLOBs project){

        return sugarProjectMapper.updateByPrimaryKeySelective(project);
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
    public TSugarProject selectSugarProjectByName(String platformName) {
        TSugarProjectExample example = new TSugarProjectExample();
        TSugarProjectExample.Criteria sql = example.createCriteria();
        sql.andPlatformNameEqualTo(platformName);
        List<TSugarProject> tSugarProjects = sugarProjectMapper.selectByExample(example);
        TSugarProject sugarProject = new TSugarProject();
        sugarProject = tSugarProjects.get(0);
        return sugarProject;
    }

    @Override
    public TSugarProjectVO getSugarProjectById(TSugarProjectVO vo) {
	    if(vo.getId()!=null){
            TSugarProjectWithBLOBs project = sugarProjectMapper.selectByPrimaryKey(vo.getId());
            return ModelCopyUtil.copy(project,TSugarProjectVO.class);
        }
        return null;
    }
}
