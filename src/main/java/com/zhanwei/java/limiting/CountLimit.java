package com.zhanwei.java.limiting;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 计数器限流
 * <p> Description:  </p>
 * @Author Zhanwei
 * @Date [2017年3月9日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号   修改人  修改时间     修改内容描述
 * ----------------------------------------
 * V1.0		zhanwei	2017年3月9日	新建文件.
 * 
 * </pre>
 */
public class CountLimit {
	
	private static long timeStamp = System.currentTimeMillis();
	
	private static int reqCount = 0;
	
	private static final int LIMIT = 10;
	
	private static final int INTERVAL = 1000;//ms
	
	public static boolean grant(){
		long now = System.currentTimeMillis();
		if(now < timeStamp+INTERVAL){
			if(reqCount <= LIMIT){
				reqCount ++;
				return true;
			}else{
				return false;
			}
		}else{
			timeStamp = System.currentTimeMillis();
			reqCount = 0;
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
