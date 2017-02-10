/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liangchuan.AOP.Annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

/**
 * 
 * @author Liangchuan.Ping
 * @since 5.0
 */
@Aspect
@Order(1)
public class CalculatorLoggingAspect {
     
	@Before("execution(* ArithemticCaculator.add(..))")

	public void beforeAdd(JoinPoint joinPoint){
//		System.out.println("------------------------");
//		System.out.println(joinPoint.getSignature().getName());
//		System.out.println(joinPoint.getTarget());
//		System.out.println("------------------------");
		System.out.println("before add,order 1");	
		} 
	
	@After("execution(* ArithemticCaculator.add(..))")
	public void afterAdd(){
		System.out.println("after add, order 1");
	}
	
	@AfterReturning("execution(* ArithemticCaculator.add(..))")
	public void afterReturningAdd(){
		System.out.println("after return add");
	}
	
	@Around("execution(* ArithemticCaculator.add(..)))")
	public Double aroundAdd(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("aroundBefore");
			Double result = (Double) joinPoint.proceed();
			System.out.println(result);	
			System.out.println("aroundAfter");	
			return result;
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
