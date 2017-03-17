package com.zhanwei.java.test3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{

	private Object target;
	
	public DynamicProxy(Object obj) {
		this.target = obj;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}
	
	private void before(){
		System.out.println("before...");
	}

	private void after(){
		System.out.println("after...");
	}
}
