package com.zhanwei.java.limiting;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenLimit {
	
	private static long timeStamp = System.currentTimeMillis();
	
	private static final int capacity = 10;
	
	private static final int rate = 3;
	
	private static int tokens;
	
	public static boolean grant(){
		long now = System.currentTimeMillis();
		
		//先添加令牌
		int in = (int) ((now-timeStamp)*rate);
		
		tokens = Math.min(tokens+in, capacity);
		
		timeStamp = now;
		
		if(tokens < 1){
			return false;
		}else{
			tokens --;
			return true;
		}
	}
	
	static class TestWork implements Runnable {

		public void run() {
			if(grant()){
				System.err.println("++++++执行代码逻辑");
			}else{
				System.out.println("------被限流");			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i=0;i<200;i++){
			Random random = new Random();
			int time = random.nextInt(100);
			Thread.sleep(time);
			service.submit(new TestWork());
		}
	}

}
