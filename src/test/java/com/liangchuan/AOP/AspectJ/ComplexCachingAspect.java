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

package com.liangchuan.AOP.AspectJ;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ComplexCachingAspect {
   private Map<String, Complex> cache;
   
   public ComplexCachingAspect(){
	   cache = Collections.synchronizedMap(new HashMap<String, Complex>());	   
   }
   
   public void setCache(Map<String, Complex> cache){
          this.cache = Collections.synchronizedMap(cache);	   
   }
   
   @Around("call(public Complex.new(int, int)) && args(a,b)")
   public Object cacheAround(ProceedingJoinPoint joinPoint, int a, int b)throws Throwable{
	   String key = a + "," + b;
	   Complex complex = cache.get(key);
	   if(complex == null){
		   System.out.println("Cache MISS for("+ key +")");
		   complex = (Complex) joinPoint.proceed();
		   cache.put(key , complex);
	   }
	   else{
		   System.out.println("Cache HIT for (" + key +")");
	   }
	   return complex;
   }
}
