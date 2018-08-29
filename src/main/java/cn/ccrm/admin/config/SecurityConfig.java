package cn.ccrm.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import cn.ccrm.admin.config.security.AjaxAuthFailHandler;
import cn.ccrm.admin.config.security.AjaxAuthSuccessHandler;
import cn.ccrm.admin.config.security.UnauthorizedEntryPoint;
import cn.ccrm.admin.service.impl.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public SpringDataUserDetailsService springDataUserDetailsService() {
		return new SpringDataUserDetailsService();
	}

	@Bean
	public ShaSecurityPasswordEncoder securityPasswordEncoder() {
		return new ShaSecurityPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(springDataUserDetailsService()).passwordEncoder(securityPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/fonts/**", "/login.htm");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint()).and()
		.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated()
		.and().logout().permitAll().and().formLogin().loginPage("/login.htm").loginProcessingUrl("/login").defaultSuccessUrl("/admin/goods/index/").usernameParameter("username").passwordParameter("password").successHandler(new AjaxAuthSuccessHandler()).failureHandler(new AjaxAuthFailHandler()).permitAll();
		http.csrf().disable();
	}

}
