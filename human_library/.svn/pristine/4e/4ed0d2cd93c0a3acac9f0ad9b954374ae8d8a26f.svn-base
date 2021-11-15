package shop.j980108.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.BookVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
@WebAppConfiguration
public class BooksControllerTests {
	
	@Autowired @Setter
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testExist(){
		assertNotNull(ctx);
		assertNotNull(mvc);
		log.info(ctx);
		log.info(mvc);
	}
	
	//페이지번호에 따른 도서 목록 출력
	@Test
	public void testList() throws Exception{
		ModelMap map =mvc.perform(MockMvcRequestBuilders.get("/book/selectbooks")
				.param("pageNum", "3")
				.param("amount", "10")
				)
		.andReturn()
		.getModelAndView()
		.getModelMap();
		List<?> list= (List<?>)map.get("list");
		list.forEach(log::info);
	}
	
	//도서 상세보기
	@Test
	public void testGet() throws Exception{
		ModelMap map =mvc.perform(MockMvcRequestBuilders.get("/book/detailbooks").param("isbn","8965962374 9788965962373"))
		.andReturn()
		.getModelAndView()
		.getModelMap();
		log.info(map.get("book"));
		log.info(map.get("possession"));
	}
	
}
