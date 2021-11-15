package shop.j980108.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.NAvailableVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class NAvailableMapperTests {
	@Autowired @Setter
	   private NAvailableMapper nAvailableMapper;
	
	@Test
	public void testInsert(){
		NAvailableVo na=new NAvailableVo();
		na.setLoc(3);
		na.setSeatNo(5);
		na.setReason("사회적거리두기");
		nAvailableMapper.insert(na);
		log.info(na);
	}
	
	@Test
	public void testGetList(){
		nAvailableMapper.getList().forEach(log::info);
	}
	
	@Test
	public void testDelete(){
		nAvailableMapper.delete(3L);
	}
	
	@Test
	public void testIsExist(){
		NAvailableVo na=new NAvailableVo();
		na.setLoc(4);
		na.setSeatNo(5);
		log.info(nAvailableMapper.isExist(na));
	}
	
	@Test
	public void testFindBy(){
		log.info(nAvailableMapper.findBy(43L));
	}
}
