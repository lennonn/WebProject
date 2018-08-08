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
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
<!-- .box-footer -->
    <div class="box-footer ">
        <c:choose>
            <c:when test="${pageUrl.indexOf('?')!=-1}">
                <c:set var="bashPath" value="${pageContext.request.contextPath}${pageUrl}&"></c:set>
            </c:when>
            <c:otherwise>
                <c:set var="bashPath" value="${pageContext.request.contextPath}${pageUrl}?"></c:set>
            </c:otherwise>
        </c:choose>

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
                            <a href="#" onclick="getWebContent('${bashPath}page=${pageInfo.prePage}&size=${pageInfo.pageSize}')" aria-label="Previous">
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
                                        <a href="#" onclick="getWebContent('${bashPath}page=${i}&size=${pageInfo.pageSize}')">${i}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a href="#" onclick="getWebContent('${bashPath}page=${i}&size=${pageInfo.pageSize}')">${i}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${pageInfo.pageNum<pageInfo.navigatePages}">

                                <c:forEach var="i" begin="1" end="${pageInfo.navigatePages}" step="1">
                                    <c:choose>
                                        <c:when test="${i==pageInfo.pageNum}">
                                            <li class="active">
                                                <a href="#" onclick="getWebContent('${bashPath}page=${i}&size=${pageInfo.pageSize}')">${i}</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li>
                                                <a href="#" onclick="getWebContent('${bashPath}page=${i}&size=${pageInfo.pageSize}')">${i}</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <li>
                                    <span aria-hidden="true">...</span>
                                </li>
                                <li>
                                    <a href="#" onclick="getWebContent('${bashPath}page=${pageInfo.pages-1}&size=${pageInfo.pageSize}')">${pageInfo.pages-1}</a>
                                </li>
                                <li>
                                    <a href="#" onclick="getWebContent('${bashPath}page=${pageInfo.pages}&size=${pageInfo.pageSize}')">${pageInfo.pages}</a>
                                </li>
                            </c:when>
                            <c:when test="${pageInfo.pageNum>pageInfo.pages-7}">

                                <li>
                                    <a href="#" onclick="getWebContent('${bashPath}page=1&size=${pageInfo.pageSize}')">1</a>
                                </li>
                                <li>
                                    <a href="#" onclick="getWebContent('${bashPath}page=2&size=${pageInfo.pageSize}')">2</a>
                                </li>
                                <li>
                                    <span aria-hidden="true">...</span>
                                </li>
                                <c:forEach var="i" begin="${pageInfo.pages-7}" end="${pageInfo.pages}" step="1">
                                    <c:choose>
                                        <c:when test="${i==pageInfo.pageNum}">
                                            <li class="active">
                                                <a href="#" onclick="getWebContent('${bashPath}page=${i}&size=${pageInfo.pageSize}')">${i}</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li>
                                                <a href="#" onclick="getWebContent('${bashPath}page=${i}&size=${pageInfo.pageSize}')">${i}</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="#" onclick="getWebContent('${bashPath}page=1&size=${pageInfo.pageSize}')">1</a>
                                </li>
                                <li>
                                    <a href="#" onclick="getWebContent('${bashPath}page=2&size=${pageInfo.pageSize}')">2</a>
                                </li>
                                <li>
                                    <span aria-hidden="true">...</span>
                                </li>

                                <c:forEach var="i" begin="${pageInfo.navigateFirstPage+1}" end="${pageInfo.navigateLastPage-1}" step="1">
                                    <c:choose>
                                        <c:when test="${i==pageInfo.pageNum}">
                                            <li class="active">
                                                <a href="#" onclick="getWebContent('${bashPath}page=${i}&size=${pageInfo.pageSize}')">${i}</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li>
                                                <a href="#" onclick="getWebContent('${bashPath}page=${i}&size=${pageInfo.pageSize}')">${i}</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>

                                <li>
                                    <span aria-hidden="true">...</span>
                                </li>
                                <li>
                                    <a href="#" onclick="getWebContent('${bashPath}page=${pageInfo.pages-1}&size=${pageInfo.pageSize}')">${pageInfo.pages-1}</a>
                                </li>
                                <li>
                                    <a href="#" onclick="getWebContent('${bashPath}page=${pageInfo.pages}&size=${pageInfo.pageSize}')">${pageInfo.pages}</a>
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
                            <a href="#" onclick="getWebContent('${bashPath}page=${pageInfo.nextPage}&size=${pageInfo.pageSize}')" aria-label="Previous">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </c:if>
    </div>
<!-- /.box-footer -->
</body>
</html>

