package cn.grand.demoboot.controller;

import cn.grand.demoboot.dao.XpGridFunctionsForPublicDao;
import cn.grand.demoboot.dao.XpGridUserDao;
import cn.grand.demoboot.entity.sqlserver.XpGridFunctionsForPublic;
import cn.grand.demoboot.entity.sqlserver.XpGridUser;
import cn.grand.demoboot.helper.CookieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Home")
public class HomeController
{
    @Autowired
    private HttpServletRequest request;
    @Autowired
    XpGridFunctionsForPublicDao  xpGridFunctionsForPublicDao;

    @Autowired
    XpGridUserDao xpGridUserDao;

    //整合bootstarp 样式后台。
    @RequestMapping("/Default")
    public String Default(Model model) throws Exception
    {
        List<XpGridFunctionsForPublic> menuList = xpGridFunctionsForPublicDao.selectList();
        model.addAttribute("menuList", menuList);

        int uid = CookieHelper.getSidCookie(request);
        if(uid > 0)
        {
            XpGridUser userModel = xpGridUserDao.getModelByUserID(uid);
            if (userModel != null)
            {
                model.addAttribute("userCName", userModel.getUsercname());
                model.addAttribute("userId",userModel.getUserid());
            }
            else
            {
                model.addAttribute("userCName", "游客");
                model.addAttribute("userId","");
            }
        }
        //返回网页路径
        return "Home/Default";
    }

    //整合bootstarp 样式后台。
    @RequestMapping("/Default2")
    public String Default2(Model model) throws Exception
    {
        List<XpGridFunctionsForPublic> menuList = xpGridFunctionsForPublicDao.selectList();
        model.addAttribute("menuList", menuList);

        int uid = CookieHelper.getSidCookie(request);
        if(uid > 0)
        {
            XpGridUser userModel = xpGridUserDao.getModelByUserID(uid);
            if (userModel != null)
            {
                model.addAttribute("userCName", userModel.getUsercname());
                model.addAttribute("userId",userModel.getUserid());
            }
            else
            {
                model.addAttribute("userCName", "游客");
                model.addAttribute("userId","");
            }
        }
        //返回网页路径
        return "Home/Default2";
    }


    //业务提醒功能页
    @RequestMapping("/mallruninfo")
    public String mallruninfo()
    {
        //返回网页路径
        return "Home/mallruninfo";
    }
}
