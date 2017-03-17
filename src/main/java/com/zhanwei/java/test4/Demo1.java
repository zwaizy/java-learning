package com.zhanwei.java.test4;

public class Demo1 {

	public boolean test1(){

		try {
			for(int i=10;i>=0;i--){
				System.out.println("result =" + 100/i);
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}
	
}
