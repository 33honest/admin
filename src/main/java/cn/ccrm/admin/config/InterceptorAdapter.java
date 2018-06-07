package cn.ccrm.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.ccrm.admin.interceptor.UrlInterceptor;

@Configuration
public class InterceptorAdapter implements WebMvcConfigurer {


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UrlInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login.htm", "/logout.htm", "/login.do", "/error/**", "/css/**", "/js/**", "/fonts/**", "/images/**", "/upload/show/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	private Logger logger = LoggerFactory.getLogger(getClass());
		

}
