package com.zhanwei.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler{

	private Object target;
	
	public JDKProxy(Object target) {
		this.target = target;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("save")){
			before();
		}
		method.invoke(target, args);
		if(method.getName().equals("save")){
			after();
		}
		return null;
	}
	
	private void before(){
		System.out.println("before...");
	}
	
	private void after(){
		System.out.println("after...");
	}
	
	public static void main(String[] args) {
		User userProxy = new JDKProxy(new UserImpl()).getProxy();
		userProxy.deleteById(1);
	}

}
