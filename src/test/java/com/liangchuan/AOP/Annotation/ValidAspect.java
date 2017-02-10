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

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * 
 * @author Liangchuan.Ping
 * @since 5.0
 */
@Aspect
@Order(0)
public class ValidAspect {
	
	@Pointcut("execution(* *.*(..))")
	private void allOperation(){} 
	
	@Before(value = "execution(* ArithemticCaculator.add(..))")   
	public void beforeAdd(){
		System.out.println("before add,order 0");
	}
	
	@After(value = "execution(* ArithemticCaculator.add(..))")
	public void afterAdd(){
		System.out.println("after add, order 0");
	}
	
	@Before("allOperation()")
	public void beforeAddAll(){
		System.out.println("before all operation");
	}
	
	@Before("@annotation(com.liangchuan.AOP.Annotation.LoggingRequired)")
	public void beforeAddAnnotation(){
		System.out.println("before through annotation");
	}
}
