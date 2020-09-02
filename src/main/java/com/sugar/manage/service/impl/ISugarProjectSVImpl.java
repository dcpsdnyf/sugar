package com.sugar.manage.service.impl;

import com.sugar.manage.dao.mapper.TSugarProjectMapper;
import com.sugar.manage.dao.model.TSugarProject;
import com.sugar.manage.dao.model.TSugarProjectExample;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.service.ISugarProjectSV;
import com.sugar.manage.vo.TSugarProjectVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
     * @param projectVO
     */
    private void initParam(TSugarProjectExample.Criteria sql, TSugarProjectVO projectVO){
        if(StringUtils.isBlank(projectVO.getCheckDeliver())){

        }

    }

    /**
     * 获取项目列表信息
     *
     * @param projectVO 参数对象
     * @return 返回信息
     */
    @Override
    public List<TSugarProjectVO> getSugarProjectList(TSugarProjectVO projectVO) {
        TSugarProjectExample example = new TSugarProjectExample();
        TSugarProjectExample.Criteria sql = example.createCriteria();

        this.initParam(sql,projectVO);

        List<TSugarProjectWithBLOBs> sugarProject =  sugarProjectMapper.selectByExampleWithBLOBs(example);
        if(!CollectionUtils.isEmpty(sugarProject)){
            ArrayList<TSugarProjectVO> result = new ArrayList<>();

            for (TSugarProjectWithBLOBs s:sugarProject){
                TSugarProjectVO t = new TSugarProjectVO();
                t.setId(s.getId());
                t.setProductType(s.getProductType());
                t.setPlatformName(s.getPlatformName());
                t.setDemandReview(s.getDemandReview());
                t.setDemandConfirm(s.getDemandConfirm());
                t.setDemandCheck(s.getDemandCheck());
                t.setTechnologySelection(s.getTechnologySelection());
                t.setEnvironmentDeployment(s.getEnvironmentDeployment());
                t.setFrameworkDesign(s.getFrameworkDesign());
                t.setDevelopProgress10(s.getDevelopProgress10());
                t.setDevelopProgress25(s.getDevelopProgress25());
                t.setDevelopProgress50(s.getDevelopProgress50());
                t.setDevelopProgress75(s.getDevelopProgress75());
                t.setDevelopProgress100(s.getDevelopProgress100());
                t.setInsideTest(s.getInsideTest());
                t.setCustomerTest(s.getCustomerTest());
                t.setImplementDeliver(s.getImplementDeliver());
                t.setCheckDeliver(s.getCheckDeliver());
                t.setStatus(s.getStatus());
                t.setCreatedStaff(s.getCreatedStaff());
                t.setCreatedTime(s.getCreatedTime());
                t.setUpdatedStaff(s.getUpdatedStaff());
                t.setUpdatedTime(s.getUpdatedTime());
                result.add(t);
            }

            return result;
        }

        return null;
    }

    /**
     * 保存及更新项目信息
     *
     * @param project 参数对象
     */
    @Override
    public void saveSugarProject(TSugarProject project) {
        int a=sugarProjectMapper.insertType(project);
        if (a>0){
            System.out.println(a);
        }

    }

    @Override
    public int updateSugarProject(TSugarProjectWithBLOBs project){
        int a=sugarProjectMapper.updateSugarProject(project);
        return a;
    }
    @Override
    public int deleteByPrimaryKey(Integer id){
        int a=sugarProjectMapper.deleteByPrimaryKey(id);
        return a;
    }

}
