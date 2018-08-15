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
    <title>AdminLTE 2 | Top Navigation</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
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
                        <div class="box box-success">
                            <div class="box-header with-border">
                                <h3 class="box-title">豆瓣书籍评分统计</h3>
                            </div>
                            <div class="box-body">
                                <div class="chart">
                                    <canvas id="canvas" style="height:500px"></canvas>
                                </div>
                            </div>
                            <!-- /.box-body -->
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<script>
    var star=[];
    var counts=[];
    <c:forEach items="${groupList}" var="group">
    <c:forEach items="${group }" var="map"  >
    if(${map.key=='total'}){
        counts.push(${map.value});
    }else{
        star.push(${map.value});
    }
    </c:forEach>
    </c:forEach>
    var barChartData = {
        labels : star,
        datasets : [
            {
                label: "总数",
                backgroundColor: "#3e95cd",
                data: counts
            }
        ]

    }
    // var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Bar(barChartData, defaults);
    new Chart(document.getElementById("canvas"), {
        type: 'bar',
        data: {
            labels : star,
            datasets : [
                {
                    label: "总数",
                    backgroundColor: "#3e95cd",
                    data: counts
                }
            ]
        },
        options: {
            onClick: function(evt) {
                var activePoints = this.getElementsAtEvent(evt);
                var firstPoint = activePoints[0];
                var label = this.data.labels[firstPoint._index];
                window.location.href="${pageContext.request.contextPath}/website/dbTagList/list?star="+label;
            },
            legend: { display: true
            },
            scaleGridLineColor: "rgba(0,0,0,.05)",
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                        fontColor:'#fff'

                    },
                }]
            },
            animation:{                              //动画配置
                duration:1000                        //动画播放时间
            },
            title: {
                display: true,
                text: '豆瓣评分9分以上书籍统计'
            }
        }
    });
</script>
</body>
</html>

