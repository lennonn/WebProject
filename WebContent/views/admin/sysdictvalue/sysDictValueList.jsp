 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <table id="sysDictValueTable"></table>
        <div id="toolbar">
            <div class="btn-group">
                <button class="btn btn-block btn-info" data-toggle="modal" data-target="#modal-default">
                    <i class="fa fa-plus-square">添加</i>
                </button>
            </div>
        </div>
        <div class="modal fade" id="modal-default">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">添加文章</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id ="sysDictValueForm">

                            <input type="hidden" name="id" id="id" value="">
                             <div class="form-group">
                             </div>
                             <div class="form-group">
                                    <label for="dictTypeId" class="col-sm-2 control-label">类型ID</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="dictTypeId" name="dictTypeId" placeholder="请输入类型ID"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="label" class="col-sm-2 control-label">键值名称</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="label" name="label" placeholder="请输入键值名称"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="value" class="col-sm-2 control-label">键值</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="value" name="value" placeholder="请输入键值"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="sort" class="col-sm-2 control-label">无</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="sort" name="sort" placeholder="请输入无"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="createBy" class="col-sm-2 control-label">无</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="createBy" name="createBy" placeholder="请输入无"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="createDate" class="col-sm-2 control-label">无</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="createDate" name="createDate" placeholder="请输入无"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="updateBy" class="col-sm-2 control-label">无</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="updateBy" name="updateBy" placeholder="请输入无"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="updateDate" class="col-sm-2 control-label">无</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="updateDate" name="updateDate" placeholder="请输入无"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="delFlag" class="col-sm-2 control-label">无</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="delFlag" name="delFlag" placeholder="请输入无"/>
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
<script src="${pageContext.request.contextPath}/views/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script type="text/javascript">
    $(function(){
        var oTable = new TableInit();
        oTable.Init();
    });
    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#sysDictValueTable').bootstrapTable({
                url: '${pageContext.request.contextPath}/sysDictValue/initTable',         //请求后台的URL（*）
                striped: true,  //表格显示条纹
                pagination: true, //启动分页
                toolbar: "#toolbar",                //工具按钮用哪个容器
                pageSize: 10,  //每页显示的记录数
                pageNumber: 1, //当前第几页
                pageList: [30, 40, 80],  //记录数可选列表
                search: true,  //是否启用查询
                showColumns: true,  //显示下拉框勾选要显示的列
                showRefresh: true,  //显示刷新按钮
                sidePagination: "server", //表示服务端请求
                //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
                //设置为limit可以获取limit, offset, search, sort, order
                //queryParamsType: "undefined",
                queryParamsType : 'undefined',
                queryParams: function queryParams(params) {   //设置查询参数
                    var param = {
                        pageNumber: params.pageNumber,
                        pageSize: params.pageSize,
                        searchText:params.searchText
                    };
                    return param;
                },
                columns: [
                    {checkbox: true},
                    {field: 'dictTypeId', title: '类型ID', sortable: true},
                    {field: 'label', title: '键值名称', sortable: true},
                    {field: 'value', title: '键值', sortable: true},
                    {field: 'sort', title: '无', sortable: true},
                    {field: 'createBy', title: '无', sortable: true},
                    {field: 'createDate', title: '无', sortable: true},
                    {field: 'updateBy', title: '无', sortable: true},
                    {field: 'updateDate', title: '无', sortable: true},
                    {field: 'delFlag', title: '无', sortable: true},
                    {field: 'button', title: '操作', events: "operateEvents", formatter: operateFormatter}
                    ],
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
            $("#sysDictValueForm").find(':input').each(function () {
                var  name= $(this).attr("name");
                debugger;
                $("#"+name).val(row[name]);
            });
            $("#modal-default").modal('show');
        },
        'click .delete': function (e, value, row, index) {
            $.ajax({
                url:"${pageContext.request.contextPath}/sysDictValue/delete?id="+row.id,
                type: "post",
                dataType: "json",
                success: function (res) {
                    alert(res.msg);
                    getContent('${pageContext.request.contextPath}/sysDictValue/list');//刷新ds_table的数据
                }
            });
        }
    };

    function _save() {
        var  data = $("#sysDictValueForm").serialize();
        $.ajax({
            url:"${pageContext.request.contextPath}/sysDictValue/save",
            type: "post",
            data:data,
            dataType: "json",
            success: function (res) {
                alert(res.msg);
                $("#modal-default").modal('toggle');
                getContent('${pageContext.request.contextPath}/sysDictValue/list');
                // $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
            }
        });
    }
</script>
</body>
</html>
