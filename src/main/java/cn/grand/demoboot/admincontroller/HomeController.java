package cn.grand.demoboot.admincontroller;


import cn.grand.demoboot.dao.XpGridFunctionsForPublicDao;
import cn.grand.demoboot.dao.XpGridUserDao;
import cn.grand.demoboot.entity.sqlserver.XpGridFunctions;
import cn.grand.demoboot.entity.sqlserver.XpGridUser;
import cn.grand.demoboot.helper.CookieHelper;
import cn.grand.demoboot.service.HomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller("HomeController")
@RequestMapping("/malladmin/Home")
public class HomeController
{
    //自动注入
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    XpGridFunctionsForPublicDao  xpGridFunctionsForPublicDao;
    @Autowired
    XpGridUserDao xpGridUserDao;

    @Autowired
    private HomeServices homeServices;

    //整合bootstarp 样式后台。
    @RequestMapping("/Default")
    public String Default(Model model) throws  Exception
    {

        int uid = CookieHelper.getSidCookie(request);
        if(uid > 0)
        {
            List<XpGridFunctions> menuList = homeServices.selectListByUserId(uid);
            model.addAttribute("menuList", menuList);

            XpGridUser userModel = xpGridUserDao.getModelByUserID(uid);
            if (userModel != null)
            {
                model.addAttribute("userCName", userModel.getUsercname());
                model.addAttribute("userId",userModel.getUserid());
            }
        }
        //返回网页路径
        return "malladmin/Home/Default";
    }

//    //业务提醒功能页
//    @RequestMapping("/mallruninfo")
//    public String mallruninfo()
//    {
//        //返回网页路径
//        return "Home/mallruninfo";
//    }
}
