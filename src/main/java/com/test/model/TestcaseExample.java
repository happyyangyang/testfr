package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class TestcaseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public TestcaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCasenameIsNull() {
            addCriterion("casename is null");
            return (Criteria) this;
        }

        public Criteria andCasenameIsNotNull() {
            addCriterion("casename is not null");
            return (Criteria) this;
        }

        public Criteria andCasenameEqualTo(String value) {
            addCriterion("casename =", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameNotEqualTo(String value) {
            addCriterion("casename <>", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameGreaterThan(String value) {
            addCriterion("casename >", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameGreaterThanOrEqualTo(String value) {
            addCriterion("casename >=", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameLessThan(String value) {
            addCriterion("casename <", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameLessThanOrEqualTo(String value) {
            addCriterion("casename <=", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameLike(String value) {
            addCriterion("casename like", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameNotLike(String value) {
            addCriterion("casename not like", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameIn(List<String> values) {
            addCriterion("casename in", values, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameNotIn(List<String> values) {
            addCriterion("casename not in", values, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameBetween(String value1, String value2) {
            addCriterion("casename between", value1, value2, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameNotBetween(String value1, String value2) {
            addCriterion("casename not between", value1, value2, "casename");
            return (Criteria) this;
        }

        public Criteria andScenarioIsNull() {
            addCriterion("scenario is null");
            return (Criteria) this;
        }

        public Criteria andScenarioIsNotNull() {
            addCriterion("scenario is not null");
            return (Criteria) this;
        }

        public Criteria andScenarioEqualTo(String value) {
            addCriterion("scenario =", value, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioNotEqualTo(String value) {
            addCriterion("scenario <>", value, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioGreaterThan(String value) {
            addCriterion("scenario >", value, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioGreaterThanOrEqualTo(String value) {
            addCriterion("scenario >=", value, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioLessThan(String value) {
            addCriterion("scenario <", value, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioLessThanOrEqualTo(String value) {
            addCriterion("scenario <=", value, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioLike(String value) {
            addCriterion("scenario like", value, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioNotLike(String value) {
            addCriterion("scenario not like", value, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioIn(List<String> values) {
            addCriterion("scenario in", values, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioNotIn(List<String> values) {
            addCriterion("scenario not in", values, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioBetween(String value1, String value2) {
            addCriterion("scenario between", value1, value2, "scenario");
            return (Criteria) this;
        }

        public Criteria andScenarioNotBetween(String value1, String value2) {
            addCriterion("scenario not between", value1, value2, "scenario");
            return (Criteria) this;
        }

        public Criteria andParmaterIsNull() {
            addCriterion("parmater is null");
            return (Criteria) this;
        }

        public Criteria andParmaterIsNotNull() {
            addCriterion("parmater is not null");
            return (Criteria) this;
        }

        public Criteria andParmaterEqualTo(String value) {
            addCriterion("parmater =", value, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterNotEqualTo(String value) {
            addCriterion("parmater <>", value, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterGreaterThan(String value) {
            addCriterion("parmater >", value, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterGreaterThanOrEqualTo(String value) {
            addCriterion("parmater >=", value, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterLessThan(String value) {
            addCriterion("parmater <", value, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterLessThanOrEqualTo(String value) {
            addCriterion("parmater <=", value, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterLike(String value) {
            addCriterion("parmater like", value, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterNotLike(String value) {
            addCriterion("parmater not like", value, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterIn(List<String> values) {
            addCriterion("parmater in", values, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterNotIn(List<String> values) {
            addCriterion("parmater not in", values, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterBetween(String value1, String value2) {
            addCriterion("parmater between", value1, value2, "parmater");
            return (Criteria) this;
        }

        public Criteria andParmaterNotBetween(String value1, String value2) {
            addCriterion("parmater not between", value1, value2, "parmater");
            return (Criteria) this;
        }

        public Criteria andExpectIsNull() {
            addCriterion("expect is null");
            return (Criteria) this;
        }

        public Criteria andExpectIsNotNull() {
            addCriterion("expect is not null");
            return (Criteria) this;
        }

        public Criteria andExpectEqualTo(String value) {
            addCriterion("expect =", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectNotEqualTo(String value) {
            addCriterion("expect <>", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectGreaterThan(String value) {
            addCriterion("expect >", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectGreaterThanOrEqualTo(String value) {
            addCriterion("expect >=", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectLessThan(String value) {
            addCriterion("expect <", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectLessThanOrEqualTo(String value) {
            addCriterion("expect <=", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectLike(String value) {
            addCriterion("expect like", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectNotLike(String value) {
            addCriterion("expect not like", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectIn(List<String> values) {
            addCriterion("expect in", values, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectNotIn(List<String> values) {
            addCriterion("expect not in", values, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectBetween(String value1, String value2) {
            addCriterion("expect between", value1, value2, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectNotBetween(String value1, String value2) {
            addCriterion("expect not between", value1, value2, "expect");
            return (Criteria) this;
        }

        public Criteria andApiidIsNull() {
            addCriterion("apiid is null");
            return (Criteria) this;
        }

        public Criteria andApiidIsNotNull() {
            addCriterion("apiid is not null");
            return (Criteria) this;
        }

        public Criteria andApiidEqualTo(String value) {
            addCriterion("apiid =", value, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidNotEqualTo(String value) {
            addCriterion("apiid <>", value, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidGreaterThan(String value) {
            addCriterion("apiid >", value, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidGreaterThanOrEqualTo(String value) {
            addCriterion("apiid >=", value, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidLessThan(String value) {
            addCriterion("apiid <", value, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidLessThanOrEqualTo(String value) {
            addCriterion("apiid <=", value, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidLike(String value) {
            addCriterion("apiid like", value, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidNotLike(String value) {
            addCriterion("apiid not like", value, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidIn(List<String> values) {
            addCriterion("apiid in", values, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidNotIn(List<String> values) {
            addCriterion("apiid not in", values, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidBetween(String value1, String value2) {
            addCriterion("apiid between", value1, value2, "apiid");
            return (Criteria) this;
        }

        public Criteria andApiidNotBetween(String value1, String value2) {
            addCriterion("apiid not between", value1, value2, "apiid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table testcase
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 13 14:23:36 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
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