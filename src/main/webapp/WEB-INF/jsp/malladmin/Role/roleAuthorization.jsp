<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2019/1/17
  Time: 16:00
  To change this template use File | Settings | File Templates.
  角色分配权限
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>角色授权</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/site.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/showlist.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tabhelp.js"></script>
</head>
<body>
<h1 class="rightH1">
    角色管理 &gt;&gt; 角色授权
    <div class="right">
        <a href="${refer}" class="menuBT"><img src="${pageContext.request.contextPath}/images/goback.jpg" />返回列表</a>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</h1>

<form action="${pageContext.request.contextPath}/malladmin/Role/roleAuthorization" method="post">
    <div class="dataListSearch">
        <table height="32">
            <tbody>
            <tr>
                <td width="35"><img id="searchImg" src="${pageContext.request.contextPath}/images/search1.gif" /></td>
                <td>
                    &nbsp;&nbsp;&nbsp;角色名：
                </td>
                <td width="110">
                    <%--@Html.TextBox("roleName", Model.role.RoleName, new { height = "18" })--%>
                    <%--@Html.Hidden("rid", @Model.role.RoleId)--%>
                    <input height="18" id="roleName" name="roleName" type="text" value="${model.rolename}" />
                    <input id="sid" name="sid" type="hidden" value="${model.roleid}" />
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
    <div  id="categoryTree">
        <table   style="width:100%" >
            <thead>
            <tr>
                <th width="30"></th>
                <th width="40" align="center"><input type="checkbox" id="allSelect" /></th>
                <th width="150">功能权限</th>
                <th align="left">功能权限名称</th>
            </tr>
            </thead>
            <tbody>
            <%--循环 List<LinkedHashMap<String,Object>> --%>
            <c:forEach var="row" items="${list}" >
                <c:if test ="${fn:length(row.FuncParent) < 3}">
                    <tr id="${row.FuncCode}">
                        <th>
                            <span class="open" onclick="categoryTree(this,1)"></span>
                        </th>
                        <td align="center">
                            <c:if test ="${row.checked == 1}">
                                <input type="checkbox" value="${row.FuncCode}" checked="checked" class="fcheckbox"  selectItem="true" name="pmIdList" />
                            </c:if>
                            <c:if test ="${row.checked != 1}">
                                <input type="checkbox" value="${row.FuncCode}"  class="fcheckbox"   selectItem="true" name="pmIdList" />
                            </c:if>
                        </td>
                        <td>${row.FuncCode}</td>
                        <td>${row.FuncName}</td>
                    </tr>
                </c:if>
                <c:if test ="${fn:length(row.FuncParent) >= 3}">
                    <tr style="display:none; background-color:gainsboro" name="${row.FuncParent}">
                        <td></td>
                        <td align="center">
                            <c:if test ="${row.checked == 1}">
                                <input type="checkbox" value="${row.FuncCode}" checked="checked" selectItem="true" name="pmIdList" />
                            </c:if>
                            <c:if test ="${row.checked != 1}">
                                <input type="checkbox" value="${row.FuncCode}" selectItem="true" name="pmIdList" />
                            </c:if>
                        </td>
                        <td>${row.FuncCode}</td>
                        <td>${row.FuncName}</td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div >
    <div class="dataListEdit">
        <a href="#" delUrl="${pageContext.request.contextPath}/malladmin/Role/authorizationChange" class="batch change">确   认</a>${message}
        <div class="page">
        </div>
    </div>
</form>

<!-- iframe 高度设置 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js//home/iframe.js"></script>

</body>
</html>
