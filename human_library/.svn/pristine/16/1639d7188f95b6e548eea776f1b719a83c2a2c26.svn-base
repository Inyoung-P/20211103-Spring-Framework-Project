package shop.j980108.service;

import java.util.List;

import shop.j980108.domain.BookVo;
import shop.j980108.domain.Criteria;

public interface BooksService {
	void register(BookVo bookVo); //게시글 작성
	List<BookVo> getList(Criteria cri); //게시글 목록
	int getTotal(Criteria cri); //검색한 게시글 갯수 또는 게시글 개수
	BookVo get(String isbn); //게시글 상세보기
}
