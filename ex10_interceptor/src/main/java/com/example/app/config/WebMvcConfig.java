package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.app.interceptor.MemoInterceptor;

@Configuration
@EnableWebMvc  //servlet-context.xml의 역할을 대신해서 함. 스프링 MVC 설정을 자바 기반(@Configuration)으로 활성화하는 어노테이션
@ComponentScans({
	@ComponentScan("com.example.app.controller"),
	@ComponentScan("com.example.app.restController")
})
public class WebMvcConfig implements WebMvcConfigurer{  //servlet-context.xml의 역할을 대신해서 함.

	@Bean
	public MultipartResolver multipartResolver() { 
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20971520); 			// 20MB	//전체 업로드 허용 사이즈
        multipartResolver.setMaxUploadSizePerFile(20971520); 	// 20MB	//파일 1개당 허용가능한 업로드 사이즈
        multipartResolver.setMaxInMemorySize(20971520); 		// 20MB //캐시 공간
        return multipartResolver;
	}
	
	

	
	//ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//정적파일설정할때 페이지에서 나오는 기본아이콘 (파비콘) 설정할때 중요
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		
	}
	
	//INTERCEPTOR ADD
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MemoInterceptor()).addPathPatterns("/memo/*");
	}

	

	
	

	
	
}
