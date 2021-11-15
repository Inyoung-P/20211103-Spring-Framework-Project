<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<style>
.container{margin-top:160px; margin-left:auto; margin-right:auto; max-width: 950px;}
.books{height:230px; border-bottom:1px solid #bababa;}
.detail{font-size: 15px;}
.title{font-size: 18px; font-weight: 600;}
.contents{overflow: hidden; height: 40px;}
h5{font-size: 23px; font-weight: 600;}
</style>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="mainbooks">
		<div class="container">
			<div class="row under">
				<h5 class="pl-0">도서검색</h5>			
			</div>
			<form>
			<div class="row mb-3 pl-0">
				<div class="col-2 p-1">
					<select name="type" class="custom-select custom-selet-sm form-control form-control-sm ">
						<option value="T">제목</option>
						<option value="A">저자</option>
						<option value="I">ISBN</option>
					</select>
				</div>
				<div class="col-4 p-1">
					<input name= "keyword" type="search" class="form-control form-control-sm" placeholder="search.." aria-controls="dataTable">
				</div>
				<div class="col-5 p-1">
					<button class="btn btn-primary btn-sm">
                       <i class="fas fa-search fa-sm"></i>
                    </button>
				</div>
			</div>
			<input type="hidden" name="pageNum" value="${page.cri.pageNum}">
            <input type="hidden" name="amount" value="${page.cri.amount}">
            </form>
            <div class="row">
            	<ul class="list_type">
            		<c:forEach items="${list}" var="books">
            		<li>
            			<div class="row books">
	            			<div class="col-2 cover pt-2">
	            			<img src="${books.thumbnail}" alt="이미지" />
	            			</div>
	            			<div class="col-8 detail pt-2">
	            				<div class="title"><a href="detailbooks${page.cri.params}&isbn=${books.isbn}"><c:out value="${books.title}"/></a></div>
	            				<div class="authors mt-2">저자 :&nbsp;<c:out value="${books.authors}"/></div>
	            				<div class="publisher mt-2">출판사 :&nbsp;<c:out value="${books.publisher}"/></div>
	            				<div class="isbn mt-2">isbn :&nbsp;<c:out value="${books.isbn}"/></div>
	            				<div class="datetime mt-2">발행일자 :&nbsp;<fmt:formatDate value="${books.datetime}" pattern="yy-MM-dd"/></div>
	            				<div class="contents mt-2">줄거리 :&nbsp;<c:out value="${books.contents}"/>...</div>
	            			</div>
	            			<div class="col-2 add pt-2">
	            				<button class="btn btn-primary">대출예약</button>
	            			</div>
            			</div>
            		</li>
            		</c:forEach>
            	</ul>
            </div>
            <div class="row">
           		<div class="col-sm-12 col-md-5">
           		</div>
           		<div class="col-sm-12 col-md-7">
           			<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
           				<ul class="pagination">
           					 <li class="paginate_button page-item previous ${page.prev ? '' : 'disabled'}" id="dataTable_previous">
                          <a href="selectbooks?pageNum=${page.startPage-1}&amount=${page.cri.amount}" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
                         </li>
                          <c:forEach begin="${page.startPage}" end="${page.endPage}" var="p">
                         <li class="paginate_button page-item ${p == page.cri.pageNum ? 'active' : ''}">
                            <a href="selectbooks?pageNum=${p}&amount=${page.cri.amount}" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">${p}</a>
                      </li>
                      </c:forEach>
                      <li class="paginate_button page-item ${page.next ? '' : 'disabled' }" id="dataTable_next">
                         <a href="selectbooks?pageNum=${page.endPage+1}&amount=${page.cri.amount}" aria-controls="dataTable" data-dt-idx="3" tabindex="0" class="page-link">Next</a>
                        </li>
           				</ul>
           			</div>
           		</div>
           	</div>
		</div>
	</div>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>