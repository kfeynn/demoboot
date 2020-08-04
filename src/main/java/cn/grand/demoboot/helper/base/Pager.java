package cn.grand.demoboot.helper.base;

/// <summary>
/// 分页基类
/// </summary>
public abstract class Pager
{
    protected final PageModel _pagemodel;//分页对象
    protected boolean _showsummary = true;//是否显示汇总
    protected boolean _showitems = true;//是否显示页项
    protected int _itemcount = 7;//项数量
    protected boolean _showfirst = true;//是否显示首页
    protected boolean _showpre = true;//是否显示上一页
    protected boolean _shownext = true;//是否显示下一页
    protected boolean _showlast = true;//是否显示末页
    protected boolean _showpagesize = true;//是否显示每页数
    protected boolean _showgopage = true;//是否显示页数输入框

    public Pager(PageModel pageModel)
    {
        _pagemodel = pageModel;
    }

    /// <summary>
    /// 设置是否显示汇总
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ShowSummary(boolean value)
    {
        _showsummary = value;
        return this;
    }
    /// <summary>
    /// 设置是否显示页项
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ShowItems(boolean value)
    {
        _showitems = value;
        return this;
    }
    /// <summary>
    /// 设置项数量
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ItemCount(int count)
    {
        _itemcount = count;
        return this;
    }
    /// <summary>
    /// 设置是否显示首页
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ShowFirst(boolean value)
    {
        _showfirst = value;
        return this;
    }
    /// <summary>
    /// 设置是否显示上一页
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ShowPre(boolean value)
    {
        _showpre = value;
        return this;
    }
    /// <summary>
    /// 设置是否显示下一页
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ShowNext(boolean value)
    {
        _shownext = value;
        return this;
    }
    /// <summary>
    /// 设置是否显示末页
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ShowLast(boolean value)
    {
        _showlast = value;
        return this;
    }
    /// <summary>
    /// 设置是否显示每页数
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ShowPageSize(boolean value)
    {
        _showpagesize = value;
        return this;
    }
    /// <summary>
    /// 设置是否显示页数输入框
    /// </summary>
    /// <param name="value">value</param>
    /// <returns></returns>
    public Pager ShowGoPage(boolean value)
    {
        _showgopage = value;
        return this;
    }
    /// <summary>
    /// 获得开始页数
    /// </summary>
    /// <returns></returns>
    protected int GetStartPageNumber()
    {
        int mid = _itemcount / 2;
//        if ((_pagemodel.TotalPages < _itemcount) || ((_pagemodel.PageNumber - mid) < 1))
        if ((_pagemodel.getTotalpages() < _itemcount) || ((_pagemodel.getPagenumber() - mid) < 1))
        {
            return 1;
        }
        if ((_pagemodel.getPagenumber() + mid) > _pagemodel.getTotalpages())
        {
            return _pagemodel.getTotalpages() - _itemcount + 1;
        }
        return _pagemodel.getPagenumber() - mid;
    }
    /// <summary>
    /// 获得结束页数
    /// </summary>
    /// <returns></returns>
    protected int GetEndPageNumber()
    {
        int mid = _itemcount / 2;
        if ((_itemcount % 2) == 0)
        {
            mid--;
        }
        if ((_pagemodel.getTotalpages() < _itemcount) || ((_pagemodel.getPagenumber() + mid) >= _pagemodel.getTotalpages()))
        {
            return _pagemodel.getTotalpages();
        }
        if ((_pagemodel.getPagenumber() - (_itemcount / 2)) < 1)
        {
            return _itemcount;
        }
        return _pagemodel.getPagenumber() + mid;
    }
}