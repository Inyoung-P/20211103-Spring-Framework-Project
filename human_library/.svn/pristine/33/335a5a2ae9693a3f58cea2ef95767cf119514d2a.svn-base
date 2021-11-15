package shop.j980108.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.j980108.domain.PossessionVo;
import shop.j980108.mapper.PossessionMapper;

/**
 * @author 박인영
 * @date 2021-11-01 ~ 
 * @name 소장도서 ServiceImpl
 */
@Service
@AllArgsConstructor
public class PossessionServiceImpl implements PossessionService {
	
	private PossessionMapper mapper;
	
	/** 도서번호(bkno)로 소장 도서 정보(possession) 조회 */
	@Override
	public PossessionVo getPossession(Long bkno) {
		return mapper.getPossession(bkno);
	}
	
	/** ISBN으로 소장 도서(possession) 목록 조회 */
	@Override
	public List<PossessionVo> listPossessionInfo(String isbn) {
		return mapper.listPossessionInfo(isbn);
	}
	
	/** 최근 7일 대출 인기 소장 도서 */
	@Override
	public List<PossessionVo> listPopularityPossession() {
		return mapper.listPopularityPossession();
	}
	
	/** index 신착 도서(최근 등록된 소장도서) 6권 리스트 */
	@Override
	public List<PossessionVo> listNewPossession() {
		return mapper.listNewPossession();
	}
	
}
