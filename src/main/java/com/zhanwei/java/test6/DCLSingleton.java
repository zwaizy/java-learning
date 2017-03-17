package com.zhanwei.java.test6;

public class DCLSingleton {

	private static volatile DCLSingleton instance;
	private boolean flag;
	private final int value;

	private DCLSingleton() {
		flag = true;
		value = 10;
	}

	public static DCLSingleton getInstance() {
		if (instance == null) {
			synchronized (DCLSingleton.class) {
				if (instance == null) {
					instance = new DCLSingleton();
				}
			}
		}
		return instance;
	}

}
