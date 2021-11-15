<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<jsp:include page="../includes/head.jsp" />
<style type="text/css">
.container {
	height: 100%;
}
#comment-count{border-bottom: 1px solid #d8d6d6;
    font-size: 17px;
    font-weight: 700;
    color: #8f8e8e;}
</style>
</head>

<body id="page-top">
	<jsp:include page="../includes/header.jsp" />

	<div class="container">
		<div id="main" class="row p-5" style="border: 2px solid #d8d6d6; border-radius: 6px; background-color: #fff;">
			<!-- 상단 start-->
			<div class="row" style="border-bottom: 1px solid #d8d6d6;">
				<input type="hidden" class="form-control" id="isbn" name="isbn" disabled value="${books.isbn}">
			</div>
			<!-- 상단 end-->
			<!-- 중간 사진부분 start-->
			<div class="row mb-5">
				<div class="col-3">
					<div class="col-12 pt-4" ><img src="${books.thumbnail}" alt="이미지" style="width: 200px;"/></div>
				</div>
				<div class="col-8">
					<div class="row pt-4" style="border-bottom: 1px solid #d8d6d6;">
						<h3>${books.title}</h3>
					</div>
					<div class="row pt-4">
						<div class=" fontsize">
							<span class="fontcolor">저자 </span> &nbsp; &nbsp;${books.authors}</div>
						<div class=" fontsize">
							<span class="fontcolor">출판사</span> &nbsp;&nbsp;${books.publisher}</div>
						<div class=" fontsize">
							<span class="fontcolor">ISBN</span> &nbsp;&nbsp;${books.isbn}</div>
						<div class=" fontsize">
							<span class="fontcolor">발행일</span> &nbsp;&nbsp;<fmt:formatDate value="${books.datetime}" pattern="yy-MM-dd"/></div>
						<div class=" fontsize">
							<span class="fontcolor">번역가</span> &nbsp;&nbsp;${books.translators}</div>
						<div>
							<table class="table">
								<tr>
									<th>도서번호</th>
									<th>도서상태</th>
									<th>비고</th>
								</tr>
								<c:forEach items="${possession}" var="ps">
									<tr style="text-align: center;">
										<td class="align-middle">${ps.bkno}</td>
										<td class="align-middle">
											<c:choose>
												<c:when test="${ps.status == 0}"><i class="fas fa-circle text-success"></i>&nbsp;&nbsp;대출가능</c:when>
												<c:when test="${ps.status == 1}"><i class="fas fa-circle text-warning"></i>&nbsp;&nbsp;대출예약중&nbsp;&nbsp;(반납예정일 : ${ps.loansableDate})</c:when>
												<c:when test="${ps.status == 2}"><i class="fas fa-circle text-danger"></i>&nbsp;&nbsp;대출중&nbsp;&nbsp;(반납예정일 : ${ps.loansableDate})</c:when>
												<c:otherwise><i class="fas fa-circle text-danger"></i>&nbsp;&nbsp;대출불가</c:otherwise>	
											</c:choose>
										</td>
										<td class="align-middle">
											<c:choose>
												<c:when test="${ps.status == 0}">
													<button type="button" class="btn btn-outline-primary btn-sm d-inline-block" onclick="openModalToReserveLoans('${ps.bkno}')">대출예약</button>
												</c:when>
												<c:when test="${ps.status == 1}">
													<button type="button" class="btn btn-outline-primary btn-sm d-inline-block" onclick="notService()">예약취소알림신청</button>
												</c:when>
												<c:when test="${ps.status == 2}">
													<button type="button" class="btn btn-outline-primary btn-sm d-inline-block" onclick="notService()">도서반납알림신청</button>
												</c:when>
												<c:otherwise>도서 분실 또는 도서 훼손 등</c:otherwise>	
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</table>
							
						</div>
					</div>
				</div>
			<!-- 중간 사진부분 end-->
			<!-- 내용 부분 start-->
			<div class="row">
				<div class="form-group mt-4" style="border-top: 1px solid #d8d6d6;">
					<div class=" mt-3"><span class="fontcolor">책소개</span> </div>
					&nbsp;&nbsp;${books.contents}</div>
				</div>
			<!-- 내용 부분 end-->
			<!-- 댓글 부분 start-->
			<div class="row">
				<div id="form-commentInfo">
					<div class="mb-2" id="commentCount">댓글 
					</div> 
					<div class="row">
						<div class="col-11">
							<input class="form-control" id="comment-input" placeholder="댓글을 입력해 주세요.">
						</div>
						<div class="col-1 px-0 pt-1">
							<button class="btn bg-primary" id="submit" style="color: white">등록</button>
						</div>
					</div>
				</div>
			</div>
		 	<ul id="replyUL" class="list-group list-group-flush">
			</ul> 
			
			<div class="panel-footer">
						
				</div>
			<!-- 댓글 부분 end-->
		</div>
	</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/review.js"></script>
	<script>
	$(function () {
    var token = $("meta[name='_csrf']").attr('content');
    var header = $("meta[name='_csrf_header']").attr('content');
    if(token && header) {
        $(document).ajaxSend(function(event, xhr, options) {
            xhr.setRequestHeader(header, token);
	        });
	    }
	});
	

		// ************************************ getList *******************************************
		  $(function() {
			 var isbn ='${books.isbn}';
			 var replyUL = $("#replyUL");
			 var commentCount=$("#commentCount");
			 var reviewCnt = '${books.reviewCnt}';
			
			 showList();
			 function showList(page) {
				 
				 console.log("show list " + page);
				 reviewService.getList({isbn:isbn, page: page||1},
						 
			 function(reviewCnt,list) {
				 console.log("isbn:"+isbn);
				 console.log("reviewCnt " + reviewCnt);
				 console.log("list " + list);
				 console.log(list);
				 
				  if(page == -1){
					 pageNum = Math.ceil(reviewCnt/10.0);
					 showList(pageNum);
					 return;
				 } 
				 var str = "";
				 var str2 = "";
				 str2 +='댓글&nbsp;<span id="count">'+reviewCnt + '</span>'
                 str2 +='</div>'
				 
				 if(list == null || list.length == 0){
					 return;
				 }
				   for(var i in list){
	                     str += ' <li class="list-group-item" data-rno="'+list[i].rno+ '" id="rcont'+list[i].rno + '">'
	                     str += ' <div class="row">'
	                     str += ' <div class="col-9">'
	                     str += ' <div class="text-dark font-weight-bold replyer">'+list[i].replyer+'</div>'
	                     str += '<form>'
	                     str += ' <div class="cont">'
	                     str += ' <div class="my-2 reply">'+list[i].reply+'</div>'
	                    
	                     str += ' <div class="row">'
	                     str += ' <div class="col-3 pr-0" style="width: 150px; replyDate">'+reviewService.displayTime(list[i].replyDate)+'</div>'
	                     str += ' <div class="col-6">'
	                     str += '		<a href="#">댓글쓰기</a>'
	                     str += ' </div>'
	                     str += ' </div>'
	                     str += ' </div>'
	                     str += ' </div>'
	                     str += '</form>'
	                     str += ' <div class="col-3 pl-3 btn" style="text-align: right;">'
	                     str += '		<button class="btn-sm btn-outline-primary modifyform">수정</button>'
	                     str += '		<button class="btn-sm btn-outline-primary btnRmv">삭제</button>' 
	                     str += '	</div>'
	                     str += '</div>'
	                     str += '</li>'
	                     }
				 replyUL.html(str);
				 commentCount.html(str2);
					showReplyPage(reviewCnt);
			 });
			
			}	
			 
			// ************************************ add *******************************************
			
			   $("#submit").click(function() {//#submit를 클릭하면
				//reply변수에 들어간 데이터들로 replyVo생성자  호출해서 add()에 넣는다
				var review = {
					reply : $("#comment-input").val(),
					replyer : "user1",
					isbn : isbn
				};
				reviewService.add(review, function(data) {
					alert(data);//success띄움
					showList(-1);//그리고 리스트 보여줌
				});
				 $("#comment-input").val("");
			});   
		
			
			// ************************************ 페이징처리  ******************************************* 
			var pageNum=1;
			var reviewPageFooter=$(".panel-footer");
			
			function showReplyPage(reviewCnt) {
				var endNum=Math.ceil(pageNum /10.0)* 10;
				var startNum = endNum -9; //2-9
				console.log("startNum"+startNum);
				
				var prev = startNum !=1;//startNum이 1이 아니면 true반환
				var next = false;
				
				if(endNum * 10 >= reviewCnt){
					endNum=Math.ceil(reviewCnt/10.0);
				}
				
				if(endNum * 10 < reviewCnt){
					next = true;
				}
				var str = "<ul class='pagination pull-right'>";
				
				if(prev){
					str += "<li class='page-item'><a class='page-link' href='"+(startNum -1)+"'>Previous</a></li>";
				}
				
				for(var i = startNum; i<=endNum;i++){
					
					var active = pageNum == i? "active":""; 
					
					str += "<li class='page-item " +active +" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
				}
				if(next){
					str+="<li class='page-item'><a class='page-link' href='"+(endNum +1)+"'> Next</a></li>";
				}
				str += "</ul></div>";
				
				
				reviewPageFooter.html(str);
			}
			reviewPageFooter.on("click","li a",function(e){
				e.preventDefault();
				console.log("page click");
				
				var targetPageNum= $(this).attr("href");
				
				console.log("targetPageNum: " +targetPageNum);
				
				pageNum=targetPageNum;
				
				showList(pageNum);
				
			});
			// ************************************ modifyform  ******************************************* 
			$(document).on("click",".modifyform", function(){
				 var rno=$(this).parent().parent().parent().attr('data-rno');
			     var reply= $('#rcont'+rno).find('div.reply').text();
			     var replyer=$('#rcont'+rno).find('div.replyer').text();
				 var str = "";
				 str += '<div class="text-dark font-weight-bold" id="replyerEdit">'+replyer+'</div>';
				 str += '<textarea class="my-2" id="reply">'+reply+'</textarea>';
				 str += '<button class="btnMod">완료</button>';
				 str += '<button class="cancle">취소</button>';
				 $(this).parent().parent().parent().html(str);
				 });
			
			// ************************************ modify  *******************************************  
			$(document).on("click",".btnMod", function(){
				 var replyerr=$("#replyerEdit").text();
				 console.log(replyerr)
				 var review = {
		 				 reply:$("#reply").val(), 
		 				 rno:$(this).parent().attr('data-rno'),
		 				 replyer:replyerr
		 				 };
		 		 console.log(review);
		 			reviewService.modify(review, function(data) {
		 				alert(data);
		 				
		 				showList(pageNum);
		 			})
				 });
			// ************************************ remove  ******************************************* 
			
			 $(document).on("click",".btnRmv", function(){
				 var rno=$(".btnRmv").parent().parent().parent().attr('data-rno');
				
				  console.log("rno",rno)
				reviewService.remove(rno, function(data) { 
					 alert(data);
					 console.log("removpageNum"+pageNum);
					 showList(pageNum);
				 });
				 
			 }); 
		}); //end of ready
	</script>
	<jsp:include page="../loans/reserveloans.jsp" />
	<jsp:include page="../includes/footer.jsp" />
</body>

</html>