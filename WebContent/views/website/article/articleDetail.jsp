<%@ page import="java.util.Date" %><%--
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
                    <div class="col-md-9">
                        <!-- Box Comment -->
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block">
                                    <img class="img-circle" src="${pageContext.request.contextPath}/images/article/gif/title.gif" alt="User Image">
                                    <span class="username">${article.title}</span>
                                    <span class="description"><%=new Date()%></span>
                                </div>
                                <!-- /.user-block -->
                                <div class="box-tools">
                                </div>
                                <!-- /.box-tools -->
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                ${article.content}

                                <!-- Social sharing buttons -->
                                <button type="button" class="btn btn-default btn-xs"><i class="fa fa-share"></i> Share</button>
                                <button type="button" class="btn btn-default btn-xs"><i class="fa fa-thumbs-o-up"></i> Like</button>
                                <span class="pull-right text-muted">45 likes - 2 comments</span>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer box-comments">
                                <div class="box-comment">
                                    <!-- User image -->
                                    <img class="img-circle img-sm" src="${pageContext.request.contextPath}/images/article/gif/title.gif" alt="User Image">

                                    <div class="comment-text">
                      <span class="username">
                        Maria Gonzales
                        <span class="text-muted pull-right">8:03 PM Today</span>
                      </span><!-- /.username -->
                                        It is a long established fact that a reader will be distracted
                                        by the readable content of a page when looking at its layout.
                                    </div>
                                    <!-- /.comment-text -->
                                </div>
                                <!-- /.box-comment -->
                            </div>
                            <!-- /.box-footer -->
                            <div class="box-footer">
                                <form action="#" method="post">
                                    <img class="img-responsive img-circle img-sm" src="${pageContext.request.contextPath}/images/article/gif/title.gif" alt="Alt Text">
                                    <!-- .img-push is used to add margin to elements next to floating images -->
                                    <div class="img-push">
                                        <input type="text" class="form-control input-sm" placeholder="Press enter to post comment">
                                    </div>
                                </form>
                            </div>
                            <!-- /.box-footer -->
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


