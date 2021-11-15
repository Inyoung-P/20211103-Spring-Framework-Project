<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<jsp:include page="../includes/head.jsp"/>
	<script src="https://code.jquery.com/jquery-3.4.1.js"
  			integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  			crossorigin="anonymous">
	</script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/terms.css">
</head>

<body>
<jsp:include page="../includes/header.jsp" />
	<form class="terms_form" action="join" onsubmit="return CheckForm(this)" name="chkBox">
        <h2 class="terms_h2">홈페이지 이용약관</h2>
        	<div class="agree">
             	<div>

                  제 1 조 (목적)

                  힘내세요! 화이팅 하세요!! 화이팅할수있으면 동의하시고 아니면 그냥 돌아가세요
                </div>
                	<p><input type="checkbox" id="chk1" name="chk1"><label for="chk1">홈페이지 이용약관에 동의합니다.(동의하지 않을경우 가입되지 않습니다.)</label></p>
			</div>
			<div class="agree">
				<div>

                  제 1 조 (목적)

                  
                  이용약관입니다. 동의하시면 체크박스에 체크해주세요
                  
                  신중히 생각해주시고 체크해주세요... 동의 후 피해에 대한 책임은 회원 개인에게 있음을 밝힙니다.
                </div>
					<p><input type="checkbox" id="chk2" name="chk2"><label for="chk1" class="chk1_label">홈페이지 이용약관에 동의합니다.(동의하지 않을경우 가입되지 않습니다.)</label></p>
			</div>
			<button class="btn btn-secondary btn-block">동의 후 가입하기</button>
	</form>
<jsp:include page="../includes/footer.jsp" />
<script>
function CheckForm(Join){
    
    var chk1=document.chkBox.chk1.checked
    var chk2=document.chkBox.chk2.checked
    
    if(!chk1){
        alert('서비스 이용약관에 동의해 주세요');
        return false;
    } 
    if(!chk2) {
        alert('개인정보 수집 및 이용에 동의해 주세요');
        return false;
    }
}
</script>
</body>
</html>