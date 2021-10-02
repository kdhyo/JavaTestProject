package com.hyo.story.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
@Order(value = 2)
public class LogAOP {
	
	@Around("execution(* com.hyo.story.service.aop.TestAopService.*(..))")
	public void logAop1(ProceedingJoinPoint joinPoint) throws Throwable {
		log.error("==========LogAOP1 시작==========");
		joinPoint.proceed();
		log.error("==========LogAOP1 종료==========");
	}
}


