package com.sugar.manage.dao.model;

import java.io.Serializable;
import java.util.Date;

public class TStagePrincipal implements Serializable {
    private Integer id;

    private String stageNum;

    private String stageName;

    private Integer userId;

    private String principalName;

    private Integer projectId;

    private String status;

    private String createdStaff;

    private Date createdTime;

    private String updatedStaff;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStageNum() {
        return stageNum;
    }

    public void setStageNum(String stageNum) {
        this.stageNum = stageNum == null ? null : stageNum.trim();
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName == null ? null : stageName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName == null ? null : principalName.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
        TStagePrincipal other = (TStagePrincipal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStageNum() == null ? other.getStageNum() == null : this.getStageNum().equals(other.getStageNum()))
            && (this.getStageName() == null ? other.getStageName() == null : this.getStageName().equals(other.getStageName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPrincipalName() == null ? other.getPrincipalName() == null : this.getPrincipalName().equals(other.getPrincipalName()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedStaff() == null ? other.getCreatedStaff() == null : this.getCreatedStaff().equals(other.getCreatedStaff()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedStaff() == null ? other.getUpdatedStaff() == null : this.getUpdatedStaff().equals(other.getUpdatedStaff()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStageNum() == null) ? 0 : getStageNum().hashCode());
        result = prime * result + ((getStageName() == null) ? 0 : getStageName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPrincipalName() == null) ? 0 : getPrincipalName().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedStaff() == null) ? 0 : getCreatedStaff().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedStaff() == null) ? 0 : getUpdatedStaff().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stageNum=").append(stageNum);
        sb.append(", stageName=").append(stageName);
        sb.append(", userId=").append(userId);
        sb.append(", principalName=").append(principalName);
        sb.append(", projectId=").append(projectId);
        sb.append(", status=").append(status);
        sb.append(", createdStaff=").append(createdStaff);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedStaff=").append(updatedStaff);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}