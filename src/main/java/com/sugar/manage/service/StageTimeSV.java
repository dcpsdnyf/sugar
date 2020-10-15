package com.sugar.manage.service;

import com.sugar.manage.vo.StageTimeVO;

import java.util.List;

public interface StageTimeSV {

    public List<StageTimeVO> selectStageTimeList(StageTimeVO vo);
}
