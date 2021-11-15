package shop.j980108.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import shop.j980108.domain.MemberVo;

@Getter
public class CustomUser extends User{
   private MemberVo memberVo;
   
public CustomUser(String id, String pwd, Collection<? extends GrantedAuthority> authorities) {
	super(id, pwd, authorities);
}

   public CustomUser(MemberVo member) {
      super(member.getId(),
            member.getPwd(),
            member.getAuths()
            .stream()
            .map(a-> new SimpleGrantedAuthority(a.getAuth())).collect(Collectors.toList()));
      this.memberVo = member;
   }
}