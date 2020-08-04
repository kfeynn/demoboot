package cn.grand.demoboot.helper.base;

/// <summary>
/// 分页模型
/// </summary>
public class PageModel
{
    private int pageindex;//当前页索引
    private int pagenumber;//当前页数
    private int prepagenumber;//上一页数
    private int nextpagenumber;//下一页数
    private int pagesize;//每页数
    private int totalcount;//总项数
    private int totalpages;//总页数
    private boolean hasprepage;//是否有上一页
    private boolean hasnextpage;//是否有下一页
    private boolean isfirstpage;//是否是第一页
    private boolean islastpage;//是否是最后一页

    /// <summary>
    /// 分页模型
    /// </summary>
    /// <param name="pageSize">页尺寸</param>
    /// <param name="pageNumber">当前页码</param>
    /// <param name="totalCount">总记录数</param>
    public PageModel(int pageSize, int pageNumber, int totalCount)
    {
        if (pageSize > 0)
            pagesize = pageSize;
        else
            pagesize = 1;

        if (pageNumber > 0)
            pagenumber = pageNumber;
        else
            pagenumber = 1;

        if (totalCount > 0)
            totalcount = totalCount;
        else
            totalcount = 0;

        pageindex = pagenumber - 1;

        totalpages = totalcount / pagesize;
        if (totalcount % pagesize > 0)
            totalpages++;

        hasprepage = pagenumber > 1;
        hasnextpage = pagenumber < totalpages;

        isfirstpage = pagenumber == 1;
        islastpage = pagenumber == totalpages;

        prepagenumber = pagenumber < 2 ? 1 : pagenumber - 1;
        nextpagenumber = pagenumber < totalpages ? pagenumber + 1 : totalpages;
    }

    public int getPageindex()
    {
        return pageindex;
    }

    public void setPageindex(int pageindex)
    {
        this.pageindex = pageindex;
    }

    public int getPagenumber()
    {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber)
    {
        this.pagenumber = pagenumber;
    }

    public int getPrepagenumber()
    {
        return prepagenumber;
    }

    public void setPrepagenumber(int prepagenumber)
    {
        this.prepagenumber = prepagenumber;
    }

    public int getNextpagenumber()
    {
        return nextpagenumber;
    }

    public void setNextpagenumber(int nextpagenumber)
    {
        this.nextpagenumber = nextpagenumber;
    }

    public int getPagesize()
    {
        return pagesize;
    }

    public void setPagesize(int pagesize)
    {
        this.pagesize = pagesize;
    }

    public int getTotalcount()
    {
        return totalcount;
    }

    public void setTotalcount(int totalcount)
    {
        this.totalcount = totalcount;
    }

    public int getTotalpages()
    {
        return totalpages;
    }

    public void setTotalpages(int totalpages)
    {
        this.totalpages = totalpages;
    }

    public boolean isHasprepage()
    {
        return hasprepage;
    }

    public void setHasprepage(boolean hasprepage)
    {
        this.hasprepage = hasprepage;
    }

    public boolean isHasnextpage()
    {
        return hasnextpage;
    }

    public void setHasnextpage(boolean hasnextpage)
    {
        this.hasnextpage = hasnextpage;
    }

    public boolean isIsfirstpage()
    {
        return isfirstpage;
    }

    public void setIsfirstpage(boolean isfirstpage)
    {
        this.isfirstpage = isfirstpage;
    }

    public boolean isIslastpage()
    {
        return islastpage;
    }

    public void setIslastpage(boolean islastpage)
    {
        this.islastpage = islastpage;
    }
}