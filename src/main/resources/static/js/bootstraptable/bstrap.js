$(function() {

    InitTable();
    //当点击按钮的时候进行查询
    $('#searchOrderBtn').bind("click",InitTable);

    $('#btnShowPdf').click(function() {

        var dnnum = $('#sendId').html();
        var type = $('input[name=pdfType]:checked').val();
        var success;
        var $rows1 = $('#table_sortSearchResult tr');
        //解决 管理员打印单据时，供应商信息错误。
        var ssupid = $('#sendSupid').html();

        var queryurl = $("#PageContext").val()+'/BootstrapTable/downLoadByGuid?type=PN&supid=' + ssupid + '&dnnum=' + dnnum ;

        success = new PDFObject({ url: queryurl }).embed("pdfDiv");

        //获取pdf
        // if(type == 0)
        //     success = new PDFObject({ url: "/BootstrapTable/downLoadByGuid?type=PN&supid=210051&dnnum=GDS80" }).embed("pdfDiv");
        // else
        //     success = new PDFObject({ url: "/BootstrapTable/downLoadByGuid?type=PN&supid=210051&dnnum=GDS80" }).embed("pdfDiv");
        $('#modal_showpdf').modal('show');
        $('#modal_pdf').modal('hide');
    });
});

//主表
function InitTable(){
    //设置表格
    //var clientHeight = document.body.clientHeight;  //高度
    var clientHeight = 650 ;
    var tableHeight = clientHeight - 188;
    $('#table_sortSearchResult').bootstrapTable('destroy');
    //后台访问路径
    var queryUrl = $("#PageContext").val()+'/BootstrapTable/JsonBstrap';
    //alert(queryUrl);
    //window.open(queryUrl);
    $('#table_sortSearchResult').bootstrapTable({
        url: queryUrl,
        method: 'post',
        dataType: 'json',
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        cache: false,						//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        striped: true,						//是否显示行间隔色
        pagination: true,       			//是否显示分页（*）
        showPaginationSwitch: false, 		//显示分页切换按钮
        sortable: true,                     //是否启用排序
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        pageSize: 100,                     	//每页的记录行数（*）
        pageList: [100],                    //可供选择的每页的行数（*）
        search: false,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: false,                 //是否显示所有的列（选择显示的列）
        showRefresh: false,                 //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: tableHeight,                //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        //uniqueId: "ID",                   //每一行的唯一标识，一般为主键列
        showToggle: false,                  //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                  //是否显示父子表
        sortName: 'pmn33', // 要排序的字段
        sortOrder: 'desc', // 排序规则
        //得到查询的参数
        queryParams: function (params){
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var params = {
                //supid: supid,
                //dnnum: $('.bootstrap-table .fixed-table-toolbar .search input').val(),
                content: $('#content').val(),                   //自定义条件 按料号查询
                pageSize: params.limit,                         //页面大小
                pageNumber: (params.offset / params.limit) + 1, //页码
                sortName: params.sort,      					//排序列名
                sortOrder: params.order 					    //排位命令（desc，asc）
            };
            return params;
        },
        columns: [
            {field: 'dnnum', title: '送货单号tt', valign: 'middle', sortable: true},
            {field: 'pmn33', title: '送货日期', sortable: true},
            {field: 'supid', title: '供应商编号'},
            {field: 'name',  title: '供应商名称' },
            // {field: 'dnnum', title: '操作', width: 120,align: 'center',valign: 'middle',formatter: actionFormatter},
            {field: 'name',  title: '营运中心'  },
            {field: 'change_user', title: '最近修改者'},
            {field: 'change_time', title: '最近修改时间'},
            {
                field: 'status',
                title: '状态',
                formatter: function (value, row, index){
                    if (value == '1'){
                        return "有效";
                    }else if (value == '2'){
                        return "已收货";
                    }else{
                        return "无效";
                    }
                }
            },
            {
                title: '操作',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    if (row.status == '1')
                        return "<button class='btn btn-danger' title='使无效' name='invalid' onclick=\"invalidPN('"
                            + row.dnnum + "','" + row.plant
                            + "')\"><i class='fa fa-times' aria-hidden='true'></i></button>"
                            + "<button class='btn btn-info' title='下载' name='invalid' onclick=\"downloadPdf('"
                            + row.dnnum + "','" + row.supid + "')\"><i class='fa fa-download' aria-hidden='true'></i></button>";
                    else if (row.status == '2')
                        return "<button class='btn btn-info' title='下载' name='invalid' onclick=\"downloadPdf('"
                            + row.dnnum + "','" + row.supid + "')\"><i class='fa fa-download' aria-hidden='true'></i></button>";
                    else
                        return null;
                }
            }
            ],
        onLoadSuccess: function () {
        },
        //行单击事件,调用查询子页面
        onClickRow: function (row, tr, field) {
            if (field != "dnnum" && field != 8){
                //alert(field); field 有名称则为名称，无名称则为序列
                InitDetailedTable(row.dnnum);}
        },
        onLoadError: function (status, jqXHR) {
            showTips("数据加载失败！");
            //alert(JSON.stringify(status));
        },
        onDblClickRow: function (row, $element) {
            // 双击响应事件
            /* var id = row.ID;
            EditViewById(id, 'view'); */
        }
    });
}

// 备注
// queryParams: queryParams,
// function queryParams(params)
// {
//     var paramss = {
//         name: $("#name"),
//         hobby: $("hobby")  //select option
//     }
//     return paramss;
// }
//request.getParameterValues("hobby[]");

//操作栏的格式化
// function actionFormatter(value, row, index) {
//     var id = value;
//     var result = "";
//     result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"EditViewById('" + id + "', view='view')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
//     result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
//     result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
//     return result;
// }


//子表
function InitDetailedTable(dnnum){
    //标题赋值
    $('#modal_detail .modal-body span').text(dnnum);
    //模态框弹出 ，实现悬浮功能iModal
    $('#modal_detail').modal('show');
    //销毁表格
    $('#modal_table').bootstrapTable('destroy');
    //后台访问路径
    var queryUrl = $("#PageContext").val()+'/BootstrapTable/JsonBstrapDetail';



    //alert(queryUrl1);
    //初始化表格
    $('#modal_table').bootstrapTable({
        url: queryUrl,
        method: 'post',
        dataType: 'json',
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        cache: false,						//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        striped: true,						//是否显示行间隔色
        pagination: true,       			//是否显示分页（*）
        showPaginationSwitch: false, 		//显示分页切换按钮
        sortable: true,                     //是否启用排序
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        pageSize: 20,                     	//每页的记录行数（*）
        pageList: [10,20,50],               //可供选择的每页的行数（*）
        search: false,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: false,                 //是否显示所有的列（选择显示的列）
        showRefresh: false,                 //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 350,                //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        //uniqueId: "ID",                   //每一行的唯一标识，一般为主键列
        showToggle: false,                  //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                  //是否显示父子表
        sortName: 'id', // 要排序的字段
        sortOrder: 'asc', // 排序规则

        // //得到查询的参数
        // queryParams : function (params) {
        //     //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        //     var temp = {
        //         supid: supid,
        //         dnnum: dnnum
        //
        //     };
        //     return temp;
        // },

        //得到查询的参数
        queryParams: function (params){
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var params = {
                //supid: supid,
                //dnnum: $('.bootstrap-table .fixed-table-toolbar .search input').val(),
                dnnum: dnnum,
                pageSize: params.limit,                         //页面大小
                pageNumber: (params.offset / params.limit) + 1, //页码
                sortName: params.sort,      					//排序列名
                sortOrder: params.order 					    //排位命令（desc，asc）
            };
            return params;
        },
        columns: [{
            field: 'pmm01',
            title: '采购单号',
            sortable: true
        }, {
            field: 'pmn02',
            title: '项次'
        }, {
            field: 'pmn04',
            title: '料号',
            sortable: true
        }, {
            field: 'pmn041',
            title: '品名'
        }, {
            field: 'ima021',
            title: '规格'
        }, {
            field: 'pmn20',
            title: '数量'
        }],
        onLoadSuccess: function () {
        },
        onLoadError: function () {
            //showTips("数据加载失败！");
        },
        onDblClickRow: function (row, $element) {
            /* var id = row.ID;
            EditViewById(id, 'view'); */
        }
    });
}

//模态框显示pdf文件
function downloadPdf(dnnum,supid) {
    $('#modal_pdf').modal('show');
    $('#sendId').html(dnnum);
    $('#sendSupid').html(supid);
}



// //调用父框架，锁屏弹框提示
// function openMotal(title,content,timer)
// {
//
//     if (window.parent != window) {
//         //parent.openMotal("title","请休息一下，",5);
//         parent.openMotal(title, content, timer);
//     }
// }


//父页面JS放此方法
function openMotal(title,content,ltime) {

    //$('#myModal').modal({backdrop: 'static', keyboard: false});
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




//js获取总记录数 ，可以自定义首页，尾页 ，第几页 ？
//var num = $('#table_sortSearchResult').bootstrapTable('getOptions').totalRows;
//alert(num);


//https://www.cnblogs.com/laowangc/p/8875526.html

// //实现删除数据的方法
// function Delete() {
//     var ids = "";//得到用户选择的数据的ID
//     var rows = $table.bootstrapTable('getSelections');
//     for (var i = 0; i < rows.length; i++) {
//         ids += rows[i].ID + ',';
//     }
//     ids = ids.substring(0, ids.length - 1);
//
//     DeleteByIds(ids);
// }



