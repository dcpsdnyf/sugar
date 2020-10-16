package com.sugar.manage.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDelayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDelayExample() {
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

        public Criteria andDelayTimeIsNull() {
            addCriterion("DELAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIsNotNull() {
            addCriterion("DELAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDelayTimeEqualTo(String value) {
            addCriterion("DELAY_TIME =", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotEqualTo(String value) {
            addCriterion("DELAY_TIME <>", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeGreaterThan(String value) {
            addCriterion("DELAY_TIME >", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeGreaterThanOrEqualTo(String value) {
            addCriterion("DELAY_TIME >=", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLessThan(String value) {
            addCriterion("DELAY_TIME <", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLessThanOrEqualTo(String value) {
            addCriterion("DELAY_TIME <=", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLike(String value) {
            addCriterion("DELAY_TIME like", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotLike(String value) {
            addCriterion("DELAY_TIME not like", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIn(List<String> values) {
            addCriterion("DELAY_TIME in", values, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotIn(List<String> values) {
            addCriterion("DELAY_TIME not in", values, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeBetween(String value1, String value2) {
            addCriterion("DELAY_TIME between", value1, value2, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotBetween(String value1, String value2) {
            addCriterion("DELAY_TIME not between", value1, value2, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameIsNull() {
            addCriterion("DELAY_PEOPLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameIsNotNull() {
            addCriterion("DELAY_PEOPLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameEqualTo(String value) {
            addCriterion("DELAY_PEOPLE_NAME =", value, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameNotEqualTo(String value) {
            addCriterion("DELAY_PEOPLE_NAME <>", value, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameGreaterThan(String value) {
            addCriterion("DELAY_PEOPLE_NAME >", value, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameGreaterThanOrEqualTo(String value) {
            addCriterion("DELAY_PEOPLE_NAME >=", value, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameLessThan(String value) {
            addCriterion("DELAY_PEOPLE_NAME <", value, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameLessThanOrEqualTo(String value) {
            addCriterion("DELAY_PEOPLE_NAME <=", value, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameLike(String value) {
            addCriterion("DELAY_PEOPLE_NAME like", value, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameNotLike(String value) {
            addCriterion("DELAY_PEOPLE_NAME not like", value, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameIn(List<String> values) {
            addCriterion("DELAY_PEOPLE_NAME in", values, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameNotIn(List<String> values) {
            addCriterion("DELAY_PEOPLE_NAME not in", values, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameBetween(String value1, String value2) {
            addCriterion("DELAY_PEOPLE_NAME between", value1, value2, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andDelayPeopleNameNotBetween(String value1, String value2) {
            addCriterion("DELAY_PEOPLE_NAME not between", value1, value2, "delayPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameIsNull() {
            addCriterion("AUDITING_PEOPLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameIsNotNull() {
            addCriterion("AUDITING_PEOPLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameEqualTo(String value) {
            addCriterion("AUDITING_PEOPLE_NAME =", value, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameNotEqualTo(String value) {
            addCriterion("AUDITING_PEOPLE_NAME <>", value, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameGreaterThan(String value) {
            addCriterion("AUDITING_PEOPLE_NAME >", value, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameGreaterThanOrEqualTo(String value) {
            addCriterion("AUDITING_PEOPLE_NAME >=", value, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameLessThan(String value) {
            addCriterion("AUDITING_PEOPLE_NAME <", value, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameLessThanOrEqualTo(String value) {
            addCriterion("AUDITING_PEOPLE_NAME <=", value, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameLike(String value) {
            addCriterion("AUDITING_PEOPLE_NAME like", value, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameNotLike(String value) {
            addCriterion("AUDITING_PEOPLE_NAME not like", value, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameIn(List<String> values) {
            addCriterion("AUDITING_PEOPLE_NAME in", values, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameNotIn(List<String> values) {
            addCriterion("AUDITING_PEOPLE_NAME not in", values, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameBetween(String value1, String value2) {
            addCriterion("AUDITING_PEOPLE_NAME between", value1, value2, "auditingPeopleName");
            return (Criteria) this;
        }

        public Criteria andAuditingPeopleNameNotBetween(String value1, String value2) {
            addCriterion("AUDITING_PEOPLE_NAME not between", value1, value2, "auditingPeopleName");
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

        public Criteria andAuditingStatusIsNull() {
            addCriterion("AUDITING_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusIsNotNull() {
            addCriterion("AUDITING_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusEqualTo(String value) {
            addCriterion("AUDITING_STATUS =", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusNotEqualTo(String value) {
            addCriterion("AUDITING_STATUS <>", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusGreaterThan(String value) {
            addCriterion("AUDITING_STATUS >", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusGreaterThanOrEqualTo(String value) {
            addCriterion("AUDITING_STATUS >=", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusLessThan(String value) {
            addCriterion("AUDITING_STATUS <", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusLessThanOrEqualTo(String value) {
            addCriterion("AUDITING_STATUS <=", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusLike(String value) {
            addCriterion("AUDITING_STATUS like", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusNotLike(String value) {
            addCriterion("AUDITING_STATUS not like", value, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusIn(List<String> values) {
            addCriterion("AUDITING_STATUS in", values, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusNotIn(List<String> values) {
            addCriterion("AUDITING_STATUS not in", values, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusBetween(String value1, String value2) {
            addCriterion("AUDITING_STATUS between", value1, value2, "auditingStatus");
            return (Criteria) this;
        }

        public Criteria andAuditingStatusNotBetween(String value1, String value2) {
            addCriterion("AUDITING_STATUS not between", value1, value2, "auditingStatus");
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