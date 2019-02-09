package org.vexelon.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"));
		auth.inMemoryAuthentication().withUser(users.username("mary").password("test123").roles("MANAGER"));
		auth.inMemoryAuthentication().withUser(users.username("susan").password("test123").roles("ADMINISTRATOR"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll();
	}

}
