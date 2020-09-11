package com.sugar.manage.vo;

import lombok.Data;

/**
 * 产品阶段对应字段实体类
 */
@Data
public class ProductPhaseVO {

    private String designBrief;

    private String detailedDesign;

    private String uiDesign;

    private String requirementDesign;

    private String requirementsReview;

    private String demandOrderConfirm;

    private String proCheckDeliver;
}
