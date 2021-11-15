package shop.j980108.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.LoansVo;
import shop.j980108.domain.ReservationVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
@WebAppConfiguration
public class SeatControllerTests {
	
	@Autowired @Setter
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testExist(){
		assertNotNull(ctx);
		assertNotNull(mvc);
		log.info(ctx);
		log.info(mvc);
	}
	
	@Test
	public void testList() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/seat/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		log.info(map.get("revTime"));
	}
	
	@Test
	public void testGetSeats() throws Exception{
		mvc.perform(get("/seat/getSeats"))
				.andExpect(status().is(200));
	}
	
	@Test
	public void testChoose() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/seat/choose"))
				.andReturn()
				.getModelAndView()
				.getModelMap();
			log.info(map);
	}
	
	@Test
	public void testComplete() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/seat/complete"))
				.andReturn()
				.getModelAndView()
				.getModelMap();
			log.info(map);
	}
	
	/* 관리자 좌석관리 컨트롤러테스트 */
	@Test
	public void testSeatManage() throws Exception{
		ModelMap map =mvc.perform(MockMvcRequestBuilders.get("/seat/seatManage"))
		.andReturn()
		.getModelAndView()
		.getModelMap();
		
		List<?> list= (List<?>)map.get("list");
		list.forEach(log::info);
	}
	
	@Test
	public void testInsertSeatManage() throws Exception{
		ModelAndView mav =mvc.perform(
				MockMvcRequestBuilders.post("/seat/seatManage")
				.param("loc", "3")
				.param("seatNo","3")
				.param("reason", "컨트롤러 테스트"))
			.andReturn()
			.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	@Test
	public void testDeleteNAvailable() throws Exception{
		mvc.perform(delete("/seat/update/61"))
				.andExpect(status().is(200));
	}
	

	
	
}
