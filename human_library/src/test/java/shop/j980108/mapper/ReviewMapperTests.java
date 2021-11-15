package shop.j980108.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReplyCriteria;
import shop.j980108.domain.ReplyVo;
import shop.j980108.domain.ReviewVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class ReviewMapperTests {
	@Setter @Autowired
	private ReviewMapper mapper;
	
	@Test
	public void testExist(){
		assertNotNull(mapper);
	}
	//리뷰 작성
	@Test
	public void testInsert(){
		IntStream.range(0,10).forEach(i->{
			ReviewVo vo= new ReviewVo();
			vo.setIsbn("9791191114157");
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("user1");
			mapper.insert(vo);
		});
	}
	//리뷰수정
	@Test
	public void testUpdate(){
		ReviewVo vo=new ReviewVo();
		vo.setReply("수정된 댓글");
		vo.setReplyer("user1");
		vo.setRno(113L);
		mapper.update(vo);
	}
	//리뷰삭제
	@Test
	public void testRemove(){
		log.info(mapper.delete(123L));
	}
	//페이지,글개수에따라 게시글 목록 보여주기
	@Test
	public void tetGetListPaging() {
		Criteria cri =  new Criteria(); //기본생성자(1,10)
		mapper.getListWithPaging("9791191114157",cri).forEach(log::info);//1,10,T,수정
		//mapper.getList();
	}

}
