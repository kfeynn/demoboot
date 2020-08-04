<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2019/6/28
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title></title>

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
    <!--------------------------------------------- basic scripts end ----------------------------------------->
    <!--miniui-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/boot.js"></script>
    <link href="${pageContext.request.contextPath}/js/miniui/themes/blue/skin.css" rel="stylesheet" type="text/css" />

    <style type="text/css">
        html, body {
        margin: 0;
        padding: 0;
        border: 0;
        width: 100%;
        height: 900px;
        overflow: hidden;
    }
    </style>
    </head>
    <body>
    <div class="mini-toolbar" style="padding: 2px; border-bottom: 0;">
        <table style="width: 100%;">
        <tr>
        <td style="width: 100%;">
        <a class="mini-button" iconcls="icon-add" onclick="addRow()" plain="true" tooltip="增加...">增加</a>
        <span class="separator"></span>
        <a class="mini-button" iconcls="icon-remove" onclick="removeRow()" plain="true">删除</a>
        <span class="separator"></span>
        <a class="mini-button" iconcls="icon-save" plain="true" onclick="saveData()">保存</a>
        <span class="separator"></span>
        </td>
        <td style="white-space: nowrap;">
        <label style="font-family: Verdana;">
        关键字:
    </label>
    <input id="key" class="mini-textbox" emptytext="请输入关键字" style="width: 150px;"  onenter="onKeyEnter" />
        <a class="mini-button" iconcls="icon-search" plain="true" onclick="search()">查询</a>
        </td>
        </tr>
        </table>
        </div>

        <div class="mini-fit">
        <div id="datagrid1" class="mini-datagrid" style="width: 99%; height: 900;" url="MyDataBing"
    idfield="FuncCode" allowresize="true" sizelist="[20,50,100,200,300]" pagesize="20" allowcelledit="true" cellEditAction="celldblclick"  oncellbeginedit="OnCellBeginEdit"
    allowcellselect="true" editnextonenterkey="true" allowcellvalid="true" multiselect="true"
    editnextrowcell="true" allowalternating="true" showcolumnsmenu="false"  headercontextmenu="#headerMenu">
        <div property="columns">
        <div type="indexcolumn"></div>
        <div type="checkcolumn"></div>

        <div field="FuncCode" name="FuncCode" width="60" align="left" headeralign="center" vtype="required" allowsort="true">
        编号<input property="editor" class="mini-textbox" style="width: 100%;" minwidth="20" />
        </div>
        <div field="FuncName" name="FuncName" width="80" align="left" headeralign="center"  vtype="required"   allowsort="true">
        名称<input property="editor" class="mini-textbox" style="width: 100%;" minwidth="20" />
        </div>
        <div field="FuncUrl" name="FuncUrl" width="230" align="left" headeralign="center"   allowsort="true">
        URL<input property="editor" class="mini-textbox" style="width: 100%;" minwidth="20" />
        </div>
        <div field="FuncParent" name="FuncParent" width="60" align="left" headeralign="center"  vtype="required"   allowsort="true">
        FuncParent<input property="editor" class="mini-textbox" style="width: 100%;" minwidth="20" />
        </div>
        <div field="FuncImg" name="FuncImg" width="120" align="left" headeralign="center" allowsort="true">
        显示图标<input property="editor" class="mini-textbox" style="width: 100%;" minwidth="20" />
        </div>
        <div field="DisplayOrder" name="DisplayOrder" width="80" align="center" headeralign="center"    allowsort="true">
        排序号<input property="editor" class="mini-textbox" style="width: 100%;" minwidth="20" />
        </div>
        </div>
        </div>
        </div>
        <!-- iframe 高度设置 -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/home/iframe.js"></script>

    </body>
</html>

<script type="text/javascript">
    mini.parse();
    var grid = mini.get("datagrid1");
    //默认查询在用数据
    grid.load();
    ///////////////////////////查询/////////////////////////////
    function search() {
        var key = mini.get("key").getValue();
        grid.load(
            {
                //传递查询参数
                key: key
            }
        );
    }
    function onKeyEnter(e) {
        search();
    }
    //如果是录入员,录入时间，则不允许编辑
    function OnCellBeginEdit(e) {
        var field = e.field;
    }
    //添加
    function addRow() {
        var newRow = { name: "New Row" };
        grid.addRow(newRow, 0);
        grid.beginEditCell(newRow, "LoginName");

    }
    //删除
    function removeRow() {
        var rows = grid.getSelecteds();
        if (rows.length > 0) {
            grid.removeRows(rows, true);
        }
    }
    //保存
    function saveData() {
        //效验数据
        //var grid = mini.get("datagrid1");
        grid.validate();
        if (grid.isValid() == false) {
            //alert("请校验输入单元格内容");
            var error = grid.getCellErrors()[0];
            grid.beginEditCell(error.record, error.column);
            return;
        }
        //获得增加、删除、修改的记录集合
        var data = grid.getChanges();
        var json = mini.encode(data);
        //mini.encode(data)          把JS对象序列化为字符串
        //mini.decode(json)            把字符串反序列化为JS对象
        var flag = true;
        var ojson = data; //mini.decode(json)

        for (var i = 0; i < ojson.length; i++) {
            var sid = ojson[i].FuncCode;

            var order = ojson[i].DisplayOrder;
            if (order!=null && order!="" && !isNumber(order)) {
                flag = false;
                alert('排序号：' + order + '非数字');
                return;
            }

            //删除动作不判断
            if (ojson[i]._state == "added") {
                //返回false 则不允许调用保存按钮 data.content
                $.ajax({
                    dataType: "json",
                    type: 'post',
                    url: '${pageContext.request.contextPath}/malladmin/Role/isExistsFuncCodeAjax',
                    data: {
                        "sid": sid
                    },
                    async: false, //取消异步
                    success: function (data, status) {
                        if (data.content == "1") {
                            //达到寿命
                            flag = false;
                            alert("编号：" +sid+":已经存在，不能重复");
                            return;
                        }
                    },
                    error: function (data, status) {
                        alert('ajax isExistsFuncCodeAjax Error')
                    }
                });
            }
        }
        //通过前台验证。提交后台处理
        if (flag) {

            grid.loading("保存中，请稍后......");

            $.ajax({
                url: "${pageContext.request.contextPath}/malladmin/Role/saveChanged",
                data: { data: json },
            type: "post",
                success: function (text) {
                grid.reload();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
        }
    }

    grid.on("celleditenter", function (e) {
        var index = grid.indexOf(e.record);
        if (index == grid.getData().length - 1) {
            var row = {};
            grid.addRow(row);
        }
    });

    grid.on("beforeload", function (e) {
        if (grid.getChanges().length > 0) {
            if (confirm("有增删改的数据未保存，是否取消本次操作？")) {
                e.cancel = true;
            }
        }
    });

    function isNumber(value)
    {
        //验证是否为 数字 0+ 正整数
        //var patrn = /^[1-9]\d*|0$/;
        var reg = /^([1-9]\d*|[0]{1,1})$/; //含0正整数

        if (reg.test(value))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


</script>


<script type="text/javascript">

    // $(window).on('load', function(){ ...});
    // 大概意思：$(window).load(function(){})在高版本中已经废弃，
    //$(window).on('load',function(){});

    var WinAlerts = window.alert;
    window.alert = function (e) {
        //console.log('对象数组1：', e);

        if (e != null && e.indexOf("www.miniui.com") > -1) {
            //和谐了
        }
        else {
            WinAlerts(e);
        }
    };

</script>