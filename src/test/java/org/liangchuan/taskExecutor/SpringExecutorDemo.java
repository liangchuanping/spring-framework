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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class SpringExecutorDemo {
   
   @Autowired
   private  SimpleAsyncTaskExecutor asyncTaskExecutor;
   
   @Autowired
   private SyncTaskExecutor syncTaskExecutor;
   
   @Autowired
   private TaskExecutorAdapter taskExecutorAdapter;
      
//   @Autowired
//   private ThreadPoolTaskExecutor threadPoolTaskExecutor;
   
   @Autowired
   private DemoRunnable runTask;
   
   @Autowired
   private DemoCallable callTask;
   
   @Autowired
   private ConcurrentTaskScheduler concurrentTaskScheduler;
   
   @Async
   public void testAnnotationAsync() throws InterruptedException{
	   Thread.sleep(5000);
	   System.out.println("Execute method asynchronously."+Thread.currentThread().getName());
	   testAnnotationAsyncTest();	   
   }
   
   @Async
   public Future<String> testAnnotationAsyncWithReturn() throws InterruptedException{
	   Thread.sleep(5000);
	   return new AsyncResult<String>("Hi,liangchuan");	   
   }
   
   private void testAnnotationAsyncTest() throws InterruptedException{
	   System.out.println(Thread.currentThread().getName());
   }
   
   public void testSyncTaskExecutor(){
	   syncTaskExecutor.execute(runTask);
	   System.out.println("afterSyncTaskExecutor");
   }
     
   public void testAsyncTaskExecutor(){
	   asyncTaskExecutor.execute(runTask);
	   System.out.println("afterAsyncTaskExecutor");
   }
   
   public void testAsyncTaskExecuterCallable() throws InterruptedException, ExecutionException{
	   Future<String> future = asyncTaskExecutor.submit(callTask);
	   System.out.println("afterAsyncTaskExecutorSubmit");
	   System.out.println(future.get());
	   System.out.println("afterAsyncTaskExecutorFutureGet");
   }
   
   public void testTaskExecutorAdapter(){
	   for(int i =0; i<5; i++){
	   taskExecutorAdapter.execute(runTask);
	   System.out.println("afterTaskExecutorAdapter"+i);}
   }
 
   public void testConcurrentTaskScheduler(){
	   concurrentTaskScheduler.scheduleWithFixedDelay(runTask, 2000);
   }
   
}
