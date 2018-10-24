<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>莫辂技术</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
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

                                <h3 class="box-title">最新文章</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <c:forEach items="${pageInfo.list}" var="item" varStatus="stat">
                                    <dl class="dl-description">
                                        <h4><p class="text-aqua">${item.title}</p></h4>
                                        <dd>${item.shortContent}...</dd>
                                            <%--  <span class="pull-left">hahha</span>--%>
                                        <span class="pull-right" style="color: #ff0000; font-size: 15px">
                           <a href="${pageContext.request.contextPath}/article/website/showDetail?id=${item.id}">查看详细>></a>
                </span>
                                        <br/>
                                        <c:if test="${!stat.last}">
                                            <hr/>
                                        </c:if>
                                    </dl>

                                </c:forEach>
                            </div>
                            <jsp:include page="../page.jsp"></jsp:include>

                        </div>

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

