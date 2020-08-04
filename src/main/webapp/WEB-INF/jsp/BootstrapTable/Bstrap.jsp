<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2020/7/15
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BootstrapTable Test</title>

    <!--@*1、Jquery组件引用*@-->
    <!--[if !IE]> -->
    <script src="${pageContext.request.contextPath}/Content/assets/js/jquery-2.1.4.min.js"></script>

    <!--@*2、bootstrap组件引用*@-->
    <script src="${pageContext.request.contextPath}/Content/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/bootstrap.min.css" /><!-- Url.Content 路径取绝对路径 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!--@*3、bootstrap table组件以及中文包的引用*@-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/BootstrapTable/bootstrap-table.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="${pageContext.request.contextPath}/BootstrapTable/bootstrap-table.min.js"></script>
    <!-- Latest compiled and minified Locales -->
    <script src="${pageContext.request.contextPath}/BootstrapTable/locale/bootstrap-table-zh-CN.min.js"></script>


    <%--  --%>


</head>
<body>


<div class="content-wrapper">
    <div class="container-fluid">
        <%--PageContext值 ，给js获取使用--%>
        <input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="header-line">供应商送货单维护&nbsp--&nbsp打印记录</h4>

                    </div>
                    <div class="panel-body" >
                        <div id="table_respon" class="table-responsive">
                            <div class="table-toolbar" style="width: 98%;">
                                <div class="navbar-form navbar-right" role="search"  style=" margin-left:0px;margin-top:0;padding-left:0;">
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


<!-- 模态框 显示子表信息  -->
<div class="modal" id="modal_detail" tabindex="-1" role="dialog"
     aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 1000px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">送货单明细</h4>
            </div>
            <div class="modal-body" style="height:400px;">
                <h4>送货单号：<span></span></h4>
                <table id="modal_table" class="table text-nowrap table-striped table-bordered table-hover table-condensed" role="table">
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 模态框显示PDF1（Modal） -->
<div class="modal fade" id="modal_pdf" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" >选择要显示的PDF文档</h4>
            </div>
            <div class="modal-body">
                <label>送货单号：<strong id="sendId"></strong></label>
                <label>供应商id：<strong id="sendSupid"></strong></label>
                <div style="border: 1px solid #dddddd;padding:2px 10px 0px 10px;" >
                    <label class="checkbox-inline">
                        <input type="radio" name="pdfType" value="0" checked> 送货单
                    </label>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="btnShowPdf">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- 模态框（显示pdf） -->
<div class="modal" id="modal_showpdf" tabindex="-1" role="dialog"
     aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 600px; ">
            <div class="modal-body" style="height: 500px;">
                <div id="pdfDiv" style="height: 100%;"></div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/bootstraptable/bstrap.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/PdfJS/pdfobject.js"></script>

<!-- iframe 高度设置 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/iframe.js"></script>

</body>
</html>
