<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="../includes/header.jsp" %>

<body>

    <div id="wrapper">

		<!-- Navigation -->
        <%@include file="../includes/nav.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">카페 이름</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-3">
                    <div class="panel panel-default">
                        <c:forEach items="${list}" var="menu">
                        	<div class="panel-heading text-center">
                        		<c:out value="${menu.menu}" />
                        	</div>
                        	<div class="panel-body p-0">
                        		<img src='/menu/display?fileName=STARBUCKS/나이트로 쇼콜라 클라우드' class="full-width">
                        	</div>
                        	<div class="panel-footer text-center">
                        		<p class="fa fa-star m-0">
                        		<c:out value="${menu.star_avg}" />
                        	</div>
                        </c:forEach>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- plugin-js -->
    <%@include file="../includes/plugin_js.jsp" %>
    
    <script>
    
    	$.getJSON("/menu/display", {fileName : "나이트로 쇼콜라 클라우드"}, function())
    
    </script>

</body>

</html>
