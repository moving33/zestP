package com.zest.web.client.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@Aspect
public class AopAdvice {

	private Logger logger = LoggerFactory.getLogger(AopAdvice.class);
	
	//시작 전
	/*@Pointcut("execution( * com.zest.web.client.*.*(..))")
	public void test() {}*/
	
	@Before("execution( * com.zest.web..*.*(..))")
	public void beforeLog(JoinPoint joinPoint) {		
		
		//처리하는 클래스 이름
		
		String className = joinPoint.getTarget().getClass().getSimpleName();
		//실행하는 메서드
		String method = joinPoint.getSignature().getName();		
		logger.info("\n[Class] : "+className+"\n"+"[Method] : "+method);
	}

	public AopAdvice() {
		super();			
	}	
	
	
}
