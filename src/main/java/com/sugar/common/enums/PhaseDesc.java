package com.sugar.common.enums;

public enum PhaseDesc {


    //==============================
    businessClueOpen(100,"商机线索开启"),

    businessClue0(101,"1、商机线索0%"),

    businessDiscover10(102,"2、商机发现10%"),

    businessEstablish25(103,"3、商机确立25%"),

    businessEstablish50(104,"4、商机确立50%"),

    businessEstablish75(105,"5、商机确认75%"),

    businessWin100(106,"6、商机赢取100%"),

    customerMaintainBackMoney(107,"7、客户维护/回款阶段"),

    businessClose(108,"商机关闭"),


    //=============================
    initialIntentionPlan(201,"1、初步意向方案"),

    writeProjectProposal(202,"2、写立项方案"),

    workingHoursAssess(203,"3、工时评估"),

    businessNegotiation(204,"4、商务谈判"),

    requestDraft(205,"5、请示拟写"),

    attendMeeting(206,"6、上会"),

    bidding(207,"7、招投标"),

    requestOaApproval(208,"8、请示OA审批"),

    contractDraft(209,"9、合同拟写"),

    lawyerReview(210,"10、律师审核"),

    contractOaApproval(211,"11、合同OA审批"),

    usageSeal(212,"12、用章"),

    otherSeal(213,"13、对方盖章"),

    scan(214,"14、扫描"),

    generalDepartmentFile(215,"15、综合部归档"),

    firstPayment(216,"16、首付款"),

    progressPayment(217,"17、进度款"),

    finalPayment(218,"18、尾款"),

    //===============================
    designBrief(301,"1、设计概要"),

    detailedDesign(302,"2、详细设计"),

    uiDesign(303,"3、UI设计"),

    requirementDesign(304,"4、需求设计"),

    requirementsReview(305,"5、需求评审"),

    demandOrderConfirm(306,"6、需求单确认"),

    proCheckDeliver(307,"7、验收"),

    //==================================
    technologySelection(401,"1、技术选型"),

    environmentDeployment(402,"2、环境部署"),

    frameworkDesign(403,"3、框架设计"),

    developProgress10(404,"4、开发进度10%"),

    developProgress25(405,"5、开发进度25%"),

    developProgress50(406,"6、开发进度50%"),

    developProgress75(407,"7、开发进度75%"),

    developProgress100(408,"8、开发进度100%"),

    insideTest(409,"9、内部测试优化"),

    customerTest(410,"10、客户测试优化"),

    implementDeliver(411,"11、实施交付"),

    checkDeliver(412,"12、验收");

    //================================


    int phaseNum;

    String phaseName;

    PhaseDesc(int phaseNum, String phaseName){
        this.phaseNum = phaseNum;
        this.phaseName = phaseName;
    }
}
