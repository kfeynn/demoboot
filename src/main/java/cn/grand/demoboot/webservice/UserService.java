package cn.grand.demoboot.webservice;

import cn.grand.demoboot.entity.sqlserver.XpGridUser;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface UserService
{
    @WebMethod
    String getName(@WebParam(name = "userId") String userId);

    @WebMethod
    XpGridUser getUser(String userId);

    @WebMethod
    ArrayList<XpGridUser> getAlLUser();


}
