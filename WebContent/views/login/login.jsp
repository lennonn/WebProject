<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>

    <script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/validator/bootstrapValidator.css"/>

    <link href="${pageContext.request.contextPath}/css/font-awesome/font-awesome.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/validator/bootstrapValidator.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login/style.css">



</head>
<body>

<div class="container">
    <div class="row">
        <!-- form: -->
        <section>
            <div class="page-header">
                <h1>请登录系统</h1>
            </div>

            <div class="col-lg-8 col-lg-offset-2">
                <form id="login_form" method="post" action="" class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">用户名</label>
                            <div class="col-lg-5">
                                <input type="text" class="form-control" name="username" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">密码</label>
                            <div class="col-lg-5">
                                <input type="password" class="form-control" name="password" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-5 col-lg-offset-3">
                                <div id="loginErrorMsg" style="color: red">
                                </div>
                            </div>
                        </div>
                    </fieldset>

                    <div class="form-group">
                        <div class="col-lg-5 col-lg-offset-3">
                            <button type="button" class="btn btn-block btn-primary btn-sm" onclick="javascript:_login();">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- :form -->
    </div>
</div>

<script type="text/javascript">

    function _login() {

        $.ajax({
            url: "<%=request.getContextPath()%>/signin",
            type: "post",
            dataType: "json",
            data: $("#login_form").serialize(),
            success: function (res) {
                debugger;
                if (!res.isSuccess) {
                    $("#loginErrorMsg").text(res.msg);
                } else {//用户验证成功
                    window.location.href = "<%=request.getContextPath()%>/views/index";
                }
            }
        });
    }
</script>
</body>
</html>