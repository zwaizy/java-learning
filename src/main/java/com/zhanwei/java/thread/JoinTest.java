package com.zhanwei.java.thread;

public class JoinTest {
	
	private static volatile int i = 0;
	
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new testThread());
		
		thread1.start();
		try {
			thread1.join();//下面执行代码的线程必须等待 thread1线程的加入，即等待thread1线程执行完run方法，才继续执行下面的代码
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(i);
	}

	
	static class testThread implements Runnable{

		public void run() {
			for( i=0;i<10000;i++){};
		}
		
	}
}
