<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2019/7/22
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>修改密码</title>
    <!--响应式设置，自动检测客户端设备-->
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/bootstrap/validator/css/bootstrapValidator.css" />
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
    <!--------------------------------------------- basic scripts -------------------------------------------->
    <!--[if !IE]> -->
    <script src="${pageContext.request.contextPath}/Content/assets/js/jquery-2.1.4.min.js"></script>
    <!-- <![endif]-->
    <!--[if IE]>
    <script src="assets/js/jquery-1.11.3.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/Content/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
    </script>
    <script src="${pageContext.request.contextPath}/Content/assets/js/bootstrap.min.js"></script>
    <!-- page specific plugin scripts -->
    <!--[if lte IE 8]>
    <script src="${pageContext.request.contextPath}/Content/assets/js/excanvas.min.js"></script>
    <![endif]-->
    <!--------------------------------------------- basic scripts end ----------------------------------------->
    <!--bootstrap 表单验证插件-->
    <script src="${pageContext.request.contextPath}/Content/bootstrap/validator/js/bootstrapValidator.min.js"></script>
    <script src="${pageContext.request.contextPath}/Content/bootstrap/validator/js/language/zh_CN.js"></script>
    <style type="text/css">
        html, body {
            background-color: white;
        }
    </style>

</head>

<body>

<div class="page-header">
    <h1>
        修改密码
    </h1>
</div><!-- /.page-header -->

<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="position-relative">
                        <div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="ace-icon fa fa-users blue"></i>
                                        Reset Password
                                    </h4>
                                    <div class="space-6"></div>
                                    <form id="defaultForm" name="resetPwd" action="" method="post">
                                        <fieldset>
                                            <div class="space-24"></div>
                                            <div class="form-group">
                                                <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="password" class="form-control" name="password"  placeholder="New Password"
                                                                   required=required data-bv-notempty-message="The password is required and cannot be empty"
                                                                   data-bv-identical="true" data-bv-identical-field="confirmPassword" data-bv-identical-message="密码输入不一致"
                                                            />
                                                            <i class="ace-icon fa fa-lock"></i>
                                                        </span>
                                                </label>
                                            </div>
                                            <div class="form-group">
                                                <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">

                                                            <input type="password" class="form-control" name="confirmPassword"  placeholder="Repeat password"
                                                                   required=required data-bv-notempty-message="The confirm password is required and cannot be empty"
                                                                   data-bv-identical="true" data-bv-identical-field="password" data-bv-identical-message="密码输入不一致" />
                                                            <i class="ace-icon fa fa-retweet"></i>
                                                        </span>
                                                </label>
                                            </div>

                                            <div class="clearfix">
                                                <button type="reset" class="width-30 pull-left btn btn-sm">
                                                    <i class="ace-icon fa fa-refresh"></i>
                                                    <span class="bigger-110">Reset</span>
                                                </button>
                                                <button type="submit" class="width-65 pull-right btn btn-sm btn-success">
                                                    <span class="bigger-110">确定修改</span>
                                                    <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                </button>
                                            </div>
                                            <div class="clearfix">
                                                ${message}
                                            </div>
                                            <div class="space-24"></div>

                                        </fieldset>

                                    </form>
                                </div>
                            </div><!-- /.widget-body -->
                        </div><!-- /.signup-box -->
                    </div><!-- /.position-relative -->

                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.main-content -->
</div><!-- /.main-container -->

<!-- iframe 高度设置 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/iframe.js"></script>
</body>

</html>


<script type="text/javascript">

    $(function () {
        $('#defaultForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                password: {
                    message: '密码验证失败',
                    validators: {
                        notEmpty: {
                            message: '不能为空'
                        },
                        stringLength: {  //长度限制
                            min: 4,
                            //max: 18,
                            message: '必须在4位以上'
                        }
                    }
                }
            }
        });
    });


</script>