package cn.grand.demoboot.controller;

import cn.grand.demoboot.dao.XpGridUserDao;
import cn.grand.demoboot.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@EnableConfigurationProperties(Student.class)
@RequestMapping("/Hello")
public class HelloController
{
    @Autowired
    XpGridUserDao xpGridUserDao;

    @Autowired
    private Student student;

    //@ResponseBody
    @RequestMapping("/hello")
    public String hello(Model model)
    {
        System.out.println("---------helleo-");
        boolean flag = xpGridUserDao.isExists("admin","admin");
        if(flag)
        {
            model.addAttribute("message","33" + student.getName() );
        }
        else
        {
            model.addAttribute("message","2222222" + student.getName());
        }
        return "hello";
    }
}
