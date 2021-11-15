<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
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
			<sec:authorize access="hasAnyRole('ROLE_ANONYMOUS', 'ROLE_MEMBER')">
			<script>
				alert('해당 페이지는 관리자만 접근이 가능합니다.');
				location.href='${pageContext.request.contextPath}/';
			</script>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
	        <div class="managerBoard">
	            <div class="managerBoardArea mx-auto">
	            		<div class="managerBoardBox px-2 py-5">
		                    <div class="bookListTitle clearfix pb-2 border-bottom border-2 border-info">
		                        <h5 class="float-left text-info">열람실 관리</h5>
		                    </div>
		                    <form method="post">
		                    	<div class="form-check-inline my-3">
								  <label class="form-check-label">
								    <input type="radio" class="form-check-input lchoose" name="loc" value="1" onclick="slist(1)">열람실 1
								  </label>
								</div>
								<div class="form-check-inline">
								  <label class="form-check-label">
								    <input type="radio" class="form-check-input lchoose" name="loc" value="2" onclick="slist(2)">열람실 2
								  </label>
								</div>
								<div class="form-check-inline">
								  <label class="form-check-label">
								    <input type="radio" class="form-check-input lchoose" name="loc" value="3" onclick="slist(3)">열람실 3
								  </label>
								</div>
								<div class="form-check-inline">
								  <label class="form-check-label">
								    <input type="radio" class="form-check-input lchoose" name="loc" value="4" onclick="slist(4)">열람실 4
								  </label>
								</div>
								<div class="form-group">
								  <label for="sel1">좌석번호:</label>
									  <select class="form-control schoose" id="sel1" name="seatNo" required>
										    <option class="sdefault" disabled>열람실을 선택해주세요</option>
									  </select>
								</div>
								<input type="text" class="form-control" placeholder="사유를 입력해주세요." name="reason" required>
		             			<input type="submit" class="btn btn-primary float-right my-2" value="등록">
		             		</form>
							<div class="table-responsive my-3 revTable">
								<table class="table table-hover">
									<thead class="bg-dark text-light">
										<tr>
											<th colspan="4" class="border-right border-light text-center small">이용불가좌석정보</th>
										</tr>
										<tr>
											<th class="border-right border-light text-center small align-middle">좌석번호</th>
											<th class="border-right border-light text-center small align-middle">열람실 번호</th>
											<th class="border-right border-light text-center small align-middle">불가 사유</th>
											<th class="border-right border-light text-center small align-middle">삭제</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${list}" var="na">
										<tr>
											<td class="text-center small">${na.seatNo}</td>
											<td class="text-center small">${na.loc}</td>
											<td class="text-center small">${na.reason}</td>
										 	<td class="text-center small">
												<button type="button" class="btn btn-outline-warning btn-sm small d-inline" onclick="ndelete(${na.NANo})">삭제</button>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
		                </div>
                	</div>
	        </div>
	     </sec:authorize>   
	    </main>
    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <script>
    	var code='${code}';
    	if(code==1){
    		alert("이미 이용불가인 좌석입니다.");
    	}
    	function slist(data){
    		var str="";
    		if(data%2==1){
    			for(var i=1;i<=25;i++){
    				str+='<option value="'+i+'">'+i+'</option>';
    			}
    			$(".schoose").html(str);
    		}
    		else{
    			for(var j=1;j<=42;j++){
    				str+='<option value="'+j+'">'+j+'</option>';
    			}
    			$(".schoose").html(str);
    		}
    		
    	}
    	
    	function ndelete(data){
	        if(confirm("해당좌석의 상태를 변경하시겠습니까?")) {
	        	$.ajax("update/"+data,{
	                type : "delete",
	                success:function(a){
		            	  
		                alert("변경이 완료되었습니다.");
		             	location.reload();
		              }
	              })
	        } else {
	            
	        }
	    }
    </script>
</body>
</html>