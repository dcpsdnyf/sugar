package com.sugar.manage.dao.model;

import java.io.Serializable;
import java.util.Date;

public class TUserTask implements Serializable {
    private Integer id;

    private String status;

    private String createdStaff;

    private Date createdTime;

    private String updatedStaff;

    private Date updatedTime;

    private String projectId;

    private String taskPrincipal;

    private String taskType;

    private String taskStatus;

    private String taskName;

    private String taskSubName;

    private String startTime;

    private String endTime;

    private String estimatedTime;

    private String taskInfo;

    private String taskParentType;

    private String delayDay;

    private String delayPeople;

    private String principal;

    private String productType;

    private String platformName;

    private String groupName;

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getTaskPrincipal() {
        return taskPrincipal;
    }

    public void setTaskPrincipal(String taskPrincipal) {
        this.taskPrincipal = taskPrincipal == null ? null : taskPrincipal.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime == null ? null : estimatedTime.trim();
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo == null ? null : taskInfo.trim();
    }

    public String getTaskParentType() {
        return taskParentType;
    }

    public void setTaskParentType(String taskParentType) {
        this.taskParentType = taskParentType == null ? null : taskParentType.trim();
    }

    public String getDelayDay() {
        return delayDay;
    }

    public void setDelayDay(String delayDay) {
        this.delayDay = delayDay == null ? null : delayDay.trim();
    }

    public String getDelayPeople() {
        return delayPeople;
    }

    public void setDelayPeople(String delayPeople) {
        this.delayPeople = delayPeople == null ? null : delayPeople.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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
        TUserTask other = (TUserTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedStaff() == null ? other.getCreatedStaff() == null : this.getCreatedStaff().equals(other.getCreatedStaff()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedStaff() == null ? other.getUpdatedStaff() == null : this.getUpdatedStaff().equals(other.getUpdatedStaff()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getTaskPrincipal() == null ? other.getTaskPrincipal() == null : this.getTaskPrincipal().equals(other.getTaskPrincipal()))
            && (this.getTaskType() == null ? other.getTaskType() == null : this.getTaskType().equals(other.getTaskType()))
            && (this.getTaskStatus() == null ? other.getTaskStatus() == null : this.getTaskStatus().equals(other.getTaskStatus()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getTaskSubName() == null ? other.getTaskSubName() == null : this.getTaskSubName().equals(other.getTaskSubName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getEstimatedTime() == null ? other.getEstimatedTime() == null : this.getEstimatedTime().equals(other.getEstimatedTime()))
            && (this.getTaskInfo() == null ? other.getTaskInfo() == null : this.getTaskInfo().equals(other.getTaskInfo()))
            && (this.getTaskParentType() == null ? other.getTaskParentType() == null : this.getTaskParentType().equals(other.getTaskParentType()))
            && (this.getDelayDay() == null ? other.getDelayDay() == null : this.getDelayDay().equals(other.getDelayDay()))
            && (this.getDelayPeople() == null ? other.getDelayPeople() == null : this.getDelayPeople().equals(other.getDelayPeople()))
            && (this.getPrincipal() == null ? other.getPrincipal() == null : this.getPrincipal().equals(other.getPrincipal()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getPlatformName() == null ? other.getPlatformName() == null : this.getPlatformName().equals(other.getPlatformName()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()));
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
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getTaskPrincipal() == null) ? 0 : getTaskPrincipal().hashCode());
        result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
        result = prime * result + ((getTaskStatus() == null) ? 0 : getTaskStatus().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getTaskSubName() == null) ? 0 : getTaskSubName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getEstimatedTime() == null) ? 0 : getEstimatedTime().hashCode());
        result = prime * result + ((getTaskInfo() == null) ? 0 : getTaskInfo().hashCode());
        result = prime * result + ((getTaskParentType() == null) ? 0 : getTaskParentType().hashCode());
        result = prime * result + ((getDelayDay() == null) ? 0 : getDelayDay().hashCode());
        result = prime * result + ((getDelayPeople() == null) ? 0 : getDelayPeople().hashCode());
        result = prime * result + ((getPrincipal() == null) ? 0 : getPrincipal().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getPlatformName() == null) ? 0 : getPlatformName().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
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
        sb.append(", projectId=").append(projectId);
        sb.append(", taskPrincipal=").append(taskPrincipal);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskSubName=").append(taskSubName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", estimatedTime=").append(estimatedTime);
        sb.append(", taskInfo=").append(taskInfo);
        sb.append(", taskParentType=").append(taskParentType);
        sb.append(", delayDay=").append(delayDay);
        sb.append(", delayPeople=").append(delayPeople);
        sb.append(", principal=").append(principal);
        sb.append(", productType=").append(productType);
        sb.append(", platformName=").append(platformName);
        sb.append(", groupName=").append(groupName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}