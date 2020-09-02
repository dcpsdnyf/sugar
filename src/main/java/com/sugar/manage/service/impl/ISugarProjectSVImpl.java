package com.sugar.manage.service.impl;

import com.sugar.common.utils.ModelCopyUtil;
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
        sql.andStatusEqualTo("01");

        this.initParam(sql,projectVO);

        List<TSugarProjectWithBLOBs> sugarProject =  sugarProjectMapper.selectByExampleWithBLOBs(example);
        if(!CollectionUtils.isEmpty(sugarProject)){
            ArrayList<TSugarProjectVO> result = new ArrayList<>();

            for (TSugarProjectWithBLOBs s:sugarProject){
                TSugarProjectVO copy = ModelCopyUtil.copy(s, TSugarProjectVO.class);
                result.add(copy);
            }

            return result;
        }

        return null;
    }

    /**
     * 保存及更新项目信息
     *
     * @param record 参数对象
     */
    @Override
    public void saveSugarProject(TSugarProjectWithBLOBs record) {
        /*int a=sugarProjectMapper.insertType(project);
        if (a>0){
            System.out.println(a);
        }*/
        sugarProjectMapper.insert(record);
    }

    @Override
    public int updateSugarProject(TSugarProjectWithBLOBs project){
        /*int a=sugarProjectMapper.updateSugarProject(project);
        return a;*/
        sugarProjectMapper.updateByPrimaryKeySelective(project);
        return 1;
    }
    @Override
    public int deleteByPrimaryKey(TSugarProjectWithBLOBs project){
        sugarProjectMapper.updateByPrimaryKeySelective(project);
        return 1;
    }

}
