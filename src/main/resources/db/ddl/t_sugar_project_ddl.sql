CREATE TABLE t_sugar_project(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT '索引值' ,
    product_type VARCHAR(32)    COMMENT '产品类型' ,
    platform_name VARCHAR(128)    COMMENT '平台名称' ,
    platform_id VARCHAR(128)    COMMENT '平台ID' ,
    business_clue_open TEXT    COMMENT '商机线索开启' ,
    business_clue_0 TEXT    COMMENT '商机推进阶段1、商机线索0%：我方分析客户存在潜在需求' ,
    business_discover_10 TEXT    COMMENT '商机推进阶段2、商机发现10%：深入交流明确需求' ,
    business_establish_25 TEXT    COMMENT '商机推进阶段3、商机确立25%：客户明确购买意愿/立项/预算' ,
    business_establish_50 TEXT    COMMENT '商机推进阶段4、商机确立50%：客户启动招标/采购流程、我方入围' ,
    business_establish_75 TEXT    COMMENT '商机推进阶段5、商机确认75%：客户招标/采购，我方交流需求细则' ,
    business_win_100 TEXT    COMMENT '商机推进阶段6、商机赢取100%：合同签订' ,
    customer_maintain_back_money TEXT    COMMENT '商机推进阶段7、客户维护/回款阶段' ,
    business_close TEXT    COMMENT '商机关闭' ,	
    initial_intention_plan TEXT    COMMENT '1、初步意向方案（采购阶段）' ,
    write_project_proposal TEXT    COMMENT '2、写立项方案（采购阶段）' ,
    working_hours_assess TEXT    COMMENT '3、工时评估（采购阶段）' ,
    business_negotiation TEXT    COMMENT '4、商务谈判（采购阶段）' ,
    request_draft TEXT    COMMENT '5、请示拟写（采购阶段）' ,
    attend_meeting TEXT    COMMENT '6、上会（采购阶段）' ,
    bidding TEXT    COMMENT '7、招投标（采购阶段）' ,
    request_oa_approval TEXT    COMMENT '8、请示OA审批（采购阶段）' ,
    contract_draft TEXT    COMMENT '9、合同拟写（采购阶段）' ,
    lawyer_review TEXT    COMMENT '10、律师审核（采购阶段）' ,
    contract_oa_approval TEXT    COMMENT '11、合同OA审批（采购阶段）' ,
    usage_seal TEXT    COMMENT '12、用章（采购阶段）' ,
    other_seal TEXT    COMMENT '13、对方盖章（采购阶段）' ,
    scan TEXT    COMMENT '14、扫描（采购阶段）' ,
    general_department_file TEXT    COMMENT '15、综合部归档（采购阶段）' ,
    first_payment TEXT    COMMENT '16、首付款（采购阶段）' ,
    progress_payment TEXT    COMMENT '17、进度款（采购阶段）' ,
    final_payment TEXT    COMMENT '18、尾款（采购阶段）' ,
    design_brief TEXT    COMMENT '1、设计概要（产品阶段）' ,
    detailed_design TEXT    COMMENT '2、详细设计（产品阶段）' ,
    ui_design TEXT    COMMENT '3、UI设计（产品阶段）' ,
    requirement_design TEXT    COMMENT '4、需求设计（产品阶段）' ,
    requirements_review TEXT    COMMENT '5、需求评审（产品阶段）' ,
    demand_order_confirm TEXT    COMMENT '6、需求单确认（产品阶段）' ,
    pro_check_deliver TEXT    COMMENT '7、验收（产品阶段）' ,
    technology_selection TEXT    COMMENT '1、技术选型（研发阶段）' ,
    environment_deployment TEXT    COMMENT '2、环境部署（研发阶段）' ,
    framework_design TEXT    COMMENT '3、框架设计（研发阶段）' ,
    develop_progress_10 TEXT    COMMENT '4、开发进度10%（研发阶段）' ,
    develop_progress_25 TEXT    COMMENT '5、开发进度25%（研发阶段）' ,
    develop_progress_50 TEXT    COMMENT '6、开发进度50%（研发阶段）' ,
    develop_progress_75 TEXT    COMMENT '7、开发进度75%（研发阶段）' ,
    develop_progress_100 TEXT    COMMENT '8、开发进度100%（研发阶段）' ,
    inside_test TEXT    COMMENT '9、内部测试优化（研发阶段）' ,
    customer_test TEXT    COMMENT '10、客户测试优化（研发阶段）' ,
    implement_deliver TEXT    COMMENT '11、实施交付（研发阶段）' ,
    check_deliver TEXT    COMMENT '12、验收（研发阶段）' ,
    operation_phase TEXT    COMMENT '运营阶段' ,
    maintain_phase TEXT    COMMENT '运维阶段' ,
    status VARCHAR(32)    COMMENT '状态' ,
    CREATED_STAFF VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_STAFF VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (ID)
) COMMENT = '项目信息';
