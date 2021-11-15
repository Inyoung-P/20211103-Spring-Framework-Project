package shop.j980108.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.j980108.domain.SeatVo;
import shop.j980108.mapper.SeatMapper;

/**
 * @author 조윤정
 * @date 2021-10-26 ~ 
 * @name 자리 Service
 */
@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService{
	private SeatMapper seatMapper;
	@Override
	public List<SeatVo> getList(SeatVo vo) {
		return seatMapper.getList(vo);
	}

	@Override
	public List<SeatVo> readByLoc(int loc) {
		SeatVo vo= new SeatVo();
		vo.setLoc(1);
		return seatMapper.getList(vo);
	}

	@Override
	public Integer getCurrentTime() {
		return seatMapper.returnTime();
	}

	@Override
	public int getSeatCntByLoc(int loc, int revTime) {
		// TODO Auto-generated method stub
		return seatMapper.getSeatCntByLoc(loc, revTime);
	}

}
