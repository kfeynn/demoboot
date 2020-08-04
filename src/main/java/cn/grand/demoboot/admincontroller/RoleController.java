package cn.grand.demoboot.admincontroller;

import cn.grand.demoboot.dao.XpGridRoleDao;
import cn.grand.demoboot.entity.sqlserver.XpGridFunctions;
import cn.grand.demoboot.entity.sqlserver.XpGridRole;
import cn.grand.demoboot.helper.CookieHelper;
import cn.grand.demoboot.helper.PageHelper;
import cn.grand.demoboot.helper.RDBSHelper;
import cn.grand.demoboot.helper.base.PageModel;
import cn.grand.demoboot.service.RoleServices;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/malladmin/Role")
public class RoleController
{
    @Autowired
    RoleServices roleServices;
    @Autowired
    RDBSHelper rdbsHelper;
    @Autowired
    XpGridRoleDao xpGridRoleDao;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping("/list")
    public String list(String roleName,
                       @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
                       Model model)
    {

        //System.out.println(1/0);
        //获取数据
        Map map = roleServices.getRoleList(roleName, pageNumber, pageSize);
        //分页查询约定两个返回值。list , pageHelper
        List<XpGridRole> list = (List<XpGridRole>) map.get("list");
        Long trecord = (Long) map.get("totalRecord");
        int totalRecord = trecord.intValue();
        model.addAttribute("list", list);

        //页脚Model
        PageModel pageModel = new PageModel(pageSize, pageNumber, totalRecord);
        String pageHelper = new PageHelper(pageModel).toString();
        model.addAttribute("pageHelper", pageHelper);

        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumber", pageNumber);

        //记录本次访问地址， 用于返回上一层。
        CookieHelper.setAdminRefererCookie(request, response, String.format("%s?pageNumber=%s&pageSize=%s&roleName=%s",
                "list", String.valueOf(pageModel.getPagenumber()), String.valueOf(pageModel.getPagesize()),
                roleName));

//
//        Map  alista  = rdbsHelper.ExecutePaging("xpGrid_Functions","*","FuncCode asc","1=1",pageSize,pageNumber,0,0);
//        List<XpGridFunctions> aaa  = (List<XpGridFunctions> )alista.get("list");


        //大小写敏感！！！
        return "malladmin/Role/list";
    }

    @GetMapping("/add")
    public String add(Model model)
    {
        //上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);
        model.addAttribute("refer", refer);

        return "malladmin/Role/add";
    }

    @PostMapping("/add")
    public String add(String roleName, String roleDes, boolean AddFlag, Model model)
    {
        String message = "";
        if (roleName != null)
        {
            System.out.println("添加Role信息" + roleName);
            try
            {
                roleServices.insertRole(roleName, roleDes);
                message = "添加成功！";
            } catch (Exception ex)
            {
                message = "添加失败！" + ex.getMessage();
            }
        }
        //上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);
        model.addAttribute("refer", refer);
        if (AddFlag)
        {
            model.addAttribute("message", message);
            return "malladmin/Role/add";
        }
        else
        {
            //返回上一级目录
            refer = "redirect:" + refer;
            return refer;
        }
    }

    @RequestMapping("/delete")
    public String delete(int sid)
    {
        roleServices.deleteRole(sid);
        //返回上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);
        refer = "redirect:" + refer;
        //redirect : 同一Controller下 用相对目录。不能从根目录下查找 "/"
        return refer;
    }

    @GetMapping("/edit")
    public String edit(int sid, Model model)
    {
        //上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);
        model.addAttribute("refer", refer);
        String message = "";
        if (sid > 0)
        {
            XpGridRole roleModel = roleServices.getRole(sid);
            model.addAttribute("model", roleModel);
        }
        else
        {
            message = "角色不存在";
        }
        model.addAttribute("message", message);
        return "malladmin/Role/edit";
    }

    @PostMapping("/edit")
    public String edit(int sid)
    {
        String roleName = request.getParameter("roleName");
        String roleDes = request.getParameter("roleDes");
        //更新记录
        roleServices.edit(sid, roleName, roleDes);
        //返回上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);
        refer = "redirect:" + refer;
        return refer;
    }

    @RequestMapping("/roleAuthorization")
    public String roleAuthorization(int sid,String message,Model model)
    {
        //返回上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);

        XpGridRole roleModel = roleServices.getRole(sid);
        if(model == null )
        {
            //异常，没有找到角色。 // 直接返回了，提示信息怎么弄 ？
            return refer;
        }
        //添加roleMdel 到视图
        model.addAttribute("model",roleModel);
        model.addAttribute("refer",refer);
        //这个List 到前台一样循环
        List<LinkedHashMap<String,Object>>  list = roleServices.roleAuthorizationFunc(sid);

        model.addAttribute("list",list);
        model.addAttribute("message",message);
        //region
//        System.out.println("============begin ===========");
//        for (LinkedHashMap<String, Object> m : list)
//        {
//            System.out.println("-----------begin  ----------");
//            for (String k : m.keySet())
//            {
//                System.out.println(k + " : " + m.get(k));
//            }
//            System.out.println("-----------end  ----------");
//        }
//        System.out.println("============end ===========");

        //endregion
        return "malladmin/Role/roleAuthorization";
    }

    @RequestMapping("/authorizationChange")
    public String authorizationChange(String[] pmIdList, int sid , RedirectAttributes attr)
    {
        String message = "";
        XpGridRole roleModel = roleServices.getRole(sid);
        if(roleModel == null)
        {
            message = "没有找到角色！";
            //跳转也保存值 RedirectAttributes
            //attr.addFlashAttribute("message", message);
            attr.addAttribute("message",message);
            //转向
            return "malladmin/Role/roleAuthorization";
        }
        //修改授权
        if (roleServices.roleAuthorizationChange(sid, pmIdList))
            message = "修改成功";

        attr.addAttribute("message", message);
        attr.addAttribute("sid",sid);
        String refer = "redirect:roleAuthorization" ;

        return refer;
    }

    @RequestMapping("/funcliste")
    public String funcliste()
    {
        return "malladmin/Role/funcliste";
    }

    @ResponseBody
    @RequestMapping("/MyDataBing")
    public Map<String, Object> MyDataBing(String key,
                             @RequestParam(value = "sortField", required = false, defaultValue = "") String sortField,
                             @RequestParam(value = "sortOrder", required = false, defaultValue = "") String sortOrder,
                             @RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex ,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize
                             )
    {
        //分页
        if (pageSize <= 0)
        {
            pageSize = 1;
        }
        //脚标从 1 开始
        pageIndex += 1;

        if (sortField.equals(""))
        {
            sortField = " FuncCode ";
        }
        if (sortOrder.equals(""))
        {
            sortOrder = " asc ";
        }
        sortField = sortField + " " + sortOrder;

        //查询条件
        String filter = "";

        //filter = " where 1=1 ";

        if (key != null && !key.equals(""))
        {
            if (filter.length() > 1)
            {
                filter += " and ";
            }
            filter += " FuncCode like '%" + key + "%' ";
        }

        //返回总页数、总记录数
        //int totalPage;
        int totalRecord = 0 ;
        //分页查询
        int totalpage = 0;

        Map  map  = rdbsHelper.ExecutePaging("xpGrid_Functions","*",sortField,filter,pageSize,pageIndex,totalpage,totalRecord);

        //List<LinkedHashMap<String,Object>>  list   = (List<LinkedHashMap<String,Object>>)map.get("list");
        List<XpGridFunctions> list  = (List<XpGridFunctions> )map.get("list");
        totalRecord = (int)map.get("totalRecord");

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("data", list);
        resultMap.put("total",totalRecord);
        return resultMap;

    }



    @RequestMapping(value="/saveChanged")
    @ResponseBody
    public void saveChanged(String data){

        String json = data;

        List<HashMap> list = (List<HashMap>)JSON.parseArray(json, HashMap.class);
        for(HashMap row : list)
        {
            String state  = row.get("_state").toString();

            if (state.equals("added"))
            {
                //添加
                addNewRow(row);
            }
            else if (state.equals( "removed") || state.equals("deleted"))
            {
                //删除
                String sid = row.get("FuncCode").toString();
                //Roles.DeleteFunc(sid);
                int  i  = roleServices.deleteFunc(sid);

               int  ii= 5 ;

            }
            else if (state.equals("modified"))
            {
                //修改
                editRow(row);
            }
        }

        // ToObject 获取方法
//        ArrayList list = (ArrayList) JSON.parseArray(json, Object.class);
//        for(int i=0;i<list.size();i++){
//            //JSONObject job = list.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//            JSONObject job = (JSONObject) JSON.parse(String.valueOf(list.get(i)));
//
//            String state  = job.getString("_state");//取值name的值
//            String aa = "e";
//        }

    }

    public void editRow(HashMap row)
    {
        XpGridFunctions model = new XpGridFunctions();
        model.setFunccode(row.get("FuncCode").toString());
        if(row.get("FuncName") != null)
        {
            model.setFuncname(row.get("FuncName").toString());
        }
        else
        {
            model.setFuncname(null);
        }
        if(row.get("FuncUrl") != null){model.setFuncurl(row.get("FuncUrl").toString());}else{model.setFuncurl(null);}
        if(row.get("FuncParent") != null)
        {
            model.setFuncparent(row.get("FuncParent").toString());
        }
        if(row.get("FuncImg") != null)
        {
            model.setFuncimg(row.get("FuncImg").toString());
        }
        else
        {
            model.setFuncimg(null);
        }
        model.setEnable(0);
        if(row.get("DisplayOrder") != null)
        {
            model.setDisplayorder((int)row.get("DisplayOrder"));
        }
        else
        {
            model.setDisplayorder(null);
        }

        xpGridRoleDao.updateFunc(model);
    }

    public void addNewRow(HashMap row)
    {
        XpGridFunctions model = new XpGridFunctions();
        model.setFunccode(row.get("FuncCode").toString());
        if(row.get("FuncName") != null)
        {
            model.setFuncname(row.get("FuncName").toString());
        }
        if(row.get("FuncUrl") != null)
        {
            model.setFuncurl(row.get("FuncUrl").toString());
        }
        if(row.get("FuncParent") != null)
        {
            model.setFuncparent(row.get("FuncParent").toString());
        }
        if(row.get("FuncImg") != null)
        {
            model.setFuncimg(row.get("FuncImg").toString());
        }
        model.setEnable(0);
        if(row.get("DisplayOrder") != null)
        {
            model.setDisplayorder((int)row.get("DisplayOrder"));
        }
        xpGridRoleDao.addFunc(model);
    }


    /// <summary>
    /// 是否已经存在
    /// </summary>
    /// <param name="mouldId"></param>
    /// <returns></returns>
    @RequestMapping("/isExistsFuncCodeAjax")
    @ResponseBody
    public String isExistsFuncCodeAjax(@RequestParam(value = "sid", required = false, defaultValue = "") String sid )
    {
        String status = "0";
        if(roleServices.isExistsFunc(sid))
            status = "1";//存在

//        if (Roles.IsExistFunc(sid))
//        {
//            //存在
//            status = "1";
//        }
        //return AjaxResult("success", status, true);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "success");
        jsonObject.put("content", status);
        String value = jsonObject.toJSONString();

        return value;
    }


}

