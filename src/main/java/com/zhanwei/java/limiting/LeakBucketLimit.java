package com.zhanwei.java.limiting;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LeakBucketLimit {
	
	private static long timeStamp = System.currentTimeMillis();
	
	private static final int capacity = 10;
	
	private static final int rate = 3;//出水速率
	
	private static int water = 0;//当前水量
	
	public static boolean grant(){
		long now = System.currentTimeMillis();
		
		//先执行漏水 ，计算剩余水量
		int out = (int) ((now - timeStamp) * rate);
		
		water = Math.max(0, water - out);
		
		timeStamp = now;
		
		if(water+1 < capacity){
			water ++;
			return true;
		}else{
			return false;
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
