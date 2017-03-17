package com.zhanwei.java.test3;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor{

	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls){
		return (T)Enhancer.create(cls, this);
	}	
	
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(arg0, arg2);
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
