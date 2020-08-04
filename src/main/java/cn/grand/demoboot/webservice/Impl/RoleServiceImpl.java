package cn.grand.demoboot.webservice.Impl;

import cn.grand.demoboot.webservice.RoleService;

public class  RoleServiceImpl implements RoleService
{
    @Override
    public String getRoleName(String roleId)
    {
        return "Welcome Role : " + roleId;
    }
}
