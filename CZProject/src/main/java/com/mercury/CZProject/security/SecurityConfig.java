package com.mercury.CZProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsServiceImpl;
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable()
			.cors();
		http.authorizeRequests(
				(requests) -> 
				requests
					.anyRequest()
					//.authenticated()
					.permitAll()
				);
		http.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
		;
		http.logout()
			.permitAll()
			.logoutUrl("/logout")
		;
		http.httpBasic();
	}
	@Bean // put the return object into spring container, as a bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
	@Autowired // @Autowired on function will autowired the parameters
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder(11));
	}
}
