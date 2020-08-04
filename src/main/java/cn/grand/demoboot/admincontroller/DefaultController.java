package cn.grand.demoboot.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import static cn.grand.demoboot.webservice.client.webserviceclienttest.testservice;

//后台controller加名称区别前台
@Controller("DefaultController")
@RequestMapping("/malladmin")
public class DefaultController
{
    @RequestMapping("/")
    public String index(Model model)
    {
        //System.out.println("malladmin.DefaultController,  aaa，");
        //跳转到默认首页
        return "redirect:Home/Default";
    }
}
