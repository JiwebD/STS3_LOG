package com.example.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MemoInterceptor implements HandlerInterceptor {

	//MemoController로 이동하기 전 처리  = 서브컨트롤러 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MemoInterceptior's preHandle...");
		return true;
	}
	
	//MemoController의 작업이 끝난 이후  = 서브컨트롤러 진입후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MemoInterceptior's postHandle...");

	}

	//View Page 렌더링 된 이후 처리
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MemoInterceptior's afterCompletion...");

	}

	
}
