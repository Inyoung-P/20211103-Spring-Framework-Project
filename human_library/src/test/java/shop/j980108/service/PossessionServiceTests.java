package shop.j980108.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.PossessionVo;

/**
 * @author 박인영
 * @date 2021-11-01 ~ 
 * @name 소장도서 Service Tests
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class PossessionServiceTests {
	
	@Setter @Autowired
	private PossessionService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
	}
	
	/** 도서번호(bkno)로 소장 도서 정보(possession) 조회 */
	@Test
	public void testGetPossession() {
		log.info(service.getPossession(3L));
	}
	
	/** ISBN으로 소장 도서(possession) 목록 조회 */
	@Test
	public void testListPossessionInfo() {
		service.listPossessionInfo("9791158362157").forEach(log::info);
	}
	
	/** index 최근 7일 대출 인기 소장 도서 6권 리스트 */
	@Test
	public void testListPopularityPossession() {
		service.listPopularityPossession().forEach(log::info);
	}
	
	/** index 신착 도서(최근 등록된 소장도서) 6권 리스트 */
	@Test
	public void testListNewPossession() {
		service.listNewPossession().forEach(log::info);
	}
	
}
