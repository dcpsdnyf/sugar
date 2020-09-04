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

    private String businessClueOpen;

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

    public void setFrameworkDesign(String frameworkDesign) {
        this.frameworkDesign = frameworkDesign;
    }

    public String getDevelopProgress10() {
        return developProgress10;
    }

    public void setDevelopProgress10(String developProgress10) {
        this.developProgress10 = developProgress10;
    }

    public String getDevelopProgress25() {
        return developProgress25;
    }

    public void setDevelopProgress25(String developProgress25) {
        this.developProgress25 = developProgress25;
    }

    public String getDevelopProgress50() {
        return developProgress50;
    }

    public void setDevelopProgress50(String developProgress50) {
        this.developProgress50 = developProgress50;
    }

    public String getDevelopProgress75() {
        return developProgress75;
    }

    public void setDevelopProgress75(String developProgress75) {
        this.developProgress75 = developProgress75;
    }

    public String getDevelopProgress100() {
        return developProgress100;
    }

    public void setDevelopProgress100(String developProgress100) {
        this.developProgress100 = developProgress100;
    }

    public String getInsideTest() {
        return insideTest;
    }

    public void setInsideTest(String insideTest) {
        this.insideTest = insideTest;
    }

    public String getCustomerTest() {
        return customerTest;
    }

    public void setCustomerTest(String customerTest) {
        this.customerTest = customerTest;
    }

    public String getImplementDeliver() {
        return implementDeliver;
    }

    public void setImplementDeliver(String implementDeliver) {
        this.implementDeliver = implementDeliver;
    }

    public String getCheckDeliver() {
        return checkDeliver;
    }

    public void setCheckDeliver(String checkDeliver) {
        this.checkDeliver = checkDeliver;
    }

    public String getOperationPhase() {
        return operationPhase;
    }

    public void setOperationPhase(String operationPhase) {
        this.operationPhase = operationPhase;
    }

    public String getMaintainPhase() {
        return maintainPhase;
    }

    public void setMaintainPhase(String maintainPhase) {
        this.maintainPhase = maintainPhase;
    }
}