package shop.j980108.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.MemberVo;
import shop.j980108.mapper.MemberMapper;
import shop.j980108.security.domain.CustomUser;


@Log4j @Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired @Setter
	private MemberMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		log.warn(arg0);
		MemberVo member = mapper.read(arg0);
		return member == null? null : new CustomUser(member);
	}
}