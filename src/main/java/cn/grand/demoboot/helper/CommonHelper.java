package cn.grand.demoboot.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/// <summary>
/// 普通帮助类
/// </summary>
public class CommonHelper
{
    //星期数组
    private static String[] _weekdays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

    private static SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日");

    //region 时间操作

    /// <summary>
    /// 获得当前时间的" yyyy-MM-dd "格式字符串
    /// </summary>
    public static String GetDate()
    {
        Date date = new Date();
        return myFmt.format(date.getTime());
    }

    /// <summary>
    /// 获得当前星期(汉字)
    /// </summary>
    public static String GetWeek()
    {
        Date today = new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(today);
        int weekday=c.get(Calendar.DAY_OF_WEEK);
        weekday = weekday -1 ; //Calendar ，和数据角标不一致。
        return _weekdays[weekday];
    }

     //endregion




}
