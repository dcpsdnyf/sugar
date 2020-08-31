package com.sugar.manage.vo;


import java.io.Serializable;
import java.util.Date;

/**
 * @program: sugarManage
 * @description: 项目信息
 * @author: liangbq
 * @create: 2020-08-30 13:41
 */
public class TSugarProjectVO implements Serializable,Cloneable{
    /** 索引值 */
    private Integer id ;
    /** 产品类型 */
    private String productType ;
    /** 平台名称 */
    private String platformName ;
    /** 5、需求评审 */
    private String demandReview ;
    /** 6、需求单确认 */
    private String demandConfirm ;
    /** 7、验收 */
    private String demandCheck ;
    /** 1、技术选型 */
    private String technologySelection ;
    /** 2、环境部署 */
    private String environmentDeployment ;
    /** 3、框架设计 */
    private String frameworkDesign ;
    /** 4、开发进度10% */
    private String developProgress10 ;
    /** 5、开发进度25% */
    private String developProgress25 ;
    /** 6、开发进度50% */
    private String developProgress50 ;
    /** 7、开发进度75% */
    private String developProgress75 ;
    /** 8、开发进度100% */
    private String developProgress100 ;
    /** 9、内部测试优化 */
    private String insideTest ;
    /** 10、客户测试优化 */
    private String customerTest ;
    /** 11、实施交付 */
    private String implementDeliver ;
    /** 12、验收 */
    private String checkDeliver ;
    /** 状态（01有效 99 失效） */
    private String status ;
    /** 创建人 */
    private String createdStaff ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedStaff ;
    /** 更新时间 */
    private Date updatedTime ;

    /** 索引值 */
    public Integer getId(){
        return this.id;
    }
    /** 索引值 */
    public void setId(Integer id){
        this.id = id;
    }
    /** 产品类型 */
    public String getProductType(){
        return this.productType;
    }
    /** 产品类型 */
    public void setProductType(String productType){
        this.productType = productType;
    }
    /** 平台名称 */
    public String getPlatformName(){
        return this.platformName;
    }
    /** 平台名称 */
    public void setPlatformName(String platformName){
        this.platformName = platformName;
    }
    /** 5、需求评审 */
    public String getDemandReview(){
        return this.demandReview;
    }
    /** 5、需求评审 */
    public void setDemandReview(String demandReview){
        this.demandReview = demandReview;
    }
    /** 6、需求单确认 */
    public String getDemandConfirm(){
        return this.demandConfirm;
    }
    /** 6、需求单确认 */
    public void setDemandConfirm(String demandConfirm){
        this.demandConfirm = demandConfirm;
    }
    /** 7、验收 */
    public String getDemandCheck(){
        return this.demandCheck;
    }
    /** 7、验收 */
    public void setDemandCheck(String demandCheck){
        this.demandCheck = demandCheck;
    }
    /** 1、技术选型 */
    public String getTechnologySelection(){
        return this.technologySelection;
    }
    /** 1、技术选型 */
    public void setTechnologySelection(String technologySelection){
        this.technologySelection = technologySelection;
    }
    /** 2、环境部署 */
    public String getEnvironmentDeployment(){
        return this.environmentDeployment;
    }
    /** 2、环境部署 */
    public void setEnvironmentDeployment(String environmentDeployment){
        this.environmentDeployment = environmentDeployment;
    }
    /** 3、框架设计 */
    public String getFrameworkDesign(){
        return this.frameworkDesign;
    }
    /** 3、框架设计 */
    public void setFrameworkDesign(String frameworkDesign){
        this.frameworkDesign = frameworkDesign;
    }
    /** 4、开发进度10% */
    public String getDevelopProgress10(){
        return this.developProgress10;
    }
    /** 4、开发进度10% */
    public void setDevelopProgress10(String developProgress10){
        this.developProgress10 = developProgress10;
    }
    /** 5、开发进度25% */
    public String getDevelopProgress25(){
        return this.developProgress25;
    }
    /** 5、开发进度25% */
    public void setDevelopProgress25(String developProgress25){
        this.developProgress25 = developProgress25;
    }
    /** 6、开发进度50% */
    public String getDevelopProgress50(){
        return this.developProgress50;
    }
    /** 6、开发进度50% */
    public void setDevelopProgress50(String developProgress50){
        this.developProgress50 = developProgress50;
    }
    /** 7、开发进度75% */
    public String getDevelopProgress75(){
        return this.developProgress75;
    }
    /** 7、开发进度75% */
    public void setDevelopProgress75(String developProgress75){
        this.developProgress75 = developProgress75;
    }
    /** 8、开发进度100% */
    public String getDevelopProgress100(){
        return this.developProgress100;
    }
    /** 8、开发进度100% */
    public void setDevelopProgress100(String developProgress100){
        this.developProgress100 = developProgress100;
    }
    /** 9、内部测试优化 */
    public String getInsideTest(){
        return this.insideTest;
    }
    /** 9、内部测试优化 */
    public void setInsideTest(String insideTest){
        this.insideTest = insideTest;
    }
    /** 10、客户测试优化 */
    public String getCustomerTest(){
        return this.customerTest;
    }
    /** 10、客户测试优化 */
    public void setCustomerTest(String customerTest){
        this.customerTest = customerTest;
    }
    /** 11、实施交付 */
    public String getImplementDeliver(){
        return this.implementDeliver;
    }
    /** 11、实施交付 */
    public void setImplementDeliver(String implementDeliver){
        this.implementDeliver = implementDeliver;
    }
    /** 12、验收 */
    public String getCheckDeliver(){
        return this.checkDeliver;
    }
    /** 12、验收 */
    public void setCheckDeliver(String checkDeliver){
        this.checkDeliver = checkDeliver;
    }
    /** 状态（01有效 99 失效） */
    public String getStatus(){
        return this.status;
    }
    /** 状态（01有效 99 失效） */
    public void setStatus(String status){
        this.status = status;
    }
    /** 创建人 */
    public String getCreatedStaff(){
        return this.createdStaff;
    }
    /** 创建人 */
    public void setCreatedStaff(String createdStaff){
        this.createdStaff = createdStaff;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public String getUpdatedStaff(){
        return this.updatedStaff;
    }
    /** 更新人 */
    public void setUpdatedStaff(String updatedStaff){
        this.updatedStaff = updatedStaff;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
}