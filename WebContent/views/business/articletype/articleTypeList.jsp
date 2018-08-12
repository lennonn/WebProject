<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>文章类型</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/table/bootstrap-table.css">
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body>
    <div class="row">
        <div class="col-md-12">
            <table id="articleType"
                   data-classes="table table-hover "
                   data-search="true"
                   data-show-refresh="true"
                   data-show-toggle="true"
                   data-show-columns="true"
                   data-toolbar="#toolbar"></table>
            <div id="toolbar">
                <div class="btn-group">
                    <button class="btn btn-block btn-info" data-toggle="modal" data-target="#modal-default">
                        <i class="fa fa-plus-square">添加</i>
                    </button>
                </div>
            </div>
            <div class="modal fade" id="modal-default">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">添加文章类型</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="typeName" class="col-sm-2 control-label">类型名称</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="typeName" id="typeName"
                                               placeholder="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="typeDesc" class="col-sm-2 control-label">类型描述</label>

                                    <div class="col-sm-10">
                                    <textarea class="form-control" rows="3" name="typeDesc" id="typeDesc"
                                              placeholder="Enter ..."></textarea>
                                    </div>
                                </div>

                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" onclick="_save();">保存提交</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>

        </div>
    </div>
<script src="${pageContext.request.contextPath}/js/bootstrap/table/bootstrap-table.js"></script>

<script type="text/javascript">
    $(function () {

        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

    });


    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#articleType').bootstrapTable({
                url: '${pageContext.request.contextPath}/articleType/initTable',         //请求后台的URL（*）
                striped: true,  //表格显示条纹
                pagination: true, //启动分页
                toolbar: "#toolbar",                //工具按钮用哪个容器
                pageSize: 10,  //每页显示的记录数
                pageNumber: 1, //当前第几页
                pageList: [ 10, 15, 20, 25],  //记录数可选列表
                search: true,  //是否启用查询
                showColumns: true,  //显示下拉框勾选要显示的列
                showRefresh: true,  //显示刷新按钮
                sidePagination: "server", //表示服务端请求
                //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
                //设置为limit可以获取limit, offset, search, sort, order
                queryParamsType: "undefined",
                queryParams: function queryParams(params) {   //设置查询参数
                    var param = {
                        pageNumber: params.pageNumber,
                        pageSize: params.pageSize,
                        queryString: $("#orderNum").val()
                    };
                    return param;
                },
                columns: [{
                    checkbox: true
                }, {
                    field: 'typeName',
                    title: '文章类型名称',
                    sortable: true
                }, {
                    field: 'typeDesc',
                    title: '类型描述'
                }, {
                    field: 'button',
                    title: '操作',
                    events: "operateEvents",
                    formatter: operateFormatter
                }],
                onLoadSuccess: function () {  //加载成功时执行
                    // alert("加载成功");
                },
                onLoadError: function () {  //加载失败时执行
                    // alert("加载数据失败");
                }
            });
        };
        return oTableInit;
    };

    function operateFormatter(value, row, index) {
        return [
            '<button type="button" class="edit btn btn-info btn-xs" > <i class="fa fa-edit">编辑</i></button>',
            '<button type="button" class="delete btn btn-info btn-xs" > <i class="fa  fa-remove">删除</i></button>'
        ].join('');
    }

    window.operateEvents = {
        'click .edit': function (e, value, row, index) {
            debugger;
            alert(row);
        },
        'click .delete': function (e, value, row, index) {
            $("#editModal").modal('show');
            alert(index);
        }
    };

    function _save() {
        var _data = $(".form-horizontal").serialize();
        $.ajax({
            url: "${pageContext.request.contextPath}/articleType/save",
            type: "post",
            data: _data,
            dataType: "json",
            success: function (data) {
                alert(data.msg);
                $("#modal-default").modal('toggle');
               // $("#articleType").bootstrapTable('refresh');//刷新ds_table的数据
               getContent("${pageContext.request.contextPath}/articleType/list");
                //
               // $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
            }
        });
    }
</script>
</body>
</html>
