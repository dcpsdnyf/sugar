package com.sugar.manage.vo;

import lombok.Data;

@Data
public class ProjectChartVO {

    //阶段名称
    private String projectStage;

    //阶段标志
    private String taskName;

    //开始时间
    private String startTime;

    //结束时间
    private String endTime;
}
