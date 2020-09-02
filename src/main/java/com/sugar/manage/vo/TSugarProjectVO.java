package com.sugar.manage.vo;


import java.io.Serializable;
import java.util.Date;

/**
 * @program: sugarManage
 * @description: 项目信息
 * @author: liangbq
 * @create: 2020-08-30 13:41
 */
public class TSugarProjectVO implements Serializable,Cloneable{
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getBusinessClueOpen() {
        return businessClueOpen;
    }

    public void setBusinessClueOpen(String businessClueOpen) {
        this.businessClueOpen = businessClueOpen;
    }

    public String getBusinessClue0() {
        return businessClue0;
    }

    public void setBusinessClue0(String businessClue0) {
        this.businessClue0 = businessClue0;
    }

    public String getBusinessDiscover10() {
        return businessDiscover10;
    }

    public void setBusinessDiscover10(String businessDiscover10) {
        this.businessDiscover10 = businessDiscover10;
    }

    public String getBusinessEstablish25() {
        return businessEstablish25;
    }

    public void setBusinessEstablish25(String businessEstablish25) {
        this.businessEstablish25 = businessEstablish25;
    }

    public String getBusinessEstablish50() {
        return businessEstablish50;
    }

    public void setBusinessEstablish50(String businessEstablish50) {
        this.businessEstablish50 = businessEstablish50;
    }

    public String getBusinessEstablish75() {
        return businessEstablish75;
    }

    public void setBusinessEstablish75(String businessEstablish75) {
        this.businessEstablish75 = businessEstablish75;
    }

    public String getBusinessWin100() {
        return businessWin100;
    }

    public void setBusinessWin100(String businessWin100) {
        this.businessWin100 = businessWin100;
    }

    public String getCustomerMaintainBackMoney() {
        return customerMaintainBackMoney;
    }

    public void setCustomerMaintainBackMoney(String customerMaintainBackMoney) {
        this.customerMaintainBackMoney = customerMaintainBackMoney;
    }

    public String getBusinessClose() {
        return businessClose;
    }

    public void setBusinessClose(String businessClose) {
        this.businessClose = businessClose;
    }

    public String getInitialIntentionPlan() {
        return initialIntentionPlan;
    }

    public void setInitialIntentionPlan(String initialIntentionPlan) {
        this.initialIntentionPlan = initialIntentionPlan;
    }

    public String getWriteProjectProposal() {
        return writeProjectProposal;
    }

    public void setWriteProjectProposal(String writeProjectProposal) {
        this.writeProjectProposal = writeProjectProposal;
    }

    public String getWorkingHoursAssess() {
        return workingHoursAssess;
    }

    public void setWorkingHoursAssess(String workingHoursAssess) {
        this.workingHoursAssess = workingHoursAssess;
    }

    public String getBusinessNegotiation() {
        return businessNegotiation;
    }

    public void setBusinessNegotiation(String businessNegotiation) {
        this.businessNegotiation = businessNegotiation;
    }

    public String getRequestDraft() {
        return requestDraft;
    }

    public void setRequestDraft(String requestDraft) {
        this.requestDraft = requestDraft;
    }

    public String getAttendMeeting() {
        return attendMeeting;
    }

    public void setAttendMeeting(String attendMeeting) {
        this.attendMeeting = attendMeeting;
    }

    public String getBidding() {
        return bidding;
    }

    public void setBidding(String bidding) {
        this.bidding = bidding;
    }

    public String getRequestOaApproval() {
        return requestOaApproval;
    }

    public void setRequestOaApproval(String requestOaApproval) {
        this.requestOaApproval = requestOaApproval;
    }

    public String getContractDraft() {
        return contractDraft;
    }

    public void setContractDraft(String contractDraft) {
        this.contractDraft = contractDraft;
    }

    public String getLawyerReview() {
        return lawyerReview;
    }

    public void setLawyerReview(String lawyerReview) {
        this.lawyerReview = lawyerReview;
    }

    public String getContractOaApproval() {
        return contractOaApproval;
    }

    public void setContractOaApproval(String contractOaApproval) {
        this.contractOaApproval = contractOaApproval;
    }

    public String getUsageSeal() {
        return usageSeal;
    }

    public void setUsageSeal(String usageSeal) {
        this.usageSeal = usageSeal;
    }

    public String getOtherSeal() {
        return otherSeal;
    }

    public void setOtherSeal(String otherSeal) {
        this.otherSeal = otherSeal;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getGeneralDepartmentFile() {
        return generalDepartmentFile;
    }

    public void setGeneralDepartmentFile(String generalDepartmentFile) {
        this.generalDepartmentFile = generalDepartmentFile;
    }

    public String getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(String firstPayment) {
        this.firstPayment = firstPayment;
    }

    public String getProgressPayment() {
        return progressPayment;
    }

    public void setProgressPayment(String progressPayment) {
        this.progressPayment = progressPayment;
    }

    public String getFinalPayment() {
        return finalPayment;
    }

    public void setFinalPayment(String finalPayment) {
        this.finalPayment = finalPayment;
    }

    public String getDesignBrief() {
        return designBrief;
    }

    public void setDesignBrief(String designBrief) {
        this.designBrief = designBrief;
    }

    public String getDetailedDesign() {
        return detailedDesign;
    }

    public void setDetailedDesign(String detailedDesign) {
        this.detailedDesign = detailedDesign;
    }

    public String getUiDesign() {
        return uiDesign;
    }

    public void setUiDesign(String uiDesign) {
        this.uiDesign = uiDesign;
    }

    public String getRequirementDesign() {
        return requirementDesign;
    }

    public void setRequirementDesign(String requirementDesign) {
        this.requirementDesign = requirementDesign;
    }

    public String getRequirementsReview() {
        return requirementsReview;
    }

    public void setRequirementsReview(String requirementsReview) {
        this.requirementsReview = requirementsReview;
    }

    public String getDemandOrderConfirm() {
        return demandOrderConfirm;
    }

    public void setDemandOrderConfirm(String demandOrderConfirm) {
        this.demandOrderConfirm = demandOrderConfirm;
    }

    public String getProCheckDeliver() {
        return proCheckDeliver;
    }

    public void setProCheckDeliver(String proCheckDeliver) {
        this.proCheckDeliver = proCheckDeliver;
    }

    public String getTechnologySelection() {
        return technologySelection;
    }

    public void setTechnologySelection(String technologySelection) {
        this.technologySelection = technologySelection;
    }

    public String getEnvironmentDeployment() {
        return environmentDeployment;
    }

    public void setEnvironmentDeployment(String environmentDeployment) {
        this.environmentDeployment = environmentDeployment;
    }

    public String getFrameworkDesign() {
        return frameworkDesign;
    }

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