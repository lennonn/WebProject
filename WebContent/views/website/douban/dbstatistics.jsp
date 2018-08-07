<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Top Navigation</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
</head>
<body class="hold-transition skin-blue sidebar-mini">


<!-- BAR CHART -->
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
<script>
    new Chart(document.getElementById("canvas"), {
        type: 'bar',
        data: {
            labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
            datasets: [
                {
                    label: "Population (millions)",
                    backgroundColor: ["#3e95cd"],
                    data: [2478,5267,734,784,433]
                }
            ]
        },
        options: {
            legend: { display: false },
            title: {
                display: true,
                text: 'Predicted world population (millions) in 2050'
            }
        }
    });
</script>
</body>
</html>
