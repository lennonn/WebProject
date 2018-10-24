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
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body>
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
     <i class="fa fa-text-width"></i>

     <h3 class="box-title">文章类型</h3>
 </div>
 <!-- /.box-header -->
 <div class="box-body" id="articleType">


 </div>
 <!-- /.box-body -->
</div>
         <div class="box box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">每日推荐</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <div class="box-group" id="accordion">
                    <div class="panel box box-primary">
                        <div class="box-header with-border">
                            <h4 class="box-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                    每日一句
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="box-body" id="dailySentence">

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
         <div class="info-box">
             <span class="info-box-icon bg-green"><i class="fa fa-flag-o"></i></span>

             <div class="info-box-content">
                 <span class="info-box-text">网站访问总量</span>
                 <span class="info-box-number"></span>
             </div>
             <!-- /.info-box-content -->
         </div>
     </div>
</body>
<script type="text/javascript">
    $(function(){
        $.ajax({
            url:"${pageContext.request.contextPath}/right/website/load",
            type:"post",
            success:function (res) {
                setArticleType(res);
                $(".info-box-number").html(res.pv);
                $("#dailySentence").html(res.dc.content);
            }
        });
    });
    function setArticleType(data){
            var html="";
            var atList =data.atList;
            debugger;
            for(var at in atList){
                html+='<p class="text-green"><a href="/article/findByTypeId?typeId='+atList[at].id+'">'+atList[at].typeName+'</a></p>';
            }
            $("#articleType").append(html);
    }
</script>
</html>

