<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="../includes/head.jsp"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/memberlogin.css">
	<sec:csrfMetaTags/>
</head>

<body>
	<jsp:include page="../includes/header.jsp" />
	<main>
		<div class="container d-flex justify-content-center align-items-center">
    		<div class="card">
        		<div class="p-3 border-bottom d-flex align-items-center justify-content-center">
            		<h5>Login to HexGig</h5>
        		</div>
        		<form class="member" method="post" action="/login">
        			<div class="p-3 px-4 py-4 border-bottom"><input type="text" name="username" id="id" class="form-control mb-2" placeholder="아이디를 입력하세요" />
            		<div class="form"><input type="text" name="password" id="pwd" class="form-control" placeholder="비밀번호를 입력하세요" /><a href="#">비밀번호를 잊으셨나요?</a></div>
            
            		<button class="btn btn-danger btn-block continue" type="submit">로그인</button>
            		<sec:csrfInput/>
            	</form>
            	
            	<div class="d-flex justify-content-center align-items-center mt-3 mb-3">
            		<span class="line"></span><small class="px-2 line-text">OR</small><span class="line"></span>
            	</div>
            	<button class="btn btn-danger btn-block continue facebook-button d-flex justify-content-start align-items-center">
            		<i class="fa fa-facebook ml-2"></i><span class="ml-5 px-4">Continue with facebook</span>
            	</button>
            	<button class="btn btn-danger btn-block continue google-button d-flex justify-content-start align-items-center">
            		<i class="fa fa-google ml-2"></i><span class="ml-5 px-4">Continue with Google</span>
            	</button>
        	</div>
        	<div class="p-3 d-flex flex-row justify-content-center align-items-center member"><span>회원이 아니신가요?</span><a href="/member/terms" class="text-decoration-none ml-2">가입하러가기</a></div>
    	</div>
	</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>