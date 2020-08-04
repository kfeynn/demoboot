<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2019/6/12
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <!--响应式设置，自动检测客户端设备-->
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <title>主页</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon" />
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/bootstrap.min.css" /><!-- Url.Content 路径取绝对路径 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
    <!-- page specific plugin styles -->
    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/fonts.googleapis.com.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-rtl.min.css" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-ie.min.css" />
    <![endif]-->
    <!-- inline styles related to this page -->
    <!-- ace settings handler -->
    <script src="${pageContext.request.contextPath}/Content/assets/js/ace-extra.min.js"></script>
    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
    <!--[if lte IE 8]>
    <script src="${pageContext.request.contextPath}/Content/assets/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/Content/assets/js/respond.min.js"></script>
    <![endif]-->
    </head>

    <body class="no-skin">
        <!-- 头部导航栏 固定在顶部 navbar  navbar-default    navbar-fixed-top       ace-save-state -->
        <div id="navbar" class="navbar navbar-default navbar-fixed-top ">
        <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
        <span class="sr-only">Toggle sidebar</span>

    <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
        <a href="${pageContext.request.contextPath}/" class="navbar-brand">
    <small>
    <i class="fa fa-leaf"></i>
        My Tiptop
    </small>
    </a>
    </div>
    <div class="navbar-buttons navbar-header pull-right" role="navigation">
        <ul class="nav ace-nav">
            <li class="light-blue dropdown-modal">
                <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                    <img class="nav-user-photo" src="${pageContext.request.contextPath}/Content/assets/images/avatars/user.jpg" alt="Jason's Photo" />
                    <span class="user-info">
                        <small>欢迎,</small>
                        ${userCName}
                    </span>
                    <input type="hidden" id="userId" value="${userId}">
                    <i class="ace-icon fa fa-caret-down"></i>
                </a>
                <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                    <li>
                        <a href="#">
                            <i class="ace-icon fa fa-cog"></i>
                            Settings
                        </a>
                    </li>
                    <li>
                        <a href="profile.html">
                            <i class="ace-icon fa fa-user"></i>
                            Profile
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/Account/logout">
                            <i class="ace-icon fa fa-power-off"></i>
                            退出
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    </div><!-- /.navbar-container -->
    </div>

    <div class="main-container ace-save-state" id="main-container">
        <script type="text/javascript">
    try{ace.settings.loadState('main-container')}catch(e){}
    </script>
    <!-- 左侧导航栏 -->
    <div id="sidebar" class="sidebar  responsive ace-save-state">
        <script type="text/javascript">
            try{ace.settings.loadState('sidebar')}catch(e){}
        </script>

        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
            <!-- 更换皮肤 -->
            <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                <button class="btn btn-success" id="btn-no-skin">
                    <i class="glyphicon glyphicon-music"></i>
                </button>
                <button class="btn btn-info" id="btn-skin-1">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>
                <button class="btn btn-warning"  id="btn-skin-2">
                    <i class="ace-icon fa fa-users"></i>
                </button>
                <button class="btn btn-danger"  id="btn-skin-3">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>
            </div>

            <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>
                <span class="btn btn-info"></span>
                <span class="btn btn-warning"></span>
                <span class="btn btn-danger"></span>
            </div>
        </div><!-- /.sidebar-shortcuts -->
        <ul class="nav nav-list">
            <c:forEach items="${menuList}" var="info" >
                <c:if test ="${info.funcparent == '00'}">
                <li class="">
                <c:if test ="${info.funcurl != null && info.funcurl != ''}">
                    <%--没有子目录--%>
                    <a href="${pageContext.request.contextPath}/${info.funcurl}" target="menuFrame">
                    <i class="${info.funcimg}"></i>
                    <span class="menu-text">${info.funcname}</span>
                    </a>
                    <b class="arrow"></b>
                </c:if>
                <c:if test="${info.funcurl == null || info.funcurl == ''}">
                    <%--包含子目录--%>
                    <a href="${pageContext.request.contextPath}/${info.funcurl}" class="dropdown-toggle">
                    <i class="${info.funcimg}"></i>
                    <span class="menu-text">${info.funcname}</span>
                    <b class="arrow fa fa-angle-down"></b>
                    </a>
                    <b class="arrow"></b>
                    <ul class="submenu">
                        <c:forEach items="${menuList}" var="subinfo" >
                            <c:if test ="${subinfo.funcparent == info.funccode}">
                            <c:if test ="${subinfo.funcurl != null && subinfo.funcurl != ''}">
                            <li class="">
                                <a href="${pageContext.request.contextPath}/${subinfo.funcurl}" target="menuFrame">
                                <i class="menu-icon fa fa-caret-right"></i>
                                        ${subinfo.funcname}
                                <span class="badge badge-primary"></span>
                                </a>
                                <b class="arrow"></b>
                            </li>
                            </c:if>
                            <c:if test ="${subinfo.funcurl == null || subinfo.funcurl == ''}">
                            <li class="">
                                <a href="#" target="menuFrame">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                        ${subinfo.funcname}
                                    <span class="badge badge-primary"></span>
                                </a>
                                <b class="arrow"></b>
                            </li>
                            </c:if>
                            </c:if>
                        </c:forEach>
                    </ul>
                </c:if>
                </li>
                </c:if>
            </c:forEach>
        </ul>
        <!-- /.nav-list -->
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>

    <!-- 右侧内容栏 -->
    <div class="main-content" style="margin-bottom:0px;">
        <div class="main-content-inner"  style="margin-bottom:0px;">
            <!-- 面包屑路径条-->
            <div class="breadcrumbs ace-save-state" id="breadcrumbs" style="margin-bottom:0px;">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="${pageContext.request.contextPath}/Home/Default">Home</a>
                    </li>
                    <li class="active"></li>
                </ul>
                <div class="nav-search" id="nav-search">
                    <form class="form-search">
                            <span class="input-icon">
                                <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
                                <i class="ace-icon fa fa-search nav-search-icon"></i>
                            </span>
                    </form>
                </div>
            </div>
            <!--iframe框架容器-->
            <div class="page-content"  style="margin-left:0px; margin-bottom:0px;">
                <iframe id="menuFrame" name="menuFrame" src="${pageContext.request.contextPath}/Home/mallruninfo" style="overflow: visible;"
                scrolling="no" frameborder="0"  width="100%" height="650"></iframe>
            </div>
            <!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
    <!--页脚样式 -->
    <%--@Html.Partial("_footerace")--%>
        <jsp:include page="../../Home/footer.jsp" />
    </div><!-- /.main-container -->

    <!-- 模态框（Modal）<div class="modal-body" style="font-size: 5px;height: 80%;overflow-y: scroll;"> -->
    <div class="modal fade bs-example-modal-sm" id="iModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        <span id="ititle">Title</span>
                    </h4>
                </div>
                <div class="modal-body">
                    <span id="icontent">提示信息，休息</span> <span id="timer">5</span> 秒
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        关闭
                    </button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
    <!--------------------------------------------- basic scripts -------------------------------------------->
    <!--[if !IE]> -->
    <script src="${pageContext.request.contextPath}/Content/assets/js/jquery-2.1.4.min.js"></script>
    <!-- <![endif]-->
    <!--[if IE]>
    <script src="${pageContext.request.contextPath}/Content/assets/js/jquery-1.11.3.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/Content/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
    </script>
    <script src="${pageContext.request.contextPath}/Content/assets/js/bootstrap.min.js"></script>
    <!-- page specific plugin scripts -->
    <!--[if lte IE 8]>
    <script src="${pageContext.request.contextPath}/Content/assets/js/excanvas.min.js"></script>
    <![endif]-->
    <!-- ace scripts -->
    <script src="${pageContext.request.contextPath}/Content/assets/js/ace-elements.min.js"></script>
    <script src="${pageContext.request.contextPath}/Content/assets/js/ace.min.js"></script>
    <!-- 自定义js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/home/default.js"></script>
    <script type="text/javascript">
        function openMotal(title,content,ltime) {
            //$(‘#myModal’).modal({backdrop: 'static', keyboard: false});
            //其中 ，backdrop：'static' 指的是点击背景空白处不被关闭；
            //keyboard:false指的是触发键盘esc事件时不关闭。
            $("#iModal").modal({ backdrop: 'static', keyboard: false });  //手动开启
            //5秒自动关闭
            //setTimeout("$('#myModal').modal('hide')", 5000);//5s延时自动关闭
            var time = ltime; //5; //设置时间为几秒
            var timer = document.getElementById('timer'); //获取ID为timer的对象
            timer.innerHTML = time; //初始化显示秒数
            var hcontent = document.getElementById('icontent'); //获取ID为timer的对象
            var htitle = document.getElementById('ititle'); //获取ID为timer的对象
            hcontent.innerHTML = content;
            htitle.innerHTML = title;
            var g = window.setInterval(function () {
                if (time <= 1) {
                    $('#iModal').modal('hide');  //关闭
                    window.clearInterval(g);     //关闭计时器 ，使页面不重新加载时 ，可重复利用
                } else {
                    showTime();
                }
            }, 1000);
            //显示函数
            function showTime() {
                time--;
                timer.innerHTML = time;
            }
        }
    </script>
    </body>
</html>


