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
        <table id="sysUserTable" data-classes="table table-hover ">
        </table>
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
                        <form class="form-horizontal" id ="sysUserForm">

                            <input type="hidden" name="id" id="id" value="" >
                             <div class="form-group">
                             </div>
                             <div class="form-group">
                                    <label for="username" class="col-sm-2 control-label">用户名</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="username" name="username" placeholder="请输入用户名"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="passwd" class="col-sm-2 control-label">密码</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" type="password" id="passwd" name="passwd" placeholder="请输入密码"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="phone" class="col-sm-2 control-label">手机</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="phone" name="phone" placeholder="请输入手机"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label class="col-sm-2 control-label">性别</label>
                                    <div class="col-xs-6">
                                        <select class="form-control" name="sex" id="sex">
                                            <option value="1">男</option>
                                            <option value="2">女</option>
                                        </select>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="email" name="email" placeholder="请输入邮箱"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="mark" class="col-sm-2 control-label">备注</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="mark" name="mark" placeholder="请输入备注"/>
                                    </div>
                             </div>

                             <div class="form-group">
                                    <label for="imageurl" class="col-sm-2 control-label">头像</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="imageurl" name="imageurl" placeholder="请输入头像图片路径"/>
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
        <div class="modal fade" id="modal-roleAuth">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">添加文章</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id ="roleAuth">
                            <input type="hidden" name="userId" id="userId" value="" >
                            <!-- checkbox -->
                            <div class="form-group">
                                <c:forEach items="${sysRole}" var="sr">
                                <label>
                                    <input type="checkbox" id="${sr.roleId}" class="flat-red" value="${sr.roleId}" >
                                    ${sr.roleName}
                                </label>
                                </c:forEach>
                            </div>

                        </form>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="_saveRole();">授权</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap/table/bootstrap-table.min.js"></script>
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
            $('#sysUserTable').bootstrapTable({
                url: '${pageContext.request.contextPath}/sysUser/initTable',         //请求后台的URL（*）
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
                    {field: 'username', title: '用户名', sortable: true},
                    {field: 'passwd', title: '密码', sortable: true},
                    {field: 'phone', title: '手机', sortable: true},
                    {field: 'sex', title: '性别', sortable: true},
                    {field: 'email', title: '邮箱', sortable: true},
                    {field: 'mark', title: '备注', sortable: true},
/*                    {field: 'urank', title: '账号等级', sortable: true},
                    {field: 'lastlogin', title: '最后一次登录时间', sortable: true},
                    {field: 'loginip', title: '登录ip', sortable: true},
                    {field: 'imageurl', title: '头像图片路径', sortable: true},
                    {field: 'regtime', title: '注册时间', sortable: true},
                    {field: 'locked', title: '账号是否被锁定', sortable: true},
                    {field: 'rights', title: '权限（没有使用）', sortable: true},*/
                    {field: 'button',width:200, title: '   操作    ', events: "operateEvents", formatter: operateFormatter}
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
            '<button type="button" class="delete btn btn-info btn-xs" > <i class="fa  fa-remove">删除</i></button>',
            '<button type="button" class="roleAuth btn btn-info btn-xs" > <i class="fa  fa-remove">角色授权</i></button>'
        ].join('');
    }

    window.operateEvents = {
        'click .edit': function (e, value, row, index) {
            $("#sysUserForm").find(':input').each(function () {
                var  name= $(this).attr("name");
                debugger;
                $("#"+name).val(row[name]);
            });
            $("#modal-default").modal('show');
        },
        'click .roleAuth': function (e, value, row, index) {
            //获取已授权的角色
            $.ajax({
                url:"${pageContext.request.contextPath}/sysUser/getAuthedRole",
                type: "post",
                dataType: "json",
                data:{"userId":row.id},
                async:false,
                success: function (res) {
                    var authedRole = res.authedRole;
                    for(var p in authedRole ){
                        $("#roleAuth").find("input[type=checkbox]").each(function(){
                            if(authedRole[p].roleId==$(this).val()){
                                $(this).attr("checked","checked");
                            }
                        });
                    }
                }
            });
            $("#userId").val(row.id);
            $("#modal-roleAuth").modal('show');
        },
        'click .delete': function (e, value, row, index) {
            $.ajax({
                url:"${pageContext.request.contextPath}/sysUser/delete?id="+row.id,
                type: "post",
                dataType: "json",
                success: function (res) {
                    alert(res.msg);
                    getContent('${pageContext.request.contextPath}/sysUser/list');//刷新ds_table的数据
                }
            });
        }
    };

    function _save() {
        var  data = $("#sysUserForm").serialize();
        $.ajax({
            url:"${pageContext.request.contextPath}/sysUser/save",
            type: "post",
            data:data,
            dataType: "json",
            success: function (res) {
                alert(res.msg);
                $("#modal-default").modal('toggle');
                getContent('${pageContext.request.contextPath}/sysUser/list');//刷新ds_table的数据                //window.location.href="${pageContext.request.contextPath}/article/list";
                // $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
            }
        });
    }

    function _saveRole() {
        var roleIds="";
        $("#roleAuth").find("input[type=checkbox]").each(function(){
            if ($(this).is(':checked')) {
                roleIds+=$(this).val()+",";
            }
        });
        $.ajax({
            url:"${pageContext.request.contextPath}/sysUser/authRole",
            type: "post",
            data:{"userId": $("#userId").val(),"roleIds":roleIds.substring(0,roleIds.length-1)},
            dataType: "json",
            success: function (res) {
                alert(res.msg);
                $("#modal-default").modal('toggle');
                getContent('${pageContext.request.contextPath}/sysUser/list');//刷新ds_table的数据                //window.location.href="${pageContext.request.contextPath}/article/list";
                // $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
            }
        });
    }

</script>
</body>
</html>
