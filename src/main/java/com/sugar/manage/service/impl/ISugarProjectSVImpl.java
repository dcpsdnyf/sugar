package com.sugar.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sugar.manage.dao.mapper.TSugarProjectMapper;
import com.sugar.manage.dao.model.TSugarProjectExample;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.dao.vo.GroupSugarList;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.vo.TSugarProjectVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
		sugarProjectMapper.insert(record);
	}

	@Override
	public int updateSugarProject(TSugarProjectWithBLOBs project) {
		if (StringUtils.isBlank(project.getProductType())) {
			project.setProductType(null);
		}
		if (StringUtils.isBlank(project.getPlatformName())) {
			project.setPlatformName(null);
		}
		sugarProjectMapper.updateByPrimaryKeySelective(project);
		return 1;
	}

	@Override
	public int deleteByPrimaryKey(TSugarProjectWithBLOBs project) {
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

}
