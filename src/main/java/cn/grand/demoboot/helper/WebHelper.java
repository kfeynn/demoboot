package cn.grand.demoboot.helper;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Web帮助类
 */
public class WebHelper
{
    //region Cookie

    /**
     * 检索所有Cookie封装到Map集合
     *
     * @param request
     * @return
     */
    public static Map<String, String> readCookieMap(HttpServletRequest request)
    {
        Map<String, String> cookieMap = new HashMap<String, String>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies)
        {
            for (Cookie cookie : cookies)
            {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }

    /**
     * 获取Cookie对象
     *
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name)
    {
        Cookie reutnCookie = null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies)
        {
            for (Cookie cookie : cookies)
            {
                //String cookieName = ;
                if (name.equals(cookie.getName()))
                {
                    reutnCookie = cookie;
                }
            }
        }
        return reutnCookie;
    }

    /**
     * 获得指定名称的Cookie值
     *
     * @param request
     * @param name    Cookie名称
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name) throws Exception
    {
        Map<String, String> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name))
        {
            String cookieValue = cookieMap.get(name);
            return UrlDecode(cookieValue);
        }
        else
            return "";
    }


    public static String getCookieValue(HttpServletRequest request, String name, String key) throws Exception
    {
        String rStr = "";
        Map<String, String> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name))
        {
            String cookieValue = cookieMap.get(name);

            cookieValue = UrlDecode(cookieValue);

            JSONObject jsonObject = JSONObject.parseObject(cookieValue);
            if (jsonObject != null)
            {
                rStr = jsonObject.getString(key);
            }
        }
        return rStr;
    }

    /**
     * 删除指定名称的Cookie
     *
     * @param request
     * @param response
     * @param name     Cookie名称
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name)
    {
        Cookie cookie = getCookieByName(request, name);
        if (cookie != null)
        {
            // 设置生存期为0
            cookie.setMaxAge(0);
            cookie.setPath("/");
            // 设回Response中生效
            response.addCookie(cookie);
        }
    }

    /**
     * 设置指定名称的Cookie的值
     *
     * @param name  Cookie名称
     * @param value 值
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value)  throws Exception
    {
        //给json值编码
        value = UrlEncode(value);

        Cookie cookie = getCookieByName(request, name);
        if (null != cookie)
            cookie.setValue(value);
        else
            cookie = new Cookie(name, value);
        //cookie.setDomain("/");
        cookie.setPath("/");
        //没有传递过期时间的默认过期时间20分钟
        int expires = 20 * 60;
        cookie.setMaxAge(expires);
        response.addCookie(cookie);
    }

    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int expires)  throws Exception
    {
        //给json值编码
        value = UrlEncode(value);

        Cookie cookie = getCookieByName(request, name);
        if (null != cookie)
            cookie.setValue(value);
        else
            cookie = new Cookie(name, value);
        //cookie.setDomain("/");
        cookie.setPath("/");
        cookie.setMaxAge(expires);
        response.addCookie(cookie);
    }

    //endregion

    /** URL解码 */
    public static String UrlDecode(String s) throws Exception
    {
        return URLDecoder.decode(s, "GBK");
    }

    /** URL编码 */
    public static String UrlEncode(String s) throws Exception
    {
        return URLEncoder.encode(s, "GBK");
    }

//    URLEncoder.encode(name, "utf-8");
//    URLDecoder.decode(cookies[i].getName(),"utf-8")

}
