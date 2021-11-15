package shop.j980108.domain;

import java.util.Date;
import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @author 김재은
 * @date 2021-10-18
 * @name 중고게시판 댓글
 */
@Data 
@Alias("reply")
public class ReplyVo {
	/*댓글번호*/
	private Long rno;
	/*글번호*/
	private Long bno;
	/*댓글*/
	private String reply;
	/*댓글작성자*/
	private String replyer;
	/*댓글작성일*/
	private Date replyDate;
	/*댓글수정일*/
	private Date updateDate;
	/*계층*/
	private Long depth; //부모 0 자식 1
	/*순서*/
	//private Long order;
	/*댓글 그룹*/
	private Long groupNum;
	/*비밀댓글여부*/
	//private boolean open;
	/*부모댓글번호*/
	//private Long prno;
}
