<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2019/7/18
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户列表</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/site.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/showlist.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tabhelp.js"></script>
</head>
<body>
<h1 class="rightH1">
    用户管理 &gt;&gt; 用户列表
    <div class="right">
        <a href="${pageContext.request.contextPath}/malladmin/User/add" class="menuBT"><img src="${pageContext.request.contextPath}/images/add.jpg" />添加</a>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</h1>
<form action="${pageContext.request.contextPath}/malladmin/User/list" method="post">
<div class="dataListSearch">
    <table height="32">
        <tbody>
        <tr>
            <td width="35"><img id="searchImg" src="${pageContext.request.contextPath}/images/search1.gif" /></td>
            <td>
                &nbsp;&nbsp;&nbsp;用户名：
            </td>
            <td width="110">
                <input height="18" id="userName" name="userName" type="text" value="" />
            </td>
            <td>
                &nbsp;&nbsp;&nbsp;姓名：
            </td>
            <td width="110">
                <input height="18" id="UserCName" name="UserCName" type="text" value="" />
            </td>
            <td></td>
            <td width="130"></td>
            <td></td>
            <td width="130"></td>
            <td></td>
            <td width="130"></td>
            <td>
                <input id="SearchUser" name="SearchUser" type="image" class="searchBut submit" src="${pageContext.request.contextPath}/images/s.jpg" />
            </td>
        </tr>
        </tbody>
    </table>
</div>

<div class="dataList">
    <table   style="width:100%" >
        <thead>
        <tr>
            <th width="10"></th>
            <th width="140" align="left">用户名</th>
            <th width="140" align="left">姓名</th>
            <th width="80">帐户禁用</th>
            <th width="80" align="left">在线情况</th>
            <th width="150" align="left">登录次数</th>
            <th width="140" align="left">最近操作时间</th>
            <th width="150" align="left">在线总计（分钟）</th>
            <th align="left">编辑</th>
            <th align="left">删除</th>
            <th width="150">分配权限</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="row" >
        <tr>
            <td></td>
            <td>${row.UserName}</td>
            <td>${row.UserCName}</td>
            <td>${row.deleted}</td>
            <td>${row.Online}</td>
            <td>${row.LoginTimes}</td>
            <td>${row.LastOprtnDateTime}</td>
            <td>${row.AllOnlineTime}</td>
            <td><a class="editOperate" href="/malladmin/User/edit?sid=${row.UserID}">[编辑]</a></td>
            <td><a class="editOperate" href="/malladmin/User/delete?sid=${row.UserID}" onclick = "if(!confirm('您确认要删除该内容吗?')) return false;">[删除]</a></td>
            <td><a class="editOperate" href="/malladmin/User/userAuthorization?sid=${row.UserID}">[分配权限]</a></td>
        </tr>
        </c:forEach>

        </tbody>
    </table>
</div >

<div class="dataListEdit">
    <div class="page">
        <%--分页导航条 --%>
        ${pageHelper}
    </div>
</div>
</form>

<!-- iframe 高度设置 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js//home/iframe.js"></script>

</body>
</html>
