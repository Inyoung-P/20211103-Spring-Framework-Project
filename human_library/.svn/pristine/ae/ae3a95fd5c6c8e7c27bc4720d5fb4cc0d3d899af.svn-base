package shop.j980108.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.Data;

/**
 * @author 김재은
 * @date 2021-10-18
 * @name 중고게시판
 */
@Data
@Alias("board") //매퍼파일에서 별칭으로 해당 클래스 매핑해줌
public class BoardVo {
	/*글번호*/
	private Long bno;
	/*글제목*/
	private String title; 
	/*글내용*/
	private String content;
	/*작성자ID*/
	private String writer; //작성자
	/*글작성시간*/
	private Date regDate;
	/*글 수정시간*/
	private Date updateDate;
	/*상품가격*/
	private String price;
	/*상품상태*/
	private String pstatus;
	/*배송방법*/
	private String delivery;
//	/*조회수*/
//	private int views;
	/*댓글수*/
	private int replyCnt; 
//	/*폰번호노출동의여부*/
	private boolean agree;
//	/*거래상태*/
	private String tstatus;
	@Autowired 
	private List<AttachVo> attachs =new ArrayList<>();
}
