<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("X-Frame-Options", "SAMEORIGIN");
%>
<%--<jsp:include page="/views/global.jsp"></jsp:include>--%>

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
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">添加文章</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <input type="hidden" name="id" id="_id" >
                            <input type="hidden" name="scan" id="scan" >

                            <select class="form-control" id="tId" name="tId" style="margin-bottom: 10px">
                                    <c:forEach items="${articleType}" var="at">
                                        <option value="${at.id}">${at.typeName}</option>
                                    </c:forEach>
                                </select>
                            <input class="form-control" id="title" name="title" placeholder="请输入文章标题" style="margin-bottom: 10px"/>
                            <textarea id="editor1" name="editor1" rows="10" cols="80" ></textarea>
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
<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script type="text/javascript">
    $(function () {
        // CKEDITOR.addCss( '.cke_editable { font-size: 15px; padding: 2em; }' );
         CKEDITOR.replace('editor1',{
             extraPlugins: 'codesnippet,image2,uploadfile',
            // extraAllowedContent: 'h3{clear};h2{line-height};h2 h3{margin-left,margin-top}',
             height: 260,
             codeSnippet_theme: 'zenburn',
            removePlugins: 'image',
             // Adding drag and drop image upload.
             uploadUrl: '/zlennon/common/uploadByPaste?&type=Files&responseType=json',
            filebrowserUploadUrl:'/zlennon/common/ckeditorUpload?type=File',
            // This is optional, but will let us define multiple different styles for multiple editors using the same CSS file.
            //bodyClass: 'article-editor',
            // Reduce the list of block elements listed in the Format dropdown to the most commonly used.
            format_tags: 'p;h1;h2;h3;pre',
            // Simplify the Image and Link dialog windows. The "Advanced" tab is not needed in most cases.
            removeDialogTabs: 'image:advanced;link:advanced',

             // Load the default contents.css file plus customizations for this sample.
             //contentsCss: [ CKEDITOR.basePath + 'contents.css', 'https://sdk.ckeditor.com/samples/assets/css/widgetstyles.css' ],
/*             contentsCss: [
                 'https://sdk.ckeditor.com/samples/assets/accessibilitychecker/contents.css',
                 'https://cdn.ckeditor.com/4.10.1/full-all/contents.css'
             ]*/
             // Configure the Enhanced Image plugin to use classes instead of styles and to disable the
             // resizer (because image size is controlled by widget styles or the image takes maximum
             // 100% of the editor width).

        } );        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

    });


    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#articleType').bootstrapTable({
                url: '${pageContext.request.contextPath}/article/initTable',         //请求后台的URL（*）
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
                columns: [{
                    checkbox: true
                }, {
                    field: 'title',
                    title: '文章名称',
                    sortable: true
                }, {
                    field: 'author',
                    title: '作者'
                }, {
                    field: 'plainText',
                    title: '文章类容',
                    sortable: true,
                }, {
                    field: 'scan',
                    title: '阅读数',
                    sortable: true
                }, {
                    field: 'createTime',
                    title: '创建时间',
                    formatter: convert
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


            $("#tId").val(row.tId);
            $("#title").val(row.title);
            $("#_id").val(row.id);
            $("#scan").val(row.scan);
            CKEDITOR.instances.editor1.setData(row.content);
            $("#modal-default").modal('show');
        },
        'click .delete': function (e, value, row, index) {

            $.ajax({
                url:"${pageContext.request.contextPath}/article/delete?id="+row.id,
                type: "post",
                dataType: "json",
                success: function (res) {
                     $("#articleType").bootstrapTable('refresh');//刷新ds_table的数据
                }
            });
        }
    };

    function convert(value, row, index) {
        debugger;
        var date = new Date();
        date.setTime(row.time);
        return date.format("yyyy-MM-dd");
    };
    function _save() {
        var tId =$("#tId option:selected").val();
        var content = CKEDITOR.instances.editor1.getData();
        debugger;
       var plainText= CKEDITOR.instances.editor1.document.getBody().getText(); //取得纯文本
        var title =$("#title").val();
        var data= {"tId":tId,"title":title,"content":content,"plainText":plainText};
        var id =$("#_id").val();
        var scan =$("#scan").val();
        if(id!=""){
            data.id=id;
            data.scan =scan;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/article/save",
            type: "post",
            data:data,
            dataType: "json",
            success: function (res) {
                alert(res.msg);
                $("#modal-default").modal('toggle');
                 $("#articleType").bootstrapTable('refresh');//刷新ds_table的数据
                //window.location.href="${pageContext.request.contextPath}/article/list";
                // $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
            }
        });
    }
</script>
</body>
</html>
