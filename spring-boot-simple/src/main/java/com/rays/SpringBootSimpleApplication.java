
package com.rays;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.rays.common.FrontCtl;


@SpringBootApplication
public class SpringBootSimpleApplication {
	
	@Autowired
	private FrontCtl frontCtl;


	public static void main(String[] args) {

		SpringApplication.run(SpringBootSimpleApplication.class, args);

	}
	
	
	/* its called corsmapping for connect angular and spring boot */ 
//method ko jb bean banana hota h to annotation @bean ka use karte hai
	@Bean
	public WebMvcConfigurer corsConfig() {
		WebMvcConfigurer w = new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				CorsRegistration cors = registry.addMapping("/**");
				cors.allowedOrigins("http://localhost:4200");
				cors.allowedHeaders("*");
				cors.allowCredentials(true);
	
			}
			
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns("/Auth/**");
			}
		};
		return w;
	}

}
