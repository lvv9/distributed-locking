package me.liuweiqiang.locking.dao.model;

import java.util.ArrayList;
import java.util.List;

public class TokenExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public TokenExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
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
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResourceKeyIsNull() {
            addCriterion("resource_key is null");
            return (Criteria) this;
        }

        public Criteria andResourceKeyIsNotNull() {
            addCriterion("resource_key is not null");
            return (Criteria) this;
        }

        public Criteria andResourceKeyEqualTo(String value) {
            addCriterion("resource_key =", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyNotEqualTo(String value) {
            addCriterion("resource_key <>", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyGreaterThan(String value) {
            addCriterion("resource_key >", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyGreaterThanOrEqualTo(String value) {
            addCriterion("resource_key >=", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyLessThan(String value) {
            addCriterion("resource_key <", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyLessThanOrEqualTo(String value) {
            addCriterion("resource_key <=", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyLike(String value) {
            addCriterion("resource_key like", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyNotLike(String value) {
            addCriterion("resource_key not like", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyIn(List<String> values) {
            addCriterion("resource_key in", values, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyNotIn(List<String> values) {
            addCriterion("resource_key not in", values, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyBetween(String value1, String value2) {
            addCriterion("resource_key between", value1, value2, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyNotBetween(String value1, String value2) {
            addCriterion("resource_key not between", value1, value2, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdIsNull() {
            addCriterion("token_aka_locking_id is null");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdIsNotNull() {
            addCriterion("token_aka_locking_id is not null");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdEqualTo(Long value) {
            addCriterion("token_aka_locking_id =", value, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdNotEqualTo(Long value) {
            addCriterion("token_aka_locking_id <>", value, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdGreaterThan(Long value) {
            addCriterion("token_aka_locking_id >", value, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("token_aka_locking_id >=", value, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdLessThan(Long value) {
            addCriterion("token_aka_locking_id <", value, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdLessThanOrEqualTo(Long value) {
            addCriterion("token_aka_locking_id <=", value, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdIn(List<Long> values) {
            addCriterion("token_aka_locking_id in", values, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdNotIn(List<Long> values) {
            addCriterion("token_aka_locking_id not in", values, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdBetween(Long value1, Long value2) {
            addCriterion("token_aka_locking_id between", value1, value2, "tokenAkaLockingId");
            return (Criteria) this;
        }

        public Criteria andTokenAkaLockingIdNotBetween(Long value1, Long value2) {
            addCriterion("token_aka_locking_id not between", value1, value2, "tokenAkaLockingId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table locking..token
     *
     * @mbg.generated do_not_delete_during_merge Sun Feb 20 23:54:28 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table locking..token
     *
     * @mbg.generated Sun Feb 20 23:54:28 CST 2022
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