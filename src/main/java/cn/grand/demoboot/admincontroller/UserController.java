package cn.grand.demoboot.admincontroller;

import cn.grand.demoboot.dao.XpGridUserDao;
import cn.grand.demoboot.entity.sqlserver.XpGridUser;
import cn.grand.demoboot.entity.supplier.SupplierLogin;
import cn.grand.demoboot.helper.CookieHelper;
import cn.grand.demoboot.helper.PageHelper;
import cn.grand.demoboot.helper.RDBSHelper;
import cn.grand.demoboot.helper.SupRDBSHelper;
import cn.grand.demoboot.helper.base.PageModel;
import cn.grand.demoboot.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/malladmin/User")
public class UserController
{
    @Autowired
    UserServices userServices;
    @Autowired
    XpGridUserDao xpGridUserDao;
    @Autowired
    RDBSHelper rdbsHelper;
    @Autowired
    SupRDBSHelper supRDBSHelper;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping("/list")
    public String list(String userName,
                       @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
                       Model model)
    {
        //System.out.println(1/0);
        //获取数据
        int totalpage =0;
        int totalRecord = 0;

        Map  map  = rdbsHelper.ExecutePaging("xpGrid_User","*","userid asc","1=1",pageSize,pageNumber,totalpage,totalRecord);

        //List<LinkedHashMap<String,Object>>  list   = (List<LinkedHashMap<String,Object>>)map.get("list");
        List<XpGridUser> list  = (List<XpGridUser>)map.get("list");
        totalRecord = (int)map.get("totalRecord");
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
                userName));

        //大小写敏感！！！
        return "malladmin/User/list";
    }

    @GetMapping("/add")
    public String add(Model model)
    {
        //上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);
        model.addAttribute("refer", refer);

        return "malladmin/User/add";
    }

    @PostMapping("/add")
    public String add(String UserName, String UserCName, boolean AddFlag, Model model)
    {
        String message = "";
        if (UserName != null)
        {
            System.out.println("添加User信息" + UserName);
            try
            {

                XpGridUser iModel = new XpGridUser();
                iModel.setUsername(UserCName);
                iModel.setUsercname(UserCName);
                iModel.setPassword("123456");
//                iModel.setOnline(0);
                iModel.setDeleted(0);
//                iModel.setAllonlinetime(0);

                xpGridUserDao.insert(iModel);

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
            return "malladmin/User/add";
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
        xpGridUserDao.delete(sid);
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
            XpGridUser iModel = xpGridUserDao.getModelByUserID(sid);
            model.addAttribute("model", iModel);
        }
        else
        {
            message = "用户不存在";
        }
        model.addAttribute("message", message);
        return "malladmin/User/edit";
    }

    @PostMapping("/edit")
    public String edit(int sid, boolean isdeleted)
    {
        String UserName = request.getParameter("UserName");
        String UserCName = request.getParameter("UserCName");
        XpGridUser iModel = xpGridUserDao.getModelByUserID(sid);
        if(iModel !=null)
        {
            iModel.setUsername(UserName);
            iModel.setUsercname(UserCName);
            if(isdeleted)
                iModel.setDeleted(1);
            else
                iModel.setDeleted(0);
        }
        //更新记录
        xpGridUserDao.edit(iModel);
        //返回上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);
        refer = "redirect:" + refer;
        return refer;
    }

    @RequestMapping("/userAuthorization")
    public String userAuthorization(int sid,String message, Model model)
    {
        //返回上一级目录
        String refer = CookieHelper.getMallAdminRefererCookie(request);

        XpGridUser iModel = xpGridUserDao.getModelByUserID(sid);
        if(model == null )
        {
            //异常，没有找到用户
            return refer;
        }
        //添加roleMdel 到视图
        model.addAttribute("model",iModel);
        model.addAttribute("refer",refer);
        //这个List 到前台一样循环
        List<LinkedHashMap<String,Object>>  list = userServices.userAuthorizationRoleList(sid);

        model.addAttribute("list",list);
        model.addAttribute("message",message);

        return "malladmin/User/userAuthorization";
    }

    @RequestMapping("/authorizationChange")
    public String authorizationChange(int[] pmIdList, int sid , RedirectAttributes attr)
    {
        String message = "";
        XpGridUser roleModel = xpGridUserDao.getModelByUserID(sid);
        if(roleModel == null)
        {
            message = "没有找到用户！";
            //跳转也保存值 RedirectAttributes
            //attr.addFlashAttribute("message", message);
            attr.addAttribute("message",message);
            //转向
            return "malladmin/User/userAuthorization";
        }
        //修改授权
        if (userServices.userAuthorizationChange(sid, pmIdList))
            message = "修改成功";

        attr.addAttribute("message", message);
        attr.addAttribute("sid",sid);
        String refer = "redirect:userAuthorization" ;

        return refer;
    }

    @GetMapping("/changepassword")
    public String changepassword(Model model)
    {
        //model.addAttribute("message","进入方法！");
        return "malladmin/User/changepassword";
    }

    @PostMapping("/changepassword")
    public String changepassword(String password,String confirmPassword,Model model) throws Exception
    {
        String message = "";
        if(!password.equals(confirmPassword))
        {
            message = "两次输入密码不一致！";
        }
        //获取用户id
        int uid = CookieHelper.getSidCookie(request);
        //更新密码
        XpGridUser iModel = xpGridUserDao.getModelByUserID(uid);
        iModel.setPassword(password);
        xpGridUserDao.edit(iModel);
        message = "更改密码成功";

        model.addAttribute("message",message);

        return "malladmin/User/changepassword";
    }

    @RequestMapping("/suplist")
    public String suplist(String supid,
                       @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
                       Model model)
    {
        //System.out.println(1/0);
        //获取数据
        int totalpage =0;
        int totalRecord = 0;


        Map  map  = supRDBSHelper.ExecutePaging("supplierlogin","id asc"," where 1=1",pageSize,pageNumber,totalRecord);

        //List<LinkedHashMap<String,Object>>  list   = (List<LinkedHashMap<String,Object>>)map.get("list");
        List<SupplierLogin> list  = (List<SupplierLogin>)map.get("list");
        totalRecord = (int)map.get("totalRecord");
        model.addAttribute("list", list);
        //页脚Model
        PageModel pageModel = new PageModel(pageSize, pageNumber, totalRecord);
        String pageHelper = new PageHelper(pageModel).toString();
        model.addAttribute("pageHelper", pageHelper);

        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumber", pageNumber);

        //记录本次访问地址， 用于返回上一层。
        CookieHelper.setAdminRefererCookie(request, response, String.format("%s?pageNumber=%s&pageSize=%s&supid=%s",
                "suplist", String.valueOf(pageModel.getPagenumber()), String.valueOf(pageModel.getPagesize()),
                supid));

        //大小写敏感！！！
        return "malladmin/User/suplist";
    }

}

