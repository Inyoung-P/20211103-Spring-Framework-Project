package shop.j980108.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.BoardVo;
import shop.j980108.domain.Criteria;

//@RunWith : JUnit 프레임워크의 테스트 실행 방법을 확장할 때 사용하는 애노테이션
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration: 자동으로 만들어줄 애플리케이션 컨텍스트의 설정파일 위치를 지정
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	,"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class BoardServiceTests {
	@Setter 
	@Autowired //필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입
	private BoardService service;
	
	@Test
	public void testExist(){
		assertNotNull(service);//객체 service가 null이 아닌지 확인
	}
	
	//게시글 목록 보여주기
	@Test
	public void testGetList(){
		service.getList(new Criteria()).forEach(log::info);
	}
	
	//게시글 작성
	@Test
	public void testRegister(){
		BoardVo boardVo=new BoardVo();
		boardVo.setTitle("서비스 테스트 등록글 제목2");
		boardVo.setContent("서비스 테스트 등록글 내용");
		boardVo.setWriter("서비스 테스터");
		boardVo.setPrice("24000");
		service.register(boardVo);
	}
	
	//게시글 상세보기
	@Test
	public void testGet(){
		log.info(service.get(431L));
	}
	
	//게시글 수정
	@Test
	public void testModify(){
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("서비스 테스트 수정글 제목");
		boardVo.setContent("서비스 테스트 수정글 제목");
		boardVo.setWriter("서비스 테스터");
		boardVo.setBno(9L);
		service.modify(boardVo);
	}

	//게시글 삭제
	@Test
	public void testRemove(){
		log.info(service.get(10L));
		log.info(service.remove(10L));
		log.info(service.get(10L));
	}
	
	//검색한 게시글 갯수 또는 게시글 개수
	@Test
   public void testGetTotal() {
      log.info(service.getTotal(new Criteria()));
   }
}
