package shop.j980108.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.Criteria;
import shop.j980108.domain.ReplyCriteria;
import shop.j980108.domain.ReplyVo;
import shop.j980108.domain.ReviewVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class ReviewServiceTests {
	@Setter @Autowired
	private ReviewService service;
	
	
	@Test
	public void testClass(){
		log.info(service);
		log.info(service.getClass().getSimpleName());
	}
	
	
	@Test
	public void testExist(){
		assertNotNull(service);
	}
	
	//게시글 목록 보여주기
	@Test
	public void testGetList(){
		service.getList(new Criteria(),"9791191114157").forEach(log::info);
	}
	
	@Test
	public void testRegister(){
		ReviewVo reviewVo=new ReviewVo();
		reviewVo.setReply("서비스 테스트 등록글 제목 트랜1");
		reviewVo.setReplyer("user1");
		reviewVo.setIsbn("9791191114157");
		service.register(reviewVo);
	}
	@Test
	public void testGet(){
		//log.info(service.get("9791191114157"));
	}
	@Test
	public void testModify(){
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setReply("수정입니다");
		reviewVo.setReplyer("user1");
		reviewVo.setRno(123L);
		service.modify(reviewVo);
	}
	
	@Test
	public void testRemove(){
		log.info(service.remove(122L));
		
	}
}
