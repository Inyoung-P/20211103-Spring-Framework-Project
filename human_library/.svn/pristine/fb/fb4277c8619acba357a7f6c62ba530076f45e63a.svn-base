package shop.j980108.service;

import java.util.List;

import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReplyVo;
import shop.j980108.domain.ReviewVo;


public interface ReviewService {
	void register(ReviewVo vo);//트랜잭션
	ReviewVo get(Long rno);
	boolean modify(ReviewVo vo);
	boolean remove(Long rno);
	List<ReviewVo> getList(Criteria cri,String isbn); //게시글 목록
	int getTotal(String isbn, Criteria cri); //검색한 게시글 갯수 또는 게시글 개수
	
}
