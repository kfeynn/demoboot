package cn.grand.demoboot.config;

import cn.grand.demoboot.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //登录拦截的管理器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());     //拦截的对象会进入这个类中进行判断
        registration.addPathPatterns("/malladmin/**");                    //后台所有路径都被拦截

        registration.excludePathPatterns("/static/**", "/css/**", "/images/**", "/js/**");       //静态文件不拦截

        //权限拦截的管理器
        //InterceptorRegistration registration1 = registry.addInterceptor(rightsInterceptor);
        //registration1.addPathPatterns("/**");                    //所有路径都被拦截
        //registration1.excludePathPatterns("/","/login","/error","/static/**","/logout");       //添加不拦截路径
    }
}

