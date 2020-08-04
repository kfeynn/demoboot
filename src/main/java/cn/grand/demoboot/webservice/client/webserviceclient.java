package cn.grand.demoboot.webservice.client;



import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

public class webserviceclient
{



    //动态调用
    public static void main11(String[] args) throws Exception
    {

//        //0 .调用
//        UserService  service= new UserServiceImplService().getUserServiceImplPort();
//        String aae  = service.getName("werwr");
//        System.out.println(aae);

        //1.动态调用
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:9999/service/user/?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try
        {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getName", "331-S312006230009");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e)
        {
            e.printStackTrace();
        }
        //main2(args);
        //main3(args);
        //main4(args);
        main5(args);
    }

    //调用方式二，通过接口协议获取数据类型
    public static void main2(String[] args) throws Exception {
//        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
//        jaxWsProxyFactoryBean.setAddress("http://localhost:9999/service/user/?wsdl");
//        jaxWsProxyFactoryBean.setServiceClass(UserService.class);
//
//        UserService userService=(UserService)jaxWsProxyFactoryBean.create();
//        String ee = userService.getName("aaa");
//        System.out.println(ee);
        //---------------
//        User userResult= userService.getUser("411001");
//        System.out.println("UserName:"+userResult.getUsername());
//        ArrayList<User> users=userService.getAlLUser();

    }


    //调用方式三，通过接口协议获取数据类型,设置链接超时和响应时间
    public static void main3(String[] args) throws Exception {
//        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
//        jaxWsProxyFactoryBean.setAddress("http://localhost:9999/service/user/?wsdl");
//        jaxWsProxyFactoryBean.setServiceClass(UserService.class);
//
//        UserService userService = (UserService) jaxWsProxyFactoryBean.create(); // 创建客户端对象
//        Client proxy= ClientProxy.getClient(userService);
//        HTTPConduit conduit=(HTTPConduit)proxy.getConduit();
//        HTTPClientPolicy policy=new HTTPClientPolicy();
//        policy.setConnectionTimeout(1000);
//        policy.setReceiveTimeout(1000);
//        conduit.setClient(policy);
//
//        System.out.println( userService.getName("ee"));

//        User userResult= userService.getUser("411001");
//        System.out.println("UserName:"+userResult.getUsername());
//        ArrayList<User> users=userService.getAlLUser();

    }


    public static void main4(String[] args) throws Exception {
//        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
//        jaxWsProxyFactoryBean.setAddress("http://192.168.0.80:6384/ws/r/aws_ttsrv2/?wsdl");
//        jaxWsProxyFactoryBean.setServiceClass(ERPService.class);
//
//        ERPService userService = (ERPService) jaxWsProxyFactoryBean.create(); // 创建客户端对象
//        Client proxy= ClientProxy.getClient(userService);
//        HTTPConduit conduit=(HTTPConduit)proxy.getConduit();
//        HTTPClientPolicy policy=new HTTPClientPolicy();
//        policy.setConnectionTimeout(1000);
//        policy.setReceiveTimeout(1000);
//        conduit.setClient(policy);
//
//        Object o  = userService.GetAsfi510("331-S322006230003");
//
//        System.out.println( userService.GetAsfi510("331-S322006230003"));

//        User userResult= userService.getUser("411001");
//        System.out.println("UserName:"+userResult.getUsername());
//        ArrayList<User> users=userService.getAlLUser();

    }


    public static void main5(String[] args) throws Exception
    {


        //1.动态调用
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://192.168.0.80:6384/ws/r/aws_ttsrv2/?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try
        {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("GetAsfi510", "331-S322006230003");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e)
        {
            e.printStackTrace();
        }


    }

}
