package com.zhanwei.java.test7;

public class SingletonTest {

	public static void main(String[] args) {
		new Thread(new Runnable() {

			public void run() {
				for (int i=0 ;i<10;i++) {
					Singleton single = Singleton.getInstance();
					System.out.println(Thread.currentThread().getName() + "@" + single);
				}
			}
		}).start();
		new Thread(new Runnable() {

			public void run() {
				for (int i=0 ;i<10;i++) {
					Singleton single = Singleton.getInstance();
					System.out.println(Thread.currentThread().getName() + "@" + single);
				}
			}
		}).start();
	}

}
