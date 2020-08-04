package cn.grand.demoboot.service;

import cn.grand.demoboot.dao.XpGridRoleDao;
import cn.grand.demoboot.dao.XpGridUserDao;
import cn.grand.demoboot.entity.sqlserver.XpGridUsersInRoles;
import cn.grand.demoboot.mapper.sqlserver.CommonMapper;
import cn.grand.demoboot.mapper.sqlserver.XpGridFunctionsMapper;
import cn.grand.demoboot.mapper.sqlserver.XpGridUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserServices
{
    @Autowired
    XpGridUserMapper xpGridUserMapper;

    @Autowired
    CommonMapper  commonMapper;

    @Autowired
    XpGridRoleDao xpGridRoleDao;

    @Autowired
    XpGridUserDao xpGridUserDao;

    @Autowired
    XpGridFunctionsMapper xpGridFunctionsMapper;

//    public int deleteUser(int sid)
//    {
//        return xpGridUserMapper.deleteByPrimaryKey(sid);
//    }

    /**
     * 获取角色权限列表
     */
    public List<LinkedHashMap<String,Object>> userAuthorizationRoleList(int sid)
    {
        //mybatis 执行原生sql语句
        String sql = "select [xpGrid_Role].*,isnull(checked,0) as checked from [dbo].[xpGrid_Role] left join (select [xpGrid_UsersInRoles].*,1 as checked from [dbo].[xpGrid_User] inner join [xpGrid_UsersInRoles] on [xpGrid_User].UserID = [xpGrid_UsersInRoles].UserID where [xpGrid_User].userid = " + sid + " ) CheckedRole  on  [xpGrid_Role].RoleId = CheckedRole.RoleId ";

        List<LinkedHashMap<String,Object>>  list =  commonMapper.commonSelect(sql);
        return list;
    }

    /** 角色更改权限,(多数据源事务控制) */
    //@Transactional(transactionManager = “当前模块配置的TransactionManager”)
    @Transactional(transactionManager = "sqlserverTrans")
    public boolean userAuthorizationChange(int sid, int[] pmIdList) //throws Exception
    {
        //0.已经配置有事务管理
        //1.删除原有权限
        String cmdDelStr = "delete from [xpGrid_UsersInRoles] where userId = " + sid;
        commonMapper.commonSql(cmdDelStr);
        //2.添加新权限
        if (pmIdList != null)
        {
            for(int pmId : pmIdList)
            {
                XpGridUsersInRoles f = new XpGridUsersInRoles();
                f.setUserid(sid);
                f.setRoleid(pmId);
                //添加
                xpGridUserDao.addUserAuthorization(f);
            }
        }


        return true;
    }

}
