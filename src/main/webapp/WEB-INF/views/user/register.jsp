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
                                        	<label>Name</label>
                                            <input readonly type="text" class="form-control" name="name" placeholder="Name" value="${name }">
                                        </div>
                                        <div class="form-group">
                                        	<label>Nickname</label>
                                            <input type="text" class="form-control" name="nickname" placeholder="Nickname" value="${nickname }">
                                        </div>
                                        <div class="form-group">
                                        	<label>Age</label>
                                            <input type="text" class="form-control" name="age" placeholder="Age">
                                        </div>
                                        <div class="form-group">
                                        	<label>Gender</label>
                                            <input readonly type="text" class="form-control" name="gender" placeholder="Gender" value="${gender }">
                                        </div>
                                        <div class="form-group">
                                        	<label>PhoneNumber</label>
                                            <input type="text" class="form-control" name="phonenum" placeholder="PhoneNumber">
                                        </div>
                                        <div class="form-group">
                                        	<label>Address</label>
                                            <input type="text" class="form-control" name="address" placeholder="Address">
                                        </div>
                                        <div class="form-group">
                                        	<label>Email</label>
                                            <input readonly type="email" class="form-control" name="email" placeholder="Email" value="${email }">
                                            <!-- 아예 못 바꾸게 -->
                                        </div>
                                        
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
		if (document.signup.phonenum.value == "") {
			alert("전화번호를 입력하세요.");
			document.signup.phonenum.focus();
			return false;
		}
		
		if (document.signup.address.value == "") {
			alert("주소를 입력하세요.");
			document.signup.address.focus();
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
