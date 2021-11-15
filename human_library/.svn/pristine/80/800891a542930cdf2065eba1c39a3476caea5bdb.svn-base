<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
    <main>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
	        <!-- best book list -->
	        <div class="managerBoard">
	            <div class="managerBoardArea mx-auto">
	                <div class="managerBoardBox px-2 py-5">
	                    <div class="bookListTitle clearfix pb-2 border-bottom border-2 border-info">
	                        <h5 class="float-left text-info">대출 현황</h5>
	                    </div>
						<div class="table-responsive my-3">
							<table class="table table-hover">
								<thead class="bg-dark text-light">
									<tr>
										<th colspan="3" class="text-center small">대출정보</th>
										<th colspan="2" class="text-center small">도서정보</th>
										<th colspan="3" class="text-center small">대출자정보</th>
										<th colspan="2" class="text-center small bg-primary">관리</th>
									</tr>
									<tr>
										<th class="text-center small">대출<br>번호</th>
										<th class="text-center small align-middle">대출일</th>
										<th class="text-center small">반납<br>예정일</th>
										<th class="text-center small">도서<br>번호</th>
										<th class="text-center small align-middle">도서 제목</th>
										<th class="text-center small">대출자<br>아이디</th>
										<th class="text-center small">대출자<br>학번</th>
										<th class="text-center small">대출자<br>이름</th> 
										<th class="text-center small bg-primary">도서<br>상태</th> 
										<th class="text-center small border-right-0 bg-primary align-middle">반납 처리</th> 
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list}" var="loans">
									<tr>
										<td class="text-center small align-middle">${loans.lno}</td>
										<td class="text-center small align-middle">${loans.LDate}</td>
										<td class="text-center small align-middle">${loans.rdDate}</td>
										<td class="text-center small align-middle">${loans.bkno}</td>
										<td class="small align-middle overflow-hidden text-truncate">${loans.title}</td>
										<td class="text-center small align-middle">${loans.id}</td>
										<td class="text-center small align-middle">${loans.studNo}</td>
										<td class="text-center small align-middle">${loans.name}</td>
										<td class="text-center small align-middle">
											<c:if test="${loans.status == 5}">대출중</c:if>
											<c:if test="${loans.status == 6}"><span class="text-danger">연체중</span></c:if>
										</td>
										<td class="text-center align-middle">
											<button type="button" class="btn btn-outline-success btn-sm small d-inline" onclick="returnLoans(${loans.lno}, ${loans.bkno}, '${loans.id}')">반납</button>
											<button type="button" class="btn btn-outline-warning btn-sm small d-inline" onclick="notReturnLoans(${loans.lno}, ${loans.bkno}, '${loans.id}')">미반납</button>
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
								<button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/loans/listLoansForManager?pageNum=${page.startPage-1}&amount=${page.cri.amount}'">
									<i class="fas fa-angle-left"></i> 이전
								</button>
								</c:if>
								<c:forEach begin="${page.startPage}" end="${page.endPage}" var="p">
								<button type="button" class="btn btn-outline-primary ${p == page.cri.pageNum ? 'active' : ''}" onclick="location.href='${pageContext.request.contextPath}/loans/listLoansForManager?pageNum=${p}&amount=${page.cri.amount}'">
									${p}
								</button>
								</c:forEach>
								<c:if test="${page.next}">
								<button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/loans/listLoansForManager?pageNum=${page.endPage+1}&amount=${page.cri.amount}'">
									다음 <i class="fas fa-angle-right"></i>		
								</button>
								</c:if>
							</div>
						</div>
	                </div>
	            </div>
	        </div>
	        <div class="modal" id="LoadingLayerModal">
				<div class="LoadingLayerBox modal-dialog text-center mt-5">
					<div class="LoadingLayer spinner-border text-info mx-auto" ></div>
					<p class="text-light mt-2">처리 중입니다. 잠시만 기다려 주세요.</p>
				</div>
			</div>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_ANONYMOUS', 'ROLE_MEMBER')">
			<script>alert('해당 페이지는 관리자만 접근이 가능합니다.'); location.href='${pageContext.request.contextPath}/';</script>
		</sec:authorize>
    </main>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
<script src="${pageContext.request.contextPath}/resources/js/loans.js"></script>
<script>
// 도서 반납 by Manager
function returnLoans(lno, bkno, id) {
	<sec:authorize access="hasAnyRole('ROLE_ANONYMOUS', 'ROLE_MEMBER')">
		if(confirm("반납 처리는 관리자만 가능합니다."))
			location.href="${pageContext.request.contextPath}/";
		else return;
	</sec:authorize>
	if (confirm("해당 "+ lno +"번 대출 건을 반납처리 하시겠습니까?")) {
		$("#LoadingLayerModal").modal({keyboard: false, backdrop: 'static'});
		var loans = {lno: lno, bkno: bkno, id: id};
		loansService.returnLoans(loans, function(result) {
			$("#LoadingLayerModal").modal('hide');
			alert(result);
			location.reload();
		})
	}
}
// 도서 영구미반납 by Manager
function notReturnLoans(lno, bkno, id) {
	<sec:authorize access="hasAnyRole('ROLE_ANONYMOUS', 'ROLE_MEMBER')">
		if(confirm("대출 미반납 처리는 관리자만 가능합니다."))
			location.href="${pageContext.request.contextPath}/";
		else return;
	</sec:authorize>
	if (confirm("해당 "+ lno +"번 대출 건을 분실, 훼손 등으로 영구 미반납 처리 하시겠습니까?")) {
		$("#LoadingLayerModal").modal({keyboard: false, backdrop: 'static'});
		var loans = {lno: lno, bkno: bkno, id: id};
		loansService.notReturnLoans(loans, function(result) {
			$("#LoadingLayerModal").modal('hide');
			alert(result);
			location.reload();
		})
	}
}
</script>
</html>