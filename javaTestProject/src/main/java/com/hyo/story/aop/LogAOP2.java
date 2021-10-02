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
@Order(value = 1)
public class LogAOP2 {

	@Around("execution(* com.hyo.story.service.aop.*TestAopService.*(..))")
	public void logAop2(ProceedingJoinPoint joinPoint) throws Throwable {
		log.error("==========LogAOP2 시작==========");
		joinPoint.proceed();
		log.error("==========LogAOP2 종료==========");
	}
	
}
