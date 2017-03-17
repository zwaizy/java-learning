package com.zhanwei.java.javase;

public class StaticTest {
	
	private static int count = 0;
	
	public void setCount(){
		count ++;
	}
	
	public int getCount(){
		return count;
	}

	public static void main(String[] args) {
		
		for(int i=0;i<100;i++){
			new StaticTest().setCount();
		}
		
		System.out.println(new StaticTest().getCount());
		
	}
}
