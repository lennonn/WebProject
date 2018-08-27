<#noparse> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
</#noparse>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>文章类型</title>
    <link rel="stylesheet" href="<#noparse>${pageContext.request.contextPath}</#noparse>/css/bootstrap/table/bootstrap-table.css">

</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body>
<div class="row">
    <div class="col-md-12">
        <table id="${actionName}Table"
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
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">添加文章</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id ="${actionName}Form">

                            <input type="hidden" name="id" id="id" value="">
                            <#list tableInfo as item>
                             <div class="form-group">
                                <#if item_index!=0>
                                    <label for="${item.colName}" class="col-sm-2 control-label">${item.remark}</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="${item.colName}" name="${item.colName}" placeholder="请输入${item.remark}"/>
                                    </div>
                                </#if>
                             </div>
                            </#list>
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
<script src="<#noparse>${pageContext.request.contextPath}</#noparse>/js/bootstrap/table/bootstrap-table.js"></script>
<script src="<#noparse>${pageContext.request.contextPath}</#noparse>/views/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script type="text/javascript">
    $(function(){
        var oTable = new TableInit();
        oTable.Init();
    });
    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#${actionName}Table').bootstrapTable({
                url: '<#noparse>${pageContext.request.contextPath}</#noparse>/${actionName}/initTable',         //请求后台的URL（*）
                striped: true,  //表格显示条纹
                pagination: true, //启动分页
                toolbar: "#toolbar",                //工具按钮用哪个容器
                pageSize: 20,  //每页显示的记录数
                pageNumber: 1, //当前第几页
                pageList: [30, 40, 80],  //记录数可选列表
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
                columns: [
                    {checkbox: true},
                    <#list tableInfo as item>
                        <#if item_index!=0>
                    {field: '${item.colName}', title: '${item.remark}', sortable: true},
                        </#if>
                    </#list>
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
            $("#${actionName}Form").find(':input').each(function () {
                var  name= $(this).attr("name");
                debugger;
                $("#"+name).val(row[name]);
            });
            $("#modal-default").modal('show');
        },
        'click .delete': function (e, value, row, index) {
            $.ajax({
                url:"${pageContext.request.contextPath}/${actionName}/delete?id="+row.id,
                type: "post",
                dataType: "json",
                success: function (res) {
                    alert(res.msg);
                    getContent('${pageContext.request.contextPath}/${actionName}/list');//刷新ds_table的数据
                }
            });
        }
    };

    function _save() {
        var  data = $("#sysUserForm").serialize();
        $.ajax({
            url:"${pageContext.request.contextPath}/${actionName}/save",
            type: "post",
            data:data,
            dataType: "json",
            success: function (res) {
                alert(res.msg);
                $("#modal-default").modal('toggle');
                getContent('${pageContext.request.contextPath}/${actionName}/list');//刷新ds_table的数据                //window.location.href="${pageContext.request.contextPath}/article/list";
                // $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
            }
        });
    }
</script>
</body>
</html>
