<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Top Navigation</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/views/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/views/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/views/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">

    <header class="main-header">
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/views/index2.html" class="navbar-brand"><b>Admin</b>LTE</a>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Link</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                                <li class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" id="navbar-search-input" placeholder="Search">
                        </div>
                    </form>
                </div>
                <!-- /.navbar-collapse -->
                <!-- Navbar Right Menu -->
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li class="dropdown messages-menu">
                            <!-- Menu toggle button -->
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-envelope-o"></i>
                                <span class="label label-success">4</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 4 messages</li>
                                <li>
                                    <!-- inner menu: contains the messages -->
                                    <ul class="menu">
                                        <li><!-- start message -->
                                            <a href="#">
                                                <div class="pull-left">
                                                    <!-- User Image -->
                                                    <img src="${pageContext.request.contextPath}/views/dist/img/user2-160x160.jpg"
                                                         class="img-circle" alt="User Image">
                                                </div>
                                                <!-- Message title and timestamp -->
                                                <h4>
                                                    Support Team
                                                    <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                </h4>
                                                <!-- The message -->
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <!-- end message -->
                                    </ul>
                                    <!-- /.menu -->
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>
                        <!-- /.messages-menu -->

                        <!-- Notifications Menu -->
                        <li class="dropdown notifications-menu">
                            <!-- Menu toggle button -->
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-bell-o"></i>
                                <span class="label label-warning">10</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 10 notifications</li>
                                <li>
                                    <!-- Inner Menu: contains the notifications -->
                                    <ul class="menu">
                                        <li><!-- start notification -->
                                            <a href="#">
                                                <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                            </a>
                                        </li>
                                        <!-- end notification -->
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">View all</a></li>
                            </ul>
                        </li>
                        <!-- Tasks Menu -->
                        <li class="dropdown tasks-menu">
                            <!-- Menu Toggle Button -->
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-flag-o"></i>
                                <span class="label label-danger">9</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 9 tasks</li>
                                <li>
                                    <!-- Inner menu: contains the tasks -->
                                    <ul class="menu">
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <!-- Task title and progress text -->
                                                <h3>
                                                    Design some buttons
                                                    <small class="pull-right">20%</small>
                                                </h3>
                                                <!-- The progress bar -->
                                                <div class="progress xs">
                                                    <!-- Change the css width attribute to simulate progress -->
                                                    <div class="progress-bar progress-bar-aqua" style="width: 20%"
                                                         role="progressbar" aria-valuenow="20" aria-valuemin="0"
                                                         aria-valuemax="100">
                                                        <span class="sr-only">20% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <!-- end task item -->
                                    </ul>
                                </li>
                                <li class="footer">
                                    <a href="#">View all tasks</a>
                                </li>
                            </ul>
                        </li>
                        <!-- User Account Menu -->
                        <li class="dropdown user user-menu">
                            <!-- Menu Toggle Button -->
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <!-- The user image in the navbar-->
                                <img src="${pageContext.request.contextPath}/views/dist/img/user2-160x160.jpg"
                                     class="user-image" alt="User Image">
                                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                <span class="hidden-xs">Alexander Pierce</span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- The user image in the menu -->
                                <li class="user-header">
                                    <img src="${pageContext.request.contextPath}/views/dist/img/user2-160x160.jpg"
                                         class="img-circle" alt="User Image">

                                    <p>
                                        Alexander Pierce - Web Developer
                                        <small>Member since Nov. 2012</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="row">
                                        <div class="col-xs-4 text-center">
                                            <a href="#">Followers</a>
                                        </div>
                                        <div class="col-xs-4 text-center">
                                            <a href="#">Sales</a>
                                        </div>
                                        <div class="col-xs-4 text-center">
                                            <a href="#">Friends</a>
                                        </div>
                                    </div>
                                    <!-- /.row -->
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat">Profile</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-custom-menu -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </header>
    <!-- Full Width Column -->
    <div class="content-wrapper">
        <div class="container">
            <section class="content">
                <div class="callout callout-info">
                    <h4>Tip!</h4>

                    <p>Add the layout-top-nav class to the body tag to get this layout. This feature can also be used
                        with a
                        sidebar! So use this class if you want to remove the custom dropdown menus from the navbar and
                        use regular
                        links instead.</p>
                </div>
                <div class="row">
                    <div class="col-md-9">
                        <div class="box box-solid">
                            <div class="box-header with-border">
                                <i class="fa fa-text-width"></i>

                                <h3 class="box-title">最新文章</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <c:forEach items="${newsList}" var="item" varStatus="stat">
                                    <dl class="dl-horizontal">
                                        <h4><p class="text-aqua">${item.title}</p></h4>
                                        <dt><img src="${pageContext.request.contextPath}/images/books/book.jpg"
                                                 width="160" height="100" alt="First slide"></dt>
                                        <dd>${item.shortContent}...</dd>
                                        <c:if test="${!stat.last}">
                                            <hr/>
                                        </c:if>
                                    </dl>
                                </c:forEach>
                            </div>

                            <!-- /.box-body -->
                            <div class="box-footer ">
                                <c:if test="${pageInfo.pages>1}">
                                    <ul class="pagination pagination-right" style="float: right;">
                                        <c:choose>
                                           <c:when test="${pageInfo.isFirstPage==true}">
                                               <li class="disabled">
                                                       <span aria-hidden="true">&laquo;</span>
                                               </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/website/main?page=${pageInfo.prePage}&size=${pageInfo.size}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                        <span class="sr-only">Previous</span>
                                                    </a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:choose>
                                            <c:when test="${pageInfo.pages<=10}">
                                                <c:forEach var="i" begin="1" end="${pageInfo.pages}" step="1">
                                                    <c:choose>
                                                        <c:when test="${i==pageInfo.pageNum}">
                                                            <li class="active">
                                                                <a href="${pageContext.request.contextPath}/website/main?page=${i}&size=${pageInfo.size}">${i}</a>
                                                            </li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li>
                                                                <a href="${pageContext.request.contextPath}/website/main?page=${i}&size=${pageInfo.size}">${i}</a>
                                                            </li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </c:when>
                                             <c:otherwise>
                                                 <c:choose>
                                                     <c:when test="${pageInfo.pageNum<pageInfo.navigatePages}">

                                                     <c:forEach var="j" begin="1" end="${pageInfo.navigatePages}" step="1">
                                                         <c:choose>
                                                             <c:when test="${j==pageInfo.pageNum}">
                                                                 <li class="active">
                                                                     <a href="${pageContext.request.contextPath}/website/main?page=${j}&size=${pageInfo.size}">${j}</a>
                                                                 </li>
                                                             </c:when>
                                                             <c:otherwise>
                                                                 <li>
                                                                     <a href="${pageContext.request.contextPath}/website/main?page=${j}&size=${pageInfo.size}">${j}</a>
                                                                 </li>
                                                             </c:otherwise>
                                                         </c:choose>
                                                     </c:forEach>
                                                         <li>
                                                                 <span aria-hidden="true">...</span>
                                                         </li>
                                                         <li>
                                                             <a href="${pageContext.request.contextPath}/website/main?page=${pageInfo.pages-1}&size=${pageInfo.size}">${pageInfo.pages-1}</a>
                                                         </li>
                                                         <li>
                                                             <a href="${pageContext.request.contextPath}/website/main?page=${pageInfo.pages}&size=${pageInfo.size}">${pageInfo.pages}</a>
                                                         </li>
                                                     </c:when>
                                                     <c:when test="${pageInfo.pageNum>pageInfo.pages-7}">

                                                         <li>
                                                             <a href="${pageContext.request.contextPath}/website/main?page=1&size=${pageInfo.size}">1</a>
                                                         </li>
                                                         <li>
                                                             <a href="${pageContext.request.contextPath}/website/main?page=2&size=${pageInfo.size}">2</a>
                                                         </li>
                                                         <li>
                                                             <span aria-hidden="true">...</span>
                                                         </li>
                                                         <c:forEach var="j" begin="${pageInfo.pages-7}" end="${pageInfo.pages}" step="1">
                                                             <c:choose>
                                                                 <c:when test="${j==pageInfo.pageNum}">
                                                                     <li class="active">
                                                                         <a href="${pageContext.request.contextPath}/website/main?page=${j}&size=${pageInfo.size}">${j}</a>
                                                                     </li>
                                                                 </c:when>
                                                                 <c:otherwise>
                                                                     <li>
                                                                         <a href="${pageContext.request.contextPath}/website/main?page=${j}&size=${pageInfo.size}">${j}</a>
                                                                     </li>
                                                                 </c:otherwise>
                                                             </c:choose>
                                                         </c:forEach>
                                                     </c:when>
                                                         <c:otherwise>
                                                             <li>
                                                                 <a href="${pageContext.request.contextPath}/website/main?page=1&size=${pageInfo.size}">1</a>
                                                             </li>
                                                             <li>
                                                                 <a href="${pageContext.request.contextPath}/website/main?page=2&size=${pageInfo.size}">2</a>
                                                             </li>
                                                             <li>
                                                                 <span aria-hidden="true">...</span>
                                                             </li>

                                                             <c:forEach var="j" begin="${pageInfo.navigateFirstPage+1}" end="${pageInfo.navigateLastPage-1}" step="1">
                                                                 <c:choose>
                                                                     <c:when test="${j==pageInfo.pageNum}">
                                                                         <li class="active">
                                                                             <a href="${pageContext.request.contextPath}/website/main?page=${j}&size=${pageInfo.size}">${j}</a>
                                                                         </li>
                                                                     </c:when>
                                                                     <c:otherwise>
                                                                         <li>
                                                                             <a href="${pageContext.request.contextPath}/website/main?page=${j}&size=${pageInfo.size}">${j}</a>
                                                                         </li>
                                                                     </c:otherwise>
                                                                 </c:choose>
                                                             </c:forEach>

                                                             <li>
                                                                 <span aria-hidden="true">...</span>
                                                             </li>
                                                             <li>
                                                                 <a href="${pageContext.request.contextPath}/website/main?page=${pageInfo.pages-1}&size=${pageInfo.size}">${pageInfo.pages-1}</a>
                                                             </li>
                                                             <li>
                                                                 <a href="${pageContext.request.contextPath}/website/main?page=${pageInfo.pages}&size=${pageInfo.size}">${pageInfo.pages}</a>
                                                             </li>
                                                         </c:otherwise>
                                                 </c:choose>
                                             </c:otherwise>
                                         </c:choose>


                                        <c:choose>
                                            <c:when test="${pageInfo.isLastPage==true}">
                                                <li class="disabled">
                                                        <span aria-hidden="true">&raquo;</span>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/website/main?page=${pageInfo.nextPage}&size=${pageInfo.size}" aria-label="Previous">
                                                        <span aria-hidden="true">&raquo;</span>
                                                        <span class="sr-only">Previous</span>
                                                    </a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </ul>
                                </c:if>
                            </div>
                        </div>

                        <!-- /.box -->
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="box box-solid">
                            <div class="box-header with-border">
                                <h3 class="box-title">Carousel</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                                    <ol class="carousel-indicators">
                                        <li data-target="#carousel-example-generic" data-slide-to="0"
                                            class="active"></li>
                                        <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
                                        <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
                                    </ol>
                                    <div class="carousel-inner">
                                        <div class="item active">
                                            <img src="http://placehold.it/900x500/39CCCC/ffffff" alt="">

                                            <div class="carousel-caption">
                                                First Slide
                                            </div>
                                        </div>
                                        <div class="item">
                                            <img src="http://placehold.it/900x500/3c8dbc/ffffff" alt="">

                                            <div class="carousel-caption">
                                                Second Slide
                                            </div>
                                        </div>
                                        <div class="item">
                                            <img src="http://placehold.it/900x500/f39c12/ffffff" alt="">

                                            <div class="carousel-caption">
                                                Third Slide
                                            </div>
                                        </div>
                                    </div>
                                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                        <span class="fa fa-angle-left"></span>
                                    </a>
                                    <a class="right carousel-control" href="#carousel-example-generic"
                                       data-slide="next">
                                        <span class="fa fa-angle-right"></span>
                                    </a>
                                </div>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <div class="box box-solid">
                            <div class="box-header with-border">
                                <h3 class="box-title">Collapsible Accordion</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <div class="box-group" id="accordion">
                                    <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                    <div class="panel box box-primary">
                                        <div class="box-header with-border">
                                            <h4 class="box-title">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                                    Collapsible Group Item #1
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseOne" class="panel-collapse collapse in">
                                            <div class="box-body">
                                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus
                                                terry richardson ad squid. 3
                                                wolf moon officia aute, non cupidatat skateboard dolor brunch. Food
                                                truck quinoa nesciunt laborum
                                                eiusmod.
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel box box-danger">
                                        <div class="box-header with-border">
                                            <h4 class="box-title">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                                    Collapsible Group Danger
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseTwo" class="panel-collapse collapse">
                                            <div class="box-body">
                                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus
                                                terry richardson ad squid. 3
                                                wolf moon officia aute, non cupidatat skateboard dolor brunch. Food
                                                truck quinoa nesciunt laborum
                                                eiusmod.
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel box box-success">
                                        <div class="box-header with-border">
                                            <h4 class="box-title">
                                                <a data-toggle="collapse" data-parent="#accordion"
                                                   href="#collapseThree">
                                                    Collapsible Group Success
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseThree" class="panel-collapse collapse">
                                            <div class="box-body">
                                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus
                                                terry richardson ad squid. 3
                                                wolf moon officia aute, non cupidatat skateboard dolor brunch. Food
                                                truck quinoa nesciunt laborum
                                                eiusmod.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <div class="info-box bg-aqua">
                            <span class="info-box-icon"><i class="fa fa-bookmark-o"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Bookmarks</span>
                                <span class="info-box-number">41,410</span>

                                <div class="progress">
                                    <div class="progress-bar" style="width: 70%"></div>
                                </div>
                                <span class="progress-description">
                    70% Increase in 30 Days
                  </span>
                            </div>
                            <!-- /.info-box-content -->
                        </div>
                        <!-- /.box -->
                    </div>
                </div>
                <!-- /.box -->
            </section>
            <!-- /.content -->
        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
        <div class="container">
            <div class="pull-right hidden-xs">
                <b>Version</b> 2.4.0
            </div>
            <strong>Copyright &copy; 2014-2016 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All rights
            reserved.
        </div>
        <!-- /.container -->
    </footer>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/views/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/views/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/views/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/views/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/views/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/views/dist/js/demo.js"></script>
</body>
</html>

