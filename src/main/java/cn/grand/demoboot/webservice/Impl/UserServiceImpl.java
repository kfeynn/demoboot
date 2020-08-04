package cn.grand.demoboot.webservice.Impl;

import cn.grand.demoboot.entity.sqlserver.XpGridUser;
import cn.grand.demoboot.webservice.UserService;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(targetNamespace="http://webservice.demoboot.grand.cn/",endpointInterface = "cn.grand.demoboot.webservice.UserService")
public class UserServiceImpl implements UserService
{
    //Ctrl+I
    //备注说明：接口实现类名称前的注解targetNamespace是当前类实现接口所在包名称的反序（PS：加上反斜线），endpointInterface是当前需要实现接口的全称；
    //1.接口定义  2.接口实现 3.WebServiceConfig 接口服务发布类

    //发布方式1：pom加jeety 。启动类直接加入。注意端口不同 Endpoint.publish("http://localhost:9999/service/users/", new UserServiceImpl());
    //发布方式2: 配置类。例：WebServiceConfig ，每个接口类 都需要一个配置类 。
    @Override
    public String getName(String userId)
    {
        return "welcome :" + userId;
    }

    @Override
    public XpGridUser getUser(String userId)
    {
        return null;
    }

    @Override
    public ArrayList<XpGridUser> getAlLUser()
    {
        return null;
    }
}
