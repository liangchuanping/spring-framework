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

package autoWiredTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


/**
 * @author Liangchuan.Ping
 * @since 5.0
 */

public class HasAware  implements org.springframework.beans.factory.BeanNameAware ,ResourceLoaderAware, ApplicationContextAware{
	private String name;
	
	public  ResourceLoader resourceLoader;
	
	private ApplicationContext applicationContext;
	
	@Autowired
	public  ForAware forAware;
	
	public SetterInject setterInject;
	
	public SetterInject2 setterInject2;
	
	public String isString;
	
	public Date date;
	
	
	public void setSetterInject(SetterInject setterInject){
		this.setterInject = setterInject;
	}
	
	public void setSetterInject2(SetterInject2 setterInject){
		this.setterInject2 = setterInject;
	}
	
	public void setIsString(String isString){
		this.isString = isString;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	@Override
	public void setBeanName(String name){
		this.name = name;
		System.out.println(1);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException{
       this.applicationContext = applicationContext;
	} 
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader){
		this.resourceLoader = resourceLoader;		
	}
	
	public String getResourceFromFile(){
		StringBuilder sb = new StringBuilder();
		Resource  resource = resourceLoader.getResource(isString);
		try{
		InputStream inputStream =  resource.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		while(true){
		  String line = reader.readLine();
		  if(line == null){
			 break; 
		  }
		  sb.append(line) ;			
		}		
		}catch(Exception e){	
			System.out.println("File not exist!");
			System.exit(0);
		 }
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	public void testMessageSource(){
		String code1 = applicationContext.getMessage("code1", null, Locale.ENGLISH);
		String code1InChina = applicationContext.getMessage("code1", null, Locale.CHINA);
		System.out.println(code1InChina);
		System.out.println(code1);
	}

    public void testDateEditor(){    
         System.out.println(date);
    }
}
