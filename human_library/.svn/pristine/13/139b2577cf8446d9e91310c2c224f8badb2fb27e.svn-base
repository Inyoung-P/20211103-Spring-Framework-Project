package shop.j980108.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import lombok.Data;

/**
 * @author 조윤정
 * @date 2021-10-19
 * @name 좌석예약
 */
@Data @Alias("reservation")
public class ReservationVo {
	/* 좌석예약번호 */
	private Long revNo;
	/* 좌석번호 */
	private Integer seatNo;
	/*좌석 열람실*/
	private Integer loc;
	/* 예약한 회원의 아이디 */
	private String id;
	/*좌석예약일*/
	private Date revDate;
	/* 좌석예약 시간대 */
	private Integer revTime;
	/* 좌석예약 시간대들 */
	private ArrayList<Integer> revList;
}
