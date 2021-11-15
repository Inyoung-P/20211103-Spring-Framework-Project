package shop.j980108.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.j980108.domain.BoardVo;
import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReplyCriteria;
import shop.j980108.domain.ReplyVo;


public interface ReplyMapper {
	int insert(ReplyVo vo);//트랜잭션 
	ReplyVo read(Long rno);
	List<ReplyVo> getListWithPaging(@Param("bno") Long bno, @Param("cri") Criteria cri); //페이지번호,보여줄글개수에 따른 목록 보여주기
	int update(ReplyVo vo);
	int delete(Long rno);
	List<ReplyVo> getList(@Param("bno") Long bno,@Param("cri") ReplyCriteria cri);
	int getTotalCount(@Param("bno") Long bno, @Param("cri") Criteria cri);
}
