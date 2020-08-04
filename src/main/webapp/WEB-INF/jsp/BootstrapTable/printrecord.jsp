<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="com.grand.supplierWeb.user.User" />
<jsp:directive.page import="com.grand.supplierWeb.po.PO" />
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>格兰达供应商管理平台</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/bootstrap-table.css" rel="stylesheet" />
    <!-- FONT AWESOME STYLE  -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <style type="text/css">
        [class^="icon-"],
        [class*=" icon-"] {
            font-family: FontAwesome;
            font-weight: normal;
            font-style: normal;
            text-decoration: inherit;
            -webkit-font-smoothing: antialiased;
            *margin-right: .3em;
        }

        [class^="icon-"],
        [class*=" icon-"] {
            display: inline;
            width: auto;
            height: auto;
            line-height: normal;
            vertical-align: baseline;
            background-image: none;
            background-position: 0% 0%;
            background-repeat: repeat;
            margin-top: 0;
        }
    </style>
    <%-- ${message} --%>
</head>



<body>

<!-- LOGO HEADER END-->
<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="header-line">供应商送货单维护</h4>
                        <span>&nbsp--&nbsp打印记录</span>
                    </div>
                    <div class="panel-body">
                        <div id="table_respon" class="table-responsive">
                            <div class="table-toolbar">
                                <div class="navbar-form navbar-right" role="search" style="margin-left:8px;margin-top:0;padding-left:0;">
                                    <div class="form-group">
                                        <input id="content" type="text" class="form-control" placeholder="料件编号">
                                    </div>
                                    <button type="button" id="searchOrderBtn" class="btn btn-default btn-search">查找</button>
                                </div>
                            </div>
                            <table id="table_sortSearchResult" class="table text-nowrap table-striped table-bordered table-hover table-condensed" role="table">
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<!-- <form action="user_add" method="post"> -->
<div class="modal" id="po_printrecord" tabindex="-1" role="dialog"
     aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 1000px;">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">送货单明细</h4>
            </div>
            <div class="modal-body" style="height:400px;">
                <h4>送货单号：<span></span></h4>
                <table id="delivery_note" class="table text-nowrap table-striped table-bordered table-hover table-condensed" role="table">
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="selectPdfDialod" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">选择要显示的PDF文档</h4>
            </div>
            <div class="modal-body">
                <label  >送货单号：<strong id="sendId"></strong></label>
                <label  >供应商id：<strong id="sendSupid"></strong></label>
                <div style="border: 1px solid #dddddd;" >
                    <label class="checkbox-inline">
                        <input type="radio" name="pdfType" value="0" checked> 送货单
                    </label>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="selectPdf">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal" id="pdfModalDialog" tabindex="-1" role="dialog"
     aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 600px; ">
            <div class="modal-body" style="height: 600px;">
                <div id="pdfDiv" style="height: 100%;"></div>
            </div>
        </div>
    </div>
</div>








<!-- </form> -->
<!-- FOOTER SECTION END-->
<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
<!-- CORE JQUERY  -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS  -->
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/dataTables/bootstrap-table.js"></script>
<script src="assets/js/dataTables/bootstrap-table-export.js"></script>
<script src="assets/js/dataTables/bootstrap-table-toolbar.js"></script>
<script src="assets/js/dataTables/bootstrap-table-zh-CN.js"></script>
<script src="assets/js/dataTables/tableExport.js"></script>
<script src="assets/js/custom.js"></script>
<script src="assets/js/pdfobject.js"></script>
<script src="assets/js/printRecord.js"></script>


</body>
</html>
