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

package cycTest;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

import static org.springframework.tests.TestResourceUtils.*;

import mySpringTest.HasAware;

/**
 * 
 * @author Liangchuan.Ping
 * @since 5.0
 */
public class clcTest {
	public static void main(String[] args){
		Class<?> CLASS = clcTest.class;
		Resource ROOT_CONTEXT = qualifiedResource(CLASS, "context.xml");
		DefaultListableBeanFactory grandParent = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader(grandParent).loadBeanDefinitions(ROOT_CONTEXT);
//		BeanPostProcessor beanPostProcesser  = (BeanPostProcessor)grandParent.getBean("beanPostProcesser");
		A a =  (A)grandParent.getBean("beanA");
//		System.out.println(hasAware.forAware);
//		System.out.println(beanPostProcesser);
	}
}