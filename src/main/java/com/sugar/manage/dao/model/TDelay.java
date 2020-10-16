package com.sugar.manage.dao.model;

import java.io.Serializable;
import java.util.Date;

public class TDelay implements Serializable {
    private Integer id;

    private String status;

    private String createdStaff;

    private Date createdTime;

    private String updatedStaff;

    private Date updatedTime;

    private String delayTime;

    private String delayPeopleName;

    private String auditingPeopleName;

    private String projectId;

    private String taskName;

    private String taskSubName;

    private String auditingStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreatedStaff() {
        return createdStaff;
    }

    public void setCreatedStaff(String createdStaff) {
        this.createdStaff = createdStaff == null ? null : createdStaff.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedStaff() {
        return updatedStaff;
    }

    public void setUpdatedStaff(String updatedStaff) {
        this.updatedStaff = updatedStaff == null ? null : updatedStaff.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime == null ? null : delayTime.trim();
    }

    public String getDelayPeopleName() {
        return delayPeopleName;
    }

    public void setDelayPeopleName(String delayPeopleName) {
        this.delayPeopleName = delayPeopleName == null ? null : delayPeopleName.trim();
    }

    public String getAuditingPeopleName() {
        return auditingPeopleName;
    }

    public void setAuditingPeopleName(String auditingPeopleName) {
        this.auditingPeopleName = auditingPeopleName == null ? null : auditingPeopleName.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskSubName() {
        return taskSubName;
    }

    public void setTaskSubName(String taskSubName) {
        this.taskSubName = taskSubName == null ? null : taskSubName.trim();
    }

    public String getAuditingStatus() {
        return auditingStatus;
    }

    public void setAuditingStatus(String auditingStatus) {
        this.auditingStatus = auditingStatus == null ? null : auditingStatus.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TDelay other = (TDelay) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedStaff() == null ? other.getCreatedStaff() == null : this.getCreatedStaff().equals(other.getCreatedStaff()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedStaff() == null ? other.getUpdatedStaff() == null : this.getUpdatedStaff().equals(other.getUpdatedStaff()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getDelayTime() == null ? other.getDelayTime() == null : this.getDelayTime().equals(other.getDelayTime()))
            && (this.getDelayPeopleName() == null ? other.getDelayPeopleName() == null : this.getDelayPeopleName().equals(other.getDelayPeopleName()))
            && (this.getAuditingPeopleName() == null ? other.getAuditingPeopleName() == null : this.getAuditingPeopleName().equals(other.getAuditingPeopleName()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getTaskSubName() == null ? other.getTaskSubName() == null : this.getTaskSubName().equals(other.getTaskSubName()))
            && (this.getAuditingStatus() == null ? other.getAuditingStatus() == null : this.getAuditingStatus().equals(other.getAuditingStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedStaff() == null) ? 0 : getCreatedStaff().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedStaff() == null) ? 0 : getUpdatedStaff().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getDelayTime() == null) ? 0 : getDelayTime().hashCode());
        result = prime * result + ((getDelayPeopleName() == null) ? 0 : getDelayPeopleName().hashCode());
        result = prime * result + ((getAuditingPeopleName() == null) ? 0 : getAuditingPeopleName().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getTaskSubName() == null) ? 0 : getTaskSubName().hashCode());
        result = prime * result + ((getAuditingStatus() == null) ? 0 : getAuditingStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", createdStaff=").append(createdStaff);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedStaff=").append(updatedStaff);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", delayTime=").append(delayTime);
        sb.append(", delayPeopleName=").append(delayPeopleName);
        sb.append(", auditingPeopleName=").append(auditingPeopleName);
        sb.append(", projectId=").append(projectId);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskSubName=").append(taskSubName);
        sb.append(", auditingStatus=").append(auditingStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}