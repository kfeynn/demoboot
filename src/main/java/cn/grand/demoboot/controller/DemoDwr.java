package cn.grand.demoboot.controller;

import cn.grand.demoboot.dao.XpGridRoleDao;
import cn.grand.demoboot.dao.XpGridUserDao;
import cn.grand.demoboot.entity.sqlserver.XpGridRole;
import cn.grand.demoboot.helper.PageHelper;
import cn.grand.demoboot.helper.RDBSHelper;
import cn.grand.demoboot.helper.SupRDBSHelper;
import cn.grand.demoboot.helper.base.PageModel;
import cn.grand.demoboot.service.RoleServices;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Service
@RemoteProxy  // spring 的注解，相当于暴露服务
public class DemoDwr
{

    @Autowired
    XpGridUserDao xpGridUserDao;

    @Autowired
    SupRDBSHelper supRDBSHelper;
    @Autowired
    RoleServices roleServices;
    @Autowired
    RDBSHelper rdbsHelper;
    @Autowired
    XpGridRoleDao xpGridRoleDao;


    public String hello(){
        return "hello  dada " ;
    }

    public String echo(String  string){
        return "hello 程序返回：  " + string ;
    }


    public String list(String roleName,
                       @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize
                      )
    {
        boolean flag = xpGridUserDao.isExists("admin","admin");

//        SupRDBSHelper roleServicess = new SupRDBSHelper();
//        roleServicess.ExecutePaging("PN", "pmn33 desc,dnnum asc", "", pageSize, pageNumber, 0);

        Map map0 = supRDBSHelper.ExecutePaging("PN", "pmn33 desc,dnnum asc", "", pageSize, pageNumber, 0);

        roleName = "" ;
        //System.out.println(1/0);
        //获取数据
        Map map = roleServices.getRoleList(roleName, pageNumber, pageSize);
        //分页查询约定两个返回值。list , pageHelper
        List<XpGridRole> list = (List<XpGridRole>) map.get("list");
        Long trecord = (Long) map.get("totalRecord");
        int totalRecord = trecord.intValue();


        //页脚Model
        PageModel pageModel = new PageModel(pageSize, pageNumber, totalRecord);
        String pageHelper = new PageHelper(pageModel).toString();

        //大小写敏感！！！
        return pageHelper;
    }
}