package shop.j980108.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
@WebAppConfiguration
public class HomeControllerTests {
	
	@Autowired @Setter
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testListLoansReservationForMember() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/")
				.param("id", "dldlrwns"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		log.info("<---------- 대출예약중 도서수 ---------->");
		int countLoansReserVation = (int)map.get("countLoansReserVation");
		log.info(countLoansReserVation);
		log.info("<---------- 대출예약확정중 도서수 ---------->");
		int countLoansAccept = (int)map.get("countLoansAccept");
		log.info(countLoansAccept);
		log.info("<---------- 대출중 도서수 ---------->");
		int countLoans = (int)map.get("countLoans");
		log.info(countLoans);
		log.info("<---------- 연체중 도서수 ---------->");
		int countLoansOverdue = (int)map.get("countLoansOverdue");
		log.info(countLoansOverdue);
		log.info("<---------- 최근 반납 도서수 ---------->");
		int countReturnedLoansRecently = (int)map.get("countReturnedLoansRecently");
		log.info(countReturnedLoansRecently);
		log.info("<---------- 인기도서 리스트 ---------->");
		List<?> listPopularityPossession = (List<?>)map.get("listPopularityPossession");
		listPopularityPossession.forEach(log::info);
		log.info("<---------- 신착도서 리스트 ---------->");
		List<?> listNewPossession = (List<?>)map.get("listNewPossession");
		listNewPossession.forEach(log::info);
		log.info("<---------- 휴먼마켓 최신글 리스트 ---------->");
		List<?> listMarketBoard = (List<?>)map.get("listMarketBoard");
		listMarketBoard.forEach(log::info);
		log.info("<---------- 1열람실 예약 좌석수 ---------->");
		int loc1 = (int)map.get("loc1");
		log.info(loc1);
		log.info("<---------- 2열람실 예약 좌석수 ---------->");
		int loc2 = (int)map.get("loc2");
		log.info(loc2);
		log.info("<---------- 3열람실 예약 좌석수 ---------->");
		int loc3 = (int)map.get("loc3");
		log.info(loc3);
		log.info("<---------- 4열람실 예약 좌석수 ---------->");
		int loc4 = (int)map.get("loc4");
		log.info(loc4);
	}
	
}
