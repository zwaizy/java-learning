package com.zhanwei.java.jstack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JstackTest {
	
	
	private static ExecutorService service = Executors.newFixedThreadPool(5);
	
	private static Object lock = new Object();
	
	public static void main(String[] args) {
		
		Task task1 = new Task();
		Task task2 = new Task();
		
		service.submit(task1);
		service.submit(task2);
		
	}
	
	static class Task implements Runnable{

		public void run() {
			synchronized (lock) {
				calculate();
			}
		}
		
		void calculate(){
			int i=0;
			while(true){
				i++;
			}
		}
	}

}
