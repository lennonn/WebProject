 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>文章类型</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/table/bootstrap-table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/treeview/bootstrap-treeview.css">
    <style type="text/css">
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
                                    <div id="treeview" style="display: none;"/>
                                </div>
                            </div>
                            <div class="form-group">
                                 <label for="pname" class="col-sm-2 control-label">权限名称</label>
                                 <div class="col-xs-6">
                                        <input class="form-control" id="pname" name="pname" placeholder="请输入权限名称"/>
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
<script src="${pageContext.request.contextPath}/js/bootstrap/treeview/bootstrap-treeview.js"></script>
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
            $('#sysPermissionTable').bootstrapTable({
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
            $("#sysPermissionForm").find(':input').each(function () {
                var  name= $(this).attr("name");
                debugger;
                $("#"+name).val(row[name]);
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
        var  data = $("#sysPermissionForm").serialize();
        $.ajax({
            url:"${pageContext.request.contextPath}/sysPermission/save",
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

   // var data1 = [];
    var data1 = [
        {
            text: 'Parent 1',
            nodes: [
                {
                    text: 'Child 1',
                    nodes: [
                        {
                            text: 'Grandchild 1'
                        },
                        {
                            text: 'Grandchild 2'
                        }
                    ]
                },
                {
                    text: 'Child 2'
                }
            ]
        },
        {
            text: 'Parent 2'
        },
        {
            text: 'Parent 3'
        },
        {
            text: 'Parent 4'
        },
        {
            text: 'Parent 5'
        }
    ];
/*    $(function() {
        $.ajax({
            type : "post",
            url : "/receiverShow/findTree.action",
            success : function(data, status) {
                if (status == "success") {
                    data1 = eval("[" + data + "]");
                }
            },
            error : function() {
                toastr.error('Error');
            },
        });
    });*/

    function buildDomTree() {
        var data = [];
        var root = "所有分类";
        function walk(nodes, data) {
            if (!nodes) {
                return;
            }
            $.each(nodes, function(id, node) {
                var obj = {
                    id : id,
                    text : node.name != null ? node.name : root
                    // 										tags : [ node.isLeaf == true ? node.
                    // 												+ ' child elements'
                    // 												: '' ]
                };
                if (node.isLeaf = true) {
                    obj.nodes = [];
                    walk(node.children, obj.nodes);
                }
                data.push(obj);
            });
        }

        walk(data1, data);
        return data;
    }

    $("#txt_departmentname").click(function() {
        var options = {
            bootstrap2 : false,
            showTags : true,
            levels : 5,
            showCheckbox : true,
            checkedIcon : "glyphicon glyphicon-check",
            data : buildDomTree(),
            onNodeSelected : function(event, data) {
                $("#txt_departmentname").val(data.text);
                $("#treeview").hide();
            }
        };

        $('#treeview').treeview(options);
    });

</script>
</body>
</html>
