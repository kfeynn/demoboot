package cn.grand.demoboot.entity.sqlserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XpGridUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XpGridUserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("UserID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("UserID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("UserID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("UserID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("UserID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("UserID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("UserID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("UserID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("UserID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("UserID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("UserName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("UserName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("UserName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("UserName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("UserName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("UserName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("UserName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("UserName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("UserName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("UserName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("UserName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("UserName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("UserName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("UserName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsercnameIsNull() {
            addCriterion("UserCName is null");
            return (Criteria) this;
        }

        public Criteria andUsercnameIsNotNull() {
            addCriterion("UserCName is not null");
            return (Criteria) this;
        }

        public Criteria andUsercnameEqualTo(String value) {
            addCriterion("UserCName =", value, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameNotEqualTo(String value) {
            addCriterion("UserCName <>", value, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameGreaterThan(String value) {
            addCriterion("UserCName >", value, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameGreaterThanOrEqualTo(String value) {
            addCriterion("UserCName >=", value, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameLessThan(String value) {
            addCriterion("UserCName <", value, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameLessThanOrEqualTo(String value) {
            addCriterion("UserCName <=", value, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameLike(String value) {
            addCriterion("UserCName like", value, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameNotLike(String value) {
            addCriterion("UserCName not like", value, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameIn(List<String> values) {
            addCriterion("UserCName in", values, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameNotIn(List<String> values) {
            addCriterion("UserCName not in", values, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameBetween(String value1, String value2) {
            addCriterion("UserCName between", value1, value2, "usercname");
            return (Criteria) this;
        }

        public Criteria andUsercnameNotBetween(String value1, String value2) {
            addCriterion("UserCName not between", value1, value2, "usercname");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("Password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("Password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("Password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("Password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("Password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("Password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("Password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("Password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("Password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("Password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("Password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("Password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("Password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("Password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNull() {
            addCriterion("Online is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("Online is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(Integer value) {
            addCriterion("Online =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(Integer value) {
            addCriterion("Online <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(Integer value) {
            addCriterion("Online >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("Online >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(Integer value) {
            addCriterion("Online <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(Integer value) {
            addCriterion("Online <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<Integer> values) {
            addCriterion("Online in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<Integer> values) {
            addCriterion("Online not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(Integer value1, Integer value2) {
            addCriterion("Online between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(Integer value1, Integer value2) {
            addCriterion("Online not between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeIsNull() {
            addCriterion("LastOnlineTime is null");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeIsNotNull() {
            addCriterion("LastOnlineTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeEqualTo(Integer value) {
            addCriterion("LastOnlineTime =", value, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeNotEqualTo(Integer value) {
            addCriterion("LastOnlineTime <>", value, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeGreaterThan(Integer value) {
            addCriterion("LastOnlineTime >", value, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LastOnlineTime >=", value, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeLessThan(Integer value) {
            addCriterion("LastOnlineTime <", value, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeLessThanOrEqualTo(Integer value) {
            addCriterion("LastOnlineTime <=", value, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeIn(List<Integer> values) {
            addCriterion("LastOnlineTime in", values, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeNotIn(List<Integer> values) {
            addCriterion("LastOnlineTime not in", values, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeBetween(Integer value1, Integer value2) {
            addCriterion("LastOnlineTime between", value1, value2, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andLastonlinetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("LastOnlineTime not between", value1, value2, "lastonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeIsNull() {
            addCriterion("AllOnlineTime is null");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeIsNotNull() {
            addCriterion("AllOnlineTime is not null");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeEqualTo(Integer value) {
            addCriterion("AllOnlineTime =", value, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeNotEqualTo(Integer value) {
            addCriterion("AllOnlineTime <>", value, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeGreaterThan(Integer value) {
            addCriterion("AllOnlineTime >", value, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AllOnlineTime >=", value, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeLessThan(Integer value) {
            addCriterion("AllOnlineTime <", value, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeLessThanOrEqualTo(Integer value) {
            addCriterion("AllOnlineTime <=", value, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeIn(List<Integer> values) {
            addCriterion("AllOnlineTime in", values, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeNotIn(List<Integer> values) {
            addCriterion("AllOnlineTime not in", values, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeBetween(Integer value1, Integer value2) {
            addCriterion("AllOnlineTime between", value1, value2, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andAllonlinetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("AllOnlineTime not between", value1, value2, "allonlinetime");
            return (Criteria) this;
        }

        public Criteria andLogintimesIsNull() {
            addCriterion("LoginTimes is null");
            return (Criteria) this;
        }

        public Criteria andLogintimesIsNotNull() {
            addCriterion("LoginTimes is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimesEqualTo(Integer value) {
            addCriterion("LoginTimes =", value, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesNotEqualTo(Integer value) {
            addCriterion("LoginTimes <>", value, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesGreaterThan(Integer value) {
            addCriterion("LoginTimes >", value, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("LoginTimes >=", value, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesLessThan(Integer value) {
            addCriterion("LoginTimes <", value, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesLessThanOrEqualTo(Integer value) {
            addCriterion("LoginTimes <=", value, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesIn(List<Integer> values) {
            addCriterion("LoginTimes in", values, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesNotIn(List<Integer> values) {
            addCriterion("LoginTimes not in", values, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesBetween(Integer value1, Integer value2) {
            addCriterion("LoginTimes between", value1, value2, "logintimes");
            return (Criteria) this;
        }

        public Criteria andLogintimesNotBetween(Integer value1, Integer value2) {
            addCriterion("LoginTimes not between", value1, value2, "logintimes");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeIsNull() {
            addCriterion("CurrentLoginDateTime is null");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeIsNotNull() {
            addCriterion("CurrentLoginDateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeEqualTo(Date value) {
            addCriterion("CurrentLoginDateTime =", value, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeNotEqualTo(Date value) {
            addCriterion("CurrentLoginDateTime <>", value, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeGreaterThan(Date value) {
            addCriterion("CurrentLoginDateTime >", value, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CurrentLoginDateTime >=", value, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeLessThan(Date value) {
            addCriterion("CurrentLoginDateTime <", value, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CurrentLoginDateTime <=", value, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeIn(List<Date> values) {
            addCriterion("CurrentLoginDateTime in", values, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeNotIn(List<Date> values) {
            addCriterion("CurrentLoginDateTime not in", values, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeBetween(Date value1, Date value2) {
            addCriterion("CurrentLoginDateTime between", value1, value2, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentlogindatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CurrentLoginDateTime not between", value1, value2, "currentlogindatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeIsNull() {
            addCriterion("LastOprtnDateTime is null");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeIsNotNull() {
            addCriterion("LastOprtnDateTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeEqualTo(Date value) {
            addCriterion("LastOprtnDateTime =", value, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeNotEqualTo(Date value) {
            addCriterion("LastOprtnDateTime <>", value, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeGreaterThan(Date value) {
            addCriterion("LastOprtnDateTime >", value, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastOprtnDateTime >=", value, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeLessThan(Date value) {
            addCriterion("LastOprtnDateTime <", value, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeLessThanOrEqualTo(Date value) {
            addCriterion("LastOprtnDateTime <=", value, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeIn(List<Date> values) {
            addCriterion("LastOprtnDateTime in", values, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeNotIn(List<Date> values) {
            addCriterion("LastOprtnDateTime not in", values, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeBetween(Date value1, Date value2) {
            addCriterion("LastOprtnDateTime between", value1, value2, "lastoprtndatetime");
            return (Criteria) this;
        }

        public Criteria andLastoprtndatetimeNotBetween(Date value1, Date value2) {
            addCriterion("LastOprtnDateTime not between", value1, value2, "lastoprtndatetime");
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