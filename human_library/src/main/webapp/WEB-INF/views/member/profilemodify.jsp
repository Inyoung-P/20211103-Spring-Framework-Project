<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../includes/head.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap Delete Confirmation Modal</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profile.css">
	<sec:csrfMetaTags/>
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<sec:authentication property="principal" var="pinfo" />
	<main>
	<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                프로필 사진 변경
                                <input type="file" name="file"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        <p>${pinfo.memberVo.name} 님의 페이지입니다.</p>
                                    </h5>
                                    <h6>
                                        <p>${pinfo.memberVo.studNo}</p>
                                    </h6>
                                    <p class="proile-rating">RANKINGS : <span>8/10</span></p>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab">개인정보수정 페이지</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                    	<a type="button" class="profile-edit-btn" name="memberModify" data-toggle="modal" data-target="#modifyModal">수정완료</a>
                    	<a type="button" class="profile-edit-btn" href="/member/profile">취소</a>
                    	
                        <!-- <input type="submit" class="profile-edit-btn" name="btnAddMore" href="/member/profilemodify" value="정보 수정"/>
                    	<input type="button" class="profile-edit-btn" name="deleteMember" data-toggle="modal" data-target="#deleteModal" value="회원 탈퇴"/> -->
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-work">
                            <p>나의 도서</p>
                            <a href="">도서 대출 현황</a><br/>
                            <a href="">도서 </a><br/>
                            <a href=""></a>
                            <p>나의 마켓</p>
                            <a href="">나의 거래 내역</a><br/>
                            <a href="">판매 등록 리스트</a><br/>
                            <a href="">구매 등록 리스트</a><br/>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>아이디는 변경하실 수 없습니다</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${pinfo.memberVo.id}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>비밀번호 변경기능(수정하겠습니다)</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>수정예정</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>변경하실 닉네임을 적어주세요</label>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form"><input type="text" name="nickName" value="${pinfo.memberVo.nickName}" id="nickName" class="form-control" placeholder="변경할 닉네임을 적어주세요" /></div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>변경하실 이메일을 적어주세요</label>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form"><input type="text" name="email" value="${pinfo.memberVo.email}" id="email" class="form-control" placeholder="변경할 이메일주소를 적어주세요" /></div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>변경하실 전화번호를 적어주세요</label>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form"><input type="text" name="phone" value="${pinfo.memberVo.phone}" id="phone" class="form-control" placeholder="변경할 전화번호를 적어주세요" /></div>
                                            </div>
                                        </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </form>           
        </div>
        <!-- 정보수정 모달 -->
        <div class="modifyMember">
        	<div id="modifyModal" class="modal fade">
				<div class="modal-dialog modal-confirm">
					<div class="modal-content">
						<div class="modal-header flex-column">
							<div class="icon-box">
								<i class="material-icons">&#xE5CD;</i>
							</div>						
							<h4 class="modal-title w-100">정말 수정 하시겠습니까?</h4>	
            	    		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<p>수정하시려면YES 아니면NO를 선택해주세요</p>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">NO</button>
							<form action="/member/profile" method="post"><button type="submit" class="btn btn-danger" name="id" value="${pinfo.memberVo.id}">YES</button></form>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>