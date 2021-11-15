<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<sec:csrfMetaTags/>
<!DOCTYPE html>
<html lang="ko" class="html">
<head>
	<meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>휴먼대학교 도서관</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
	<jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
		<main>
<%-- 			<sec:authorize access="isAnonymous()">
				<script>
					alert("자리예약은 로그인 후 가능합니다.");
					location.href='${pageContext.request.contextPath}/';
				</script>
			</sec:authorize> --%>
<%-- 			<sec:authorize access="isAuthenticated()"> --%>
	        <div class="row" id="skies">
	        </div>
	        <div class="container">
	        <div class="row col-10 mx-auto py-3" id="mainSec">
	            <div class="col-lg-3 col-12" id="progress">
	                <div class="vprogress d-none d-lg-block">
	                    <div class="circle bg-primary"></div>
	                    <div class="circle bg-primary"></div>
	                    <div class="circle bg-primary"></div>      
	                </div>
	                <div class="hprogress d-lg-none my-3">
	                    <div class="circle bg-primary my-2"></div>
	                    <div class="circle bg-primary my-2"></div>
	                    <div class="circle bg-primary my-2"></div>      
	                </div>
	            </div>
	            <div class="col-lg-9 col-12 my-8">
	            	<div class="locSec my-4 p-1 col-11 mx-auto">
                    <div class="row my-4">
                        <div class="col-5 mx-auto">
                            <a href="/seat/list?loc=1">제 1열람실</a>
                        </div>
                        <div class="col-5 mx-auto">
                            <a href="/seat/list?loc=2">제 2열람실</a>
                        </div>
                    </div>
                    <div class="row my-4">
                        <div class="col-5 mx-auto">
                            <a href="/seat/list?loc=3">제 3열람실</a>
                        </div>
                        <div class="col-5 mx-auto">
                            <a href="/seat/list?loc=4">제 4열람실</a>
                        </div>
                    </div>
                </div>
	            </div>
	        </div>
	    </div>
<%-- 	    </sec:authorize> --%>
    </main>
    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <script>
    $(function () {
        var token = $("meta[name='_csrf']").attr('content');
        var header = $("meta[name='_csrf_header']").attr('content');
        if(token && header) {
            $(document).ajaxSend(function(event, xhr, options) {
                xhr.setRequestHeader(header, token);
            });
        }
        var code='${code}';
    	if(code==2){
    		alert("이미 예약된 좌석입니다.\n다시 선택해주세요.");
    	}
    });
    	
    </script>
</body>
</html>