package shop.j980108.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @author 박인영
 * @date 2021-10-18
 * @name 연체 패널티
 */
@Data
@Alias("penalty")
public class PenaltyVo {
	/** 패널티 고유 번호 <br> Penalty Number */
	private Long pno;
	/** 패널티 시작일 <br> Penalty Start Date */
	private Date psDate;
	/** 패널티 일수 <br> Penalty Days */
	private int pDays;
	/** 패널티 잔여 일수 <br> Penalty Remaining Days */
	private int prDays;
	/** 대출 고유 번호 <br> Loans Number */
	private Long lno;
	/** 회원 */
	private String id;
}
