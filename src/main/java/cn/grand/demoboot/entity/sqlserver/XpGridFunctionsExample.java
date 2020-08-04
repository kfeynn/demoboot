package cn.grand.demoboot.entity.sqlserver;

import java.util.ArrayList;
import java.util.List;

public class XpGridFunctionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XpGridFunctionsExample() {
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

        public Criteria andFunccodeIsNull() {
            addCriterion("FuncCode is null");
            return (Criteria) this;
        }

        public Criteria andFunccodeIsNotNull() {
            addCriterion("FuncCode is not null");
            return (Criteria) this;
        }

        public Criteria andFunccodeEqualTo(String value) {
            addCriterion("FuncCode =", value, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeNotEqualTo(String value) {
            addCriterion("FuncCode <>", value, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeGreaterThan(String value) {
            addCriterion("FuncCode >", value, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeGreaterThanOrEqualTo(String value) {
            addCriterion("FuncCode >=", value, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeLessThan(String value) {
            addCriterion("FuncCode <", value, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeLessThanOrEqualTo(String value) {
            addCriterion("FuncCode <=", value, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeLike(String value) {
            addCriterion("FuncCode like", value, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeNotLike(String value) {
            addCriterion("FuncCode not like", value, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeIn(List<String> values) {
            addCriterion("FuncCode in", values, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeNotIn(List<String> values) {
            addCriterion("FuncCode not in", values, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeBetween(String value1, String value2) {
            addCriterion("FuncCode between", value1, value2, "funccode");
            return (Criteria) this;
        }

        public Criteria andFunccodeNotBetween(String value1, String value2) {
            addCriterion("FuncCode not between", value1, value2, "funccode");
            return (Criteria) this;
        }

        public Criteria andFuncnameIsNull() {
            addCriterion("FuncName is null");
            return (Criteria) this;
        }

        public Criteria andFuncnameIsNotNull() {
            addCriterion("FuncName is not null");
            return (Criteria) this;
        }

        public Criteria andFuncnameEqualTo(String value) {
            addCriterion("FuncName =", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameNotEqualTo(String value) {
            addCriterion("FuncName <>", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameGreaterThan(String value) {
            addCriterion("FuncName >", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameGreaterThanOrEqualTo(String value) {
            addCriterion("FuncName >=", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameLessThan(String value) {
            addCriterion("FuncName <", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameLessThanOrEqualTo(String value) {
            addCriterion("FuncName <=", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameLike(String value) {
            addCriterion("FuncName like", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameNotLike(String value) {
            addCriterion("FuncName not like", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameIn(List<String> values) {
            addCriterion("FuncName in", values, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameNotIn(List<String> values) {
            addCriterion("FuncName not in", values, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameBetween(String value1, String value2) {
            addCriterion("FuncName between", value1, value2, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameNotBetween(String value1, String value2) {
            addCriterion("FuncName not between", value1, value2, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncurlIsNull() {
            addCriterion("FuncUrl is null");
            return (Criteria) this;
        }

        public Criteria andFuncurlIsNotNull() {
            addCriterion("FuncUrl is not null");
            return (Criteria) this;
        }

        public Criteria andFuncurlEqualTo(String value) {
            addCriterion("FuncUrl =", value, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlNotEqualTo(String value) {
            addCriterion("FuncUrl <>", value, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlGreaterThan(String value) {
            addCriterion("FuncUrl >", value, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlGreaterThanOrEqualTo(String value) {
            addCriterion("FuncUrl >=", value, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlLessThan(String value) {
            addCriterion("FuncUrl <", value, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlLessThanOrEqualTo(String value) {
            addCriterion("FuncUrl <=", value, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlLike(String value) {
            addCriterion("FuncUrl like", value, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlNotLike(String value) {
            addCriterion("FuncUrl not like", value, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlIn(List<String> values) {
            addCriterion("FuncUrl in", values, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlNotIn(List<String> values) {
            addCriterion("FuncUrl not in", values, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlBetween(String value1, String value2) {
            addCriterion("FuncUrl between", value1, value2, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncurlNotBetween(String value1, String value2) {
            addCriterion("FuncUrl not between", value1, value2, "funcurl");
            return (Criteria) this;
        }

        public Criteria andFuncparentIsNull() {
            addCriterion("FuncParent is null");
            return (Criteria) this;
        }

        public Criteria andFuncparentIsNotNull() {
            addCriterion("FuncParent is not null");
            return (Criteria) this;
        }

        public Criteria andFuncparentEqualTo(String value) {
            addCriterion("FuncParent =", value, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentNotEqualTo(String value) {
            addCriterion("FuncParent <>", value, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentGreaterThan(String value) {
            addCriterion("FuncParent >", value, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentGreaterThanOrEqualTo(String value) {
            addCriterion("FuncParent >=", value, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentLessThan(String value) {
            addCriterion("FuncParent <", value, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentLessThanOrEqualTo(String value) {
            addCriterion("FuncParent <=", value, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentLike(String value) {
            addCriterion("FuncParent like", value, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentNotLike(String value) {
            addCriterion("FuncParent not like", value, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentIn(List<String> values) {
            addCriterion("FuncParent in", values, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentNotIn(List<String> values) {
            addCriterion("FuncParent not in", values, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentBetween(String value1, String value2) {
            addCriterion("FuncParent between", value1, value2, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncparentNotBetween(String value1, String value2) {
            addCriterion("FuncParent not between", value1, value2, "funcparent");
            return (Criteria) this;
        }

        public Criteria andFuncimgIsNull() {
            addCriterion("FuncImg is null");
            return (Criteria) this;
        }

        public Criteria andFuncimgIsNotNull() {
            addCriterion("FuncImg is not null");
            return (Criteria) this;
        }

        public Criteria andFuncimgEqualTo(String value) {
            addCriterion("FuncImg =", value, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgNotEqualTo(String value) {
            addCriterion("FuncImg <>", value, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgGreaterThan(String value) {
            addCriterion("FuncImg >", value, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgGreaterThanOrEqualTo(String value) {
            addCriterion("FuncImg >=", value, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgLessThan(String value) {
            addCriterion("FuncImg <", value, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgLessThanOrEqualTo(String value) {
            addCriterion("FuncImg <=", value, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgLike(String value) {
            addCriterion("FuncImg like", value, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgNotLike(String value) {
            addCriterion("FuncImg not like", value, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgIn(List<String> values) {
            addCriterion("FuncImg in", values, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgNotIn(List<String> values) {
            addCriterion("FuncImg not in", values, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgBetween(String value1, String value2) {
            addCriterion("FuncImg between", value1, value2, "funcimg");
            return (Criteria) this;
        }

        public Criteria andFuncimgNotBetween(String value1, String value2) {
            addCriterion("FuncImg not between", value1, value2, "funcimg");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("Enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("Enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("Enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("Enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("Enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("Enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("Enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("Enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("Enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("Enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("Enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("Enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIsNull() {
            addCriterion("DisplayOrder is null");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIsNotNull() {
            addCriterion("DisplayOrder is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayorderEqualTo(Integer value) {
            addCriterion("DisplayOrder =", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotEqualTo(Integer value) {
            addCriterion("DisplayOrder <>", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderGreaterThan(Integer value) {
            addCriterion("DisplayOrder >", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("DisplayOrder >=", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderLessThan(Integer value) {
            addCriterion("DisplayOrder <", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderLessThanOrEqualTo(Integer value) {
            addCriterion("DisplayOrder <=", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIn(List<Integer> values) {
            addCriterion("DisplayOrder in", values, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotIn(List<Integer> values) {
            addCriterion("DisplayOrder not in", values, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderBetween(Integer value1, Integer value2) {
            addCriterion("DisplayOrder between", value1, value2, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotBetween(Integer value1, Integer value2) {
            addCriterion("DisplayOrder not between", value1, value2, "displayorder");
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