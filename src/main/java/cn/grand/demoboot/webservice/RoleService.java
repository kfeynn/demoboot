package cn.grand.demoboot.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface RoleService
{
    @WebMethod
    String getRoleName(@WebParam(name = "roleId") String roleId);

}
