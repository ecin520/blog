package com.pytap.blog.model.domain;

import java.util.ArrayList;
import java.util.List;

public class ReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplyExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentatorIsNull() {
            addCriterion("commentator is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIsNotNull() {
            addCriterion("commentator is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorEqualTo(Long value) {
            addCriterion("commentator =", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotEqualTo(Long value) {
            addCriterion("commentator <>", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorGreaterThan(Long value) {
            addCriterion("commentator >", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorGreaterThanOrEqualTo(Long value) {
            addCriterion("commentator >=", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLessThan(Long value) {
            addCriterion("commentator <", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLessThanOrEqualTo(Long value) {
            addCriterion("commentator <=", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorIn(List<Long> values) {
            addCriterion("commentator in", values, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotIn(List<Long> values) {
            addCriterion("commentator not in", values, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorBetween(Long value1, Long value2) {
            addCriterion("commentator between", value1, value2, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotBetween(Long value1, Long value2) {
            addCriterion("commentator not between", value1, value2, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIsNull() {
            addCriterion("commentator_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIsNotNull() {
            addCriterion("commentator_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameEqualTo(String value) {
            addCriterion("commentator_name =", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotEqualTo(String value) {
            addCriterion("commentator_name <>", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameGreaterThan(String value) {
            addCriterion("commentator_name >", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_name >=", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLessThan(String value) {
            addCriterion("commentator_name <", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLessThanOrEqualTo(String value) {
            addCriterion("commentator_name <=", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLike(String value) {
            addCriterion("commentator_name like", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotLike(String value) {
            addCriterion("commentator_name not like", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIn(List<String> values) {
            addCriterion("commentator_name in", values, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotIn(List<String> values) {
            addCriterion("commentator_name not in", values, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameBetween(String value1, String value2) {
            addCriterion("commentator_name between", value1, value2, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotBetween(String value1, String value2) {
            addCriterion("commentator_name not between", value1, value2, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarIsNull() {
            addCriterion("commentator_avatar is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarIsNotNull() {
            addCriterion("commentator_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarEqualTo(String value) {
            addCriterion("commentator_avatar =", value, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarNotEqualTo(String value) {
            addCriterion("commentator_avatar <>", value, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarGreaterThan(String value) {
            addCriterion("commentator_avatar >", value, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_avatar >=", value, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarLessThan(String value) {
            addCriterion("commentator_avatar <", value, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarLessThanOrEqualTo(String value) {
            addCriterion("commentator_avatar <=", value, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarLike(String value) {
            addCriterion("commentator_avatar like", value, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarNotLike(String value) {
            addCriterion("commentator_avatar not like", value, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarIn(List<String> values) {
            addCriterion("commentator_avatar in", values, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarNotIn(List<String> values) {
            addCriterion("commentator_avatar not in", values, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarBetween(String value1, String value2) {
            addCriterion("commentator_avatar between", value1, value2, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCommentatorAvatarNotBetween(String value1, String value2) {
            addCriterion("commentator_avatar not between", value1, value2, "commentatorAvatar");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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