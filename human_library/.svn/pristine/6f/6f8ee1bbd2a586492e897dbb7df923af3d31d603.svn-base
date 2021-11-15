package shop.j980108.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @author 박인영
 * @date 2021-10-18
 * @name 대출
 */
@Data
@Alias("loans")
public class LoansVo {
	/** 대출 고유 번호 <br> Loans Number */
	private Long lno;
	/** 대출예약일 <br> Reserved Date */
	private String rDate;
	/** 대출만기일 <br> Reservation Expiration Date */
	private String reDate;
	/** 대출일 <br> Loans Date */
	private String lDate;
	/** 반납예정일 <br> Return Due Date */
	private String rdDate;
	/** 반납일 <br> Return Date */
	private String rtDate;
	/** 대출 관련 상태 <br> 
	 * 0 대출 예약 신청<br>1 예약 사용자 취소 <br>2 예약 자동 취소 <br>
	 * 3 예약 관리자 취소(분실, 훼손 등) <br>4 예약확정(픽업) <br>
	 * 5 대출 <br>6 연체 <br>7 반납 <br>8 영구미반납(분실, 훼손 등) */
	private int status;
	/** 도서등록번호 <br>Book Number <br>도서관에 등록된 도서의 고유 번호 */
	private Long bkno;
	/** 도서명 */
	private String title;
	/** 대출회원 아이디 */
	private String id;
	/** 대출회원 학번 */
	private Long studNo;
	/** 대출회원 이름 */
	private String name;
}
