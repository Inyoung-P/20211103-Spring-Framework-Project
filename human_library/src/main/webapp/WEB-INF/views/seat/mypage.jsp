<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
		  <sec:authorize access="isAnonymous()">
				<script>
					alert('로그인 후 이용가능합니다.');
					location.href='${pageContext.request.contextPath}/';
				</script>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal" var="pinfo"/>
		        <div class="container">
		        	<div class="row mx-auto" >
		        		<div class="col-12 col-md-3 py-5">
		        			<div class="vSidebar">
			        		 	<h5 class="side-title"><span>MY PAGE</span></h5>
								<div class="side-content">
									<div class="menu-block-wrapper menu-block-ctools-main-menu-1 menu-name-main-menu parent-mlid-17090 menu-level-1">
										<ul class="side">
											<li><b>MY</b></li>
											<li>-&nbsp;&nbsp;<a class="ml-2" href="${pageContext.request.contextPath}/member/profile">회원정보</a></li>
											<li><b>MY서재</b></li>
											<li>-&nbsp;&nbsp;<a class="ml-2" href="${pageContext.request.contextPath}/loans/listLoansReservationForMember">대출 예약 현황</a></li>
											<li>-&nbsp;&nbsp;<a class="ml-2" href="${pageContext.request.contextPath}/loans/listLoansForMember">도서대출현황</a></li>
											<li>-&nbsp;&nbsp;<a class="ml-2" href="${pageContext.request.contextPath}/loans/listReturnedLoans">나의대출목록</a></li>
											<li><b>MY좌석</b></li>
											<li class="bg-dark">-&nbsp;&nbsp;<a class="ml-2 text-light" href="${pageContext.request.contextPath}/seat/mypage">자리예약현황</a></li>
											<li><b>MY마켓</b></li>
											<li>-&nbsp;&nbsp;<a class="ml-2" href="void(0);" onclick="alert('서비스를 준비중입니다.');return false;">내게시글관리</a></li>
											<li>-&nbsp;&nbsp;<a class="ml-2" href="void(0);" onclick="alert('서비스를 준비중입니다.');return false;">내리뷰관리</a></li>
										</ul>
									</div>
								</div>
							</div>
		        		</div>
		            	<div class="col-md-9 col-12" >
		            		<div class="managerBoardBox px-2 py-5">
			                    <div class="bookListTitle clearfix pb-2 border-bottom border-2 border-info">
			                        <h5 class="float-left text-info">My 예약</h5>
			                    </div>
								<div class="table-responsive my-3 revTable">
									<table class="table table-hover">
										<thead class="bg-dark text-light">
											<tr>
												<th colspan="3" class="border-right border-light text-center small">자리정보</th>
												<th colspan="3" class="border-right border-light text-center small">예약정보</th>
											</tr>
											<tr>
												<th class="border-right border-light text-center small">예약<br>번호</th>
												<th class="border-right border-light text-center small">좌석<br>번호</th>
												<th class="border-right border-light text-center small align-middle">열람실</th>
												<th class="border-right border-light text-center small align-middle">예약일</th>
												<th class="border-right border-light text-center small">예약<br>시간</th>
												<th class="border-right border-light text-center small bg-primary">예약<br>상태</th> 
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${list}" var="mySRev">
											<tr>
												<td class="text-center small">${mySRev.revNo}</td>
												<td class="text-center small">${mySRev.seatNo}</td>
												<td class="text-center small">${mySRev.loc}</td>
												<td class="text-center small">
													<fmt:formatDate pattern="yyyy-MM-dd" value="${mySRev.revDate}"/>
												</td>
												<td class="text-center small">${mySRev.revTime+8}:00 - ${mySRev.revTime+9}:00 </td>
												<td class="text-center small revStatus">
													<fmt:formatDate var="revDate" pattern="yyyy-MM-dd" value="${mySRev.revDate}"/>
													<fmt:formatDate var="sysdate" pattern="yyyy-MM-dd" value="${today}"/>
													<c:choose>
														<c:when test="${revDate >= sysdate && mySRev.revTime >= current}">
															<button type="button" class="btn btn-outline-warning btn-sm small d-inline" onclick="revCancel(${mySRev.revNo})">취소</button>												
														</c:when>
														<c:otherwise>이용완료</c:otherwise>
													</c:choose>
												</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- Pagination -->
								 <div class="col text-center">
									<div class="managerListPagination btn-group">
										<c:if test="${page.prev}">
										<button type="button" class="btn btn-outline-primary" onclick="location.href='mypage?pageNum=${page.startPage-1}&amount=${page.cri.amount}'">
											<i class="fas fa-angle-left"></i> 이전
										</button>
										</c:if>
										<c:forEach begin="${page.startPage}" end="${page.endPage}" var="p">
										<button type="button" class="btn btn-outline-primary ${p == page.cri.pageNum ? 'active' : ''}" onclick="location.href='mypage?pageNum=${p}&amount=${page.cri.amount}'">
											${p}
										</button>
										</c:forEach>
										<c:if test="${page.next}">
										<button type="button" class="btn btn-outline-primary" onclick="location.href='mypage?pageNum=${page.endPage+1}&amount=${page.cri.amount}'">
											다음 <i class="fas fa-angle-right"></i>		
										</button>
										</c:if>
									</div>
								</div>
			                </div>
	                	</div>
	                </div>
		        </div>
	        </sec:authorize>
	      
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
	        if(code==1){
	    		alert("한 타임에 한 좌석만 예약가능합니다.\n확인 후 진행해주세요.");
	    	}
	    });
    
	    function revCancel(data){
	        if(confirm("예약을 정말 취소하시겠습니까?")) {
	        	$.ajax("delete/"+data,{
	                type : "delete",
	                success:function(a){
		            	  
		                alert("예약취소가 완료되었습니다.");
		             	location.reload();
		              }
	              })
	        } else {
	            
	        }
	    }
    	
    </script>
</body>
</html>