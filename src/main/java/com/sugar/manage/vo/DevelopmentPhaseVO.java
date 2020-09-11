package com.sugar.manage.vo;

import lombok.Data;

/**
 * 研发阶段对应字段实体类
 */
@Data
public class DevelopmentPhaseVO {

    private String technologySelection;

    private String environmentDeployment;

    private String frameworkDesign;

    private String developProgress10;

    private String developProgress25;

    private String developProgress50;

    private String developProgress75;

    private String developProgress100;

    private String insideTest;

    private String customerTest;

    private String implementDeliver;

    private String checkDeliver;
}
