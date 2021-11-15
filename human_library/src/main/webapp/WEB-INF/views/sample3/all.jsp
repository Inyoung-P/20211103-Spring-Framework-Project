<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>all</h1>
	<a href="member">member</a>
	<a href="admin">admin</a>
	
	<hr>
	<p>principal : <sec:authentication property="principal"/></p>
	<sec:csrfInput/>
	<sec:authorize access="isAuthenticated()">
		<p>memberVo : <sec:authentication property="principal.memberVo"/></p>
		<p>userName : <sec:authentication property="principal.memberVo.userName"/></p>
		<p>username : <sec:authentication property="principal.username"/></p>
		<p>auths : <sec:authentication property="principal.memberVo.auths"/></p>
	</sec:authorize>
</body>
</html>