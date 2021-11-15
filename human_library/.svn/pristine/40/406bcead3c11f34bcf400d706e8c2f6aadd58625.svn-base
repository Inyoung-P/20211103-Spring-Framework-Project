<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
</head>

<body id="page-top">
	<jsp:include page="../includes/header.jsp" />

	<div class="container">
	<div class="row">
		<button>수정</button>
		<button>삭제</button>
	</div>
		<div id="main" class="row p-5" style="border: 2px solid #d8d6d6; border-radius: 6px; background-color: #fff;">
			<div class="row pr-0">
			<div class="col-10"></div>
			<div class="col-1 pr-0" style="width: 80px;">
		<a class="btn btn-primary" href="modify${cri.params}&bno=${board.bno}">수정</a> 
		</div>
		<div class="col-1 pl-0">
		<a class="btn btn-primary" href="/board/remove?bno=${board.bno}">삭제</a> 
		</div>
	</div>
			<!-- 상단 start-->
			<div class="row" style="border-bottom: 1px solid #d8d6d6;">
				<div class="row">
					<h1 class="h3 mb-2 text-gray-800"><span style="color: orange; margin-right: 10px;"><c:if test="${board.tstatus == null}"><c:out value="판매"/></c:if><c:if test="${board.tstatus != null}"><c:out value="${board.tstatus}"/></c:if></span>${board.title}</h1>
					<input type="hidden" class="form-control" id="bno" name="bno"
						disabled value="${board.bno}">
				</div>
				<div class="row">
					<p style="margin-bottom: 0;">아이디</p>
					<p>
						<fmt:formatDate value="${board.regDate}" pattern="yy-MM-dd mm:ss" />
						&nbsp;조회 4
					</p>
				</div>
			</div>
			<!-- 상단 end-->
			<!-- 중간 사진부분 start-->
			<div class="row mb-5">
			<!-- 	<div class="col-5 ">
					<div class="col-12 pt-4">사진</div>
				</div> -->
				<div class="col-7 ">
					<div class="row pt-4" >
						<h3>${board.price}원</h3>
					</div>
					<div class="row pt-4">
						<div class=" fontsize">
							<span class="fontcolor">상품상태</span> &nbsp; &nbsp;${board.pstatus}
						</div>
						<div class=" fontsize">
							<span class="fontcolor">배송방법</span> &nbsp;
							&nbsp;${board.delivery}
						</div>
					</div>
					<div class="row pl-1">
						<div class="row" style="padding-left: 21px;">
							<h4 class="form_label mt-4 p-0 fontcolor">판매자정보</h4>
						</div>
						<div class="">
							<div class="info fontsize" style="width: 156px;">dyzmend97@naver.com
							</div>
							<div class="info  fontsize" style="width: 150px;">010-3301-6238
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 중간 사진부분 end-->
			<!-- 내용 부분 start-->
			<div class="row">
				<div class="form-group">
					<form>
						<c:out value="${board.content}" escapeXml="false" />
					</form>
				</div>
			</div>
			<!-- 내용 부분 end-->
			<!-- 댓글 부분 start-->
			
			<div class="row">
				<div id="form-commentInfo">
					<div class="mb-2" id="comment-count" style="border-bottom: 1px solid #d8d6d6;">댓글 <span id="count">${board.replyCnt}</span>
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
 
 			<!-- 	<li class='left clearfix' data-rno='"+list[i].rno+"'>
					 <div><div class='header'><strong class='primary-font'>dd dd</strong>
					<small class='pull-right text-muted'>ffff</small></div>
					<p>fff</p></div></li>
			 -->
			</ul> 
			
			<div class="panel-footer">
							
						</div>
			<!-- 댓글 부분 end-->
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/reply.js"></script>
	<script>
	//get방식을 제외한 비동기처리에 필요함
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
			 var bno ='${board.bno}';
			 var replyUL = $("#replyUL");
			 var replyCnt = '${board.replyCnt}';
			 
			 showList();
			 function showList(page) {
				 
				 console.log("show list " + page);
				 replyService.getList({bno:bno, page: page||1},
			 function(replyCnt,list) {
				 console.log("bno:"+bno);
				 console.log("replyCnt " + replyCnt);
				 console.log("list " + list);
				 console.log(list);
				 
				  if(page == -1){
					 pageNum = Math.ceil(replyCnt/10.0);
					 showList(pageNum);
					 return;
				 } 
				 var str = "";
				 
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
	                     str += ' <div class="col-3 pr-0" style="width: 150px; replyDate">'+replyService.displayTime(list[i].replyDate)+'</div>'
	                     str += ' <div class="col-6">'
	                     str += '		<a href="#">댓글쓰기</a>'
	                     str += ' </div>'
	                     str += ' </div>'
	                     str += ' </div>'
	                     str += ' </div>'
	                     str += '</form>'
	                     str += ' <div class="col-3 pl-3 btn" style="text-align: right;">'
	                     str += '		<button class="modifyform">수정</button>'
	                     str += '		<button class="btnRmv">삭제</button>' 
	                     str += '	</div>'
	                     str += '</div>'
	                     str += '</li>'
	                     }
				 replyUL.html(str);
					showReplyPage(replyCnt);
			 });
			
			}	
			
			// ************************************ add *******************************************
			
			   $("#submit").click(function() {//#submit를 클릭하면
				//reply변수에 들어간 데이터들로 replyVo생성자  호출해서 add()에 넣는다
				var reply = {
					reply : $("#comment-input").val(),
					replyer : "아이디",
					bno : bno
				};
				replyService.add(reply, function(data) {
					alert(data);//success띄움
					//var count = $'{#replyUL}'.find("li").length;//ul태그에 있는 li개수 구함
					//$ul.html("");//??
					showList(-1);//그리고 리스트 보여줌
				});
				 $("#comment-input").val("");
			});   
		
			
			// ************************************ 페이징처리  ******************************************* 
			var pageNum=1;
			var replyPageFooter=$(".panel-footer");
			
			function showReplyPage(replyCnt) {
				var endNum=Math.ceil(pageNum /10.0)* 10;
				var startNum = endNum -9;
				
				var prev = startNum !=1;
				var next = false;
				
				if(endNum * 10 >= replyCnt){
					endNum=Math.ceil(replyCnt/10.0);
				}
				
				if(endNum * 10 < replyCnt){
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
				
				
				replyPageFooter.html(str);
			}
			replyPageFooter.on("click","li a",function(e){
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
				 var reply = {
		 				 reply:$("#reply").val(), 
		 				 rno:$(this).parent().attr('data-rno'),
		 				 replyer:replyerr
		 				 };
		 		 console.log(reply);
		 			replyService.modify(reply, function(data) {
		 				alert(data);
		 				
		 				showList(pageNum);
		 			})
				 });
			// ************************************ remove  ******************************************* 
			
			 $(document).on("click",".btnRmv", function(){
				 var rno=$(".btnRmv").parent().parent().parent().attr('data-rno');
				
				  console.log("rno",rno)
				replyService.remove(rno, function(data) { 
					 alert(data);
					 showList(pageNum);
				 });
				 
			 }); 
			
			
			
			
	  
			
		}); //end of ready
		
		
	</script>
	<jsp:include page="../includes/footer.jsp" />
</body>

</html>