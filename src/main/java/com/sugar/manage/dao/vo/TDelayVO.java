package com.sugar.manage.dao.vo;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 【请填写功能名称】对象 t_delay
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
@Data
public class TDelayVO
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 状态（01有效，99失效） */
    private String status;

    /** 创建人 */
    private String createdStaff;

    /** 创建时间 */
    private Date createdTime;

    /** 更新人 */
    private String updatedStaff;

    /** 更新时间 */
    private Date updatedTime;

    /** 延期天数 */
    private String delayTime;

    /** 申请延期人 */
    private String delayPeopleName;

    /** 审批延期人 */
    private String auditingPeopleName;

    /** 项目id */
    private String projectId;

    /** 任务名称 */
    private String taskName;

    /** 任务子名称 */
    private String taskSubName;

    /** 审批状态0通过1失败 审批状态0通过1失败 */
    private String auditingStatus;
}
