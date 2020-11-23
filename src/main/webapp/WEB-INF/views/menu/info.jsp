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
                    <h1 class="page-header">${menuInfo.cafe}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                   	<div class="panel panel-default">
                       	<div class="panel-heading">
                       		${menuInfo.menu}
                       	</div>
                       	<div class="panel-body">
                       		<div class="col-sm-6">
                       			<img src='/menu/display?menuName=${menuInfo.cafe}/${menuInfo.menu}' class="full-width">
                       		</div>
                       		<div class="col-sm-6">
                       			<h3> 상세 정보 </h3>
                       			<ul>
                       				<li>
		                       			<dl>
		                       				<dt>카페인 (mg)</dt><dd>${menuInfo.caffeine}</dd>
		                       			</dl>
		                       		</li>
		                       		<li>
		                       			<dl>
		                       				<dt>칼로리 (kcal)</dt><dd>${menuInfo.kcal}</dd>
		                       			</dl>
		                       		</li>
		                       		<li>
		                       			<dl>
		                       				<dt>나트륨 (mg)</dt><dd>${menuInfo.sodium}</dd>
		                       			</dl>
		                       		</li>
		                       		<li>
		                       			<dl>
		                       				<dt>당류 (g)</dt><dd>${menuInfo.sugars}</dd>
		                       			</dl>
	                       			</li>
                       			</ul>
                       		</div>
                       	</div>
                       	<div class="panel-footer">
                       		
                       	</div>
                       </div>
                    <!-- /.panel -->
                	</div>
                <!-- /.col-xs-3 -->
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
