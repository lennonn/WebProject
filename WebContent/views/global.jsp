<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/5
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Ionicons/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dist/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dist/skins/_all-skins.min.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/morris/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jvectormap/jquery-jvectormap.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/datepicker/bootstrap-datepicker.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/daterangepicker/daterangepicker.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugins/iCheck/all.css">


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/table/bootstrap-table.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/bower_components/select2/dist/css/select2.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/select/bootstrap-select.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/treeview/bootstrap-treeview.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  </head>
    <!-- jQuery 3 -->
    <script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="${pageContext.request.contextPath}/js/jquery/ui/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.7 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>

    <script src="${pageContext.request.contextPath}/js/bootstrap/treeview/bootstrap-treeview.js"></script>
    <%--
    <script src="${pageContext.request.contextPath}/js/bootstrap/table/locale/bootstrap-table-zh-CN.js"></script>
    --%>
    <script src="${pageContext.request.contextPath}/js/bootstrap/table/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/select/bootstrap-select.js"></script>

    <!-- Morris.js charts -->
    <script src="${pageContext.request.contextPath}/views/bower_components/raphael/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/morris/morris.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/zlennon-pub.js"></script>
    <!-- Select2 -->
    <script src="${pageContext.request.contextPath}/views/bower_components/select2/dist/js/select2.full.min.js"></script>
    <!-- Sparkline -->
    <script src="${pageContext.request.contextPath}/js/jquery/sparkline/jquery.sparkline.min.js"></script>
    <!-- jvectormap -->
    <script src="${pageContext.request.contextPath}/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <!-- jQuery Knob Chart -->
    <script src="${pageContext.request.contextPath}/js/jquery/knob/jquery.knob.min.js"></script>
    <!-- daterangepicker -->
    <script src="${pageContext.request.contextPath}/js/moment/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/daterangepicker/daterangepicker.js"></script>
    <!-- datepicker -->
    <script src="${pageContext.request.contextPath}/js/bootstrap/datepicker/bootstrap-datepicker.min.js"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="${pageContext.request.contextPath}/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <!-- PACE -->
    <script src="${pageContext.request.contextPath}/js/pace/pace.min.js"></script>
    <!-- Slimscroll -->
    <script src="${pageContext.request.contextPath}/js/jquery/slimscroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="${pageContext.request.contextPath}/js/fastclick/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/js/dist/adminlte.min.js"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="${pageContext.request.contextPath}/js/dist/page/dashboard.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${pageContext.request.contextPath}/js/dist/demo.js"></script>
    <!-- iCheck 1.0.1 -->
    <script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(function () {
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' /* optional */
            });
        });
    </script>

    <script src="${pageContext.request.contextPath}/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/zlennon-pub.js"></script>
<script type="text/javascript">
    function getRootPath() {
        //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
        var curWwwPath = window.document.location.href;
        //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8083
        var localhostPaht = curWwwPath.substring(0, pos);
        //获取带"/"的项目名，如：/uimcardprj
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        //生产环境 没有项目名称
        // var projectName = '';
        return (localhostPaht + projectName);
    }
</script>

</html>
