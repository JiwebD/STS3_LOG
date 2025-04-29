package com.example.app.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;

public class CustomHandler implements Controller {

	// ModelAndView : 이동해야할 위치와 담아야할 내용
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CustomHandler's handleRequest...");
		return null;
	}
	
	public void hello() {
		System.out.println("CustomHandler's hello!!..");
	}
}
