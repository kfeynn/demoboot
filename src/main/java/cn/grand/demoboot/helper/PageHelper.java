package cn.grand.demoboot.helper;

import cn.grand.demoboot.helper.base.PageModel;
import cn.grand.demoboot.helper.base.Pager;

public class PageHelper extends Pager
{
    //分页辅助类
    public PageHelper(PageModel pageModel)
    {
        //调用父类构造函数
        super(pageModel);
    }

    //重写toString方法
    public  final  String toString()
    {
        if (_pagemodel.getTotalcount() == 0 || _pagemodel.getTotalcount() <= _pagemodel.getPagesize())
            return null;
        StringBuilder html = new StringBuilder();
        if (_showsummary)
        {
            html.append(String.format("<div class=\"summary\">当前%s/%s页&nbsp;共%s条记录</div>", _pagemodel.getPagenumber(), _pagemodel.getTotalpages(),_pagemodel.getTotalcount()));
            html.append("&nbsp;");
        }
        if (_showpagesize)
        {
            html.append(String.format("每页:<input type=\"text\" value=\"%s\" id=\"pageSize\" name=\"pageSize\" size=\"1\"/>", _pagemodel.getPagesize()));
        }
        if (_showfirst)
        {
            if (_pagemodel.isIsfirstpage())
                html.append("<a href=\"#\">首页</a>");
            else
                html.append("<a href=\"#\" page=\"1\" class=\"bt\">首页</a>");
        }
        if (_showpre)
        {
            if (_pagemodel.isHasprepage())
                html.append(String.format("<a href=\"#\" page=\"%d\" class=\"bt\">上一页</a>", _pagemodel.getPagenumber() - 1));
            else
                html.append("<a href=\"#\">上一页</a>");
        }
        if (_showitems)
        {
            int startPageNumber = GetStartPageNumber();
            int endPageNumber = GetEndPageNumber();
            for (int i = startPageNumber; i <= endPageNumber; i++)
            {
                if (_pagemodel.getPagenumber() != i)
                    html.append(String.format("<a href=\"#\" page=\"%d\" class=\"bt\">%d</a>", i,i));
                else
                    html.append(String.format("<a href=\"\" class=\"hot\">%d</a>", i));
            }
        }
        if (_shownext)
        {
            if (_pagemodel.isHasnextpage())
                html.append(String.format("<a href=\"#\" page=\"%d\" class=\"bt\">下一页</a>", _pagemodel.getPagenumber() + 1));
            else
                html.append("<a href=\"#\">下一页</a>");
        }
        if (_showlast)
        {
            if (_pagemodel.isIslastpage())
                html.append("<a href=\"#\">末页</a>");
            else
                html.append(String.format("<a href=\"#\" page=\"%d\" class=\"bt\">末页</a>", _pagemodel.getTotalpages()));
        }
        if (_showgopage)
        {
            html.append(String.format("跳转到:<input type=\"text\" value=\"%d\" id=\"pageNumber\" totalPages=\"%d\" name=\"pageNumber\" size=\"1\"/>页", _pagemodel.getPagenumber(), _pagemodel.getTotalpages()));
        }
        return html.toString();
    }

}
