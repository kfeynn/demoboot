package cn.grand.demoboot.utils;

import cn.grand.demoboot.vo.APIConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HttpPath
{
    @Autowired
    APIConfigBean configBean;

    //api 要访问的地址

    public String getSupplier()
    {
        return configBean.getServer() + "pmc_getSupplier";
    }
    public String getPOCount()
    {
        return configBean.getServer() + "po_getPOCount";
    }
    public String getAllPO()
    {
        return configBean.getServer() + "po_getAllPO";
    }
    public String getPOSubmit()
    {
        return configBean.getServer() + "po_getPOSubmit";
    }
    public String getPONew()
    {
        return configBean.getServer() + "po_getPONew";
    }
    public String getPOReject()
    {
        return configBean.getServer() + "po_getPOReject";
    }
    public String getPOReturn()
    {
        return configBean.getServer() + "po_getPOReturn";
    }
    public String getPODelivered()
    {
        return configBean.getServer() + "po_getPODelivered";
    }
    public String updatePOStatus()
    {
        return configBean.getServer() + "po_updatePOStatus";
    }
    public String getPOByPOList()
    {
        return configBean.getServer() + "po_getPOByPOList";
    }
    public String getDnnumIsReceiving()
    {
        return configBean.getServer() + "po_getDnnumIsReceiving";
    }
    public String getOblFileList()
    {
        return configBean.getServer() + "pack_getOblFileList";
    }
    public String updateOblFile()
    {
        return configBean.getServer() + "pack_updateOblFile";
    }
    public String saveOblFile()
    {
        return configBean.getServer() + "pack_saveOblFile";
    }
    public String getPackByMatter()
    {
        return configBean.getServer() + "pack_getPackByMatter";
    }
    /**
     * 查询退货的数量
     **/
    public String poReturnQty()
    {
        return configBean.getServer() + "po_poReturnQty";
    }
    /***
     * 查询是否符合条件
     */
    public String queryALLUndeliveredoOrders()
    {
        return configBean.getServer() + "po_poQueryALLUndeliveredoOrders";
    }
    /**
     * 查看供应商、编码 是否存在于 cpmi004，cpmi005 内。
     *
     * @return
     */
    public String getSupCountInTcPmm()
    {
        return configBean.getServer() + "po_getSupCountInTcPmm";
    }
    /**
     * 获取订单最终营运中心。
     *
     * @return
     */
    public String getPmmFinallegal()
    {
        return configBean.getServer() + "po_getPmmFinallegal";
    }


}
