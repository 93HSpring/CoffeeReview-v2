<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<% request.setCharacterEncoding("UTF-8"); %>

<%@include file="../includes/header.jsp" %>

<body>
	

    <div id="wrapper">

		<!-- Navigation -->
        <%@include file="../includes/nav.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">회원가입</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <!-- 회원가입 양식 출력 -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" name="signup" onsubmit="return checkForm()" method="post">
                                        <div class="form-group">
                                            <input type="hidden" class="form-control" name="uid" value="${uid }">
                                        </div>
                                        <div class="form-group">
                                        	<label>Nickname</label>
                                            <input type="text" class="form-control" name="nickname" placeholder="Nickname" value="${nickname }" maxlength='10'>
                                        </div>
                                        <div class="form-group">
                                        	<label>Password</label>
                                            <input type="password" class="form-control" name="password" placeholder="Password" value="${password }" maxlength='20'>
                                        </div>
                                        <div class="form-group">
                                        	<label>Name</label>
                                            <input type="text" class="form-control" name="name" placeholder="Name" value="${name }">
                                        </div>
                                        <div class="form-group">
                                        	<label>PhoneNumber</label>
                                            <input type="text" class="form-control" name="phonenum" placeholder="PhoneNumber">
                                        </div>
                                        <div class="form-group">
                                        	<label>E-mail</label>
                                            <input type="text" class="form-control" name="email" placeholder="E-mail" value="${email }">
                                        </div>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        
                                        <button type="submit" class="btn btn-default">Register</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- 회원가입 양식 출력 끝 -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- plugin-js -->
    <%@include file="../includes/plugin_js.jsp" %>
    
    <!-- import JS -->
   	<script type="text/javascript" src="/resources/js/common.js?ver=0.1.1"></script>
    <script>
    function checkForm() {
		if (document.signup.nickname.value == "") {
			alert("닉네임을 입력하세요.");
			document.signup.nickname.focus();
			return false;
		}
		
		alert("회원가입이 완료되었습니다. 가입한 아이디로 로그인해주세요.");
		document.signup.action = "signup";
		return true;
		
	}
	</script>

	<!-- id name nickname age gender email  -->
    

</body>

</html>
