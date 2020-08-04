package cn.grand.demoboot.helper;

import cn.grand.demoboot.entity.sqlserver.XpGridUser;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper
{
    //region Cookie


    /**
     * 获得用户id
     *
     * @param request
     * @return
     */
    public static int getSidCookie(HttpServletRequest request) throws Exception
    {
        return TypeHelper.stringToInt(WebHelper.getCookieValue(request, "userinfo", "sid"), -1);
    }


    /**
     * 设置用户登录 Cookie
     *
     * @param partUserInfo 用户信息
     * @param expires      过期时间
     */
    public static void setUserCookie(HttpServletRequest request, HttpServletResponse response, XpGridUser partUserInfo, int expires)
     throws  Exception
    {
        //添加 uid cookie
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("password", partUserInfo.getPassword());
        jsonObject.put("sid", partUserInfo.getUserid().toString());
        String value = jsonObject.toJSONString();
        WebHelper.setCookie(request, response, "userinfo", value, expires);
    }

    /**
     * 设置后台访问referer
     */
    public static void setAdminRefererCookie(HttpServletRequest request, HttpServletResponse response, String url)
            //throws Exception
    {
        try
        {
            WebHelper.setCookie(request, response, "adminreferer", WebHelper.UrlEncode(url));
        }
        catch (Exception ex)
        {}
    }

    /**
     * 获得系统后台访问referer
     */
    public static String getMallAdminRefererCookie(HttpServletRequest request)
    {
        try
        {
            return getAdminRefererCookie(request, "/Home/mallruninfo");
        }
        catch (Exception ex)
        {
            return "/Home/mallruninfo";
        }
    }

    /**
     * 获得后台访问referer
     */
    public static String getAdminRefererCookie(HttpServletRequest request, String defaultUrl)
            throws Exception
    {
        String adminReferer = WebHelper.UrlDecode(WebHelper.getCookieValue(request, "adminreferer"));
        if (adminReferer.length() == 0)
            adminReferer = defaultUrl;
        return adminReferer;
    }

    //endregion

}
