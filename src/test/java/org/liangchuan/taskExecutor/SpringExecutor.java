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

package org.liangchuan.taskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SyncTaskExecutor;

/**
 * 
 * @author Liangchuan.Ping
 * @since 5.0
 */
public class SpringExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
	ApplicationContext ac = new ClassPathXmlApplicationContext("org/liangchuan/taskExecutor/context.xml");
	SpringExecutorDemo springExecutorDemo = (SpringExecutorDemo)ac.getBean("springTaskDemo");
//	springExecutorDemo.testSyncTaskExecutor();
//	springExecutorDemo.testAsyncTaskExecutor();
//	springExecutorDemo.testAsyncTaskExecuterCallable();
//	springExecutorDemo.testTaskExecutorAdapter();
//	springExecutorDemo.testAnnotationAsync();
	
//	Future<String> future = springExecutorDemo.testAnnotationAsyncWithReturn();
//	System.out.println(1);
//	System.out.println(future.get());
//	System.out.println(2);
	
	springExecutorDemo.testConcurrentTaskScheduler();
	
	}
}