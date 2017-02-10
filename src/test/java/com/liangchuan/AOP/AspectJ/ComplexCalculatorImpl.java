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


/**
 * 
 * @author Liangchuan.Ping
 * @since 5.0
 */
public class ComplexCalculatorImpl implements ComplexCalculator{
	
    public Complex add(Complex a, Complex b){
    	Complex result = new Complex(a.getReal()+b.getReal(), a.getImaginary()+b.getImaginary());
    	System.out.println(a + " + " + b +" = " + result);
    	return result;
    }
    
    public Complex sub(Complex a, Complex b){
    	Complex result = new Complex(a.getReal()-b.getReal(), a.getImaginary()-b.getImaginary());
        System.out.println(a + " + " + b +" = " + result);
        return result;
    }
}
