package shop.j980108.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import shop.j980108.domain.BoardVo;
import shop.j980108.domain.Criteria;

public interface BoardMapper {
	//@Select("SELECT * FROM TBL_BOARD WHERE BNO >0")
		List<BoardVo> getList(); //게시판 목록 보여주기
		List<BoardVo> getListWithPaging(Criteria cri); //페이지번호,보여줄글개수에 따른 목록 보여주기
		void insert(BoardVo board); //게시글 작성
		void insertSelectKey(BoardVo board); //마지막 시퀀스기준 하나 증가시킨 시퀀스에 INSERT시킴
		BoardVo read(Long bno); //게시글 상세보기
		int update (BoardVo boardVo); //게시글 수정
		int delete(Long bno); //게시글 삭제
		int getTotalCount(Criteria cri); //검색한 게시글 갯수 또는 게시글 개수
		void updateReplyCnt(@Param("bno") Long bno,@Param("amount") int amount);//트랜잭션
		
}
