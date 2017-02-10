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

package com.liangchuan.AOP.Introduction;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 
 * @author Liangchuan.Ping
 * @since 5.0
 */
@Aspect
public class CalculatorIntroduction {
    @DeclareParents(
    		value = "com.liangchuan.AOP.Introduction.ArithemticCaculatorImple",
    		defaultImpl = MaxCalculatorImple.class
    		)
    public MaxCalculator maxCalculator;
    
    @DeclareParents(
    		value = "com.liangchuan.AOP.Introduction.ArithemticCaculatorImple",
    		defaultImpl = MinCalculatorImple.class
    		)
    public MinCalculator minCalculator;
    
//    @DeclareParents(
//    		value = "com.liangchuan.AOP.Introduction.ArithemticCaculatorImple",
//    		defaultImpl = CounterImpl.class
//    		)
//    public Counter counter;
    
//    @After("execution(* com.liangchuan.AOP.Introduction.ArithemticCaculator.*(..))"
//    		+"&& this(com.liangchuan.AOP.Introduction.Counter2)"
//    		)
//    public void increaseCount(JoinPoint jointPoint){
//    	Counter2 counter2 = (Counter2) jointPoint.getThis();
//    	counter2.increase();    	
//    }
    
    @After("execution(* com.liangchuan.AOP.Introduction.ArithemticCaculator.*(..))"
    		+"&& this(counter2)&& args(a,b)"
    		)
    public void increaseCount(Counter2 counter2, double a ,double b){
    	counter2.increase();    
    	System.out.println("args is" + a+ " and "+b);
    }
}
