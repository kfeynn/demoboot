package cn.grand.demoboot.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
//  db1的接口类的包名 // 扫描指定包下的dao，这样就不用每个dao interface上面写@Mapper了
@MapperScan(basePackages = { "cn.grand.demoboot.mapper.sqlserver" }, sqlSessionFactoryRef = "db1SqlSessionFactoryBean")
public class MybatisDB1Config
{
    @Autowired
    // 必须指定注入哪个数据源，否则找到多个会注入失败
    @Qualifier(DataSources.Sqlserver)
    private DataSource sqlserver;

    @Bean(name = "db1SqlSessionFactoryBean")
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver") // 和 配置文件中的前缀保持一致
    //@Primary //如果SqlSessionFactoryBean的名字和MybatisDB2Config中的一致（默认方法名），需要加上这个注解，优先注入该SqlSessionFactoryBean
    // 这里我们通过bean指定了name,并且方法名也不一样，所以如果情况不一样，看是否需要加入@Primary 。 如果需要两个方法上加一个就行了，都加的话，spring又找不到bean注入啦。。
    public SqlSessionFactoryBean db1SqlSessionFactoryBean() throws Exception
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 配置数据源
        sqlSessionFactoryBean.setDataSource(sqlserver);
        // 如下的两行代码仅仅用于*.xml文件，如果整个持久层操作没用到xml文件的话，比如使用注解的方式，则无需加
        // 解决配置到配置文件中通过*配置找不到mapper文件的问题。 如果不设置这一行，在配置文件中，只能使用数组的方式一个个的罗列出来，并且要指定具体的文件名
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:cn/grand/demoboot/mapper/sqlserver/*.xml"));
        // 也可以通过在application.yml中配置
        //sqlSessionFactoryBean.setTypeAliasesPackage("com.artisan.domain.db1");
        return sqlSessionFactoryBean;
    }

    // 可选，如果需要通过SqlSessionTemplate来操作持久层就通过@Bean实例化,我们这个例子中没用到，随手写出来了
    @Bean(name = "db1SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate() throws Exception
    {
        SqlSessionTemplate template = new SqlSessionTemplate(db1SqlSessionFactoryBean().getObject());
        return template;
    }

}

