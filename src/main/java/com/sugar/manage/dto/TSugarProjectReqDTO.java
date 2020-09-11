package com.sugar.manage.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TSugarProjectReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String productType;

    private String platformName;

    private String platformId;

    private String groupName;

    private String status;

    private String createdStaff;

    private Date createdTime;

    private String updatedStaff;

    private Date updatedTime;

    private Integer sort;

    //==================商机推进阶段开始==================
    private String businessClueOpen;

    private String businessClue0;

    private String businessDiscover10;

    private String businessEstablish25;

    private String businessEstablish50;

    private String businessEstablish75;

    private String businessWin100;

    private String customerMaintainBackMoney;

    private String businessClose;
    //==================商机推进阶段结束==================

    //==================采购阶段开始==================
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
    //==================采购阶段开始==================

    //==================产品阶段开始==================
    private String designBrief;

    private String detailedDesign;

    private String uiDesign;

    private String requirementDesign;

    private String requirementsReview;

    private String demandOrderConfirm;

    private String proCheckDeliver;
    //==================产品阶段结束==================

    //==================研发阶段开始==================
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
    //==================研发阶段结束==================

    private String operationPhase;

    private String maintainPhase;

    /** 要更改的字段名称 */
    private String fieldName;
}
