<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2019/6/6
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户登录</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon" />
    <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/account.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/account.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tabhelp.js"></script>
    <script type="text/javascript">
        $(function(){
            //弹出错误提示
            var ycid = $("input:hidden[name='hid']").val();
            if (ycid != "")
            {
                alert(ycid);
            }
        });
    </script>
    <!-- 触发JS刷新-->
    <script type="text/javascript">
        function changeImg(){
            var img = document.getElementById("img");
            img.src = "${pageContext.request.contextPath}/AuthImage/authImage?date=" + new Date();;
        }
    </script>
</head>
<body>
<div id="loginTop" class="box">
    <a href="${pageContext.request.contextPath}/Home/Default" class="left"><img src="${pageContext.request.contextPath}/images/grand.png"  height="42" /></a>
    <h2>欢迎登录</h2>
    <div class="clear"></div>
</div>
<div class="box login">
    <img src="${pageContext.request.contextPath}/images/2.jpg" width="461" height="355" class="left" />
    <span><input type="hidden" name="hid" id="hid" value="${message}" /></span>
    <div class="right">
        <form name="loginForm" action="/Account/login" method="post">
            <dl>
                <dt>用户名/工号 </dt>
                <dd><input type="text" name="username" class="userName text" value="" /></dd>
            </dl>
            <dl>
                <dt>密码</dt>
                <dd><input type="password" name="password" class="passWord text" value="" /></dd>
            </dl>
            <dl>
                <dt>验证码</dt>
                <dd>
                    <input type="text" name="verifyCode" autocomplete="off" class="YZM text left" />
                    <img id="img" src="${pageContext.request.contextPath}/AuthImage/authImage" onclick="javascript:changeImg()" />
                    <a href='#' onclick="javascript:changeImg()" ><label >看不清？</label></a>
                    <div class="clear"></div>
                </dd>
            </dl>
            <div class="loginBt">
                <input  class="redBT loginIn"  type="submit" value="用户登录"/>
            </div>
            <div class="openID">
                <h4></h4>
            </div>
        </form>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>
