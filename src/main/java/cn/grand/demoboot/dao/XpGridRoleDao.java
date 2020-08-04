package cn.grand.demoboot.dao;

import cn.grand.demoboot.entity.sqlserver.XpGridFuncsInRoles;
import cn.grand.demoboot.entity.sqlserver.XpGridFunctions;
import cn.grand.demoboot.entity.sqlserver.XpGridRole;
import cn.grand.demoboot.mapper.sqlserver.XpGridFuncsInRolesMapper;
import cn.grand.demoboot.mapper.sqlserver.XpGridFunctionsMapper;
import cn.grand.demoboot.mapper.sqlserver.XpGridRoleMapper;
import cn.grand.demoboot.mapper.sqlserver.XpGridRoleMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XpGridRoleDao
{
    @Autowired
    XpGridRoleMapper xpGridRoleMapper;
    @Autowired
    XpGridRoleMapperPlus xpGridRoleMapperPlus;
    @Autowired
    XpGridFuncsInRolesMapper xpGridFuncsInRolesMapper;
    @Autowired
    XpGridFunctionsMapper xpGridFunctionsMapper;

    /** 获取角色信息 */
    public XpGridRole selectByRoleName(String roleName)
    {
        return xpGridRoleMapperPlus.selectByRoleName(roleName);
    }

    /** 添加信息 */
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int insert(XpGridRole role)
    {
        return xpGridRoleMapper.insert(role);
    }

    /** 更新信息 */
    public int edit(XpGridRole model)
    {
        return xpGridRoleMapper.updateByPrimaryKey(model);
    }

    /** 添加权限*/
    public int addRoleAuthorization(XpGridFuncsInRoles model)
    {
        return xpGridFuncsInRolesMapper.insertSelective(model);
    }

    public int addFunc(XpGridFunctions model)
    {
        return xpGridFunctionsMapper.insertSelective(model);
    }

    public int updateFunc(XpGridFunctions model)
    {
        return xpGridFunctionsMapper.updateByPrimaryKeySelective(model);
    }



}
