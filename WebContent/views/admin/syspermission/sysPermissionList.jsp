<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>文章类型</title>
    <style type="text/css">
        .modal-body{
            height: 400px;
        }
    </style>
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body>
<div class="row">
    <div class="col-md-12">
        <table id="sysPermissionTable"></table>
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
                        <form class="form-horizontal" id ="sysPermissionForm">

                            <input type="hidden" name="id" id="id" value="">
                             <div class="form-group">
                             </div>
                            <div class="form-group">
                                <label for="menuName" class="col-sm-2 control-label">菜单</label>
                                <div class="col-xs-6">
                                    <input class="form-control" type="hidden" id="menuId" name="menuId" />
                                    <input type="text" id="menuName" name="menuName" class="form-control" value="" onclick="$('#treeview').show()" placeholder="请选择菜单">
                                    <div id="treeview"  style="width: 93.1%;color: #54ca9a; display: none;position:absolute;z-index:999"/>
                                </div>
                            </div>
                            <div class="form-group">
                                 <label for="pname" class="col-sm-2 control-label">权限名称</label>
                                 <div class="col-xs-6">
                                        <input class="form-control" id="pname" name="pname" placeholder="请输入权限名称"/>
                                    </div>
                             </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">权限操作</label>
                                <div class="col-xs-6">
                                    <c:forEach items="${operations}" var="oper">
                                        <label>
                                            <input type="checkbox" id="${oper.id}"  value="${oper.id}">${oper.oname}
                                        </label>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="pdesc" class="col-sm-2 control-label">权限描述</label>
                                <div class="col-xs-6">
                                    <input class="form-control" id="pdesc" name="pdesc" placeholder="请输入权限描述"/>
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

<script type="text/javascript">



    $(function(){
        var oTable = new TableInit();
        oTable.Init();
    });
    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#sysPermissionTable').bootstrapTable({
                method:"get",
               // contentType: "application/x-www-form-urlencoded",//必须要有！！！！
                url: '${pageContext.request.contextPath}/sysPermission/initTable',         //请求后台的URL（*）
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
                    {field: 'pdesc', title: '权限描述', sortable: true},
                    {field: 'pname', title: '权限名称', sortable: true},
                    {field: 'menuId', title: '菜单_id', sortable: true},
                    {field: 'button', title: '操作', events: "operateEvents", formatter: operateFormatter}
                    ],
                onLoadSuccess: function (res) {  //加载成功时执行
                    debugger;
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
            $("#sysPermissionForm").find(':input').each(function () {
                var  name= $(this).attr("name");
                $("#"+name).val(row[name]);
            });
            $.ajax({
                url:"${pageContext.request.contextPath}/sysPermission/getPO?permissionId="+row.id+"&menuId="+row.menuId,
                type: "post",
                dataType: "json",
                async:false,
                success: function (res) {
                    var pos=res.pos;//改权限已有的操作
                    for (var p in pos){
                        <c:forEach items="${operations}" var="oper">
                        if(pos[p].operationId=='${oper.id}'){
                            $("#"+pos[p].operationId).attr("checked","true");
                        }
                        </c:forEach>
                        $("#menuName").val(res.menu.menuName);
                        $("#menuId").val(res.menu.menuId);

                    }
                }
            });

            $("#modal-default").modal('show');
        },
        'click .delete': function (e, value, row, index) {
            $.ajax({
                url:"${pageContext.request.contextPath}/sysPermission/delete?id="+row.id,
                type: "post",
                dataType: "json",
                success: function (res) {
                    alert(res.msg);
                    getContent('${pageContext.request.contextPath}/sysPermission/list');//刷新ds_table的数据
                }
            });
        }
    };

    function _save() {
        var operIds="";
        var  data = $("#sysPermissionForm").serialize();
        $("#sysPermissionForm").find("input[type=checkbox]").each(function () {
            if ($(this).is(':checked')) {
                operIds+=$(this).val()+",";
            }
        });
        operIds=operIds.substring(0,operIds.length-1);
        $.ajax({
            url:"${pageContext.request.contextPath}/sysPermission/save?operIds="+operIds,
            type: "post",
            data:data,
            dataType: "json",
            success: function (res) {
                alert(res.msg);
                $("#modal-default").modal('toggle');
                getContent('${pageContext.request.contextPath}/sysPermission/list');
                // $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
            }
        });
    }

    $("#menuName").click(function() {
        var options = {
            bootstrap2 : false,
            showTags : true,
            levels : 5,
            showCheckbox : true,
            checkedIcon : "glyphicon glyphicon-check",
            data : ${menus},
            onNodeSelected : function(event, data) {
                $("#menuName").val(data.text);
                $("#menuId").val(data.id);
                $("#treeview").hide();
            }
        };

        $('#treeview').treeview(options);
    });

</script>
</body>
</html>
