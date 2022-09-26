package smartDigiRH.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import smartDigiRH.security.filter.JwtAuthenticationFilter;
import smartDigiRH.security.filter.JwtAuthorizationFilter;
import smartDigiRH.security.impl.UserDetailsServiceImp;





@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsServiceImp detailsServiceImp;
	public SecurityConfig(UserDetailsServiceImp detailsServiceImp) {
		this.detailsServiceImp = detailsServiceImp;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(detailsServiceImp);
	} 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable();
		
		//http.formLogin();
		http.authorizeRequests().antMatchers("/**", "/refreshToken/**","/login/**","/profil/**,","/regester/**", "/users/**", "/user/**", "/auth/**","/project/**", "/employee/**","/meeting/**", "//projectToEmployee/**",
				"/vacation/**","/meeting/**","/training/**").permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.POST,"/users/**").hasAuthority("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/**").hasAuthority("USER");
		http.authorizeRequests().anyRequest().authenticated();
		
		http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
		http.addFilterBefore(new JwtAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	} 
}
