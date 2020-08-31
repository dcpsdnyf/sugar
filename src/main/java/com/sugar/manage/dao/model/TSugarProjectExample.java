package com.sugar.manage.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSugarProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSugarProjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNull() {
            addCriterion("platform_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameEqualTo(String value) {
            addCriterion("platform_name =", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotEqualTo(String value) {
            addCriterion("platform_name <>", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThan(String value) {
            addCriterion("platform_name >", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_name >=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThan(String value) {
            addCriterion("platform_name <", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThanOrEqualTo(String value) {
            addCriterion("platform_name <=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLike(String value) {
            addCriterion("platform_name like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotLike(String value) {
            addCriterion("platform_name not like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIn(List<String> values) {
            addCriterion("platform_name in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotIn(List<String> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameBetween(String value1, String value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotBetween(String value1, String value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andDemandReviewIsNull() {
            addCriterion("demand_review is null");
            return (Criteria) this;
        }

        public Criteria andDemandReviewIsNotNull() {
            addCriterion("demand_review is not null");
            return (Criteria) this;
        }

        public Criteria andDemandReviewEqualTo(String value) {
            addCriterion("demand_review =", value, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewNotEqualTo(String value) {
            addCriterion("demand_review <>", value, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewGreaterThan(String value) {
            addCriterion("demand_review >", value, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewGreaterThanOrEqualTo(String value) {
            addCriterion("demand_review >=", value, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewLessThan(String value) {
            addCriterion("demand_review <", value, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewLessThanOrEqualTo(String value) {
            addCriterion("demand_review <=", value, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewLike(String value) {
            addCriterion("demand_review like", value, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewNotLike(String value) {
            addCriterion("demand_review not like", value, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewIn(List<String> values) {
            addCriterion("demand_review in", values, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewNotIn(List<String> values) {
            addCriterion("demand_review not in", values, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewBetween(String value1, String value2) {
            addCriterion("demand_review between", value1, value2, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandReviewNotBetween(String value1, String value2) {
            addCriterion("demand_review not between", value1, value2, "demandReview");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmIsNull() {
            addCriterion("demand_confirm is null");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmIsNotNull() {
            addCriterion("demand_confirm is not null");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmEqualTo(String value) {
            addCriterion("demand_confirm =", value, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmNotEqualTo(String value) {
            addCriterion("demand_confirm <>", value, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmGreaterThan(String value) {
            addCriterion("demand_confirm >", value, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmGreaterThanOrEqualTo(String value) {
            addCriterion("demand_confirm >=", value, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmLessThan(String value) {
            addCriterion("demand_confirm <", value, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmLessThanOrEqualTo(String value) {
            addCriterion("demand_confirm <=", value, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmLike(String value) {
            addCriterion("demand_confirm like", value, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmNotLike(String value) {
            addCriterion("demand_confirm not like", value, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmIn(List<String> values) {
            addCriterion("demand_confirm in", values, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmNotIn(List<String> values) {
            addCriterion("demand_confirm not in", values, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmBetween(String value1, String value2) {
            addCriterion("demand_confirm between", value1, value2, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandConfirmNotBetween(String value1, String value2) {
            addCriterion("demand_confirm not between", value1, value2, "demandConfirm");
            return (Criteria) this;
        }

        public Criteria andDemandCheckIsNull() {
            addCriterion("demand_check is null");
            return (Criteria) this;
        }

        public Criteria andDemandCheckIsNotNull() {
            addCriterion("demand_check is not null");
            return (Criteria) this;
        }

        public Criteria andDemandCheckEqualTo(String value) {
            addCriterion("demand_check =", value, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckNotEqualTo(String value) {
            addCriterion("demand_check <>", value, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckGreaterThan(String value) {
            addCriterion("demand_check >", value, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckGreaterThanOrEqualTo(String value) {
            addCriterion("demand_check >=", value, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckLessThan(String value) {
            addCriterion("demand_check <", value, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckLessThanOrEqualTo(String value) {
            addCriterion("demand_check <=", value, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckLike(String value) {
            addCriterion("demand_check like", value, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckNotLike(String value) {
            addCriterion("demand_check not like", value, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckIn(List<String> values) {
            addCriterion("demand_check in", values, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckNotIn(List<String> values) {
            addCriterion("demand_check not in", values, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckBetween(String value1, String value2) {
            addCriterion("demand_check between", value1, value2, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andDemandCheckNotBetween(String value1, String value2) {
            addCriterion("demand_check not between", value1, value2, "demandCheck");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentIsNull() {
            addCriterion("environment_deployment is null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentIsNotNull() {
            addCriterion("environment_deployment is not null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentEqualTo(String value) {
            addCriterion("environment_deployment =", value, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentNotEqualTo(String value) {
            addCriterion("environment_deployment <>", value, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentGreaterThan(String value) {
            addCriterion("environment_deployment >", value, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentGreaterThanOrEqualTo(String value) {
            addCriterion("environment_deployment >=", value, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentLessThan(String value) {
            addCriterion("environment_deployment <", value, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentLessThanOrEqualTo(String value) {
            addCriterion("environment_deployment <=", value, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentLike(String value) {
            addCriterion("environment_deployment like", value, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentNotLike(String value) {
            addCriterion("environment_deployment not like", value, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentIn(List<String> values) {
            addCriterion("environment_deployment in", values, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentNotIn(List<String> values) {
            addCriterion("environment_deployment not in", values, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentBetween(String value1, String value2) {
            addCriterion("environment_deployment between", value1, value2, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentDeploymentNotBetween(String value1, String value2) {
            addCriterion("environment_deployment not between", value1, value2, "environmentDeployment");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10IsNull() {
            addCriterion("develop_progress_10 is null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10IsNotNull() {
            addCriterion("develop_progress_10 is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10EqualTo(String value) {
            addCriterion("develop_progress_10 =", value, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10NotEqualTo(String value) {
            addCriterion("develop_progress_10 <>", value, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10GreaterThan(String value) {
            addCriterion("develop_progress_10 >", value, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10GreaterThanOrEqualTo(String value) {
            addCriterion("develop_progress_10 >=", value, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10LessThan(String value) {
            addCriterion("develop_progress_10 <", value, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10LessThanOrEqualTo(String value) {
            addCriterion("develop_progress_10 <=", value, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10Like(String value) {
            addCriterion("develop_progress_10 like", value, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10NotLike(String value) {
            addCriterion("develop_progress_10 not like", value, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10In(List<String> values) {
            addCriterion("develop_progress_10 in", values, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10NotIn(List<String> values) {
            addCriterion("develop_progress_10 not in", values, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10Between(String value1, String value2) {
            addCriterion("develop_progress_10 between", value1, value2, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress10NotBetween(String value1, String value2) {
            addCriterion("develop_progress_10 not between", value1, value2, "developProgress10");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25IsNull() {
            addCriterion("develop_progress_25 is null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25IsNotNull() {
            addCriterion("develop_progress_25 is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25EqualTo(String value) {
            addCriterion("develop_progress_25 =", value, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25NotEqualTo(String value) {
            addCriterion("develop_progress_25 <>", value, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25GreaterThan(String value) {
            addCriterion("develop_progress_25 >", value, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25GreaterThanOrEqualTo(String value) {
            addCriterion("develop_progress_25 >=", value, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25LessThan(String value) {
            addCriterion("develop_progress_25 <", value, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25LessThanOrEqualTo(String value) {
            addCriterion("develop_progress_25 <=", value, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25Like(String value) {
            addCriterion("develop_progress_25 like", value, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25NotLike(String value) {
            addCriterion("develop_progress_25 not like", value, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25In(List<String> values) {
            addCriterion("develop_progress_25 in", values, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25NotIn(List<String> values) {
            addCriterion("develop_progress_25 not in", values, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25Between(String value1, String value2) {
            addCriterion("develop_progress_25 between", value1, value2, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress25NotBetween(String value1, String value2) {
            addCriterion("develop_progress_25 not between", value1, value2, "developProgress25");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50IsNull() {
            addCriterion("develop_progress_50 is null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50IsNotNull() {
            addCriterion("develop_progress_50 is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50EqualTo(String value) {
            addCriterion("develop_progress_50 =", value, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50NotEqualTo(String value) {
            addCriterion("develop_progress_50 <>", value, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50GreaterThan(String value) {
            addCriterion("develop_progress_50 >", value, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50GreaterThanOrEqualTo(String value) {
            addCriterion("develop_progress_50 >=", value, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50LessThan(String value) {
            addCriterion("develop_progress_50 <", value, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50LessThanOrEqualTo(String value) {
            addCriterion("develop_progress_50 <=", value, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50Like(String value) {
            addCriterion("develop_progress_50 like", value, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50NotLike(String value) {
            addCriterion("develop_progress_50 not like", value, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50In(List<String> values) {
            addCriterion("develop_progress_50 in", values, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50NotIn(List<String> values) {
            addCriterion("develop_progress_50 not in", values, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50Between(String value1, String value2) {
            addCriterion("develop_progress_50 between", value1, value2, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress50NotBetween(String value1, String value2) {
            addCriterion("develop_progress_50 not between", value1, value2, "developProgress50");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75IsNull() {
            addCriterion("develop_progress_75 is null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75IsNotNull() {
            addCriterion("develop_progress_75 is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75EqualTo(String value) {
            addCriterion("develop_progress_75 =", value, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75NotEqualTo(String value) {
            addCriterion("develop_progress_75 <>", value, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75GreaterThan(String value) {
            addCriterion("develop_progress_75 >", value, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75GreaterThanOrEqualTo(String value) {
            addCriterion("develop_progress_75 >=", value, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75LessThan(String value) {
            addCriterion("develop_progress_75 <", value, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75LessThanOrEqualTo(String value) {
            addCriterion("develop_progress_75 <=", value, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75Like(String value) {
            addCriterion("develop_progress_75 like", value, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75NotLike(String value) {
            addCriterion("develop_progress_75 not like", value, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75In(List<String> values) {
            addCriterion("develop_progress_75 in", values, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75NotIn(List<String> values) {
            addCriterion("develop_progress_75 not in", values, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75Between(String value1, String value2) {
            addCriterion("develop_progress_75 between", value1, value2, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress75NotBetween(String value1, String value2) {
            addCriterion("develop_progress_75 not between", value1, value2, "developProgress75");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100IsNull() {
            addCriterion("develop_progress_100 is null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100IsNotNull() {
            addCriterion("develop_progress_100 is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100EqualTo(String value) {
            addCriterion("develop_progress_100 =", value, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100NotEqualTo(String value) {
            addCriterion("develop_progress_100 <>", value, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100GreaterThan(String value) {
            addCriterion("develop_progress_100 >", value, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100GreaterThanOrEqualTo(String value) {
            addCriterion("develop_progress_100 >=", value, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100LessThan(String value) {
            addCriterion("develop_progress_100 <", value, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100LessThanOrEqualTo(String value) {
            addCriterion("develop_progress_100 <=", value, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100Like(String value) {
            addCriterion("develop_progress_100 like", value, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100NotLike(String value) {
            addCriterion("develop_progress_100 not like", value, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100In(List<String> values) {
            addCriterion("develop_progress_100 in", values, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100NotIn(List<String> values) {
            addCriterion("develop_progress_100 not in", values, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100Between(String value1, String value2) {
            addCriterion("develop_progress_100 between", value1, value2, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andDevelopProgress100NotBetween(String value1, String value2) {
            addCriterion("develop_progress_100 not between", value1, value2, "developProgress100");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverIsNull() {
            addCriterion("implement_deliver is null");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverIsNotNull() {
            addCriterion("implement_deliver is not null");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverEqualTo(String value) {
            addCriterion("implement_deliver =", value, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverNotEqualTo(String value) {
            addCriterion("implement_deliver <>", value, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverGreaterThan(String value) {
            addCriterion("implement_deliver >", value, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverGreaterThanOrEqualTo(String value) {
            addCriterion("implement_deliver >=", value, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverLessThan(String value) {
            addCriterion("implement_deliver <", value, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverLessThanOrEqualTo(String value) {
            addCriterion("implement_deliver <=", value, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverLike(String value) {
            addCriterion("implement_deliver like", value, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverNotLike(String value) {
            addCriterion("implement_deliver not like", value, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverIn(List<String> values) {
            addCriterion("implement_deliver in", values, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverNotIn(List<String> values) {
            addCriterion("implement_deliver not in", values, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverBetween(String value1, String value2) {
            addCriterion("implement_deliver between", value1, value2, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andImplementDeliverNotBetween(String value1, String value2) {
            addCriterion("implement_deliver not between", value1, value2, "implementDeliver");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffIsNull() {
            addCriterion("CREATED_STAFF is null");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffIsNotNull() {
            addCriterion("CREATED_STAFF is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffEqualTo(String value) {
            addCriterion("CREATED_STAFF =", value, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffNotEqualTo(String value) {
            addCriterion("CREATED_STAFF <>", value, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffGreaterThan(String value) {
            addCriterion("CREATED_STAFF >", value, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_STAFF >=", value, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffLessThan(String value) {
            addCriterion("CREATED_STAFF <", value, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffLessThanOrEqualTo(String value) {
            addCriterion("CREATED_STAFF <=", value, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffLike(String value) {
            addCriterion("CREATED_STAFF like", value, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffNotLike(String value) {
            addCriterion("CREATED_STAFF not like", value, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffIn(List<String> values) {
            addCriterion("CREATED_STAFF in", values, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffNotIn(List<String> values) {
            addCriterion("CREATED_STAFF not in", values, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffBetween(String value1, String value2) {
            addCriterion("CREATED_STAFF between", value1, value2, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedStaffNotBetween(String value1, String value2) {
            addCriterion("CREATED_STAFF not between", value1, value2, "createdStaff");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("CREATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("CREATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("CREATED_TIME =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("CREATED_TIME <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("CREATED_TIME >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("CREATED_TIME <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("CREATED_TIME in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("CREATED_TIME not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffIsNull() {
            addCriterion("UPDATED_STAFF is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffIsNotNull() {
            addCriterion("UPDATED_STAFF is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffEqualTo(String value) {
            addCriterion("UPDATED_STAFF =", value, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffNotEqualTo(String value) {
            addCriterion("UPDATED_STAFF <>", value, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffGreaterThan(String value) {
            addCriterion("UPDATED_STAFF >", value, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATED_STAFF >=", value, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffLessThan(String value) {
            addCriterion("UPDATED_STAFF <", value, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffLessThanOrEqualTo(String value) {
            addCriterion("UPDATED_STAFF <=", value, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffLike(String value) {
            addCriterion("UPDATED_STAFF like", value, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffNotLike(String value) {
            addCriterion("UPDATED_STAFF not like", value, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffIn(List<String> values) {
            addCriterion("UPDATED_STAFF in", values, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffNotIn(List<String> values) {
            addCriterion("UPDATED_STAFF not in", values, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffBetween(String value1, String value2) {
            addCriterion("UPDATED_STAFF between", value1, value2, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedStaffNotBetween(String value1, String value2) {
            addCriterion("UPDATED_STAFF not between", value1, value2, "updatedStaff");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("UPDATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("UPDATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("UPDATED_TIME =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("UPDATED_TIME <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("UPDATED_TIME >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED_TIME >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("UPDATED_TIME <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED_TIME <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("UPDATED_TIME in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("UPDATED_TIME not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATED_TIME between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED_TIME not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}