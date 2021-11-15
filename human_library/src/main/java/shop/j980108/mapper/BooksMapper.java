package shop.j980108.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.j980108.domain.BookVo;
import shop.j980108.domain.Criteria;

public interface BooksMapper {
	void insert(BookVo bookVo); 
	List<BookVo> getListWithPaging(Criteria cri); //페이지번호,보여줄글개수에 따른 목록 보여주기
	int getTotalCount(Criteria cri); //검색한 게시글 갯수 또는 게시글 개수
	void updateReviewCnt(@Param("isbn") String isbn,@Param("amount") int amount);//트랜잭션
	BookVo read(String isbn); //게시글 상세보기
}
