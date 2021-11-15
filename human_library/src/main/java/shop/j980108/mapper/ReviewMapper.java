package shop.j980108.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReplyCriteria;
import shop.j980108.domain.ReplyVo;
import shop.j980108.domain.ReviewVo;


public interface ReviewMapper {
	int insert(ReviewVo vo);//트랜잭션 
	List<ReviewVo> getListWithPaging(@Param("isbn") String isbn, @Param("cri") Criteria cri); //페이지번호,보여줄글개수에 따른 목록 보여주기
	int update(ReviewVo vo);
	int delete(Long rno);
	List<ReviewVo> getList(@Param("isbn") String isbn,@Param("cri") ReplyCriteria cri);
	int getTotalCount(@Param("isbn") String isbn, @Param("cri") Criteria cri);
	ReviewVo read(Long rno);
}
