package com.zhanwei.java.test2;

public class ThreadLocalTest {
	
	public static void main(String[] args) {
		SequenceA sequence = new SequenceA();
	
		ThreadDemo demo1 = new ThreadDemo(sequence);
		ThreadDemo demo2 = new ThreadDemo(sequence);
		ThreadDemo demo3 = new ThreadDemo(sequence);
		
		demo1.start();
		demo2.start();
		demo3.start();
		
	}

}
