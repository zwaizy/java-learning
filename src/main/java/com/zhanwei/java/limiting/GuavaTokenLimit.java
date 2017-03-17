package com.zhanwei.java.limiting;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.common.util.concurrent.RateLimiter;

public class GuavaTokenLimit {
	
	private static ConcurrentMap<String, RateLimiter> resRateLimiter = new ConcurrentHashMap<String, RateLimiter>();
	
	public static void createFlowLimitMap(String resource,double qps){
		RateLimiter limit = resRateLimiter.get(resource);
		if(null == limit){
			limit = RateLimiter.create(qps);
			resRateLimiter.putIfAbsent(resource, limit);
		}
		limit.setRate(qps);
	}
	
	public static boolean grant(String resource) throws Exception{
		
		RateLimiter limit = resRateLimiter.get(resource);
		if(limit == null){
			throw new Exception(resource);
		}
		if(!limit.tryAcquire()){
			return true;
		}
		return false;
	}
	
	static class TestWork implements Runnable {

		public void run() {
			try {
				if(grant("zhanwei")){
					System.err.println("++++++执行代码逻辑");
				}else{
					System.out.println("------被限流");			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		GuavaTokenLimit.createFlowLimitMap("zhanwei", 10);
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i=0;i<200;i++){
			Random random = new Random();
			int time = random.nextInt(100);
			Thread.sleep(time);
			service.submit(new TestWork());
		}
	}
	

}
