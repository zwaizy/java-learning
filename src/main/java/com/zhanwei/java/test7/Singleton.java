package com.zhanwei.java.test7;

public class Singleton {
	
	private Singleton (){}  
	
	private static class SingleHolder{
		private static Singleton single = new Singleton();
	}
	
	public static Singleton getInstance(){
		return SingleHolder.single;
	}

}
