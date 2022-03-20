package com.orderApp.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/home/**").authenticated()
		.and().formLogin()
		.loginPage("/login").loginProcessingUrl("/login")
		.usernameParameter("cName").passwordParameter("cPass")
		.defaultSuccessUrl("/home")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		.and().sessionManagement().maximumSessions(1);
		
		http
		.logout(logout -> logout
		.logoutUrl("/logout")
		.permitAll()
		.addLogoutHandler(new HeaderWriterLogoutHandler(
	            new ClearSiteDataHeaderWriter(
	                    ClearSiteDataHeaderWriter.Directive.CACHE,
	                    ClearSiteDataHeaderWriter.Directive.COOKIES,
	                    ClearSiteDataHeaderWriter.Directive.STORAGE)))
		);
		
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
