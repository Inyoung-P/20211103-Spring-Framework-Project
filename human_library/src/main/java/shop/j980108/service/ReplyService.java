package shop.j980108.service;

import java.util.List;

import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReplyVo;


public interface ReplyService {
	void register(ReplyVo vo);//트랜잭션
	ReplyVo get(Long rno);
	boolean modify(ReplyVo vo);
	boolean remove(Long rno);
	List<ReplyVo> getList(Criteria cri,Long bno); //게시글 목록
	//List<ReplyVo> getList2(ReplyCriteria cri,Long bno);
	int getTotal(Long bno, Criteria cri); //검색한 게시글 갯수 또는 게시글 개수
	
}
