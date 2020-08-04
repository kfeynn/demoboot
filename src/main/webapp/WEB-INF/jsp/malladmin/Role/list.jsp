<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>角色列表</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/site.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/showlist.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tabhelp.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#table>tbody>tr").click(function () {
                $(this).addClass('selected') //为选中项添加高亮
                    .siblings().removeClass('selected')//去除其他项的高亮形式
                    .end();
            });
        });
    </script>
</head>
<body>
<h1 class="rightH1">
    角色管理 &gt;&gt; 角色列表
    <div class="right">
        <a href="${pageContext.request.contextPath}/malladmin/Role/add" class="menuBT"><img src="${pageContext.request.contextPath}/images/add.jpg" />添加</a>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</h1>
<form action="${pageContext.request.contextPath}/malladmin/Role/list" method="post">
    <div class="dataListSearch">
        <table height="32">
            <tbody>
            <tr>
                <td width="35"><img id="searchImg" src="${pageContext.request.contextPath}/images/search1.gif" /></td>
                <td>
                    &nbsp;&nbsp;&nbsp;角色名：
                </td>
                <td width="110">
                    <input height="18" id="roleName" name="roleName" type="text" value="" />
                </td>
                <td>
                </td>
                <td width="110">
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
        <table style="width:100%">
            <thead>
            <tr>
                <th width="10"></th>
                <th width="180" align="left">角色名称</th>
                <th align="left">备注</th>
                <th width="150">编辑</th>
                <th width="150">删除</th>
                <th width="150">分配权限</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="row" >
            <tr>
                <td></td>
                <td>${row.rolename}</td>
                <td>${row.roledes}</td>
                <td><a class="editOperate" href="${pageContext.request.contextPath}/malladmin/Role/edit?sid=${row.roleid}">[编辑]</a></td>
                <td><a class="editOperate" href="${pageContext.request.contextPath}/malladmin/Role/delete?sid=${row.roleid}" onclick = "if(!confirm('您确认要删除该内容吗?')) return false;">[删除]</a></td>
                <td><a class="editOperate" href="${pageContext.request.contextPath}/malladmin/Role/roleAuthorization?sid=${row.roleid}">[分配权限]</a></td>
            </tr>
        </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="dataListEdit">
        <div class="page">
            <%--分页导航条 --%>
            ${pageHelper}
        </div>
    </div>
</form>

</body>
</html>
