package com.sugar.manage.service.impl;

import com.sugar.common.utils.ModelCopyUtil;
import com.sugar.manage.dao.mapper.StageTimeMapper;
import com.sugar.manage.dao.model.StageTime;
import com.sugar.manage.dao.model.StageTimeExample;
import com.sugar.manage.service.StageTimeSV;
import com.sugar.manage.vo.StageTimeVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageTimeSVImpl implements StageTimeSV {

    @Autowired
    private StageTimeMapper stageTimeMapper;

    @Override
    public List<StageTimeVO> selectStageTimeList(StageTimeVO vo) {

        StageTimeExample example = new StageTimeExample();
        StageTimeExample.Criteria sql = example.createCriteria();
        if(StringUtils.isNotBlank(vo.getStageType())){
            sql.andStageTypeEqualTo(vo.getStageType());
        }

        List<StageTimeVO> stageTimeVOList = null;
        List<StageTime> stageTimeList = stageTimeMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(stageTimeList)){
            stageTimeVOList = ModelCopyUtil.copyToList(stageTimeList, StageTimeVO.class);
        }

        return stageTimeVOList;
    }
}
