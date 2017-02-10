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



import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import static org.springframework.tests.TestResourceUtils.*;
/**
 * 
 * @author Liangchuan.Ping
 * @since 5.0
 */


public class BeanNameAware {

	public static void main(String[] args){
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("autoWiredTest/HasAware-context.xml");
		HasAware hasAware =  (HasAware)ac.getBean("hasWired");
		System.out.println(hasAware.isString);
		System.out.println(hasAware.forAware);
		System.out.println(hasAware.setterInject);
		System.out.println(hasAware.resourceLoader);
		hasAware.getResourceFromFile();
        hasAware.testMessageSource();
        hasAware.testDateEditor();
	}
}


