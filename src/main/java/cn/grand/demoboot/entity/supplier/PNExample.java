package cn.grand.demoboot.entity.supplier;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PNExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PNExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDnnumIsNull() {
            addCriterion("DNNUM is null");
            return (Criteria) this;
        }

        public Criteria andDnnumIsNotNull() {
            addCriterion("DNNUM is not null");
            return (Criteria) this;
        }

        public Criteria andDnnumEqualTo(String value) {
            addCriterion("DNNUM =", value, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumNotEqualTo(String value) {
            addCriterion("DNNUM <>", value, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumGreaterThan(String value) {
            addCriterion("DNNUM >", value, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumGreaterThanOrEqualTo(String value) {
            addCriterion("DNNUM >=", value, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumLessThan(String value) {
            addCriterion("DNNUM <", value, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumLessThanOrEqualTo(String value) {
            addCriterion("DNNUM <=", value, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumLike(String value) {
            addCriterion("DNNUM like", value, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumNotLike(String value) {
            addCriterion("DNNUM not like", value, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumIn(List<String> values) {
            addCriterion("DNNUM in", values, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumNotIn(List<String> values) {
            addCriterion("DNNUM not in", values, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumBetween(String value1, String value2) {
            addCriterion("DNNUM between", value1, value2, "dnnum");
            return (Criteria) this;
        }

        public Criteria andDnnumNotBetween(String value1, String value2) {
            addCriterion("DNNUM not between", value1, value2, "dnnum");
            return (Criteria) this;
        }

        public Criteria andPmn33IsNull() {
            addCriterion("PMN33 is null");
            return (Criteria) this;
        }

        public Criteria andPmn33IsNotNull() {
            addCriterion("PMN33 is not null");
            return (Criteria) this;
        }

        public Criteria andPmn33EqualTo(String value) {
            addCriterion("PMN33 =", value, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33NotEqualTo(String value) {
            addCriterion("PMN33 <>", value, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33GreaterThan(String value) {
            addCriterion("PMN33 >", value, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33GreaterThanOrEqualTo(String value) {
            addCriterion("PMN33 >=", value, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33LessThan(String value) {
            addCriterion("PMN33 <", value, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33LessThanOrEqualTo(String value) {
            addCriterion("PMN33 <=", value, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33Like(String value) {
            addCriterion("PMN33 like", value, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33NotLike(String value) {
            addCriterion("PMN33 not like", value, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33In(List<String> values) {
            addCriterion("PMN33 in", values, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33NotIn(List<String> values) {
            addCriterion("PMN33 not in", values, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33Between(String value1, String value2) {
            addCriterion("PMN33 between", value1, value2, "pmn33");
            return (Criteria) this;
        }

        public Criteria andPmn33NotBetween(String value1, String value2) {
            addCriterion("PMN33 not between", value1, value2, "pmn33");
            return (Criteria) this;
        }

        public Criteria andSupidIsNull() {
            addCriterion("SUPID is null");
            return (Criteria) this;
        }

        public Criteria andSupidIsNotNull() {
            addCriterion("SUPID is not null");
            return (Criteria) this;
        }

        public Criteria andSupidEqualTo(String value) {
            addCriterion("SUPID =", value, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidNotEqualTo(String value) {
            addCriterion("SUPID <>", value, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidGreaterThan(String value) {
            addCriterion("SUPID >", value, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidGreaterThanOrEqualTo(String value) {
            addCriterion("SUPID >=", value, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidLessThan(String value) {
            addCriterion("SUPID <", value, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidLessThanOrEqualTo(String value) {
            addCriterion("SUPID <=", value, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidLike(String value) {
            addCriterion("SUPID like", value, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidNotLike(String value) {
            addCriterion("SUPID not like", value, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidIn(List<String> values) {
            addCriterion("SUPID in", values, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidNotIn(List<String> values) {
            addCriterion("SUPID not in", values, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidBetween(String value1, String value2) {
            addCriterion("SUPID between", value1, value2, "supid");
            return (Criteria) this;
        }

        public Criteria andSupidNotBetween(String value1, String value2) {
            addCriterion("SUPID not between", value1, value2, "supid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andChangeUserIsNull() {
            addCriterion("CHANGE_USER is null");
            return (Criteria) this;
        }

        public Criteria andChangeUserIsNotNull() {
            addCriterion("CHANGE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andChangeUserEqualTo(String value) {
            addCriterion("CHANGE_USER =", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotEqualTo(String value) {
            addCriterion("CHANGE_USER <>", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserGreaterThan(String value) {
            addCriterion("CHANGE_USER >", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_USER >=", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLessThan(String value) {
            addCriterion("CHANGE_USER <", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_USER <=", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLike(String value) {
            addCriterion("CHANGE_USER like", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotLike(String value) {
            addCriterion("CHANGE_USER not like", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserIn(List<String> values) {
            addCriterion("CHANGE_USER in", values, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotIn(List<String> values) {
            addCriterion("CHANGE_USER not in", values, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserBetween(String value1, String value2) {
            addCriterion("CHANGE_USER between", value1, value2, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotBetween(String value1, String value2) {
            addCriterion("CHANGE_USER not between", value1, value2, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNull() {
            addCriterion("CHANGE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNotNull() {
            addCriterion("CHANGE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeEqualTo(String value) {
            addCriterion("CHANGE_TIME =", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotEqualTo(String value) {
            addCriterion("CHANGE_TIME <>", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThan(String value) {
            addCriterion("CHANGE_TIME >", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_TIME >=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThan(String value) {
            addCriterion("CHANGE_TIME <", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_TIME <=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLike(String value) {
            addCriterion("CHANGE_TIME like", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotLike(String value) {
            addCriterion("CHANGE_TIME not like", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIn(List<String> values) {
            addCriterion("CHANGE_TIME in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotIn(List<String> values) {
            addCriterion("CHANGE_TIME not in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeBetween(String value1, String value2) {
            addCriterion("CHANGE_TIME between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotBetween(String value1, String value2) {
            addCriterion("CHANGE_TIME not between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andPlantIsNull() {
            addCriterion("PLANT is null");
            return (Criteria) this;
        }

        public Criteria andPlantIsNotNull() {
            addCriterion("PLANT is not null");
            return (Criteria) this;
        }

        public Criteria andPlantEqualTo(String value) {
            addCriterion("PLANT =", value, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantNotEqualTo(String value) {
            addCriterion("PLANT <>", value, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantGreaterThan(String value) {
            addCriterion("PLANT >", value, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantGreaterThanOrEqualTo(String value) {
            addCriterion("PLANT >=", value, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantLessThan(String value) {
            addCriterion("PLANT <", value, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantLessThanOrEqualTo(String value) {
            addCriterion("PLANT <=", value, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantLike(String value) {
            addCriterion("PLANT like", value, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantNotLike(String value) {
            addCriterion("PLANT not like", value, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantIn(List<String> values) {
            addCriterion("PLANT in", values, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantNotIn(List<String> values) {
            addCriterion("PLANT not in", values, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantBetween(String value1, String value2) {
            addCriterion("PLANT between", value1, value2, "plant");
            return (Criteria) this;
        }

        public Criteria andPlantNotBetween(String value1, String value2) {
            addCriterion("PLANT not between", value1, value2, "plant");
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

        public Criteria andImporttypeIsNull() {
            addCriterion("IMPORTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andImporttypeIsNotNull() {
            addCriterion("IMPORTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andImporttypeEqualTo(String value) {
            addCriterion("IMPORTTYPE =", value, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeNotEqualTo(String value) {
            addCriterion("IMPORTTYPE <>", value, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeGreaterThan(String value) {
            addCriterion("IMPORTTYPE >", value, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeGreaterThanOrEqualTo(String value) {
            addCriterion("IMPORTTYPE >=", value, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeLessThan(String value) {
            addCriterion("IMPORTTYPE <", value, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeLessThanOrEqualTo(String value) {
            addCriterion("IMPORTTYPE <=", value, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeLike(String value) {
            addCriterion("IMPORTTYPE like", value, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeNotLike(String value) {
            addCriterion("IMPORTTYPE not like", value, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeIn(List<String> values) {
            addCriterion("IMPORTTYPE in", values, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeNotIn(List<String> values) {
            addCriterion("IMPORTTYPE not in", values, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeBetween(String value1, String value2) {
            addCriterion("IMPORTTYPE between", value1, value2, "importtype");
            return (Criteria) this;
        }

        public Criteria andImporttypeNotBetween(String value1, String value2) {
            addCriterion("IMPORTTYPE not between", value1, value2, "importtype");
            return (Criteria) this;
        }

        public Criteria andImportnumberIsNull() {
            addCriterion("IMPORTNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andImportnumberIsNotNull() {
            addCriterion("IMPORTNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andImportnumberEqualTo(String value) {
            addCriterion("IMPORTNUMBER =", value, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberNotEqualTo(String value) {
            addCriterion("IMPORTNUMBER <>", value, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberGreaterThan(String value) {
            addCriterion("IMPORTNUMBER >", value, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberGreaterThanOrEqualTo(String value) {
            addCriterion("IMPORTNUMBER >=", value, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberLessThan(String value) {
            addCriterion("IMPORTNUMBER <", value, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberLessThanOrEqualTo(String value) {
            addCriterion("IMPORTNUMBER <=", value, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberLike(String value) {
            addCriterion("IMPORTNUMBER like", value, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberNotLike(String value) {
            addCriterion("IMPORTNUMBER not like", value, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberIn(List<String> values) {
            addCriterion("IMPORTNUMBER in", values, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberNotIn(List<String> values) {
            addCriterion("IMPORTNUMBER not in", values, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberBetween(String value1, String value2) {
            addCriterion("IMPORTNUMBER between", value1, value2, "importnumber");
            return (Criteria) this;
        }

        public Criteria andImportnumberNotBetween(String value1, String value2) {
            addCriterion("IMPORTNUMBER not between", value1, value2, "importnumber");
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