<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="../includes/head.jsp"/>
	<script src="https://code.jquery.com/jquery-3.4.1.js"
  			integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  			crossorigin="anonymous">
	</script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/memberjoin.css">
	<sec:csrfMetaTags/>
</head>
<body>
	<jsp:include page="../includes/header.jsp" />
<main>
	<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-11 col-sm-9 col-md-7 col-lg-6 col-xl-5 text-center p-0 mt-3 mb-2">
            <div class="card px-0 pt-4 pb-0 mt-3 mb-3">
                <h2 id="heading">회원 가입</h2>
                <p>휴먼 도서관 회원가입 페이지 입니다!</p>
                <form id="msform" method="post">
                    <!-- progressbar -->
                    <ul id="progressbar">
                        <li class="active" id="account"><strong>계정정보</strong></li>
                        <li id="personal"><strong>상세정보</strong></li>
                        <li id="payment"><strong>프로필</strong></li>
                        <li id="confirm"><strong>가입완료</strong></li>
                    </ul>
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuemin="0" aria-valuemax="100"></div>
                    </div> <br> <!-- fieldsets -->
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-7">
                                    <h2 class="fs-title">계정 정보 입력:</h2>
                                </div>
                                <div class="col-5">
                                    <h2 class="steps">Step 1 - 4</h2>
                                </div>
                            </div> 
                            	<label class="fieldlabels">아이디: *</label><input type="text" name="id" id="id" placeholder="아이디를 입력하세요" />
                            	<label class="fieldlabels">이름: *</label><input type="text" name="name" id="name" placeholder="이름을 입력하세요" />
                            	<label class="fieldlabels">비밀번호: *</label><input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요" />
                            	<!-- <label class="fieldlabels">비밀번호 확인: *</label><input type="password" id="pwd" placeholder="비밀번호를 다시입력하세요" /> -->
                        	</div>
                        	<input type="button" name="next" class="next action-button" value="Next" />
                    		<sec:csrfInput/>
                    </fieldset>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-7">
                                    <h2 class="fs-title">상세 정보 입력:</h2>
                                </div>
                                <div class="col-5">
                                    <h2 class="steps">Step 2 - 4</h2>
                                </div>
                            </div>
                            	<label class="fieldlabels">닉네임: *</label><input type="text" name="nickName" id="nickName" placeholder="닉네임을 입력하세요" />
                            	<label class="fieldlabels">학번: *</label><input type="text" name="studNo" id="studNo" placeholder="학번을 입력하세요" />
                            	<label class="fieldlabels">폰넘버: *</label><input type="text" name="phone" id="phone" placeholder="스마트폰번호를 입력하세요" />
                            	<label class="fieldlabels">이메일: *</label><input type="text" name="email" id="email" placeholder="이메일을 입력하세요" />
                        	</div>
                        	<input type="button" name="next" class="next action-button" value="Next" /> <input type="button" name="previous" class="previous action-button-previous" value="Previous" />
                        	<sec:csrfInput/>
                    </fieldset>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-7">
                                    <h2 class="fs-title">프로필 사진 입력:</h2>
                                </div>
                                <div class="col-5">
                                    <h2 class="steps">Step 3 - 4</h2>
                                </div>
                            </div>
                            	<label class="fieldlabels">사진 등록:</label><input type="file" name="uuid" id="uuid" accept="image/*">
                        	</div>
                        	<input type="button" name="next" class="next action-button join_button" value="Submit" />
                        	<sec:csrfInput/>
                        	<input type="button" name="previous" class="previous action-button-previous" value="Previous" />
                        	<sec:csrfInput/>
                    </fieldset>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-7">
                                    <h2 class="fs-title">가입 완료:</h2>
                                </div>
                                <div class="col-5">
                                    <h2 class="steps">Step 4 - 4</h2>
                                </div>
                            </div> <br><br>
                            <h2 class="purple-text text-center"><strong>휴먼도서관 가입을 환영합니다!</strong></h2> <br>
                            <div class="row justify-content-center">
                                <div class="col-3"> <img src="https://i.imgur.com/GwStPmg.png" class="fit-image"> </div>
                            </div> <br><br>
                            <div class="row justify-content-center">
                                <div class="col-7 text-center">
                                    <h5 class="purple-text text-center"> 로그인 하시고 이용해주세요</h5>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <sec:csrfInput/>
                </form>
            </div>
        </div>
    </div>
</div>

</main>

<script>
$(document).ready(function(){
	//회원가입 버튼(회원가입 기능 작동)
	$(".join_button").click(function(){
		console.log("가입");
		$("#msform").attr("action", "/member/join");
		$("#msform").submit();
	});
});

	$("#Next").on("click", function(){
		if($("#id").val()==""){
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		if($("#pwd").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#pwd").focus();
			return false;
		}
		if($("#name").val()==""){
			alert("성명을 입력해주세요.");
			$("#name").focus();
			return false;
		}
	});
	
	$("#Next").on("click", function(){
		if($("#nickName").val()==""){
			alert("닉네임 입력해주세요.");
			$("#nickName").focus();
			return false;
		}
		if($("#studNo").val()==""){
			alert("학번을 입력해주세요.");
			$("#studNo").focus();
			return false;
		}
		if($("#phone").val()==""){
			alert("전화번호를 입력해주세요.");
			$("#전화번호").focus();
			return false;
		}
		if($("#emali").val()==""){
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return false;
		}
	});
</script>

<script src="${pageContext.request.contextPath}/resources/js/memberjoin.js"></script>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>