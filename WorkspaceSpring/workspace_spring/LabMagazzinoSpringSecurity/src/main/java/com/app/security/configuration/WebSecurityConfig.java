package com.app.security.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.security.services.MyAppUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		try {
			//aggiunge l'utente all'autentificazione
			auth.userDetailsService(myAppUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
		} catch (Exception e) {
			logger.error("Utente non trovato");
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/user/**").hasAnyAuthority("USER", "ADMIN", "GOD")
			.antMatchers("/admin/**").hasAnyAuthority("ADMIN", "GOD")
			.antMatchers("/god/**").hasAuthority("GOD")
			.and()
		.formLogin()  
            .loginPage("/login")
            .usernameParameter("email")
            .passwordParameter("password")
            .defaultSuccessUrl("/")
            .failureUrl("/login?error=true")
        .and().csrf().disable()
		.logout()    
		.logoutUrl("/appLogout") 
		.logoutSuccessUrl("/")
		.and().exceptionHandling() 
		.accessDeniedPage("/access-denied"); 
	} 	

}