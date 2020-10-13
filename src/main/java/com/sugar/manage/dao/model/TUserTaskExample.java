package com.sugar.manage.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserTaskExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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

        public Criteria andProjectIdIsNull() {
            addCriterion("PROJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("PROJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("PROJECT_ID =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("PROJECT_ID <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("PROJECT_ID >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_ID >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("PROJECT_ID <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_ID <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("PROJECT_ID like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("PROJECT_ID not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("PROJECT_ID in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("PROJECT_ID not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("PROJECT_ID between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("PROJECT_ID not between", value1, value2, "projectId");
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

        public Criteria andTaskTypeIsNull() {
            addCriterion("TASK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("TASK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("TASK_TYPE =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("TASK_TYPE <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("TASK_TYPE >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_TYPE >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("TASK_TYPE <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("TASK_TYPE <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("TASK_TYPE like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("TASK_TYPE not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("TASK_TYPE in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("TASK_TYPE not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("TASK_TYPE between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("TASK_TYPE not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("TASK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("TASK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(String value) {
            addCriterion("TASK_STATUS =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(String value) {
            addCriterion("TASK_STATUS <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(String value) {
            addCriterion("TASK_STATUS >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_STATUS >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(String value) {
            addCriterion("TASK_STATUS <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(String value) {
            addCriterion("TASK_STATUS <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLike(String value) {
            addCriterion("TASK_STATUS like", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotLike(String value) {
            addCriterion("TASK_STATUS not like", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<String> values) {
            addCriterion("TASK_STATUS in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<String> values) {
            addCriterion("TASK_STATUS not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(String value1, String value2) {
            addCriterion("TASK_STATUS between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(String value1, String value2) {
            addCriterion("TASK_STATUS not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("TASK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("TASK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("TASK_NAME =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("TASK_NAME <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("TASK_NAME >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_NAME >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("TASK_NAME <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("TASK_NAME <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("TASK_NAME like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("TASK_NAME not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("TASK_NAME in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("TASK_NAME not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("TASK_NAME between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("TASK_NAME not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameIsNull() {
            addCriterion("TASK_SUB_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameIsNotNull() {
            addCriterion("TASK_SUB_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameEqualTo(String value) {
            addCriterion("TASK_SUB_NAME =", value, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameNotEqualTo(String value) {
            addCriterion("TASK_SUB_NAME <>", value, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameGreaterThan(String value) {
            addCriterion("TASK_SUB_NAME >", value, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_SUB_NAME >=", value, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameLessThan(String value) {
            addCriterion("TASK_SUB_NAME <", value, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameLessThanOrEqualTo(String value) {
            addCriterion("TASK_SUB_NAME <=", value, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameLike(String value) {
            addCriterion("TASK_SUB_NAME like", value, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameNotLike(String value) {
            addCriterion("TASK_SUB_NAME not like", value, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameIn(List<String> values) {
            addCriterion("TASK_SUB_NAME in", values, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameNotIn(List<String> values) {
            addCriterion("TASK_SUB_NAME not in", values, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameBetween(String value1, String value2) {
            addCriterion("TASK_SUB_NAME between", value1, value2, "taskSubName");
            return (Criteria) this;
        }

        public Criteria andTaskSubNameNotBetween(String value1, String value2) {
            addCriterion("TASK_SUB_NAME not between", value1, value2, "taskSubName");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("END_TIME like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("END_TIME not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeIsNull() {
            addCriterion("ESTIMATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeIsNotNull() {
            addCriterion("ESTIMATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeEqualTo(String value) {
            addCriterion("ESTIMATED_TIME =", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeNotEqualTo(String value) {
            addCriterion("ESTIMATED_TIME <>", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeGreaterThan(String value) {
            addCriterion("ESTIMATED_TIME >", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ESTIMATED_TIME >=", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeLessThan(String value) {
            addCriterion("ESTIMATED_TIME <", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeLessThanOrEqualTo(String value) {
            addCriterion("ESTIMATED_TIME <=", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeLike(String value) {
            addCriterion("ESTIMATED_TIME like", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeNotLike(String value) {
            addCriterion("ESTIMATED_TIME not like", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeIn(List<String> values) {
            addCriterion("ESTIMATED_TIME in", values, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeNotIn(List<String> values) {
            addCriterion("ESTIMATED_TIME not in", values, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeBetween(String value1, String value2) {
            addCriterion("ESTIMATED_TIME between", value1, value2, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeNotBetween(String value1, String value2) {
            addCriterion("ESTIMATED_TIME not between", value1, value2, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andTaskInfoIsNull() {
            addCriterion("TASK_INFO is null");
            return (Criteria) this;
        }

        public Criteria andTaskInfoIsNotNull() {
            addCriterion("TASK_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andTaskInfoEqualTo(String value) {
            addCriterion("TASK_INFO =", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoNotEqualTo(String value) {
            addCriterion("TASK_INFO <>", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoGreaterThan(String value) {
            addCriterion("TASK_INFO >", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_INFO >=", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoLessThan(String value) {
            addCriterion("TASK_INFO <", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoLessThanOrEqualTo(String value) {
            addCriterion("TASK_INFO <=", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoLike(String value) {
            addCriterion("TASK_INFO like", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoNotLike(String value) {
            addCriterion("TASK_INFO not like", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoIn(List<String> values) {
            addCriterion("TASK_INFO in", values, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoNotIn(List<String> values) {
            addCriterion("TASK_INFO not in", values, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoBetween(String value1, String value2) {
            addCriterion("TASK_INFO between", value1, value2, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoNotBetween(String value1, String value2) {
            addCriterion("TASK_INFO not between", value1, value2, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeIsNull() {
            addCriterion("TASK_PARENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeIsNotNull() {
            addCriterion("TASK_PARENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeEqualTo(String value) {
            addCriterion("TASK_PARENT_TYPE =", value, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeNotEqualTo(String value) {
            addCriterion("TASK_PARENT_TYPE <>", value, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeGreaterThan(String value) {
            addCriterion("TASK_PARENT_TYPE >", value, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_PARENT_TYPE >=", value, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeLessThan(String value) {
            addCriterion("TASK_PARENT_TYPE <", value, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeLessThanOrEqualTo(String value) {
            addCriterion("TASK_PARENT_TYPE <=", value, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeLike(String value) {
            addCriterion("TASK_PARENT_TYPE like", value, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeNotLike(String value) {
            addCriterion("TASK_PARENT_TYPE not like", value, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeIn(List<String> values) {
            addCriterion("TASK_PARENT_TYPE in", values, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeNotIn(List<String> values) {
            addCriterion("TASK_PARENT_TYPE not in", values, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeBetween(String value1, String value2) {
            addCriterion("TASK_PARENT_TYPE between", value1, value2, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andTaskParentTypeNotBetween(String value1, String value2) {
            addCriterion("TASK_PARENT_TYPE not between", value1, value2, "taskParentType");
            return (Criteria) this;
        }

        public Criteria andDelayDayIsNull() {
            addCriterion("DELAY_DAY is null");
            return (Criteria) this;
        }

        public Criteria andDelayDayIsNotNull() {
            addCriterion("DELAY_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andDelayDayEqualTo(String value) {
            addCriterion("DELAY_DAY =", value, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayNotEqualTo(String value) {
            addCriterion("DELAY_DAY <>", value, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayGreaterThan(String value) {
            addCriterion("DELAY_DAY >", value, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayGreaterThanOrEqualTo(String value) {
            addCriterion("DELAY_DAY >=", value, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayLessThan(String value) {
            addCriterion("DELAY_DAY <", value, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayLessThanOrEqualTo(String value) {
            addCriterion("DELAY_DAY <=", value, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayLike(String value) {
            addCriterion("DELAY_DAY like", value, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayNotLike(String value) {
            addCriterion("DELAY_DAY not like", value, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayIn(List<String> values) {
            addCriterion("DELAY_DAY in", values, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayNotIn(List<String> values) {
            addCriterion("DELAY_DAY not in", values, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayBetween(String value1, String value2) {
            addCriterion("DELAY_DAY between", value1, value2, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayDayNotBetween(String value1, String value2) {
            addCriterion("DELAY_DAY not between", value1, value2, "delayDay");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleIsNull() {
            addCriterion("DELAY_PEOPLE is null");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleIsNotNull() {
            addCriterion("DELAY_PEOPLE is not null");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleEqualTo(String value) {
            addCriterion("DELAY_PEOPLE =", value, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNotEqualTo(String value) {
            addCriterion("DELAY_PEOPLE <>", value, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleGreaterThan(String value) {
            addCriterion("DELAY_PEOPLE >", value, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("DELAY_PEOPLE >=", value, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleLessThan(String value) {
            addCriterion("DELAY_PEOPLE <", value, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleLessThanOrEqualTo(String value) {
            addCriterion("DELAY_PEOPLE <=", value, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleLike(String value) {
            addCriterion("DELAY_PEOPLE like", value, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNotLike(String value) {
            addCriterion("DELAY_PEOPLE not like", value, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleIn(List<String> values) {
            addCriterion("DELAY_PEOPLE in", values, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNotIn(List<String> values) {
            addCriterion("DELAY_PEOPLE not in", values, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleBetween(String value1, String value2) {
            addCriterion("DELAY_PEOPLE between", value1, value2, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNotBetween(String value1, String value2) {
            addCriterion("DELAY_PEOPLE not between", value1, value2, "delayPeople");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("principal like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("principal not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("principal not between", value1, value2, "principal");
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