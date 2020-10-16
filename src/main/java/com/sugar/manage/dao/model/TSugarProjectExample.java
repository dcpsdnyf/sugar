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

        public Criteria andPlatformIdIsNull() {
            addCriterion("platform_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIsNotNull() {
            addCriterion("platform_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdEqualTo(String value) {
            addCriterion("platform_id =", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotEqualTo(String value) {
            addCriterion("platform_id <>", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThan(String value) {
            addCriterion("platform_id >", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThanOrEqualTo(String value) {
            addCriterion("platform_id >=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThan(String value) {
            addCriterion("platform_id <", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThanOrEqualTo(String value) {
            addCriterion("platform_id <=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLike(String value) {
            addCriterion("platform_id like", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotLike(String value) {
            addCriterion("platform_id not like", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIn(List<String> values) {
            addCriterion("platform_id in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotIn(List<String> values) {
            addCriterion("platform_id not in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdBetween(String value1, String value2) {
            addCriterion("platform_id between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotBetween(String value1, String value2) {
            addCriterion("platform_id not between", value1, value2, "platformId");
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

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("START_TIME like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("START_TIME not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalIsNull() {
            addCriterion("TASK_PRINCIPAL is null");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalIsNotNull() {
            addCriterion("TASK_PRINCIPAL is not null");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalEqualTo(String value) {
            addCriterion("TASK_PRINCIPAL =", value, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalNotEqualTo(String value) {
            addCriterion("TASK_PRINCIPAL <>", value, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalGreaterThan(String value) {
            addCriterion("TASK_PRINCIPAL >", value, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_PRINCIPAL >=", value, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalLessThan(String value) {
            addCriterion("TASK_PRINCIPAL <", value, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalLessThanOrEqualTo(String value) {
            addCriterion("TASK_PRINCIPAL <=", value, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalLike(String value) {
            addCriterion("TASK_PRINCIPAL like", value, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalNotLike(String value) {
            addCriterion("TASK_PRINCIPAL not like", value, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalIn(List<String> values) {
            addCriterion("TASK_PRINCIPAL in", values, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalNotIn(List<String> values) {
            addCriterion("TASK_PRINCIPAL not in", values, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalBetween(String value1, String value2) {
            addCriterion("TASK_PRINCIPAL between", value1, value2, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andTaskPrincipalNotBetween(String value1, String value2) {
            addCriterion("TASK_PRINCIPAL not between", value1, value2, "taskPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalIsNull() {
            addCriterion("business_principal is null");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalIsNotNull() {
            addCriterion("business_principal is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalEqualTo(String value) {
            addCriterion("business_principal =", value, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalNotEqualTo(String value) {
            addCriterion("business_principal <>", value, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalGreaterThan(String value) {
            addCriterion("business_principal >", value, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("business_principal >=", value, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalLessThan(String value) {
            addCriterion("business_principal <", value, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalLessThanOrEqualTo(String value) {
            addCriterion("business_principal <=", value, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalLike(String value) {
            addCriterion("business_principal like", value, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalNotLike(String value) {
            addCriterion("business_principal not like", value, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalIn(List<String> values) {
            addCriterion("business_principal in", values, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalNotIn(List<String> values) {
            addCriterion("business_principal not in", values, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalBetween(String value1, String value2) {
            addCriterion("business_principal between", value1, value2, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andBusinessPrincipalNotBetween(String value1, String value2) {
            addCriterion("business_principal not between", value1, value2, "businessPrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalIsNull() {
            addCriterion("purchase_principal is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalIsNotNull() {
            addCriterion("purchase_principal is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalEqualTo(String value) {
            addCriterion("purchase_principal =", value, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalNotEqualTo(String value) {
            addCriterion("purchase_principal <>", value, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalGreaterThan(String value) {
            addCriterion("purchase_principal >", value, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_principal >=", value, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalLessThan(String value) {
            addCriterion("purchase_principal <", value, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalLessThanOrEqualTo(String value) {
            addCriterion("purchase_principal <=", value, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalLike(String value) {
            addCriterion("purchase_principal like", value, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalNotLike(String value) {
            addCriterion("purchase_principal not like", value, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalIn(List<String> values) {
            addCriterion("purchase_principal in", values, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalNotIn(List<String> values) {
            addCriterion("purchase_principal not in", values, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalBetween(String value1, String value2) {
            addCriterion("purchase_principal between", value1, value2, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andPurchasePrincipalNotBetween(String value1, String value2) {
            addCriterion("purchase_principal not between", value1, value2, "purchasePrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalIsNull() {
            addCriterion("product_principal is null");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalIsNotNull() {
            addCriterion("product_principal is not null");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalEqualTo(String value) {
            addCriterion("product_principal =", value, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalNotEqualTo(String value) {
            addCriterion("product_principal <>", value, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalGreaterThan(String value) {
            addCriterion("product_principal >", value, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("product_principal >=", value, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalLessThan(String value) {
            addCriterion("product_principal <", value, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalLessThanOrEqualTo(String value) {
            addCriterion("product_principal <=", value, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalLike(String value) {
            addCriterion("product_principal like", value, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalNotLike(String value) {
            addCriterion("product_principal not like", value, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalIn(List<String> values) {
            addCriterion("product_principal in", values, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalNotIn(List<String> values) {
            addCriterion("product_principal not in", values, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalBetween(String value1, String value2) {
            addCriterion("product_principal between", value1, value2, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andProductPrincipalNotBetween(String value1, String value2) {
            addCriterion("product_principal not between", value1, value2, "productPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalIsNull() {
            addCriterion("development_principal is null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalIsNotNull() {
            addCriterion("development_principal is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalEqualTo(String value) {
            addCriterion("development_principal =", value, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalNotEqualTo(String value) {
            addCriterion("development_principal <>", value, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalGreaterThan(String value) {
            addCriterion("development_principal >", value, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("development_principal >=", value, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalLessThan(String value) {
            addCriterion("development_principal <", value, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalLessThanOrEqualTo(String value) {
            addCriterion("development_principal <=", value, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalLike(String value) {
            addCriterion("development_principal like", value, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalNotLike(String value) {
            addCriterion("development_principal not like", value, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalIn(List<String> values) {
            addCriterion("development_principal in", values, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalNotIn(List<String> values) {
            addCriterion("development_principal not in", values, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalBetween(String value1, String value2) {
            addCriterion("development_principal between", value1, value2, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andDevelopmentPrincipalNotBetween(String value1, String value2) {
            addCriterion("development_principal not between", value1, value2, "developmentPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalIsNull() {
            addCriterion("operation_principal is null");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalIsNotNull() {
            addCriterion("operation_principal is not null");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalEqualTo(String value) {
            addCriterion("operation_principal =", value, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalNotEqualTo(String value) {
            addCriterion("operation_principal <>", value, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalGreaterThan(String value) {
            addCriterion("operation_principal >", value, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("operation_principal >=", value, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalLessThan(String value) {
            addCriterion("operation_principal <", value, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalLessThanOrEqualTo(String value) {
            addCriterion("operation_principal <=", value, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalLike(String value) {
            addCriterion("operation_principal like", value, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalNotLike(String value) {
            addCriterion("operation_principal not like", value, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalIn(List<String> values) {
            addCriterion("operation_principal in", values, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalNotIn(List<String> values) {
            addCriterion("operation_principal not in", values, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalBetween(String value1, String value2) {
            addCriterion("operation_principal between", value1, value2, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationPrincipalNotBetween(String value1, String value2) {
            addCriterion("operation_principal not between", value1, value2, "operationPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalIsNull() {
            addCriterion("operation_maintain_principal is null");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalIsNotNull() {
            addCriterion("operation_maintain_principal is not null");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalEqualTo(String value) {
            addCriterion("operation_maintain_principal =", value, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalNotEqualTo(String value) {
            addCriterion("operation_maintain_principal <>", value, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalGreaterThan(String value) {
            addCriterion("operation_maintain_principal >", value, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("operation_maintain_principal >=", value, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalLessThan(String value) {
            addCriterion("operation_maintain_principal <", value, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalLessThanOrEqualTo(String value) {
            addCriterion("operation_maintain_principal <=", value, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalLike(String value) {
            addCriterion("operation_maintain_principal like", value, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalNotLike(String value) {
            addCriterion("operation_maintain_principal not like", value, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalIn(List<String> values) {
            addCriterion("operation_maintain_principal in", values, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalNotIn(List<String> values) {
            addCriterion("operation_maintain_principal not in", values, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalBetween(String value1, String value2) {
            addCriterion("operation_maintain_principal between", value1, value2, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andOperationMaintainPrincipalNotBetween(String value1, String value2) {
            addCriterion("operation_maintain_principal not between", value1, value2, "operationMaintainPrincipal");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameIsNull() {
            addCriterion("add_project_username is null");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameIsNotNull() {
            addCriterion("add_project_username is not null");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameEqualTo(String value) {
            addCriterion("add_project_username =", value, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameNotEqualTo(String value) {
            addCriterion("add_project_username <>", value, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameGreaterThan(String value) {
            addCriterion("add_project_username >", value, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("add_project_username >=", value, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameLessThan(String value) {
            addCriterion("add_project_username <", value, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameLessThanOrEqualTo(String value) {
            addCriterion("add_project_username <=", value, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameLike(String value) {
            addCriterion("add_project_username like", value, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameNotLike(String value) {
            addCriterion("add_project_username not like", value, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameIn(List<String> values) {
            addCriterion("add_project_username in", values, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameNotIn(List<String> values) {
            addCriterion("add_project_username not in", values, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameBetween(String value1, String value2) {
            addCriterion("add_project_username between", value1, value2, "addProjectUsername");
            return (Criteria) this;
        }

        public Criteria andAddProjectUsernameNotBetween(String value1, String value2) {
            addCriterion("add_project_username not between", value1, value2, "addProjectUsername");
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