package shop.j980108.service;

import java.util.Map;

import shop.j980108.domain.MemberVo;

public interface MemberService {
	//회원가입 서비스
	void memberJoin(Map<String, Object> member) throws Exception;
	//권한주기 
	void authJoin(Map<String, Object> member) throws Exception;

	int memberLogin(MemberVo member) throws Exception;
	
	MemberVo login(MemberVo member) throws Exception;
	//회원탈퇴(등급변경) 서비스
	void memberDelete(String id) throws Exception;
	//권한삭제
	void authDelete(String id) throws Exception;
	//회원정보 수정 서비스
	void memberModify(Map<String, Object> member);
	
	void memberModify(MemberVo member);
	
	/** 아이디로 회원 조회
	 * @author 박인영
	 * @date 2021-11-02
	 */
	MemberVo findMemberByID(String id);
	

	

}
