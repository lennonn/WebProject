<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/views/global.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Top Navigation</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <style type="text/css">
        img{max-width:90%}
    </style>
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">


    <jsp:include page="/views/website/topnav.jsp"/>

    <!-- Full Width Column -->
    <div class="content-wrapper">
        <div class="container">
            <section class="content">
                <jsp:include page="/views/website/tips.jsp"></jsp:include>

                <div class="row">
                    <div class="col-md-9" id="leftContent">
                            <div class="box box-solid">
                                <div class="box-header with-border">
                                    <i class="fa fa-text-width"></i>

                                    <h3 class="box-title">${article.title}</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    ${article.content}
                                </div>
                                <div class="box-footer ">
                                    <button type="button" onclick="getWebContent('${pageContext.request.contextPath}/article/website/list')" class="btn btn-default btn-xs"><i class="fa fa-share"></i> 返回</button>

                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->
                    </div>
                    <jsp:include page="/views/website/right.jsp"/>
                </div>
                <!-- /.box -->
            </section>
            <!-- /.content -->
        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="/views/copyright.jsp"></jsp:include>

</div>
</body>
</html>


