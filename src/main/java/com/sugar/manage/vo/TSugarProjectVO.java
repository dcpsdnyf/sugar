package com.sugar.manage.vo;


import com.sugar.manage.dao.vo.BaseModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: sugarManage
 * @description: 项目信息
 * @author: liangbq
 * @create: 2020-08-30 13:41
 */
@Data
public class TSugarProjectVO extends BaseModel implements Serializable,Cloneable{
    /** 索引值 */
    private Integer id ;
    /** 产品类型 */
    private String productType ;
    /** 平台名称 */
    private String platformName ;
    /** 5、需求评审 */private String businessClueOpen;

    private String businessClue0;

    private String businessDiscover10;

    private String businessEstablish25;

    private String businessEstablish50;

    private String businessEstablish75;

    private String businessWin100;

    private String customerMaintainBackMoney;

    private String businessClose;

    private String initialIntentionPlan;

    private String writeProjectProposal;

    private String workingHoursAssess;

    private String businessNegotiation;

    private String requestDraft;

    private String attendMeeting;

    private String bidding;

    private String requestOaApproval;

    private String contractDraft;

    private String lawyerReview;

    private String contractOaApproval;

    private String usageSeal;

    private String otherSeal;

    private String scan;

    private String generalDepartmentFile;

    private String firstPayment;

    private String progressPayment;

    private String finalPayment;

    private String designBrief;

    private String detailedDesign;

    private String uiDesign;

    private String requirementDesign;

    private String requirementsReview;

    private String demandOrderConfirm;

    private String proCheckDeliver;

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

    private String operationPhase;

    private String maintainPhase;

    private String roleType;

}