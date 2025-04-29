package com.example.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;



@Aspect
@Component
@Slf4j
public class LoggingAdvice {
	
	//어디에 적용시킬껀지 포인트컷표현식
	//특정 메서드 한해서 적용상황
//	@Before("execution(boolean com.example.app.domain.service.MemoServiceImpl.registrationMemo(..) )")
//	public void loggingBefore(JoinPoint joinPoint) {
//		log.info("[AOP] BEFORE..." + joinPoint);
//		
//	}
//	@After("execution(* com.example.app.domain.service.MemoServiceImpl.getAllMemo(..) )")
//	public void loggingAfter(JoinPoint joinPoint) {
//		log.info("[AOP] AFTER..." + joinPoint);
//		log.info("[AOP] AFTER..." + joinPoint.getTarget());
//		log.info("[AOP] AFTER..." + joinPoint.getSignature());
//		log.info("[AOP] AFTER..." + joinPoint.getSignature().getName());
//		
//	}

	@Around("execution(* com.example.app.domain.service.*.*(..) )") // *.* service하위에있는 모는 서비스 . 모든 메서드
	public Object loggingAround(ProceedingJoinPoint pjp) throws Throwable {
		
		//이전시점
		log.info("[AOP] AROUND BEFORE");
		long startTime = System.currentTimeMillis();
		//MVC흐름대로 진행
		Object isUpdated = (Object)pjp.proceed();
		//이후시점
		log.info("[AOP] AROUND AFTER");
		long endTime = System.currentTimeMillis();
		log.info("[AOP] TIME : " + (endTime-startTime) + " ms");
		
		return isUpdated;
		
	}
}
