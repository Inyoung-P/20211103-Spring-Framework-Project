package shop.j980108.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReservationVo;

/**
 * @author 조윤정
 * @date 2021-10-25 ~ 
 * @name 예약 Mapper
 */
public interface ReservationMapper {
	/*해당 시간의 해당 좌석의 현황가져오기 */
	int getTimetable(ReservationVo vo);
	
	/* 해당 시간에 회원이 예약한 좌석이 있는지 확인하기 */
	int checkDupRev(ReservationVo vo);
	
	/* 해당 좌석 예약하기 */
	void insert(ReservationVo rev);
	
	/* 예약 취소하기 (현재시간대 이상인 것만 취소되어야함) */
	void delete(Long revNo);
	
	/*해당 아이디의 예약 가져오기*/
	List<ReservationVo> getMyRev(@Param("cri") Criteria cri, @Param("id") String id);
	
	/* 해당 아이디의 예약 수 전부 가져오기 */
	int myRevCount(String id);
	
	/*전체 예약리스트 가져오기*/
	List<ReservationVo> getRevList(Criteria cri);
	
	/* 전체 예약갯수 가져오기 */
	int getRevCount();
	
}
