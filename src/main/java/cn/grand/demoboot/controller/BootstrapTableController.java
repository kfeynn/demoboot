package cn.grand.demoboot.controller;

import cn.grand.demoboot.entity.supplier.PN;
import cn.grand.demoboot.entity.supplier.PNSUB;
import cn.grand.demoboot.helper.BootstrapPagerHelper;
import cn.grand.demoboot.helper.ExcelHelper;
import cn.grand.demoboot.helper.PDFHelper;
import cn.grand.demoboot.helper.SupRDBSHelper;
import cn.grand.demoboot.helper.base.PageModel;
import cn.grand.demoboot.mapper.supplier.SupCommonMapper;
import cn.grand.demoboot.utils.HttpReq;
import cn.grand.demoboot.vo.APIConfigBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicNameValuePair;
import org.directwebremoting.json.types.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/BootstrapTable")
public class BootstrapTableController
{
    @Autowired
    SupRDBSHelper supRDBSHelper;
    @Autowired
    SupCommonMapper supCommonMapper;
    @Autowired
    HttpServletResponse response;

    @Autowired
    HttpServletRequest request;

    @Autowired
    APIConfigBean configBean;

    @RequestMapping("/Bstrap")
    public String Bstrap(PN pn, PNSUB pnSub,
                         @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
                         Model model)
    {
        return "BootstrapTable/Bstrap";
    }

    @RequestMapping("/JsonBstrap")
    @ResponseBody
    public JSONObject JsonBstrap(
            String content,
            String sortName,
            String sortOrder,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize  //,
//            @RequestParam(value = "offset", required = false, defaultValue = "1") int offset,
//            @RequestParam(value = "limit", required = false, defaultValue = "15") int limit
    )
    {
        //offset 页码
        //limit 页面大小
//        if(offset<=0){
//            offset =1;
//        }

        //Double a = Double.valueOf(offset)/Double.valueOf(limit);

        //pageNumber = (int)Math.ceil(Double.valueOf(offset)/Double.valueOf(limit));

        //查询条件
        String filter = "";
        filter = "where 1=1";
        if(!"".equals(content))
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += " DNNUM  like '%" + content + "%'";
        }

        JSONObject json = new JSONObject();
        //获取数据
        int totalpage = 0;
        int totalRecord = 0;
//        Map map = supRDBSHelper.ExecutePaging("PN", "pmn33 desc,dnnum asc", "", pageSize, pageNumber, totalRecord);

        Map map = supRDBSHelper.ExecutePaging("PN", sortName + " " + sortOrder, filter, pageSize, pageNumber, totalRecord);
        //List<LinkedHashMap<String,Object>>  list   = (List<LinkedHashMap<String,Object>>)map.get("list");
        List<PN> pnList = (List<PN>) map.get("list");
        //利用Json强转LinkedHashMap 成对象 PN
        pnList = JSON.parseArray(JSON.toJSONString(pnList), PN.class);
        System.out.println(pnList);
        totalRecord = (int) map.get("totalRecord");
        json.put("rows",pnList);   //list
        json.put("total",totalRecord); //记录总数
        return  json ;
    }


    @RequestMapping("/JsonBstrapDetail")
    @ResponseBody
    public JSONObject JsonBstrapDetail(
            String dnnum,
            String sortName,
            String sortOrder,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize  //,
    )
    {
        //offset 页码
        //limit 页面大小
//        if(offset<=0){
//            offset =1;
//        }

        //Double a = Double.valueOf(offset)/Double.valueOf(limit);

        //pageNumber = (int)Math.ceil(Double.valueOf(offset)/Double.valueOf(limit));

        //查询条件
        String filter = "";
        filter = "where 1=1";
        if(!"".equals(dnnum) && dnnum != null)
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += " SDNNUM  = '" + dnnum + "'";
        }

        JSONObject json = new JSONObject();
        //获取数据
        int totalpage = 0;
        int totalRecord = 0;

        Map map = supRDBSHelper.ExecutePaging("PNSub", sortName + " " + sortOrder, filter, pageSize, pageNumber, totalRecord);
        //List<LinkedHashMap<String,Object>>  list   = (List<LinkedHashMap<String,Object>>)map.get("list");
        List<PNSUB> list = (List<PNSUB>) map.get("list");
        //利用Json强转LinkedHashMap 成对象 PN
        list = JSON.parseArray(JSON.toJSONString(list), PNSUB.class);
        System.out.println(list);
        totalRecord = (int) map.get("totalRecord");
        json.put("rows",list);   //list
        json.put("total",totalRecord); //记录总数
        return  json ;
    }

    /** 显示pdf文件 */
    @RequestMapping("/downLoadByGuid")
    @ResponseBody
    public void downLoadByGuid()
    {
        System.out.println("[SupplierWeb] method : downLoadByGuid");
        //HttpServletRequest request = ServletActionContext.getRequest();
        //HttpServletResponse response = ServletActionContext.getResponse();
        String type = request.getParameter("type");
        String supid = request.getParameter("supid");
        String dnnum = request.getParameter("dnnum");

        InputStream in = null;
        OutputStream out = null;
        try
        {
            StringBuilder source = new StringBuilder(configBean.getPdfDir());
            if ("PN".equals(type))
            {
                source.append(supid);
                source.append("/PN_");
                source.append(dnnum);
                source.append(".pdf");
            } else if ("BOX".equals(type))
            {
                source.append(supid);
                source.append("/BOX_");
                source.append(supid);
                source.append(".pdf");
            } else
            {
                source.append(supid);
                source.append("/MATER_");
                source.append(dnnum);
                source.append(".pdf");
            }

            //测试 默认地址
            source.delete(0,source.length());
            source.append(configBean.getPdfDir());
            source.append("110000/PN_GDS33-11000019091901.pdf");

            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/pdf;charset=UTF-8");
            File file = new File(source.toString());
            if (!file.exists())
            {
                source = new StringBuilder(configBean.getPdfDir());
                source.append("FileNotFound.pdf");
            }
            in = new BufferedInputStream(new FileInputStream(source.toString()));
            byte buffBytes[] = new byte[1024];
            out = response.getOutputStream();
            int read = 0;
            while ((read = in.read(buffBytes)) != -1)
            {
                out.write(buffBytes, 0, read);
            }
            out.flush();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                } catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            }
            if (out != null)
            {
                try
                {
                    out.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
