package com.sugar.manage.dao.model;

import java.io.Serializable;

public class TSugarProjectWithBLOBs extends TSugarProject implements Serializable {
    private String technologySelection;

    private String frameworkDesign;

    private String insideTest;

    private String customerTest;

    private String checkDeliver;

    private static final long serialVersionUID = 1L;

    public String getTechnologySelection() {
        return technologySelection;
    }

    public void setTechnologySelection(String technologySelection) {
        this.technologySelection = technologySelection == null ? null : technologySelection.trim();
    }

    public String getFrameworkDesign() {
        return frameworkDesign;
    }

    public void setFrameworkDesign(String frameworkDesign) {
        this.frameworkDesign = frameworkDesign == null ? null : frameworkDesign.trim();
    }

    public String getInsideTest() {
        return insideTest;
    }

    public void setInsideTest(String insideTest) {
        this.insideTest = insideTest == null ? null : insideTest.trim();
    }

    public String getCustomerTest() {
        return customerTest;
    }

    public void setCustomerTest(String customerTest) {
        this.customerTest = customerTest == null ? null : customerTest.trim();
    }

    public String getCheckDeliver() {
        return checkDeliver;
    }

    public void setCheckDeliver(String checkDeliver) {
        this.checkDeliver = checkDeliver == null ? null : checkDeliver.trim();
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
        TSugarProjectWithBLOBs other = (TSugarProjectWithBLOBs) that;
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
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getTechnologySelection() == null ? other.getTechnologySelection() == null : this.getTechnologySelection().equals(other.getTechnologySelection()))
            && (this.getFrameworkDesign() == null ? other.getFrameworkDesign() == null : this.getFrameworkDesign().equals(other.getFrameworkDesign()))
            && (this.getInsideTest() == null ? other.getInsideTest() == null : this.getInsideTest().equals(other.getInsideTest()))
            && (this.getCustomerTest() == null ? other.getCustomerTest() == null : this.getCustomerTest().equals(other.getCustomerTest()))
            && (this.getCheckDeliver() == null ? other.getCheckDeliver() == null : this.getCheckDeliver().equals(other.getCheckDeliver()));
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
        result = prime * result + ((getTechnologySelection() == null) ? 0 : getTechnologySelection().hashCode());
        result = prime * result + ((getFrameworkDesign() == null) ? 0 : getFrameworkDesign().hashCode());
        result = prime * result + ((getInsideTest() == null) ? 0 : getInsideTest().hashCode());
        result = prime * result + ((getCustomerTest() == null) ? 0 : getCustomerTest().hashCode());
        result = prime * result + ((getCheckDeliver() == null) ? 0 : getCheckDeliver().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", technologySelection=").append(technologySelection);
        sb.append(", frameworkDesign=").append(frameworkDesign);
        sb.append(", insideTest=").append(insideTest);
        sb.append(", customerTest=").append(customerTest);
        sb.append(", checkDeliver=").append(checkDeliver);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}