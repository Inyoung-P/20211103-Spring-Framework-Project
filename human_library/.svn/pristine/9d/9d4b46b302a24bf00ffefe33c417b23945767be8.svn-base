package shop.j980108.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @author 박인영
 * @date 2021-10-18
 * @name 소장 도서
 */
@Data
@Alias("possession")
public class PossessionVo {
	/** 도서등록번호 <br> Book Number <br> 도서관에 등록된 도서의 고유 번호 */
	private Long bkno;
	/** 도서 제목 */
	private String title;
	/** 저자 */
	private String authors;
	/** 역자 */
	private String translators;
	/** 출판사 */
	private String publisher;
	/** 발행일 */
	private String datetime;
	/** 표지이미지 <br> Book Image URL */
	private String thumbnail;
	/** 책소개 */
	private String contents;
	/** 가격 (단위: 원) */
	private String price;
	/** 등록일 <br> 도서관에 등록된 날짜 */
	private Date regDate;
	/** 도서상태 <br> 0 대출가능 1 대출예약중 2 대출중 3 대출불가(분실, 훼손 등) */
	private int status;
	/** 대출가능일 <br> 대출예약중 또는 대출중일 때 반납예정일 */
	private String loansableDate;
	/** 도서 고유 번호(13자리) */
	private String isbn;

}
