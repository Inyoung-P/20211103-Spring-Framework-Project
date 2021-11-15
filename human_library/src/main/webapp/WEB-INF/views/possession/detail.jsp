<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../includes/head.jsp"></jsp:include>
<sec:csrfMetaTags/>
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<main>
		<div class="possessionDetail mx-auto py-5">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="border-bottom border-2 border-info text-info">
					<h5>도서정보</h5>
				</div>
				<div class="my-3">
					<div class="row mx-auto">
						<div class="col-3 d-inline-block p-0">
							<img src="${possession.thumbnail}" alt="${possession.title} 표지" class="w-100">
						</div>
						<div class="col-9 d-inline-block pl-4">
							<h5 class="col p-0 overflow-hidden text-truncate"><b>${possession.title}</b></h5>
							<p class="row m-1">
								<span class="col-2 p-0 text-dark">저자</span>
								<span class="col-10 p-0 text-black overflow-hidden text-truncate">${possession.authors}&nbsp;&nbsp;
									<c:if test="${not empty possession.translators}">
										(${possession.translators} 옮김)
									</c:if>
								</span>
							</p>
							<p class="row m-1">
								<span class="col-2 p-0 text-dark">출판사</span>
								<span class="col-10 p-0 text-black overflow-hidden text-truncate">${possession.publisher}</span>
							</p>
							<p class="row m-1">
								<span class="col-2 p-0 text-dark">발행일</span>
								<span class="col-10 p-0 text-black overflow-hidden text-truncate">${possession.datetime}</span>
							</p>
							<p class="row m-1">
								<span class="col-2 p-0 text-dark">ISBN</span>
								<span class="col-10 p-0 text-black overflow-hidden text-truncate">${possession.isbn}</span>
							</p>
							<p class="row m-1">
								<span class="p-0 text-dark">도서소개</span>
								<span class="p-0 text-black overflow-auto">${possession.contents}</span>
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-8 col-md-10 mx-auto mt-5">
				<div class="border-bottom border-2 border-info text-info">
					<h5>소장정보</h5>
				</div>
				<div class="my-3">
					<div class="row mx-auto">
						<div class="col-3 text-center bg-light p-2 border border-secondary">도서번호</div>
						<div class="col-5 text-center bg-light p-2 border-top border-bottom border-secondary">도서상태</div>
						<div class="col-4 text-center bg-light p-2 border border-secondary border-left-0">비고</div>
					</div>
					<div class="row mx-auto">
						<div class="possessionDedetailInfo col-3 text-center p-2 border border-secondary border-top-0">${possession.bkno}</div>
						<div class="possessionDedetailInfo col-5 text-center p-2 border-bottom border-secondary">
							<c:choose>
								<c:when test="${possession.status == 0}"><i class="fas fa-circle text-success"></i>&nbsp;&nbsp;대출가능</c:when>
								<c:when test="${possession.status == 1}"><i class="fas fa-circle text-warning"></i>&nbsp;&nbsp;대출예약중&nbsp;&nbsp;(반납예정일 : ${possession.loansableDate})</c:when>
								<c:when test="${possession.status == 2}"><i class="fas fa-circle text-danger"></i>&nbsp;&nbsp;대출중&nbsp;&nbsp;(반납예정일 : ${possession.loansableDate})</c:when>
								<c:otherwise><i class="fas fa-circle text-danger"></i>&nbsp;&nbsp;대출불가</c:otherwise>	
							</c:choose>
						</div>
						<div class="possessionDedetailInfo col-4 text-center p-2 border border-secondary border-top-0 text-danger">
							<c:choose>
								<c:when test="${possession.status == 0}">
									<button type="button" class="btn btn-outline-primary btn-sm d-inline-block" onclick="openModalToReserveLoans()">
										대출예약
									</button>
								</c:when>
								<c:when test="${possession.status == 1}">
									<button type="button" class="btn btn-outline-primary btn-sm d-inline-block" onclick="notService()">
										예약취소알림신청
									</button>
								</c:when>
								<c:when test="${possession.status == 2}">
									<button type="button" class="btn btn-outline-primary btn-sm d-inline-block" onclick="notService()">
										도서반납알림신청
									</button>
								</c:when>
								<c:otherwise>도서 분실 또는 도서 훼손 등</c:otherwise>	
							</c:choose>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</main>
<jsp:include page="../loans/reserveloans.jsp"></jsp:include>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
<script>
// 대출예약 신청시 로그인여부 확인
function openModalToReserveLoans() {
	<sec:authorize access="isAnonymous()">
	if(confirm("대출예약 하시려면 로그인 하셔야합니다. 로그인 페이지로 이동하시겠습니까?")) {
		location.href="${pageContext.request.contextPath}/member/login";
	}
	else {
		return;
	}
	</sec:authorize>
	$("#modalToReserveLoans").modal("show");
}
// 미구현 알림
function notService() {
	alert('서비스 준비중입니다. 이용에 불편을 드려 죄송합니다.');
}
</script>
</html>