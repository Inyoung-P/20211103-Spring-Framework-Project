package shop.j980108.service;

import java.util.List;

import shop.j980108.domain.NAvailableVo;

public interface NAvailableService {
	List<NAvailableVo> getList();
	int insert(NAvailableVo na);
	void delete(Long nANo);
}
