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
import shop.j980108.domain.ReservationVo;

/**
 * @author 조윤정
 * @date 2021-10-27 ~ 
 * @name 예약 Service Tests
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class ReservationServiceTests {
	@Setter @Autowired
	private ReservationService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
	}
	
	
	@Test
	public void testMakeRev(){
		ReservationVo rev=new ReservationVo();
		rev.setId("아이디1");
		rev.setLoc(1);
		rev.setSeatNo(2);
		rev.setRevTime(1);
		log.info(service.makeRev(rev));
	}
	
	@Test
	public void testGetRevist(Criteria cri){
		service.getRevList(cri).forEach(log::info);
	}
}
