package cn.grand.demoboot;

import cn.grand.demoboot.webservice.Impl.RoleServiceImpl;
import cn.grand.demoboot.webservice.Impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

import javax.xml.ws.Endpoint;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})  //禁止spring boot自带的DataSourceAutoConfiguration
//@SpringBootApplication
//@MapperScan("cn.grand.demoboot.mapper")
@ImportResource("classpath*:spring.xml")
public class DemobootApplication
{
	public static void main(String[] args) {
		SpringApplication.run(DemobootApplication.class, args);
		//webservice 发布，也可以用config类配置
		//Endpoint.publish("http://localhost:9999/service/user/", new UserServiceImpl());
		//Endpoint.publish("http://localhost:9999/service/role/", new RoleServiceImpl());
	}
}

////打war包时用这个
//public class DemobootApplication extends SpringBootServletInitializer
//{
//	public static void main(String[] args) {
//		SpringApplication.run(DemobootApplication.class, args);
//		//webservice 发布(一个或多个)，也可以用config类配置（一个）
//		//Endpoint.publish("http://localhost:9999/service/user/", new UserServiceImpl());
//		//Endpoint.publish("http://localhost:9999/service/role/", new RoleServiceImpl());
//	}
//	//重写configure方法，打war包时用
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(DemobootApplication.class);
//	}
//}
