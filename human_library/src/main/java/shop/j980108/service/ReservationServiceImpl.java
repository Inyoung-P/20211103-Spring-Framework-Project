package shop.j980108.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReservationVo;
import shop.j980108.domain.SeatVo;
import shop.j980108.mapper.ReservationMapper;
import shop.j980108.mapper.SeatMapper;

/**
 * @author 조윤정
 * @date 2021-10-26 ~ 
 * @name 자리예약 Service
 */
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService{
	private ReservationMapper reservationMapper;
	private SeatMapper seatMapper;

	@Override
	public int makeRev(ReservationVo rev) {
			for(int i=0;i<rev.getRevList().size();i++){
				SeatVo vo=new SeatVo();
				vo.setSeatNo(rev.getSeatNo());
				vo.setLoc(rev.getLoc());
				vo.setRevTime(rev.getRevList().get(i));
				rev.setRevTime(rev.getRevList().get(i));
				// 해당 아이디가 해당 시간에 예약이 있는지 확인
				if(reservationMapper.checkDupRev(rev)==1) return 1;
				// 해당 자리가 예약가능 상태인지 확인
				else if(((SeatVo)seatMapper.getList(vo).get(0)).getStatus()==1) return 2;
				// 아니면 예약 진행
				else reservationMapper.insert(rev);
		}
		return 0;
	}


	@Override
	public void cancelRev(long revNo) {
		reservationMapper.delete(revNo);
	}


	@Override
	public List<ReservationVo> getMyRev(Criteria cri,String id) {
		return reservationMapper.getMyRev(cri,id);
	}


	@Override
	public List<ReservationVo> getRevList(Criteria cri) {
		return reservationMapper.getRevList(cri);
	}


	@Override
	public int myRevCount(String id) {
		return reservationMapper.myRevCount(id);
	}


	@Override
	public int getRevCount() {
		return reservationMapper.getRevCount();
	}

	
}
