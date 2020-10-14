package com.sugar.manage.dao.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TUserTaskVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 状态（01有效，99失效） */
    private String status;

    /** 创建人 */
    private String createdStaff;

    /** 更新人 */
    private String updatedStaff;

    /** 项目id */
    private String projectId;

    /** 负责人 */
    private String principal;

    /** 任务责任人 */
    private String taskPrincipal;

    /** 任务类型 00指派下发的任务/01下属填写的任务 */
    private String taskType;

    /** 任务状态 0待进行1进行中2已完成 */
    private String taskStatus;

    /** 任务名称 */
    private String taskName;

    /** 任务子名称 */
    private String taskSubName;

    /** 开始时间 */
    private String startTime;

    /** 完成时间 */
    private String endTime;

    /** 预计时间 */
    private String estimatedTime;

    /** 任务内容 */
    private String taskInfo;

    /** 任务大阶段状态 */
    private String taskParentType;

    /** 产品类型 */
    private String productType ;

    /** 平台名称 */
    private String platformName ;

    /** 集团 */
    private String groupName;

    private String delayDay;

    private String delayPeople;

    //大段ID用于回显指派时的项目阶段
    private String bigId;

    /**是否显示指派按钮*/
    private boolean isAppoint;

    /**是否显示申请延期按钮*/
    private boolean isDelay;

    private String businessPrincipal;
    private String purchasePrincipal;
    private String productPrincipal;
    private String developmentPrincipal;
    private String operationPrincipal;
    private String operationMaintainPrincipal;
}
