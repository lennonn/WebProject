 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>文章类型</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/table/bootstrap-table.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/ztree/demo.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/ztree/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/ztree/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/ztree/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/ztree/jquery.ztree.exedit.js"></script>
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
                                    <input class="form-control" id="menuName" name="menuName" placeholder="请选择菜单" onclick="showMenu();"/>
                                    <div id="menuContent" class="menuContent" style="display:none;position: absolute;">
                                        <ul id="treeDemo" class="ztree" style="margin-top:0;"></ul>
                                    </div>
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
<script src="${pageContext.request.contextPath}/js/bootstrap/table/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/views/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script type="text/javascript">

    var setting = {
        check: {
            enable: true,
            chkboxType: {"Y":"", "N":""}
        },
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeClick: beforeClick,
            onCheck: onCheck
        }
    };

    var zNodes =[
        {id:1, pId:0, name:"北京"},
        {id:2, pId:0, name:"天津"},
        {id:3, pId:0, name:"上海"},
        {id:6, pId:0, name:"重庆"},
        {id:4, pId:0, name:"河北省", open:true, nocheck:true},
        {id:41, pId:4, name:"石家庄"},
        {id:42, pId:4, name:"保定"},
        {id:43, pId:4, name:"邯郸"},
        {id:44, pId:4, name:"承德"},
        {id:5, pId:0, name:"广东省", open:true, nocheck:true},
        {id:51, pId:5, name:"广州"},
        {id:52, pId:5, name:"深圳"},
        {id:53, pId:5, name:"东莞"},
        {id:54, pId:5, name:"佛山"},
        {id:6, pId:0, name:"福建省", open:true, nocheck:true},
        {id:61, pId:6, name:"福州"},
        {id:62, pId:6, name:"厦门"},
        {id:63, pId:6, name:"泉州"},
        {id:64, pId:6, name:"三明"}
    ];

    function beforeClick(treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }

    function onCheck(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
            nodes = zTree.getCheckedNodes(true),
            v = "";
        for (var i=0, l=nodes.length; i<l; i++) {
            v += nodes[i].name + ",";
        }
        if (v.length > 0 ) v = v.substring(0, v.length-1);
        var cityObj = $("#menuName");
        cityObj.attr("value", v);
    }

    function showMenu() {
        var cityObj = $("#menuName");
        var cityOffset = $("#menuName").offset();
        $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

        $("body").bind("mousedown", onBodyDown);
    }
    function hideMenu() {
        $("#menuContent").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
    }
    function onBodyDown(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "menuName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
            hideMenu();
        }
    }

    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });




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

</script>
</body>
</html>
