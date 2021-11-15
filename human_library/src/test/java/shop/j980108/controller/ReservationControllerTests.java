package shop.j980108.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
@WebAppConfiguration
public class ReservationControllerTests {

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
	public void testInsert() throws Exception{
		ModelAndView mav = mvc.perform(
				MockMvcRequestBuilders.post("/seat/list")
				.param("id", "member5")
				.param("loc", "1")
				.param("seatNo", "1")
				.param("revs", "4")
				.param("revs", "5"))
			.andReturn()
			.getModelAndView();
	
	log.info(mav.getViewName());
	}
	
	@Test
	public void testDelete() throws Exception{
		mvc.perform(delete("/seat/delete/283"))
		.andExpect(status().is(200));
	}
	
	@Test
	public void testMyPage() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/seat/mypage")
				.param("pageNum", "1")
				.param("amount", "5")
				.param("id", "member5")
				)
		.andReturn()
		.getModelAndView()
		.getModelMap();
		
		List<?> list = (List<?>) map.get("list");
		list.forEach(log::info);
	}
	
	@Test
	public void testAdmin() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/seat/admin")
				.param("pageNum", "1")
				.param("amount", "5")
				)
		.andReturn()
		.getModelAndView()
		.getModelMap();
		
		List<?> list = (List<?>) map.get("list");
		list.forEach(log::info);
	}
}
