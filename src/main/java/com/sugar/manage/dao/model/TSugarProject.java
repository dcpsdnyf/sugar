package com.sugar.manage.dao.model;

import java.io.Serializable;
import java.util.Date;

public class TSugarProject implements Serializable {
    private Integer id;

    private String productType;

    private String platformName;

    private String platformId;

    private String status;

    private String createdStaff;

    private Date createdTime;

    private String updatedStaff;

    private Date updatedTime;

    private Integer sort;

    private String groupName;

    private String startTime;

    private String taskPrincipal;

    private String businessPrincipal;

    private String purchasePrincipal;

    private String productPrincipal;

    private String developmentPrincipal;

    private String operationPrincipal;

    private String operationMaintainPrincipal;

    private static final long serialVersionUID = 1L;

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
        this.productType = productType == null ? null : productType.trim();
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getTaskPrincipal() {
        return taskPrincipal;
    }

    public void setTaskPrincipal(String taskPrincipal) {
        this.taskPrincipal = taskPrincipal == null ? null : taskPrincipal.trim();
    }

    public String getBusinessPrincipal() {
        return businessPrincipal;
    }

    public void setBusinessPrincipal(String businessPrincipal) {
        this.businessPrincipal = businessPrincipal == null ? null : businessPrincipal.trim();
    }

    public String getPurchasePrincipal() {
        return purchasePrincipal;
    }

    public void setPurchasePrincipal(String purchasePrincipal) {
        this.purchasePrincipal = purchasePrincipal == null ? null : purchasePrincipal.trim();
    }

    public String getProductPrincipal() {
        return productPrincipal;
    }

    public void setProductPrincipal(String productPrincipal) {
        this.productPrincipal = productPrincipal == null ? null : productPrincipal.trim();
    }

    public String getDevelopmentPrincipal() {
        return developmentPrincipal;
    }

    public void setDevelopmentPrincipal(String developmentPrincipal) {
        this.developmentPrincipal = developmentPrincipal == null ? null : developmentPrincipal.trim();
    }

    public String getOperationPrincipal() {
        return operationPrincipal;
    }

    public void setOperationPrincipal(String operationPrincipal) {
        this.operationPrincipal = operationPrincipal == null ? null : operationPrincipal.trim();
    }

    public String getOperationMaintainPrincipal() {
        return operationMaintainPrincipal;
    }

    public void setOperationMaintainPrincipal(String operationMaintainPrincipal) {
        this.operationMaintainPrincipal = operationMaintainPrincipal == null ? null : operationMaintainPrincipal.trim();
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
        TSugarProject other = (TSugarProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getPlatformName() == null ? other.getPlatformName() == null : this.getPlatformName().equals(other.getPlatformName()))
            && (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedStaff() == null ? other.getCreatedStaff() == null : this.getCreatedStaff().equals(other.getCreatedStaff()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedStaff() == null ? other.getUpdatedStaff() == null : this.getUpdatedStaff().equals(other.getUpdatedStaff()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getTaskPrincipal() == null ? other.getTaskPrincipal() == null : this.getTaskPrincipal().equals(other.getTaskPrincipal()))
            && (this.getBusinessPrincipal() == null ? other.getBusinessPrincipal() == null : this.getBusinessPrincipal().equals(other.getBusinessPrincipal()))
            && (this.getPurchasePrincipal() == null ? other.getPurchasePrincipal() == null : this.getPurchasePrincipal().equals(other.getPurchasePrincipal()))
            && (this.getProductPrincipal() == null ? other.getProductPrincipal() == null : this.getProductPrincipal().equals(other.getProductPrincipal()))
            && (this.getDevelopmentPrincipal() == null ? other.getDevelopmentPrincipal() == null : this.getDevelopmentPrincipal().equals(other.getDevelopmentPrincipal()))
            && (this.getOperationPrincipal() == null ? other.getOperationPrincipal() == null : this.getOperationPrincipal().equals(other.getOperationPrincipal()))
            && (this.getOperationMaintainPrincipal() == null ? other.getOperationMaintainPrincipal() == null : this.getOperationMaintainPrincipal().equals(other.getOperationMaintainPrincipal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getPlatformName() == null) ? 0 : getPlatformName().hashCode());
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedStaff() == null) ? 0 : getCreatedStaff().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedStaff() == null) ? 0 : getUpdatedStaff().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getTaskPrincipal() == null) ? 0 : getTaskPrincipal().hashCode());
        result = prime * result + ((getBusinessPrincipal() == null) ? 0 : getBusinessPrincipal().hashCode());
        result = prime * result + ((getPurchasePrincipal() == null) ? 0 : getPurchasePrincipal().hashCode());
        result = prime * result + ((getProductPrincipal() == null) ? 0 : getProductPrincipal().hashCode());
        result = prime * result + ((getDevelopmentPrincipal() == null) ? 0 : getDevelopmentPrincipal().hashCode());
        result = prime * result + ((getOperationPrincipal() == null) ? 0 : getOperationPrincipal().hashCode());
        result = prime * result + ((getOperationMaintainPrincipal() == null) ? 0 : getOperationMaintainPrincipal().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productType=").append(productType);
        sb.append(", platformName=").append(platformName);
        sb.append(", platformId=").append(platformId);
        sb.append(", status=").append(status);
        sb.append(", createdStaff=").append(createdStaff);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedStaff=").append(updatedStaff);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", sort=").append(sort);
        sb.append(", groupName=").append(groupName);
        sb.append(", startTime=").append(startTime);
        sb.append(", taskPrincipal=").append(taskPrincipal);
        sb.append(", businessPrincipal=").append(businessPrincipal);
        sb.append(", purchasePrincipal=").append(purchasePrincipal);
        sb.append(", productPrincipal=").append(productPrincipal);
        sb.append(", developmentPrincipal=").append(developmentPrincipal);
        sb.append(", operationPrincipal=").append(operationPrincipal);
        sb.append(", operationMaintainPrincipal=").append(operationMaintainPrincipal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}