package com.sugar.manage.dao.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 【请填写功能名称】对象 t_delay
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
public class TDelay
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

    /** 审批状态0通过1失败 审批状态0通过1失败 */
    private String auditingStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreatedStaff(String createdStaff) 
    {
        this.createdStaff = createdStaff;
    }

    public String getCreatedStaff() 
    {
        return createdStaff;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedStaff(String updatedStaff) 
    {
        this.updatedStaff = updatedStaff;
    }

    public String getUpdatedStaff() 
    {
        return updatedStaff;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }
    public void setDelayTime(String delayTime) 
    {
        this.delayTime = delayTime;
    }

    public String getDelayTime() 
    {
        return delayTime;
    }
    public void setDelayPeopleName(String delayPeopleName) 
    {
        this.delayPeopleName = delayPeopleName;
    }

    public String getDelayPeopleName() 
    {
        return delayPeopleName;
    }
    public void setAuditingPeopleName(String auditingPeopleName) 
    {
        this.auditingPeopleName = auditingPeopleName;
    }

    public String getAuditingPeopleName() 
    {
        return auditingPeopleName;
    }
    public void setProjectId(String projectId) 
    {
        this.projectId = projectId;
    }

    public String getProjectId() 
    {
        return projectId;
    }
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setAuditingStatus(String auditingStatus) 
    {
        this.auditingStatus = auditingStatus;
    }

    public String getAuditingStatus() 
    {
        return auditingStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("status", getStatus())
            .append("createdStaff", getCreatedStaff())
            .append("createdTime", getCreatedTime())
            .append("updatedStaff", getUpdatedStaff())
            .append("updatedTime", getUpdatedTime())
            .append("delayTime", getDelayTime())
            .append("delayPeopleName", getDelayPeopleName())
            .append("auditingPeopleName", getAuditingPeopleName())
            .append("projectId", getProjectId())
            .append("taskName", getTaskName())
            .append("auditingStatus", getAuditingStatus())
            .toString();
    }
}
