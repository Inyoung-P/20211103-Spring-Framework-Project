package shop.j980108.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.BoardVo;
import shop.j980108.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter @Autowired
	private BoardMapper mapper;
	
	
	//게시글 목록 보여주기
	@Test
	public void testGetList(){
		mapper.getList().forEach(System.out:: println);
		//mapper.getList();
	}
	
	//페이지,글개수에따라 게시글 목록 보여주기
	@Test
	public void tetGetListPaging() {
		Criteria cri =  new Criteria(); //기본생성자(1,10)
		cri.setType("T"); //글제목중에서 검색
		cri.setKeyword("수정"); //수정이라는 키워드가 포함된 글 검색
		mapper.getListWithPaging(cri).forEach(log::info);//1,10,T,수정
		//mapper.getList();
	}
	
	//게시글 작성하기
	@Test
	public void testInsert(){
		BoardVo board =  new BoardVo();
		board.setTitle("영속 테스트 제목5");
		board.setContent("영속5 테스트 내용5");
		board.setWriter("영속 테스터5");
	
		
		mapper.insert(board);
		log.info(board);
	}
	
	//마지막 시퀀스기준 하나 증가시킨 시퀀스에 INSERT시킴
	@Test
	public void testInsertSelectKey(){
		//자바의정석 6장 3-6예제
		BoardVo board =  new BoardVo();
		board.setTitle("영속 테스트 제목 - 셀렉트키");
		board.setContent("영속 테스트 내용");
		board.setWriter("영속 테스터");
		board.setPrice("24000");
		board.setPstatus("미개봉");
		board.setDelivery("직거래");
		log.info("before :: "+board);
		mapper.insertSelectKey(board);
		log.info("after :: "+board);
	}
	
	//게시글 상세보기
	@Test
	public void testRead(){
		log.info(mapper.read(15L));
	}
	
	//게시글 수정
	@Test
	public void testUpdate(){
		BoardVo board =  new BoardVo();
		board.setTitle("수정 영속 테스트 제목 ");
		board.setContent("수정영속 테스트 내용");
		board.setWriter("수정영속 테스터");
		board.setBno(15L);
		log.info(mapper.update(board));
		log.info(mapper.read(15L));
	}
	
	//게시글 삭제
	@Test
	public void testDelete(){
		log.info(mapper.read(15L));
		log.info(mapper.delete(15L));
		log.info(mapper.read(15L));
	}
	
   //검색한 키워드 게시글 갯수
   @Test
   public void testGetTotalCount() {
	   Criteria cri =  new Criteria();
	   cri.setType("T");
	   cri.setKeyword("해리");
      log.info(mapper.getTotalCount(cri));
   }
}
