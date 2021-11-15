package shop.j980108.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.AllArgsConstructor;
import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReplyVo;
import shop.j980108.domain.ReviewVo;
import shop.j980108.mapper.BoardMapper;
import shop.j980108.mapper.BooksMapper;
import shop.j980108.mapper.ReplyMapper;
import shop.j980108.mapper.ReviewMapper;

@AllArgsConstructor @Service
public class ReviewServiceImpl implements ReviewService {
	private ReviewMapper mapper;
	//댓글수 처리 위해
	private BooksMapper booksMapper;
	
	@Override
	@Transactional //이게 없으면 댓글insert가 안되도 cnt가 올라간다.
	public void register(ReviewVo vo) {
		//작업2 댓글 갯수 업데이트 작업
		booksMapper.updateReviewCnt(vo.getIsbn(), 1);
		//작업1 댓글 작성잡업
		mapper.insert(vo);
	}
	//리뷰 수정
	@Override
	public boolean modify(ReviewVo vo) {
		return mapper.update(vo) > 0;
	}
	
	@Override
	@Transactional
	public boolean remove(Long rno) {
		booksMapper.updateReviewCnt(get(rno).getIsbn(), -1);
		return mapper.delete(rno)>0;
	}

	//게시글 목록
    @Override
    public List<ReviewVo> getList(Criteria cri,String isbn) {
        return mapper.getListWithPaging(isbn, cri);
    }
    //검색한 게시글 갯수 또는 게시글 개수
    @Override
    public int getTotal(String isbn, Criteria cri){
    	return mapper.getTotalCount(isbn, cri);
    }
    
    @Override
	public ReviewVo get(Long rno) {
		return mapper.read(rno);
	}
	
	
}
