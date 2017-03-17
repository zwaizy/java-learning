package com.zhanwei.java.test3;

public class DynamicProxyTest {
	
	public static void main(String[] args) {
		DynamicProxy proxy = new DynamicProxy(new UserImpl());
		User user = proxy.getProxy();
		user.say();
		user.said();
	}

}
