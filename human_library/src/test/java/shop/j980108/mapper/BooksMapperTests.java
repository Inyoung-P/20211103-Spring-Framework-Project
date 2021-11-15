package shop.j980108.mapper;



import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.BookVo;
import shop.j980108.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class BooksMapperTests {
	@Setter @Autowired
	private BooksMapper mapper;
	
	//책 등록하기
	@Test
	public void testInsert(){
		BookVo book =  new BookVo();
		book.setIsbn("1234567700 890s122112112151111");
		book.setTitle("영속 테스트 제목 - 셀렉트키");
		book.setAuthors("영속 테스트 제목 - 셀렉트키");
		book.setContents("영속 테스트 내용 - 셀렉트키");
		Date now = new Date();
		book.setDatetime(now);
		book.setPrice(20000L);
		book.setPublisher("영속 테스트 출판사 - 셀렉트키");
		book.setThumbnail("https://ssearch1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F1168779%3Ftimestamp%3D20200216125013");
		book.setTranslators("영속 테스트 번역자 - 셀렉트키");
		
		log.info("before :: "+book);
		mapper.insert(book);
		log.info("after :: "+book);
	}
	
	 //페이지,도서 개수에따라 게시글 목록 보여주기
	 @Test
	 public void tetGetListPaging() {
	 	 Criteria cri =  new Criteria(); //기본생성자(1,10)
	 	 cri.setType("I"); //글제목중에서 검색
		 cri.setKeyword("9788965962373"); //수정이라는 키워드가 포함된 글 검색
	 	 mapper.getListWithPaging(cri).forEach(log::info);//1,10,T,수정
	  }
	 
	  //검색한 키워드 게시글 갯수
	  @Test
	  public void testGetTotalCount() {
		  Criteria cri =  new Criteria();
		  cri.setType("I");
		  cri.setKeyword("9788965962373");
	      log.info(mapper.getTotalCount(cri));
	  }
	  //게시글 상세보기
		@Test
		public void testRead(){
			//log.info(mapper.read("8965962374 9788965962373"));
		}
}
