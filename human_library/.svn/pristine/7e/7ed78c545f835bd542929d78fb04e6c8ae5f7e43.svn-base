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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	@Setter @Autowired
	private ReplyService service;
	
	
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
		service.getList(new Criteria(),294L).forEach(log::info);
	}
	
	/*@Test
	public void testGetList2(){
		service.getList2(new ReplyCriteria(),294L).forEach(log::info);
	}*/
	@Test
	public void testRegister(){
		ReplyVo replyVo=new ReplyVo();
		replyVo.setReply("서비스 테스트 등록글 제목 트랜1");
		replyVo.setReplyer("서비스 테스터1");
		replyVo.setBno(332L);
		service.register(replyVo);
	}
	@Test
	public void testGet(){
		log.info(service.get(1L));
	}
	@Test
	public void testModify(){
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply("서비스 테스트 수정글 제목");
		replyVo.setReplyer("서비스 테스트 수정글 제목");
		replyVo.setRno(5L);
		service.modify(replyVo);
	}
	
	@Test
	public void testRemove(){
		log.info(service.remove(4L));
		
	}
}
