package cn.grand.demoboot.service;

import cn.grand.demoboot.dao.XpGridRoleDao;
import cn.grand.demoboot.entity.sqlserver.XpGridFuncsInRoles;
import cn.grand.demoboot.entity.sqlserver.XpGridFunctions;
import cn.grand.demoboot.entity.sqlserver.XpGridRole;
import cn.grand.demoboot.entity.sqlserver.XpGridRoleExample;
import cn.grand.demoboot.mapper.sqlserver.CommonMapper;
import cn.grand.demoboot.mapper.sqlserver.XpGridFunctionsMapper;
import cn.grand.demoboot.mapper.sqlserver.XpGridRoleMapper;
import cn.grand.demoboot.mapper.supplier.SupCommonMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServices
{
    @Autowired
    XpGridRoleMapper xpGridRoleMapper;
    @Autowired
    CommonMapper  commonMapper;
    @Autowired
    XpGridRoleDao xpGridRoleDao;
    @Autowired
    XpGridFunctionsMapper xpGridFunctionsMapper;
    @Autowired
    SupCommonMapper supCommonMapper;

    public Map getRoleList(String roleName, int pageNumber, int pageSize)
    {
        //1.写一个通用方法获取List （符合当前页条件）
        pageNumber = pageNumber - 1;

        //分页插件
        int pageIndex = pageNumber * pageSize; //分页用角标
        PageHelper.offsetPage(pageIndex, pageSize);

        //准备查询条件
        XpGridRoleExample example = new XpGridRoleExample();
        XpGridRoleExample.Criteria criteria = example.createCriteria();
        //查询条件
        if (roleName != null && roleName.length() > 0 && !roleName.equals("null"))
        {
            criteria.andRolenameLike("%" + roleName + "%");
        }
        //criteria.andRolenameNotEqualTo("0");
        //获取当前条件下的分页数据
        List<XpGridRole> list = xpGridRoleMapper.selectByExample(example);
        //2.返回当前条件下总记录数
        PageInfo pageInfo = new PageInfo<>(list);
        //System.out.println("总数："+pageInfo.getTotal());
        //System.out.println(pageInfo);
        Map map = new HashMap();
        map.put("list", list);
        map.put("totalRecord", pageInfo.getTotal());

        // 测试连接oracle 供应商数据库
//        String cmdStr = "select * from supplierlogin";
//        List<LinkedHashMap<String,Object>>  aa =  supCommonMapper.commonSelect(cmdStr);

        return map;
    }

    public  XpGridRole getRole(int sid)
    {
        return xpGridRoleMapper.selectByPrimaryKey(sid);
    }

    /** 添加Role信息*/
    //@Transactional  //(propagation = Propagation.REQUIRES_NEW)
    public int insertRole(String roleName, String roleDes) throws Exception
    {
        XpGridRole role = new XpGridRole();
        role.setRolename(roleName);
        role.setRoledes(roleDes);
        xpGridRoleDao.insert(role);
        return 0;
    }

    public int deleteRole(int sid)
    {
        return xpGridRoleMapper.deleteByPrimaryKey(sid);
    }

    /** 更新 */
    public int edit(int sid,String roleName,String roleDes)
    {
        XpGridRole model = new XpGridRole();
        model.setRoleid(sid);
        model.setRolename(roleName);
        model.setRoledes(roleDes);

        return xpGridRoleDao.edit(model);
    }

    /**
     * 获取角色权限列表
     */
    public List<LinkedHashMap<String,Object>> roleAuthorizationFunc(int sid)
    {
        //mybatis 执行原生sql语句
        String sql = "select [xpGrid_Functions].* , isnull(CheckedFunc.checked, 0) as checked from[dbo].[xpGrid_Functions] left join (select FuncCode,1 as checked from[dbo].[xpGrid_FuncsInRoles] inner join[xpGrid_Role] on[xpGrid_FuncsInRoles].RoleId = [xpGrid_Role].roleid where[xpGrid_Role].RoleId =" + sid + " ) CheckedFunc on[xpGrid_Functions].FuncCode = CheckedFunc.FuncCode";
        List<LinkedHashMap<String,Object>>  list =  commonMapper.commonSelect(sql);
        return list;
    }

    /** 角色更改权限 ,开启事务控制 (多数据源，需要指定)*/
    @Transactional(transactionManager = "sqlserverTrans")
    public boolean roleAuthorizationChange(int sid, String[] pmIdList) //throws Exception
    {
        //0.已经配置有事务管理
        //1.删除原有权限
        String cmdDelStr = "delete  from [xpGrid_FuncsInRoles] where roleId = " + sid;
        commonMapper.commonSql(cmdDelStr);
        //2.添加新权限
        if (pmIdList != null)
        {
            for(String pmId : pmIdList)
            {
                XpGridFuncsInRoles f = new XpGridFuncsInRoles();
                f.setRoleid(sid);
                f.setFunccode(pmId);
                //添加
                xpGridRoleDao.addRoleAuthorization(f);
            }
        }
        return true;
    }

    /** 判断是否存在 */
    public boolean isExistsFunc(String funcode)
    {
        XpGridFunctions model =  xpGridFunctionsMapper.selectByPrimaryKey(funcode);
        if(model !=null )
            return true;
        else
            return false;
    }

    public int deleteFunc(String funcode)
    {
        return xpGridFunctionsMapper.deleteByPrimaryKey(funcode);
    }

}
