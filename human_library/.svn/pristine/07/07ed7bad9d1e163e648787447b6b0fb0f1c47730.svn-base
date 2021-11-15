package shop.j980108.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import shop.j980108.domain.AuthVo;

/**
 * @author 양희찬
 * @date 2021-10-19
 * @name 회원
 */

@Data @Alias("member")
public class MemberVo {
	/**유저아이디*/
	private String id;
	/**유저비밀번호*/
	private String pwd;
	/**학번*/
	private Integer studNo;
	/**이름*/
	private String name;
	/**닉네임*/
	private String nickName;
	/**스마트폰번호*/
	private String phone;
	/**이메일*/
	private String email;
	/**프로필이미지*/
	private String uuid;
	/**회원등급*/
	private Long grade;
	/**대출중인 도서수*/
	private Long loansCnt;
	
	private List<AuthVo> auths;
}
