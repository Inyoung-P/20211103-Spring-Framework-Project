package shop.j980108.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shop.j980108.domain.Criteria;
import shop.j980108.domain.LoansVo;
import shop.j980108.domain.MemberVo;
import shop.j980108.service.LoansService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberServiceTests {
	
	@Setter @Autowired
	private MemberService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
	}
	
	/** 아이디로 회원 조회
	 * @author 박인영
	 * @date 2021-11-02
	 */
	@Test
	public void testFindMemberByID() {
		log.info(service.findMemberByID("dldlrwns"));
	}
	
}
