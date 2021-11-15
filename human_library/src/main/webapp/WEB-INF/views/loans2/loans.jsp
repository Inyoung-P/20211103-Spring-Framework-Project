<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
    <main>
        <div class="managerBoard">
            <div class="managerBoardArea mx-auto">
                <div class="managerBoardBox px-2 py-5">
                    <div class="bookListTitle clearfix pb-2 border-bottom border-2 border-info">
                        <h5 class="float-left text-info">현장 대출</h5>
                    </div>
                    <div>
	                    <div calss="col-6">
	                    	<div class="input-group mt-3 mb-3">
								<div class="input-group-prepend">
									<button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown">
										학번
									</button>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="#">아이디</a>
										<a class="dropdown-item" href="#">이름</a>
									</div>
								</div>
								<input type="text" class="form-control" placeholder="Username">
								<button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown">
										<i class="fas fa-search"></i>
								</button>
							</div>
	                    </div>
                    </div>
                    
<%-- 	                <div class="mx-1 mx-sm-5 my-3">
						<div class="row mx-auto">
							<div class="col-12 col-sm-3 col-md-2 p-0">
								<img src="${pageContext.request.contextPath}/resources/img/${possession.thumbnail}" alt="${possession.title} 표지" class="w-100">
							</div>
							<div class="col-12 col-sm-9 col-md-10 p-0 px-sm-3 mt-3 mt-sm-0 mt-lg-2">
								<h6 class="col p-0 overflow-hidden text-truncate"><b>${possession.title}</b></h6>
								<p class="row mx-0 my-1 mt-2">
									<span class="col-3 col-lg-2 p-0 text-dark">저자</span>
									<span class="col-9 col-lg-10 p-0 text-black overflow-hidden text-truncate">${possession.authors}&nbsp;&nbsp;
										<c:if test="${not empty possession.translators}">
											(${possession.translators} 옮김)
										</c:if>
									</span>
								</p>
								<p class="row mx-0 my-1">
									<span class="col-3 col-lg-2 p-0 text-dark">출판사</span>
									<span class="col-9 col-lg-10 p-0 text-black overflow-hidden text-truncate">${possession.publisher}</span>
								</p>
								<p class="row mx-0 my-1">
									<span class="col-3 col-lg-2 p-0 text-dark">발행일</span>
									<span class="col-9 col-lg-10 p-0 text-black overflow-hidden text-truncate">${possession.datetime}</span>
								</p>
								<p class="row mx-0 my-1">
									<span class="col-3 col-lg-2 p-0 text-dark">ISBN</span>
									<span class="col-9 col-lg-10 p-0 text-black overflow-hidden text-truncate">${possession.isbn}</span>
								</p>
								<p class="row mx-0 my-1">
									<span class="col-3 col-lg-2 p-0 text-dark">도서상태</span>
									<span class="col-9 col-lg-10 p-0 text-black overflow-hidden text-truncate">${possession.status}</span>
								</p>
							</div>
						</div>
					</div> --%>
				</div>
			</div>
		</div>
    </main>
    <jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
<script src="${pageContext.request.contextPath}/resources/js/loans.js"></script>
<script>

</script>
</html>