<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login/style.css">



</head>
<body>
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3">
                <form  id="login_form" name="login_form" method="post">
                <h3 class="form-title">LOGIN</h3>
                <div class="col-md-9">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                            <i class="fa fa-lock fa-lg"></i>
                            <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
                    </div>
<%--                    <div class="form-group">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/>记住我
                        </label>
                    </div>--%>
                    <div class="form-group">
                        <input type="button"  id= "login_btn" name="login_btn"  value="登陆"class="btn btn-success" onclick="javascript:_login();"/>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
<script type="text/javascript">

    function _login(){
        var  name =$("#username").val();
        var  passwd = $("#password").val();
        if(!name){
            alert("请输入用户名！");
            return false;
        }else{

        }
        if(!passwd){
            alert("请输入密码！");
            return false;
        }
       $("#login_form").attr("action","<%=request.getContextPath()%>/signin");
        $("#login_form").submit();
    }
</script>
</body>
</html>