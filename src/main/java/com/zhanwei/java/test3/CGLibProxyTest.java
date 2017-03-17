package com.zhanwei.java.test3;

public class CGLibProxyTest {

	public static void main(String[] args) {
		CGLibProxy proxy = new CGLibProxy();
		UserImpl impl = (UserImpl) proxy.getProxy(UserImpl.class);
		impl.said();
		impl.say();
	}
}
