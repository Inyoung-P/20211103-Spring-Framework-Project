package shop.j980108.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReservationVo;

/**
 * @author 조윤정
 * @date 2021-10-26 ~ 
 * @name 예약 Service
 */
public interface ReservationService {
	/* 예약하기 */
	int makeRev(ReservationVo rev);
	
	/* 예약 취소하기 */
	void cancelRev(long revNo);
	
	/* 자신이 한 예약조회 */
	List<ReservationVo> getMyRev(@Param("cri")Criteria cri,@Param("id")String id);
	
	/* 자신의 예약 갯수 */
	int myRevCount(String id);
	
	/*----------------------   관리자 기능  -----------------------*/
	
	/* 총 예약 관리 */
	List<ReservationVo> getRevList(Criteria cri);
	
	/* 총 예약 갯수 */
	int getRevCount();
	
}
