package cn.grand.demoboot.config;

import org.directwebremoting.spring.DwrSpringServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DwrConfig
{

    /**
     *  加入 DWR servlet，相当于在xml中配置
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        DwrSpringServlet servlet = new DwrSpringServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet, "/dwr/*");
        //设置成true使DWR能够debug和进入测试页面。
        registrationBean.addInitParameter("debug", "true");
        //pollAndCometEnabled 设置成true能增加服务器的加载能力，尽管DWR有保护服务器过载的机制。
        registrationBean.addInitParameter("pollAndCometEnabled", "true");
        registrationBean.addInitParameter("activeReverseAjaxEnabled", "true");
        registrationBean.addInitParameter("maxWaitAfterWrite", "60");
        return registrationBean;
    }
}


///**
// * @author
// * @Package com.paic.commcc.support.dwr
// * @Description: 远程服务端ajax
// * @date 2018/12/11 19:17
// */
//@Configuration
//public class DwrConfig {
//    @Bean
//    public ServletRegistrationBean dwr() {
//        ServletRegistrationBean servlet = new ServletRegistrationBean(new DwrServlet(), "/dwr/*");
//        Map<String, String> initParam = new HashMap<>();
//        initParam.put("crossDomainSessionSecurity", "false");
//        initParam.put("allowScriptTagRemoting", "true");
//        initParam.put("classes", "java.lang.Object");
//        initParam.put("activeReverseAjaxEnabled", "true");
//        initParam.put("initApplicationScopeCreatorsAtStartup", "true");
//        initParam.put("maxWaitAfterWrite", "60000");
//        initParam.put("debug", "true");
//        initParam.put("logLevel", "WARN");
//        //自定义配置，org.directwebremoting.impl.StartupUtil#configureFromInitParams name.equals("customConfigurator")
//        //DwrServlet#init 初始化this.container
//        //initParam.put("customConfigurator", "com.paic.commcc.support.dwr.DwrXml");
//        initParam.put("customConfigurator", "cn.grand.demodwr.config.DwrXml");
//
//        servlet.setInitParameters(initParam);
//        return servlet;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean dwrListener() {
//        return new ServletListenerRegistrationBean(new DwrListener());
//    }
//}
