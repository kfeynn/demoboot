package cn.grand.demoboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DefaultController
{
    @RequestMapping("/")
    public String index(Model model) {

        System.out.println("----------eeeeeeeeeeeeeeeeee------------");
        //跳转到默认首页
        return "redirect:Home/Default2";
    }
}
