package shop.j980108.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
   "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberTests {
   @Autowired @Setter @Qualifier("BCryptPasswordEncoder")
   private PasswordEncoder encoder;
   @Autowired @Setter
   private MemberMapper memberMapper;
   
   
private List<Map<String, Object>> members = new ArrayList<>();
   
   @Before
   public void init() {
      for(int i = 0; i < 10 ; i++) {
         Map<String, Object> map = new HashMap<String,Object>();
         map.put("pwd", encoder.encode("qwe"+i));
         
         if(i < 4) {
            map.put("id", "user" + i);
            map.put("studno", "1212"+i);
            map.put("name", "휴먼사용자" + i);
            map.put("nickname", "휴먼닉네임"+i);
            map.put("phone", "010-1234-567"+i);
            map.put("email", "mail" + i +"@naver.com");
            map.put("uuid", "#");
            map.put("auth", "ROLE_USER");
            
         } else if(i < 8) {
            map.put("id", "member" + i);
            map.put("studno", "1212"+i);
            map.put("name", "휴먼회원" + i);
            map.put("nickname", "휴먼닉네임"+i);
            map.put("phone", "010-1234-567"+i);
            map.put("email", "mail" + i +"@naver.com");
            map.put("uuid", "#");
            map.put("auth", "ROLE_MEMBER");
            
         } else {
            map.put("id", "admin" + i);
            map.put("studno", "1212"+i);
            map.put("name", "휴먼관리자" + i);
            map.put("nickname", "휴먼닉네임"+i);
            map.put("phone", "010-1234-567"+i);
            map.put("email", "mail" + i +"@naver.com");
            map.put("uuid", "#");
            map.put("auth", "ROLE_ADMIN");
         }
         members.add(map);
      }
      
   }
   
   // member
   @Test
   public void testInsert() {
      members.forEach(map -> memberMapper.memberJoin(map));
   }
   // auth
   @Test
   public void testAuth() {
      members.forEach(m -> memberMapper.authJoin(m));
   }
   
//   @Test
//   public void testAuth2() {
//      List<Map<String, Object>> list = new ArrayList<>();
//      for(int i = 9; i <= 10 ; i++) {
//         Map<String, Object> map = new HashMap<String,Object>();
//         map.put("id", "admin" + i);
//         map.put("auth", "ROLE_MEMBER");
//         list.add(map);
//      }
//      list.forEach(m -> memberMapper.authJoin(m));
//   }
   
   // 통합
   @Test
   public void testInte() {
      
   }
}