/**
 * 
 */
package com.practice.aop;

import java.math.BigInteger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Anudeep Kumar
 *
 */
@Component
@Aspect
public class TrackingAspect {

	Logger logger = Logger.getLogger(TrackingAspect.class.getName());

	@Before("execution(* *(..))")
	public void entering(JoinPoint joinPoint) {
		logger.trace("Entering Executed...");
		logger.trace(joinPoint.getSignature());
	}
	
	@AfterReturning(pointcut="execution(* *(..))",
			 returning="String")
	public void enter(JoinPoint joinPoint) {
		logger.trace("Entering Executed...");
		logger.trace(joinPoint.getSignature());
	}
	@After("execution(* *(..))")
	public void afterEnter(JoinPoint joinPoint) {
		logger.trace("Entering Executed...");
		logger.trace(joinPoint.getSignature());
	}
	@AfterThrowing(pointcut="execution(* *(..))",throwing="ex")
	public void afterThrow(JoinPoint joinPoint) {
		logger.trace("Entering Executed...");
		logger.trace(joinPoint.getSignature());
	}
	
	@Around("execution(* *(..))")
	public void aroundAdvice(ProceedingJoinPoint proceedJoinPoint){
		
		
	}

}
