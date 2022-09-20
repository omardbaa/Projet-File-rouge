package smartDigiRH.security.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import smartDigiRH.services.AccountService;
import smartDigiRH.services.impl.AccountServiceImpl;





@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private AccountServiceImpl appService ;
	
	

	public UserDetailsServiceImp(AccountServiceImpl appService) {
		this.appService = appService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		smartDigiRH.entities.User user = appService.loadUserByUserName(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		user.getAppRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
