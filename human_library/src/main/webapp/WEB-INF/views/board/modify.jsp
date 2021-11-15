<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../includes/head.jsp"></jsp:include>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/board/css/style.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.16.2/ckeditor.js"></script>
<style>.container {height: 100%;}</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div id="main_reg">
		<div class="container" id="container_reg">
			<form method="post">
				<div class="row">
					<div class="row writeheader mb-3">
						<h3>게시글수정</h3>

						<div class="btn">
							
							<button type="button" class="btn btn-outline-secondary"
								id="btnimsave">임시저장 0</button>
							<button class="btn btn-primary" id="btnSubmit">등록</button>
						</div>
					</div>

					<div class="form-group row p-0 mb-0">
						<input type="hidden" class="form-control" id="bno" name="bno" readonly value="${board.bno}">
						<input type="hidden" class="form-control" id="writer" name="writer" value="dddd" readonly> 
						<input type="hidden" class="form-control" id="tstatus" name="tstatus" value="판매" > 
						<input class="form-control" id="title" name="title" placeholder="상품명을 입력하세요." value="${board.title}" style="border-radius: 0px;">
					</div>
					<div class="row form-box my-3 px-4 py-4" style="background: #fff;">
						<div class="row">
							<div class="row">
								<h4 class="form_label p-0">판매상태 변경</h4>
							</div>
							<div class="row">
							<div class="col-3 p-0">
							<select name="tstatus" id="change" class="custom-select custom-selet-sm form-control form-control-sm ">
								<option value="판매">판매</option>
								<option value="예약중">예약중</option>
								<option value="판매완료">판매완료</option>
							</select>
							</div>
							</div>
							<div class="row">
								<h4 class="form_label p-0">판매가격</h4>
							</div>
							<div class="row">
								<input type="text" class="form-control" id="price"
									name="price" value="${board.price}" placeholder="가격을 입력하세요." onkeyup="numberWithCommas(this.value)"> 
									<span class="won">원</span>
							</div>
						</div>
						<div class="row">
							<div class="row">
								<h4 class="form_label mt-4 p-0">상품상태</h4>
							</div>
							<div class="row">
								<div class="col-12" id="pstatus">
									<div class="form-check-inline">
										<label class="form-check-label" for="pstatus"> <input
											type="radio" class="form-check-input" id="pstatus"
											name="pstatus" value="미개봉">미개봉
										</label>
									</div>
									<div class="form-check-inline">
										<label class="form-check-label" for="pstatus"> <input
											type="radio" class="form-check-input" id="pstatus"
											name="pstatus" value="거의새것">거의새것
										</label>
									</div>
									<div class="form-check-inline">
										<label class="form-check-label" for="pstatus"> <input
											type="radio" class="form-check-input" id="pstatus"
											name="pstatus" value="사용감있음">사용감있음

										</label>
									</div>
								</div>
								<div class="row">
									<div class="row">
										<h4 class="form_label mt-4 p-0">배송방법</h4>
									</div>
									<div class="col-12" id="delivery">
										<div class="form-check-inline">
											<label class="form-check-label" for="delivery"> <input
												type="radio" class="form-check-input" id="delivery"
												name="delivery" value="직거래" checked>직거래
											</label>
										</div>
										<div class="form-check-inline">
											<label class="form-check-label" for="radio2"> <input
												type="radio" class="form-check-input" id="delivery"
												name="delivery" value="택배거래">택배거래
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="row">
								<h4 class="form_label mt-4 p-0">판매자정보</h4>
							</div>
							<div class="row">
								<div class="info px-0" style="width: 156px;">dyzmend97@naver.com
								</div>
								| &nbsp; &nbsp;
								<div class="info px-0" style="width: 110px;">010-3301-6238
								</div>
								<div class="info px-0" style="width: 130px;">
									<button type="button" class="btn btn-primary btn-sm">전화번호
										변경</button>
								</div>
							</div>
							<div class="row">
								<div class="form-check">
									<label class="form-check-label"> <input type="hidden"
										id="agreeyn" value="abcd"> <input type="checkbox"
										id="agree" name="agree" class="form-check-input"
										checked="checked" value="1">휴대전화번호 노출 동의
									</label>
								</div>
							</div>

						</div>
					</div>
					<div class="form-group row p-0">
						<textarea rows="10" class="form-control " id="content"
							name="content">${board.content}</textarea>
					</div>
					<div class="uploadResult">
						<ul class="list-group">
						
						</ul>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		function numberWithCommas(x) {
			  x = x.replace(/[^0-9]/g,'');   // 입력값이 숫자가 아니면 공백
			  x = x.replace(/,/g,'');          // ,값 공백처리
			  $("#price").val(x.replace(/\B(?=(\d{3})+(?!\d))/g, ",")); // 정규식을 이용해서 3자리 마다 , 추가 
		}

		$(function() {
			//셀렉트 박스 값 받아와서 선택
			var a="${board.tstatus}"
			console.log(a)
			$("#change").val(a);
			
			//라디오버튼 값 받아와서 선택
			var radio="${board.pstatus}"
			console.log(radio);
			//radio.checked = true;
			//$("input:radio[name='pstatus']:radio[value="+radio+"]").prop('checked', true); // 선택하기
		//	  $('input:radio[name="pstatus"][value="radio"]).attr('checked', 'checked');
		//	//$("#radio").val(select);

			//글작성 이밴트
			$("#btnSubmit")
					.click(
							function() {
							})
			CKEDITOR
					.replace(
							"content",
							{
								toolbar : [
										{
											name : 'document',
											items : [ 'Print' ]
										},
										{
											name : 'clipboard',
											items : [ 'Undo', 'Redo' ]
										},
										{
											name : 'styles',
											items : [ 'Format', 'Font',
													'FontSize' ]
										},
										{
											name : 'colors',
											items : [ 'TextColor', 'BGColor' ]
										},
										{
											name : 'align',
											items : [ 'JustifyLeft',
													'JustifyCenter',
													'JustifyRight',
													'JustifyBlock' ]
										},
										'/',
										{
											name : 'basicstyles',
											items : [ 'Bold', 'Italic',
													'Underline', 'Strike',
													'RemoveFormat',
													'CopyFormatting' ]
										},
										{
											name : 'links',
											items : [ 'Link', 'Unlink' ]
										},
										{
											name : 'paragraph',
											items : [ 'NumberedList',
													'BulletedList', '-',
													'Outdent', 'Indent', '-',
													'Blockquote' ]
										}, {
											name : 'insert',
											items : [ 'Image', 'Table' ]
										}, {
											name : 'tools',
											items : [ 'Maximize' ]
										}, {
											name : 'editing',
											items : [ 'Scayt' ]
										} ],
								extraAllowedContent : 'h3{clear};h2{line-height};h2 h3{margin-left,margin-top}',

								// Adding drag and drop image upload.
								extraPlugins : 'print,format,font,colorbutton,justify,uploadimage',
								uploadUrl : '/ckupload.json?command=file&type=Files&responseType=json',
								filebrowserImageUploadUrl : '/ckupload.json?command=QuickUpload&type=Images',

								height : 560,
								width : 1318,

								removeDialogTabs : 'image:advanced;link:advanced',
								removeButtons : 'PasteFromWord'

							});
		})
	</script>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>