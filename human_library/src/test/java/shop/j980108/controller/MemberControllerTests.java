package shop.j980108.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
    "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
@WebAppConfiguration
public class MemberControllerTests {
	@Setter @Autowired
	private LoginController controller;
 
 	@Setter @Autowired 
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
    
    @Test
    public void testLogin() throws Exception{
        ModelAndView view = mvc.perform(MockMvcRequestBuilders.get("/member/login")
                .param("id", "member5")
                .param("pwd","qwe5"))
                .andReturn()
                .getModelAndView();

            log.info(view.getViewName());
    }
    
    @Test
    public void testMemberJoin() throws Exception{
        ModelAndView view = mvc.perform(MockMvcRequestBuilders.post("/member/join")
                .param("id", "testmember1")
                .param("pwd","t1234")
        		.param("studNo", "111111")
        		.param("name", "승협이")
        		.param("nickName", "내가곽씨다")
        		.param("phone", "010-1234-9090")
        		.param("email", "melona@naver.com")
        		.param("uuid", "#"))
                .andReturn()
                .getModelAndView();
        
            log.info(view.getViewName());
    }   
    
    @Test
    public void testProfileModify() throws Exception{
    	ModelAndView view = mvc.perform(MockMvcRequestBuilders.post("/member/modify")
                .param("id", "testmember1")
                .param("pwd","t1234")
        		.param("studNo", "111111")
        		.param("name", "테스터")
        		.param("nickName", "수정된테스터")
        		.param("phone", "010-1234-9090")
        		.param("email", "melona@naver.com")
        		.param("uuid", "#"))
                .andReturn()
                .getModelAndView();

            log.info(view.getViewName());
    }
    
    @Test
    public void testTermsPage() throws Exception {
       mvc.perform(get("/member/terms")).andExpect(status().isOk());
    }
    
    @Test
    public void testJoinPage() throws Exception {
       mvc.perform(get("/member/join")).andExpect(status().isOk());
    }
    
    @Test
    public void testProfilePage() throws Exception {
       mvc.perform(get("/member/profile")).andExpect(status().isOk());
    }
    
    @Test
    public void testModifyPage() throws Exception {
       mvc.perform(get("/member/profilemodify")).andExpect(status().isOk());
    }

}