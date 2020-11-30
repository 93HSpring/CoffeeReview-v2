<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/sample/admin page</h1>
	
	<p>principal : <sec:authentication property="principal"/></p>
	<!-- CustomUserDetailsService가 반환한 객체
		-> loadUserByUserUsername()에서 반환된 CustomUser객체 -->
	
	<p>UserVO : <sec:authentication property="principal.user"/></p>
	<!-- CustomUser객체의 getMember() -->
	
	<p>사용자이름 : <sec:authentication property="principal.user.uid"/></p>
	<!-- CustomUser객체의 getMember()의 uid -->
	
	<p>사용자아이디 : <sec:authentication property="principal.uid"/></p>
	<!-- CustomUser객체의 uid -->
	
	<p>사용자권한리스트 : <sec:authentication property="principal.user.authList"/></p>
	<!-- CustomUser객체의 authList -->
	
	
	
	<a href="/customLogout">Logout</a>
</body>
</html>