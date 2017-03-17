package com.zhanwei.java.test2;

public class ThreadDemo extends Thread{
	private Sequence sequence;
	
	public ThreadDemo(Sequence sequence) {
		this.sequence = sequence;
	}
	
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println("Thread :" + Thread.currentThread().getName() + ",number : " + sequence.getNumber());
		}
	}

}
