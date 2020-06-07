package com.pytap.blog.model.domain;

import java.util.ArrayList;
import java.util.List;

public class ViewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewsExample() {
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

        public Criteria andAllViewsIsNull() {
            addCriterion("all_views is null");
            return (Criteria) this;
        }

        public Criteria andAllViewsIsNotNull() {
            addCriterion("all_views is not null");
            return (Criteria) this;
        }

        public Criteria andAllViewsEqualTo(Long value) {
            addCriterion("all_views =", value, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsNotEqualTo(Long value) {
            addCriterion("all_views <>", value, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsGreaterThan(Long value) {
            addCriterion("all_views >", value, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsGreaterThanOrEqualTo(Long value) {
            addCriterion("all_views >=", value, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsLessThan(Long value) {
            addCriterion("all_views <", value, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsLessThanOrEqualTo(Long value) {
            addCriterion("all_views <=", value, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsIn(List<Long> values) {
            addCriterion("all_views in", values, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsNotIn(List<Long> values) {
            addCriterion("all_views not in", values, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsBetween(Long value1, Long value2) {
            addCriterion("all_views between", value1, value2, "allViews");
            return (Criteria) this;
        }

        public Criteria andAllViewsNotBetween(Long value1, Long value2) {
            addCriterion("all_views not between", value1, value2, "allViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsIsNull() {
            addCriterion("day_views is null");
            return (Criteria) this;
        }

        public Criteria andDayViewsIsNotNull() {
            addCriterion("day_views is not null");
            return (Criteria) this;
        }

        public Criteria andDayViewsEqualTo(Long value) {
            addCriterion("day_views =", value, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsNotEqualTo(Long value) {
            addCriterion("day_views <>", value, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsGreaterThan(Long value) {
            addCriterion("day_views >", value, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsGreaterThanOrEqualTo(Long value) {
            addCriterion("day_views >=", value, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsLessThan(Long value) {
            addCriterion("day_views <", value, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsLessThanOrEqualTo(Long value) {
            addCriterion("day_views <=", value, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsIn(List<Long> values) {
            addCriterion("day_views in", values, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsNotIn(List<Long> values) {
            addCriterion("day_views not in", values, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsBetween(Long value1, Long value2) {
            addCriterion("day_views between", value1, value2, "dayViews");
            return (Criteria) this;
        }

        public Criteria andDayViewsNotBetween(Long value1, Long value2) {
            addCriterion("day_views not between", value1, value2, "dayViews");
            return (Criteria) this;
        }

        public Criteria andVisNumIsNull() {
            addCriterion("vis_num is null");
            return (Criteria) this;
        }

        public Criteria andVisNumIsNotNull() {
            addCriterion("vis_num is not null");
            return (Criteria) this;
        }

        public Criteria andVisNumEqualTo(Long value) {
            addCriterion("vis_num =", value, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumNotEqualTo(Long value) {
            addCriterion("vis_num <>", value, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumGreaterThan(Long value) {
            addCriterion("vis_num >", value, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumGreaterThanOrEqualTo(Long value) {
            addCriterion("vis_num >=", value, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumLessThan(Long value) {
            addCriterion("vis_num <", value, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumLessThanOrEqualTo(Long value) {
            addCriterion("vis_num <=", value, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumIn(List<Long> values) {
            addCriterion("vis_num in", values, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumNotIn(List<Long> values) {
            addCriterion("vis_num not in", values, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumBetween(Long value1, Long value2) {
            addCriterion("vis_num between", value1, value2, "visNum");
            return (Criteria) this;
        }

        public Criteria andVisNumNotBetween(Long value1, Long value2) {
            addCriterion("vis_num not between", value1, value2, "visNum");
            return (Criteria) this;
        }

        public Criteria andIpNumIsNull() {
            addCriterion("ip_num is null");
            return (Criteria) this;
        }

        public Criteria andIpNumIsNotNull() {
            addCriterion("ip_num is not null");
            return (Criteria) this;
        }

        public Criteria andIpNumEqualTo(Long value) {
            addCriterion("ip_num =", value, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumNotEqualTo(Long value) {
            addCriterion("ip_num <>", value, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumGreaterThan(Long value) {
            addCriterion("ip_num >", value, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumGreaterThanOrEqualTo(Long value) {
            addCriterion("ip_num >=", value, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumLessThan(Long value) {
            addCriterion("ip_num <", value, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumLessThanOrEqualTo(Long value) {
            addCriterion("ip_num <=", value, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumIn(List<Long> values) {
            addCriterion("ip_num in", values, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumNotIn(List<Long> values) {
            addCriterion("ip_num not in", values, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumBetween(Long value1, Long value2) {
            addCriterion("ip_num between", value1, value2, "ipNum");
            return (Criteria) this;
        }

        public Criteria andIpNumNotBetween(Long value1, Long value2) {
            addCriterion("ip_num not between", value1, value2, "ipNum");
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