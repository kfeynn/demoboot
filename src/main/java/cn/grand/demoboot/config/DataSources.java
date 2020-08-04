package cn.grand.demoboot.config;

public interface DataSources
{
    // 数据库
    String Sqlserver = "sqlserver";
    String Supplier = "supplier";
    // JdbcTemplate
    String Sqlserver_JDBCTEMPLATE = "sqlserverJdbcTemplate";
    String Supplier_JDBCTEMPLATE = "supplierJdbcTemplate";
    // 事务管理
    String Sqlserver_TRANSACTION = "sqlserverTrans";
    String Supplier_TRANSACTION = "supplierTrans";
}
