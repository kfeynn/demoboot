<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2019/7/19
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>添加用户</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/site.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/jquery-3.1.1.intellisense.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.extend.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tabhelp.js"></script>

    <script type="text/javascript">
        $(function(){
            //启用jquery表单验证
            $("form:first").validate();
            $(".addTag li").click(function(){
                $(".addTag li").removeClass("hot");
                $(this).addClass("hot");
                $(".addTable").hide().eq($(this).index()).show(0);
            })
            $(".addBt").click(function(){
                if (true) {
                    $("form:first").submit();
                    return false;
                }
                else {
                    //阻止页面再刷新
                    return false;
                }
            })
        });
    </script>
</head>
<body>
<h1 class="rightH1">
    用户管理 &gt;&gt; 添加用户
    <div class="right">
        <a href="${refer}" class="menuBT"><img src="${pageContext.request.contextPath}/images/goback.jpg" />返回列表</a>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</h1>
<ul class="addTag">
    <li class="hot"><a href="javascript:;">基本信息</a></li>
    <li><a href="javascript:;">扩展信息</a></li>
    <div class="clear"></div>
</ul>
<form action="${pageContext.request.contextPath}/malladmin/User/add" method="post">
<div class="addTable">
    <table width="100%">
        <tr>
            <td width="86px" align="right">连续添加：</td>
            <td><input id="AddFlag" name="AddFlag" type="checkbox" checked="checked" /></td>
        </tr>
        <tr>
            <td width="86px" align="right">工号：</td>
            <td>
                <input class="input"  name="UserName"  size="35" type="text" value=""  class="{required:true,minlength:5,maxlength:40}" />
            </td>
        </tr>
        <tr>
            <td align="right">姓名：</td>
            <td><input class="input"    name="UserCName" size="35" type="text" value="" /></td>
        </tr>
        <tr>
            <td align="right">&nbsp;</td>
            <td>
                <a href="" class="addBt" id="sumbitBut1"><img src="${pageContext.request.contextPath}/images/submit.jpg" /></a>
                <label id="lblMessage"></label> ${message} <!-- 有提示信息就显示 -->
            </td>
        </tr>
        <tr>
            <td align="right">&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>
</div>
</form>

<!-- iframe 高度设置 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js//home/iframe.js"></script>

</body>

</html>

