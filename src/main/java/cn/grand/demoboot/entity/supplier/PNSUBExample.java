package cn.grand.demoboot.entity.supplier;

import java.util.ArrayList;
import java.util.List;

public class PNSUBExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PNSUBExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPmm01IsNull() {
            addCriterion("PMM01 is null");
            return (Criteria) this;
        }

        public Criteria andPmm01IsNotNull() {
            addCriterion("PMM01 is not null");
            return (Criteria) this;
        }

        public Criteria andPmm01EqualTo(String value) {
            addCriterion("PMM01 =", value, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01NotEqualTo(String value) {
            addCriterion("PMM01 <>", value, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01GreaterThan(String value) {
            addCriterion("PMM01 >", value, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01GreaterThanOrEqualTo(String value) {
            addCriterion("PMM01 >=", value, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01LessThan(String value) {
            addCriterion("PMM01 <", value, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01LessThanOrEqualTo(String value) {
            addCriterion("PMM01 <=", value, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01Like(String value) {
            addCriterion("PMM01 like", value, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01NotLike(String value) {
            addCriterion("PMM01 not like", value, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01In(List<String> values) {
            addCriterion("PMM01 in", values, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01NotIn(List<String> values) {
            addCriterion("PMM01 not in", values, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01Between(String value1, String value2) {
            addCriterion("PMM01 between", value1, value2, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmm01NotBetween(String value1, String value2) {
            addCriterion("PMM01 not between", value1, value2, "pmm01");
            return (Criteria) this;
        }

        public Criteria andPmn02IsNull() {
            addCriterion("PMN02 is null");
            return (Criteria) this;
        }

        public Criteria andPmn02IsNotNull() {
            addCriterion("PMN02 is not null");
            return (Criteria) this;
        }

        public Criteria andPmn02EqualTo(Long value) {
            addCriterion("PMN02 =", value, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02NotEqualTo(Long value) {
            addCriterion("PMN02 <>", value, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02GreaterThan(Long value) {
            addCriterion("PMN02 >", value, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02GreaterThanOrEqualTo(Long value) {
            addCriterion("PMN02 >=", value, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02LessThan(Long value) {
            addCriterion("PMN02 <", value, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02LessThanOrEqualTo(Long value) {
            addCriterion("PMN02 <=", value, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02In(List<Long> values) {
            addCriterion("PMN02 in", values, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02NotIn(List<Long> values) {
            addCriterion("PMN02 not in", values, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02Between(Long value1, Long value2) {
            addCriterion("PMN02 between", value1, value2, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn02NotBetween(Long value1, Long value2) {
            addCriterion("PMN02 not between", value1, value2, "pmn02");
            return (Criteria) this;
        }

        public Criteria andPmn04IsNull() {
            addCriterion("PMN04 is null");
            return (Criteria) this;
        }

        public Criteria andPmn04IsNotNull() {
            addCriterion("PMN04 is not null");
            return (Criteria) this;
        }

        public Criteria andPmn04EqualTo(String value) {
            addCriterion("PMN04 =", value, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04NotEqualTo(String value) {
            addCriterion("PMN04 <>", value, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04GreaterThan(String value) {
            addCriterion("PMN04 >", value, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04GreaterThanOrEqualTo(String value) {
            addCriterion("PMN04 >=", value, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04LessThan(String value) {
            addCriterion("PMN04 <", value, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04LessThanOrEqualTo(String value) {
            addCriterion("PMN04 <=", value, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04Like(String value) {
            addCriterion("PMN04 like", value, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04NotLike(String value) {
            addCriterion("PMN04 not like", value, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04In(List<String> values) {
            addCriterion("PMN04 in", values, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04NotIn(List<String> values) {
            addCriterion("PMN04 not in", values, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04Between(String value1, String value2) {
            addCriterion("PMN04 between", value1, value2, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn04NotBetween(String value1, String value2) {
            addCriterion("PMN04 not between", value1, value2, "pmn04");
            return (Criteria) this;
        }

        public Criteria andPmn041IsNull() {
            addCriterion("PMN041 is null");
            return (Criteria) this;
        }

        public Criteria andPmn041IsNotNull() {
            addCriterion("PMN041 is not null");
            return (Criteria) this;
        }

        public Criteria andPmn041EqualTo(String value) {
            addCriterion("PMN041 =", value, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041NotEqualTo(String value) {
            addCriterion("PMN041 <>", value, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041GreaterThan(String value) {
            addCriterion("PMN041 >", value, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041GreaterThanOrEqualTo(String value) {
            addCriterion("PMN041 >=", value, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041LessThan(String value) {
            addCriterion("PMN041 <", value, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041LessThanOrEqualTo(String value) {
            addCriterion("PMN041 <=", value, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041Like(String value) {
            addCriterion("PMN041 like", value, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041NotLike(String value) {
            addCriterion("PMN041 not like", value, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041In(List<String> values) {
            addCriterion("PMN041 in", values, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041NotIn(List<String> values) {
            addCriterion("PMN041 not in", values, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041Between(String value1, String value2) {
            addCriterion("PMN041 between", value1, value2, "pmn041");
            return (Criteria) this;
        }

        public Criteria andPmn041NotBetween(String value1, String value2) {
            addCriterion("PMN041 not between", value1, value2, "pmn041");
            return (Criteria) this;
        }

        public Criteria andIma021IsNull() {
            addCriterion("IMA021 is null");
            return (Criteria) this;
        }

        public Criteria andIma021IsNotNull() {
            addCriterion("IMA021 is not null");
            return (Criteria) this;
        }

        public Criteria andIma021EqualTo(String value) {
            addCriterion("IMA021 =", value, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021NotEqualTo(String value) {
            addCriterion("IMA021 <>", value, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021GreaterThan(String value) {
            addCriterion("IMA021 >", value, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021GreaterThanOrEqualTo(String value) {
            addCriterion("IMA021 >=", value, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021LessThan(String value) {
            addCriterion("IMA021 <", value, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021LessThanOrEqualTo(String value) {
            addCriterion("IMA021 <=", value, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021Like(String value) {
            addCriterion("IMA021 like", value, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021NotLike(String value) {
            addCriterion("IMA021 not like", value, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021In(List<String> values) {
            addCriterion("IMA021 in", values, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021NotIn(List<String> values) {
            addCriterion("IMA021 not in", values, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021Between(String value1, String value2) {
            addCriterion("IMA021 between", value1, value2, "ima021");
            return (Criteria) this;
        }

        public Criteria andIma021NotBetween(String value1, String value2) {
            addCriterion("IMA021 not between", value1, value2, "ima021");
            return (Criteria) this;
        }

        public Criteria andPmn07IsNull() {
            addCriterion("PMN07 is null");
            return (Criteria) this;
        }

        public Criteria andPmn07IsNotNull() {
            addCriterion("PMN07 is not null");
            return (Criteria) this;
        }

        public Criteria andPmn07EqualTo(String value) {
            addCriterion("PMN07 =", value, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07NotEqualTo(String value) {
            addCriterion("PMN07 <>", value, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07GreaterThan(String value) {
            addCriterion("PMN07 >", value, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07GreaterThanOrEqualTo(String value) {
            addCriterion("PMN07 >=", value, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07LessThan(String value) {
            addCriterion("PMN07 <", value, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07LessThanOrEqualTo(String value) {
            addCriterion("PMN07 <=", value, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07Like(String value) {
            addCriterion("PMN07 like", value, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07NotLike(String value) {
            addCriterion("PMN07 not like", value, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07In(List<String> values) {
            addCriterion("PMN07 in", values, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07NotIn(List<String> values) {
            addCriterion("PMN07 not in", values, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07Between(String value1, String value2) {
            addCriterion("PMN07 between", value1, value2, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn07NotBetween(String value1, String value2) {
            addCriterion("PMN07 not between", value1, value2, "pmn07");
            return (Criteria) this;
        }

        public Criteria andPmn20IsNull() {
            addCriterion("PMN20 is null");
            return (Criteria) this;
        }

        public Criteria andPmn20IsNotNull() {
            addCriterion("PMN20 is not null");
            return (Criteria) this;
        }

        public Criteria andPmn20EqualTo(Double value) {
            addCriterion("PMN20 =", value, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20NotEqualTo(Double value) {
            addCriterion("PMN20 <>", value, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20GreaterThan(Double value) {
            addCriterion("PMN20 >", value, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20GreaterThanOrEqualTo(Double value) {
            addCriterion("PMN20 >=", value, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20LessThan(Double value) {
            addCriterion("PMN20 <", value, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20LessThanOrEqualTo(Double value) {
            addCriterion("PMN20 <=", value, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20In(List<Double> values) {
            addCriterion("PMN20 in", values, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20NotIn(List<Double> values) {
            addCriterion("PMN20 not in", values, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20Between(Double value1, Double value2) {
            addCriterion("PMN20 between", value1, value2, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn20NotBetween(Double value1, Double value2) {
            addCriterion("PMN20 not between", value1, value2, "pmn20");
            return (Criteria) this;
        }

        public Criteria andPmn86IsNull() {
            addCriterion("PMN86 is null");
            return (Criteria) this;
        }

        public Criteria andPmn86IsNotNull() {
            addCriterion("PMN86 is not null");
            return (Criteria) this;
        }

        public Criteria andPmn86EqualTo(String value) {
            addCriterion("PMN86 =", value, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86NotEqualTo(String value) {
            addCriterion("PMN86 <>", value, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86GreaterThan(String value) {
            addCriterion("PMN86 >", value, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86GreaterThanOrEqualTo(String value) {
            addCriterion("PMN86 >=", value, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86LessThan(String value) {
            addCriterion("PMN86 <", value, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86LessThanOrEqualTo(String value) {
            addCriterion("PMN86 <=", value, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86Like(String value) {
            addCriterion("PMN86 like", value, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86NotLike(String value) {
            addCriterion("PMN86 not like", value, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86In(List<String> values) {
            addCriterion("PMN86 in", values, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86NotIn(List<String> values) {
            addCriterion("PMN86 not in", values, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86Between(String value1, String value2) {
            addCriterion("PMN86 between", value1, value2, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn86NotBetween(String value1, String value2) {
            addCriterion("PMN86 not between", value1, value2, "pmn86");
            return (Criteria) this;
        }

        public Criteria andPmn87IsNull() {
            addCriterion("PMN87 is null");
            return (Criteria) this;
        }

        public Criteria andPmn87IsNotNull() {
            addCriterion("PMN87 is not null");
            return (Criteria) this;
        }

        public Criteria andPmn87EqualTo(Double value) {
            addCriterion("PMN87 =", value, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87NotEqualTo(Double value) {
            addCriterion("PMN87 <>", value, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87GreaterThan(Double value) {
            addCriterion("PMN87 >", value, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87GreaterThanOrEqualTo(Double value) {
            addCriterion("PMN87 >=", value, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87LessThan(Double value) {
            addCriterion("PMN87 <", value, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87LessThanOrEqualTo(Double value) {
            addCriterion("PMN87 <=", value, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87In(List<Double> values) {
            addCriterion("PMN87 in", values, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87NotIn(List<Double> values) {
            addCriterion("PMN87 not in", values, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87Between(Double value1, Double value2) {
            addCriterion("PMN87 between", value1, value2, "pmn87");
            return (Criteria) this;
        }

        public Criteria andPmn87NotBetween(Double value1, Double value2) {
            addCriterion("PMN87 not between", value1, value2, "pmn87");
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

        public Criteria andStatusEqualTo(Long value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Long value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Long value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Long value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Long value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Long> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Long> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Long value1, Long value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Long value1, Long value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSdnnumIsNull() {
            addCriterion("SDNNUM is null");
            return (Criteria) this;
        }

        public Criteria andSdnnumIsNotNull() {
            addCriterion("SDNNUM is not null");
            return (Criteria) this;
        }

        public Criteria andSdnnumEqualTo(String value) {
            addCriterion("SDNNUM =", value, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumNotEqualTo(String value) {
            addCriterion("SDNNUM <>", value, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumGreaterThan(String value) {
            addCriterion("SDNNUM >", value, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumGreaterThanOrEqualTo(String value) {
            addCriterion("SDNNUM >=", value, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumLessThan(String value) {
            addCriterion("SDNNUM <", value, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumLessThanOrEqualTo(String value) {
            addCriterion("SDNNUM <=", value, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumLike(String value) {
            addCriterion("SDNNUM like", value, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumNotLike(String value) {
            addCriterion("SDNNUM not like", value, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumIn(List<String> values) {
            addCriterion("SDNNUM in", values, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumNotIn(List<String> values) {
            addCriterion("SDNNUM not in", values, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumBetween(String value1, String value2) {
            addCriterion("SDNNUM between", value1, value2, "sdnnum");
            return (Criteria) this;
        }

        public Criteria andSdnnumNotBetween(String value1, String value2) {
            addCriterion("SDNNUM not between", value1, value2, "sdnnum");
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