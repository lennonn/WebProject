<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<script src="${pageContext.request.contextPath}/views/bower_components/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/views/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script type="text/javascript">
    $(function () {
         CKEDITOR.replace('editor1',{
            // Define the toolbar: http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_toolbar
            // The standard preset from CDN which we used as a base provides more features than we need.
            // Also by default it comes with a 2-line toolbar. Here we put all buttons in a single row.
/*            toolbar: [
                { name: 'clipboard', items: [ 'Undo', 'Redo' ] },
                { name: 'styles', items: [ 'Styles', 'Format' ] },
                { name: 'basicstyles', items: [ 'Bold', 'Italic', 'Strike', '-', 'RemoveFormat' ] },
                { name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote' ] },
                { name: 'links', items: [ 'Link', 'Unlink' ] },
                { name: 'insert', items: [ 'Image', 'EmbedSemantic', 'Table' ] },
                { name: 'tools', items: [ 'Maximize' ] },
                { name: 'editing', items: [ 'Scayt' ] }
            ],*/

            // Since we define all configuration options here, let's instruct CKEditor to not load config.js which it does by default.
            // One HTTP request less will result in a faster startup time.
            // For more information check http://docs.ckeditor.com/ckeditor4/docs/#!/api/CKEDITOR.config-cfg-customConfig
            customConfig: '',

            // Enabling extra plugins, available in the standard-all preset: http://ckeditor.com/presets-all
            extraPlugins: 'codesnippet,autoembed,embedsemantic,image2,uploadimage,uploadfile',
             codeSnippet_theme: 'zenburn',
            /*********************** File management support ***********************/
            // In order to turn on support for file uploads, CKEditor has to be configured to use some server side
            // solution with file upload/management capabilities, like for example CKFinder.
            // For more information see http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_ckfinder_integration

            // Uncomment and correct these lines after you setup your local CKFinder instance.
            // filebrowserBrowseUrl: 'http://example.com/ckfinder/ckfinder.html',
            // filebrowserUploadUrl: 'http://example.com/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files',
            /*********************** File management support ***********************/

            // Remove the default image plugin because image2, which offers captions for images, was enabled above.
            removePlugins: 'image',

            // Make the editing area bigger than default.
            height: 200,

            // An array of stylesheets to style the WYSIWYG area.
            // Note: it is recommended to keep your own styles in a separate file in order to make future updates painless.
            contentsCss: ['${pageContext.request.contextPath}/css/ckeditor/mystyles.css'],
           filebrowserUploadUrl:'/zlennon/ckeditorUpload?type=File',

            // This is optional, but will let us define multiple different styles for multiple editors using the same CSS file.
            bodyClass: 'article-editor',

            // Reduce the list of block elements listed in the Format dropdown to the most commonly used.
            format_tags: 'p;h1;h2;h3;pre',

            // Simplify the Image and Link dialog windows. The "Advanced" tab is not needed in most cases.
            removeDialogTabs: 'image:advanced;link:advanced',

            // Define the list of styles which should be available in the Styles dropdown list.
            // If the "class" attribute is used to style an element, make sure to define the style for the class in "mystyles.css"
            // (and on your website so that it rendered in the same way).
            // Note: by default CKEditor looks for styles.js file. Defining stylesSet inline (as below) stops CKEditor from loading
            // that file, which means one HTTP request less (and a faster startup).
            // For more information see http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_styles
            stylesSet: [
                /* Inline Styles */
                { name: 'Marker',			element: 'span', attributes: { 'class': 'marker' } },
                { name: 'Cited Work',		element: 'cite' },
                { name: 'Inline Quotation',	element: 'q' },

                /* Object Styles */
                {
                    name: 'Special Container',
                    element: 'div',
                    styles: {
                        padding: '5px 10px',
                        background: '#eee',
                        border: '1px solid #ccc'
                    }
                },
                {
                    name: 'Compact table',
                    element: 'table',
                    attributes: {
                        cellpadding: '5',
                        cellspacing: '0',
                        border: '1',
                        bordercolor: '#ccc'
                    },
                    styles: {
                        'border-collapse': 'collapse'
                    }
                },
                { name: 'Borderless Table',		element: 'table',	styles: { 'border-style': 'hidden', 'background-color': '#E6E6FA' } },
                { name: 'Square Bulleted List',	element: 'ul',		styles: { 'list-style-type': 'square' } },

                /* Widget Styles */
                // We use this one to style the brownie picture.
                { name: 'Illustration', type: 'widget', widget: 'image', attributes: { 'class': 'image-illustration' } },
                // Media embed
                { name: '240p', type: 'widget', widget: 'embedSemantic', attributes: { 'class': 'embed-240p' } },
                { name: '360p', type: 'widget', widget: 'embedSemantic', attributes: { 'class': 'embed-360p' } },
                { name: '480p', type: 'widget', widget: 'embedSemantic', attributes: { 'class': 'embed-480p' } },
                { name: '720p', type: 'widget', widget: 'embedSemantic', attributes: { 'class': 'embed-720p' } },
                { name: '1080p', type: 'widget', widget: 'embedSemantic', attributes: { 'class': 'embed-1080p' } }
            ]
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
                    field: 'shortContent',
                    title: '文章类容',
                    sortable: true,
                    formatter: formatContent
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

    formatContent

    function formatContent(value, row, index) {
        debugger;
        if(row.shortContent.indexOf("<img")!=-1)return "内容过大无法显示，请查看详细";

    }
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
        var title =$("#title").val();
        var data= {"tId":tId,"title":title,"content":content};
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
