package cn.grand.demoboot.interceptor;

import cn.grand.demoboot.helper.CookieHelper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     * 执行下一个拦截器,直到所有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle()
     * 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception
    {
        //region
        //验证用户是否登录 。
        String url = request.getRequestURI();
//        //判断是否是公开地址
//        //实际开发中需要将公开地址配置在配置文件中
//        if (url.indexOf("login") >= 0 || url.indexOf("/css") >= 0  || url.indexOf("/scripts") >= 0  || url.indexOf("/images") >= 0)
//        {
//            //如果是公开地址则放行
//            return true;
//        }
        //endregion
        //判断用户身份在cookie中是否存在
        int sid = CookieHelper.getSidCookie(request);
        if(sid > 0)
        {
            //String password = WebHelper.getCookieValue(request,"userinfo","password");
            //已经登录  暂时不验证用户名密码。
            return true;
        }
        else
        {
            //执行到这里就拦截，跳转到登陆页面，用户进行登陆
            //request.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(request, response);
            //return true;
            System.out.println("尚未登录，调到登录页面");
            response.sendRedirect("/Account/login");
            return false;
        }
        //return true;
    }
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception
    {
        //System.out.println("postHandle(), 在访问Controller之后，访问视图之前被调用,这里可以注入一个时间到modelAndView中，用于后续视图显示");
        // modelAndView.addObject("date", "由拦截器生成的时间:" + new Date());
    }
    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     * <p>
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        //System.out.println("afterCompletion(), 在访问视图之后被调用");
    }
}

