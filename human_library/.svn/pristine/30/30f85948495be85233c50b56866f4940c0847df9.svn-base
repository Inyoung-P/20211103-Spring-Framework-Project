package shop.j980108.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.emory.mathcs.backport.java.util.Arrays;
import lombok.Setter;
import shop.j980108.domain.AuthVo;
import shop.j980108.domain.MemberVo;
import shop.j980108.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired @Setter
	MemberMapper membermapper;
	@Autowired @Setter
	BCryptPasswordEncoder pwdEncoder;
	
	@Override @Transactional
	public void memberJoin(Map<String, Object> member) throws Exception{
		membermapper.memberJoin(member);
	}

	@Override
	public void authJoin(Map<String, Object> member) throws Exception {
		membermapper.authJoin(member);
	}
	
	@Override
	public int memberLogin(MemberVo member) throws Exception{
		return membermapper.memberLogin(member);
	}

	@Override
	public MemberVo login(MemberVo member) throws Exception{
		return membermapper.login(member);
	}
	
	@Override
	public void memberModify(MemberVo member) {
		membermapper.memberModify(member);	
	}
	
	@Override
	public void memberModify(Map<String, Object> member) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void memberDelete(String id) throws Exception {
		membermapper.memberDelete(id);
	}
	
	@Override
	public void authDelete(String id) throws Exception {
		membermapper.authDelete(id);	
	}


	/** 아이디로 회원 조회
	 * @author 박인영
	 * @date 2021-11-02
	 */
	@Override
	public MemberVo findMemberByID(String id) {
		return membermapper.findMemberByID(id);
	}
}
