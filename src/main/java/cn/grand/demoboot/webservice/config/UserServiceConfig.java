package cn.grand.demoboot.webservice.config;

import cn.grand.demoboot.webservice.Impl.UserServiceImpl;
import cn.grand.demoboot.webservice.UserService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

//@Configuration
public class UserServiceConfig
{
    //运行程序，输入 http://localhost:8080/service/user?wsdl 即可查询发布出去的接口文件；
    //如果需要发布多个webservice，需要配置多个Config实现类文件；端口8080
    //直接在启动类中使用Endpoint ,需要依赖pom多一个 ，端口需要不同
    //Endpoint.publish("http://localhost:9999/webService/userService/", new UserServiceImpl());

    //dispatcherServlet 会报错
    @Bean
    public ServletRegistrationBean userServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/webservice/*");//发布服务名称
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus()
    {
        return  new SpringBus();
    }

    @Bean
    public UserService userService()
    {
        return  new UserServiceImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint=new EndpointImpl(springBus(), userService());//绑定要发布的服务

        endpoint.publish("/user"); //显示要发布的名称
        return endpoint;
    }
}
