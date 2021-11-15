package shop.j980108.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @author 박인영
 * @date 2021-11-01
 * @name 문자
 */
@Data
@Alias("sms")
public class SmsVo {
	/** 문자 발송 고유 번호 */
	private Long sno;
	/** 문자 발송일 */
	private String sDate;
	/** 발신번호 */
	private String from;
	/** 수신번호 */
	private String to;
	/** 수신자아이디 : 연락처가 변동될 수 있기 때문에 아이디를 함께 저장 */
	private String id;
	/** 수신자이름 : 문자 발송시 ㅇㅇ님 하는게 좋다면 */
	private String name;
	/** 문자내용 (90바이트) */
	private String content;
	/** 카테고리 <br>
	 * 00 대출예약 <br>
	 * 01 예약 사용자 취소 <br>
	 * 02 예약 자동 취소 <br>
	 * 03 예약 관리자 취소 <br>
	 * 04 예약 확정 (픽업) <br>
	 * 05 대출 <br>
	 * 06 연체 <br>
	 * 07 반납 <br>
	 * 08 대출가능알림
	 */
	private String category;
	/** 대출번호 */
	private Long lno;
	/** 도서제목 */
	private String bookTilte;

}
