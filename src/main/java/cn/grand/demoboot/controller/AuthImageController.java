package cn.grand.demoboot.controller;

import cn.grand.demoboot.utils.VerifyCodeUtils;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@ResponseBody    //验证码使用ResponseBody ，不找对应的jsp页面
@RequestMapping("/AuthImage")
public class AuthImageController
{
    //自动注入
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value="/authImage",method= RequestMethod.GET)
    public void authImage() //throws Exception
    {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 100, h = 30;
        try
        {
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
