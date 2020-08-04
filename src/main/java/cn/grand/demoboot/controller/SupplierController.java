package cn.grand.demoboot.controller;

import cn.grand.demoboot.entity.supplier.PN;
import cn.grand.demoboot.entity.supplier.PNSUB;
import cn.grand.demoboot.helper.BootstrapPagerHelper;
import cn.grand.demoboot.helper.ExcelHelper;
import cn.grand.demoboot.helper.PDFHelper;
import cn.grand.demoboot.helper.PageHelper;
import cn.grand.demoboot.helper.SupRDBSHelper;
import cn.grand.demoboot.helper.base.PageModel;
import cn.grand.demoboot.mapper.supplier.SupCommonMapper;
import cn.grand.demoboot.utils.HttpPath;
import cn.grand.demoboot.utils.HttpReq;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Supplier")
public class SupplierController
{

    @Autowired
    SupRDBSHelper supRDBSHelper;
    @Autowired
    SupCommonMapper supCommonMapper;
    @Autowired
    HttpServletResponse response;

    @Autowired
    HttpPath httpPath;

    @RequestMapping("/PnList")
    public String PnList(PN pn, PNSUB pnSub,
                         @RequestParam(value = "outExcel", required = false, defaultValue = "0") int outExcel,
                         @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
                         Model model) throws IOException, DocumentException, WriterException
    {
        if (pn == null)
        {
            pn = new PN();
        }
        if (pageSize <= 0)
            //防止除0操作
            pageSize = 1;

        //region 查询条件
        String filter = "";


        filter = "where 1=1";
        if (pn.getDnnum() != null && pn.getDnnum() != "")
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += " DNNUM  like '%" + pn.getDnnum() + "%'";
        }
        if (pn.getSupid() != null && pn.getSupid() != "")
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += " SUPID  = '" + pn.getSupid() + "'";
        }
        if (pn.getName() != null && pn.getName() != "")
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += " NAME  like '%" + pn.getName() + "%'";
        }
        if (pn.getPlant() != null && pn.getPlant() != "")
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += " PLANT  like '%" + pn.getPlant() + "%'";
        }
        if (pn.getPmn33() != null && pn.getPmn33() != "")
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += " PMN33  = '" + pn.getPmn33() + "'";
        }
        if (pnSub.getPmm01() != null && pnSub.getPmm01() != "")
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += "  dnnum in (select sdnnum from pnsub where pmm01 like '%" + pnSub.getPmm01() + "%' ) ";

            //select* from pn where dnnum in (select sdnnum from pnsub where pmm01 like '%221-S341808220010%' )
        }
        if (pnSub.getPmn04() != null && pnSub.getPmn04() != "")
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += "  dnnum in (select sdnnum from pnsub where pmn04 like '%" + pnSub.getPmn04() + "%' ) ";
        }
        //endregion

        //获取数据
        int totalpage = 0;
        int totalRecord = 0;
        Map map = supRDBSHelper.ExecutePaging("PN", "pmn33 desc,dnnum asc", filter, pageSize, pageNumber, totalRecord);
        //List<LinkedHashMap<String,Object>>  list   = (List<LinkedHashMap<String,Object>>)map.get("list");
        List<PN> pnList = (List<PN>) map.get("list");
        //利用Json强转LinkedHashMap 成对象 PN
        pnList = JSON.parseArray(JSON.toJSONString(pnList), PN.class);
        totalRecord = (int) map.get("totalRecord");
        model.addAttribute("pnList", pnList);
        model.addAttribute("PN", pn);
        model.addAttribute("PNSUB", pnSub);

        //region 子表数据
        String subFilter = "";
        for (PN p : pnList)
        {
            if (subFilter.length() > 1)
            {
                subFilter += ",";
            }
            subFilter += "'" + p.getDnnum() + "'";
        }
        if (subFilter.length() > 1)
        {
            subFilter = " sdnnum in (" + subFilter + ") ";
        }
        //List<PNSUB> pnSubList = new List<PNSUB>();
        List<PNSUB> subList = null;
        List<LinkedHashMap<String, Object>> pnSubList = null;
        if (subFilter != "")
        {
            String cmdStr = "select * from pnsub where 1=1 and  " + subFilter;
            pnSubList = supCommonMapper.commonSelect(cmdStr);
            //List<PNSUB> subList = null;
            //利用Json强转LinkedHashMap 成对象 PNSUB 方便前台点出方法
            subList = JSON.parseArray(JSON.toJSONString(pnSubList), PNSUB.class);
            model.addAttribute("pnSubList", subList);
        } else
        {
            model.addAttribute("pnSubList", null);
        }
        //endregion

        //导出excel 会报错，response 与 out 重复 。@ResponseBody  不能共用 一个 controller ？
        if (outExcel == 1)
        {
           //
            ExcelHelper.exportExcel2007(response, pnSubList, "Sheet1", "download.xlsx", 15);
            return null;
        }
        //PDF模板导出
        if (outExcel == 2)
        {
//            out.clear();
//            out = pageContext.pushBody();
            PDFHelper.test(response); //生成pdf 并 下载导出
            return null;
        }
        //API test
        if (outExcel == 3)
        {
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            list.add(new BasicNameValuePair("supid", "210005"));
            String potemp = HttpReq.toPostdata(list, httpPath.getPOCount());

            if(potemp != null && !"".equals(potemp) && !"获取失败".equals(potemp)) {
                Map<String, Integer> map0 = (Map<String, Integer>)JSON.parse(potemp);
                int newCount = map0.get("newCount");
                int subCount = map0.get("subCount");
                String rejCount = String.valueOf(map0.get("rejCount"));
                int retCount = map0.get("retCount");
            }else
                return "error";
        }
        //页脚信息Model
        PageModel pageModel = new PageModel(pageSize, pageNumber, totalRecord);
        String pageHelper = new BootstrapPagerHelper(pageModel).toString();
        model.addAttribute("pageHelper", pageHelper);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("message", "");
        //大小写敏感！！！
        return "Supplier/PnList";
    }


}
