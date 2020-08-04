package cn.grand.demoboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig
{
    //destroy-method="close"：当数据库连接不使用的时候,将该连接重新放到数据池中
    @Primary //配置一个主连接
    //@Bean(name = DataSources.DB1, destroyMethod = "close")
    @Bean(name = DataSources.Sqlserver)
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver")
    public DataSource dataSourceDB1()
    {
        // 创建数据源
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = DataSources.Supplier, destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.supplier")
    public DataSource dataSourceDB2()
    {
        // 创建数据源
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    // 支持JdbcTemplate （可选）
    @Bean(DataSources.Sqlserver_JDBCTEMPLATE)
    public JdbcTemplate db1JdbcTemplate(@Qualifier(DataSources.Sqlserver) DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    @Bean(DataSources.Supplier_JDBCTEMPLATE)
    public JdbcTemplate db2JdbcTemplate(@Qualifier(DataSources.Supplier) DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    // 支持事务（可选）
    @Bean(DataSources.Sqlserver_TRANSACTION)
    public DataSourceTransactionManager db1TransactionManager(@Qualifier(DataSources.Sqlserver) DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(DataSources.Supplier_TRANSACTION)
    public DataSourceTransactionManager db2TransactionManager(@Qualifier(DataSources.Supplier) DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
}