package com.sugar.manage.service.impl;

import com.sugar.manage.dao.mapper.TStagePrincipalMapper;
import com.sugar.manage.dao.model.TStagePrincipal;
import com.sugar.manage.dao.model.TStagePrincipalExample;
import com.sugar.manage.dao.vo.TStagePrincipalVO;
import com.sugar.manage.service.IStagePrincipalSV;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStagePrincipalSVImpl implements IStagePrincipalSV {

    @Autowired
    private TStagePrincipalMapper stagePrincipalMapper;

    @Override
    public List<TStagePrincipal> selectStagePrincipalList(TStagePrincipalVO vo) {
        TStagePrincipalExample example = new TStagePrincipalExample();
        TStagePrincipalExample.Criteria sql = example.createCriteria();
        if(StringUtils.isNotBlank(vo.getStageNum())){
            sql.andStageNumEqualTo(vo.getStageNum());
        }

        List<TStagePrincipal> principalList = stagePrincipalMapper.selectByExample(example);

        return principalList;
    }
}
