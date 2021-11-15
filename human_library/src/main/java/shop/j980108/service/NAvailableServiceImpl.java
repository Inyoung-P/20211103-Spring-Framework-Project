package shop.j980108.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import shop.j980108.domain.NAvailableVo;
import shop.j980108.domain.SeatVo;
import shop.j980108.mapper.NAvailableMapper;
import shop.j980108.mapper.SeatMapper;


@AllArgsConstructor @Service
public class NAvailableServiceImpl implements NAvailableService{
	private NAvailableMapper nAvailableMapper;
	private SeatMapper seatMapper;
	
	@Override
	public List<NAvailableVo> getList() {
		return nAvailableMapper.getList();
	}

	@Override @Transactional
	public int insert(NAvailableVo na) {
		if(nAvailableMapper.isExist(na)==1) return 1;
		SeatVo svo=new SeatVo();
		svo.setLoc(na.getLoc());
		svo.setSeatNo(na.getSeatNo());
		svo.setStatus(1);
		seatMapper.update(svo);
		nAvailableMapper.insert(na);
		return 0;
	}

	@Override @Transactional
	public void delete(Long nANo) {
		NAvailableVo vo=nAvailableMapper.findBy(nANo);
		SeatVo svo=new SeatVo();
		svo.setLoc(vo.getLoc());
		svo.setSeatNo(vo.getSeatNo());
		svo.setStatus(0);
		seatMapper.update(svo);
		nAvailableMapper.delete(nANo);
	}

}
