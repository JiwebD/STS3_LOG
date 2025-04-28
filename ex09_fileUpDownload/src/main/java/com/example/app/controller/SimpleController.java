package com.example.app.controller;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/test")
public class SimpleController {

	@GetMapping("/ex")
	public void ex1_1() throws FileNotFoundException {
		log.info("GET -");
		throw new FileNotFoundException("파일을 찾을 수 없습니다.");
	}
	
	// 클래스에 붙은 경로(/test) + 메서드에 붙은 경로(/test1)가 합쳐진다
	@RequestMapping( value = "/test1" , method=RequestMethod.GET)
	public void test1() {	//void면 함수명(test1)에 해당하는 파일 찾음.
		log.info("GET /test/test1...");
		//파라미터
		//유효성
		//서비스
		//뷰이동(x) 포워딩 필요없음.
	}
	
	// 클래스에 붙은 경로(/test) + 메서드에 붙은 경로(/test2)가 합쳐진다
	@RequestMapping( value = "/test2" , method=RequestMethod.GET)
	public String test2() {	//return 값에 해당하는 파일 찾음.
		log.info("GET /test/test2...");
		//파라미터
		//유효성
		//서비스
		//뷰이동(x) 포워딩 필요없음.
		
		return "test/abcd";
	}
	
	// 클래스에 붙은 경로(/test) + 메서드에 붙은 경로(/test3)가 합쳐진다
	@RequestMapping( value = "/test3" , method= {RequestMethod.GET, RequestMethod.POST})
	public void test3() {	//return 값에 해당하는 파일 찾음.
		log.info("GET /test/test3...");

	}
	
}
