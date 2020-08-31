package com.sugar.manage.dao.model;

import java.io.Serializable;
import java.util.Date;

public class TSugarProject implements Serializable {
    private Integer id;

    private String productType;

    private String platformName;

    private String demandReview;

    private String demandConfirm;

    private String demandCheck;

    private String environmentDeployment;

    private String developProgress10;

    private String developProgress25;

    private String developProgress50;

    private String developProgress75;

    private String developProgress100;

    private String implementDeliver;

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

    public String getDemandReview() {
        return demandReview;
    }

    public void setDemandReview(String demandReview) {
        this.demandReview = demandReview == null ? null : demandReview.trim();
    }

    public String getDemandConfirm() {
        return demandConfirm;
    }

    public void setDemandConfirm(String demandConfirm) {
        this.demandConfirm = demandConfirm == null ? null : demandConfirm.trim();
    }

    public String getDemandCheck() {
        return demandCheck;
    }

    public void setDemandCheck(String demandCheck) {
        this.demandCheck = demandCheck == null ? null : demandCheck.trim();
    }

    public String getEnvironmentDeployment() {
        return environmentDeployment;
    }

    public void setEnvironmentDeployment(String environmentDeployment) {
        this.environmentDeployment = environmentDeployment == null ? null : environmentDeployment.trim();
    }

    public String getDevelopProgress10() {
        return developProgress10;
    }

    public void setDevelopProgress10(String developProgress10) {
        this.developProgress10 = developProgress10 == null ? null : developProgress10.trim();
    }

    public String getDevelopProgress25() {
        return developProgress25;
    }

    public void setDevelopProgress25(String developProgress25) {
        this.developProgress25 = developProgress25 == null ? null : developProgress25.trim();
    }

    public String getDevelopProgress50() {
        return developProgress50;
    }

    public void setDevelopProgress50(String developProgress50) {
        this.developProgress50 = developProgress50 == null ? null : developProgress50.trim();
    }

    public String getDevelopProgress75() {
        return developProgress75;
    }

    public void setDevelopProgress75(String developProgress75) {
        this.developProgress75 = developProgress75 == null ? null : developProgress75.trim();
    }

    public String getDevelopProgress100() {
        return developProgress100;
    }

    public void setDevelopProgress100(String developProgress100) {
        this.developProgress100 = developProgress100 == null ? null : developProgress100.trim();
    }

    public String getImplementDeliver() {
        return implementDeliver;
    }

    public void setImplementDeliver(String implementDeliver) {
        this.implementDeliver = implementDeliver == null ? null : implementDeliver.trim();
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
        TSugarProject other = (TSugarProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getPlatformName() == null ? other.getPlatformName() == null : this.getPlatformName().equals(other.getPlatformName()))
            && (this.getDemandReview() == null ? other.getDemandReview() == null : this.getDemandReview().equals(other.getDemandReview()))
            && (this.getDemandConfirm() == null ? other.getDemandConfirm() == null : this.getDemandConfirm().equals(other.getDemandConfirm()))
            && (this.getDemandCheck() == null ? other.getDemandCheck() == null : this.getDemandCheck().equals(other.getDemandCheck()))
            && (this.getEnvironmentDeployment() == null ? other.getEnvironmentDeployment() == null : this.getEnvironmentDeployment().equals(other.getEnvironmentDeployment()))
            && (this.getDevelopProgress10() == null ? other.getDevelopProgress10() == null : this.getDevelopProgress10().equals(other.getDevelopProgress10()))
            && (this.getDevelopProgress25() == null ? other.getDevelopProgress25() == null : this.getDevelopProgress25().equals(other.getDevelopProgress25()))
            && (this.getDevelopProgress50() == null ? other.getDevelopProgress50() == null : this.getDevelopProgress50().equals(other.getDevelopProgress50()))
            && (this.getDevelopProgress75() == null ? other.getDevelopProgress75() == null : this.getDevelopProgress75().equals(other.getDevelopProgress75()))
            && (this.getDevelopProgress100() == null ? other.getDevelopProgress100() == null : this.getDevelopProgress100().equals(other.getDevelopProgress100()))
            && (this.getImplementDeliver() == null ? other.getImplementDeliver() == null : this.getImplementDeliver().equals(other.getImplementDeliver()))
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
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getPlatformName() == null) ? 0 : getPlatformName().hashCode());
        result = prime * result + ((getDemandReview() == null) ? 0 : getDemandReview().hashCode());
        result = prime * result + ((getDemandConfirm() == null) ? 0 : getDemandConfirm().hashCode());
        result = prime * result + ((getDemandCheck() == null) ? 0 : getDemandCheck().hashCode());
        result = prime * result + ((getEnvironmentDeployment() == null) ? 0 : getEnvironmentDeployment().hashCode());
        result = prime * result + ((getDevelopProgress10() == null) ? 0 : getDevelopProgress10().hashCode());
        result = prime * result + ((getDevelopProgress25() == null) ? 0 : getDevelopProgress25().hashCode());
        result = prime * result + ((getDevelopProgress50() == null) ? 0 : getDevelopProgress50().hashCode());
        result = prime * result + ((getDevelopProgress75() == null) ? 0 : getDevelopProgress75().hashCode());
        result = prime * result + ((getDevelopProgress100() == null) ? 0 : getDevelopProgress100().hashCode());
        result = prime * result + ((getImplementDeliver() == null) ? 0 : getImplementDeliver().hashCode());
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
        sb.append(", productType=").append(productType);
        sb.append(", platformName=").append(platformName);
        sb.append(", demandReview=").append(demandReview);
        sb.append(", demandConfirm=").append(demandConfirm);
        sb.append(", demandCheck=").append(demandCheck);
        sb.append(", environmentDeployment=").append(environmentDeployment);
        sb.append(", developProgress10=").append(developProgress10);
        sb.append(", developProgress25=").append(developProgress25);
        sb.append(", developProgress50=").append(developProgress50);
        sb.append(", developProgress75=").append(developProgress75);
        sb.append(", developProgress100=").append(developProgress100);
        sb.append(", implementDeliver=").append(implementDeliver);
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