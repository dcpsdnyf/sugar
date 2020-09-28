package com.sugar.manage.dao.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 【请填写功能名称】对象 t_user_task
 * 
 * @author ruoyi
 * @date 2020-09-28
 */
public class TUserTask
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

    /** 项目id */
    private String projectId;

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
    public void setProjectId(String projectId) 
    {
        this.projectId = projectId;
    }

    public String getProjectId() 
    {
        return projectId;
    }
    public void setTaskPrincipal(String taskPrincipal) 
    {
        this.taskPrincipal = taskPrincipal;
    }

    public String getTaskPrincipal() 
    {
        return taskPrincipal;
    }
    public void setTaskType(String taskType) 
    {
        this.taskType = taskType;
    }

    public String getTaskType() 
    {
        return taskType;
    }
    public void setTaskStatus(String taskStatus) 
    {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() 
    {
        return taskStatus;
    }
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setTaskSubName(String taskSubName) 
    {
        this.taskSubName = taskSubName;
    }

    public String getTaskSubName() 
    {
        return taskSubName;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setEstimatedTime(String estimatedTime) 
    {
        this.estimatedTime = estimatedTime;
    }

    public String getEstimatedTime() 
    {
        return estimatedTime;
    }
    public void setTaskInfo(String taskInfo) 
    {
        this.taskInfo = taskInfo;
    }

    public String getTaskInfo() 
    {
        return taskInfo;
    }
    public void setTaskParentType(String taskParentType) 
    {
        this.taskParentType = taskParentType;
    }

    public String getTaskParentType() 
    {
        return taskParentType;
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
            .append("projectId", getProjectId())
            .append("taskPrincipal", getTaskPrincipal())
            .append("taskType", getTaskType())
            .append("taskStatus", getTaskStatus())
            .append("taskName", getTaskName())
            .append("taskSubName", getTaskSubName())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("estimatedTime", getEstimatedTime())
            .append("taskInfo", getTaskInfo())
            .append("taskParentType", getTaskParentType())
            .toString();
    }
}
