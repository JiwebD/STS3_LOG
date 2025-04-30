package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("MemoController's dataBinder ..." + webDataBinder);
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new DateTextEditor());
		webDataBinder.registerCustomEditor(String.class, "phone", new phoneTextEditor());
	}

	@GetMapping("/login")
	public void login() {
		log.info("GET /login...");
	}
	
//	@GetMapping("/user")
//	public void user(Authentication authentication) {
//		log.info("GET /user..." + authentication);
//		log.info("name..." + authentication.getName());
//		log.info("principal..." + authentication.getPrincipal());
//		log.info("authorities..." + authentication.getAuthorities());
//		log.info("details..." + authentication.getDetails());
//		log.info("credentials..." + authentication.getCredentials());
//	}
	
//	@GetMapping("/user")
//	public void user(@AuthenticationPrincipal Principal principal) {
//		log.info("GET /user..." + principal);
//
//	}
	
	@GetMapping("/user")
	public void user(Model model) {
		log.info("GET /user...");
		Authentication authentication =
		SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication : " + authentication);
		
		model.addAttribute("auth",authentication);
		
	}

	@GetMapping("/manager")
	public void manager() {
		log.info("GET /manager...");

	}

	@GetMapping("/admin")
	public void admin() {
		log.info("GET /a...");

	}

	@GetMapping("/join")
	public void join() {
		log.info("GET /join..");
	}

	@PostMapping("/join")
	public String join_post(@Valid UserDto dto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		log.info("POST /join.." + dto);

		for (FieldError error : bindingResult.getFieldErrors()) {
			log.info("Error Field : " + error.getField() + " Error Msg : " + error.getDefaultMessage());
			model.addAttribute(error.getField(), error.getDefaultMessage());
			return "join";
		}
		
		boolean isJoin = userService.userJoin(dto);
		if(isJoin) {
			redirectAttributes.addFlashAttribute("message","회원가입 완료!"); //sessino 에 저장
			return "redirect:/login";
		}
		else
			return "join";

	}

	// WebDateBinder Custom설정
	// 파라미터 중 phone의 값중 '-' 는 없애고 바인딩할것(010-111-2222 -> 0101112222)
	// 파라미터 중 birthday의 ~은 -로 바꾼뒤 LocalDate 로 Outformatting 할것

	private static class DateTextEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String birthdaytext) throws IllegalArgumentException {
			log.info("DateTestEditor's setAsText invoke.." + birthdaytext);
			LocalDate date = null;
			if (birthdaytext.isEmpty()) {
				date = LocalDate.now();
			} else {
				birthdaytext = birthdaytext.replaceAll("~", "-");
				date = LocalDate.parse(birthdaytext, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			setValue(date);

		}

	}

	private static class phoneTextEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String phonetext) throws IllegalArgumentException {
			log.info("phoneTestEditer's setAsText invoke.." + phonetext);
			phonetext = phonetext.replaceAll("-", "");
			setValue(phonetext);
		}

	}
}
