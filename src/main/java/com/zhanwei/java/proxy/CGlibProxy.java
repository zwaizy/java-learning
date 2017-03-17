package com.zhanwei.java.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxy implements MethodInterceptor{
	
	private static CGlibProxy instance = new CGlibProxy();

    private CGlibProxy() {
    }

    public static CGlibProxy getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }


	public Object intercept(Object target, Method arg1, Object[] args, MethodProxy proxy) throws Throwable {
		before();
        Object result = proxy.invokeSuper(target, args);
        after();
        return result;
	}
	
	private void before(){
		System.out.println("before...");
	}
	
	private void after(){
		System.out.println("after...");
	}

	public static void main(String[] args) {
		CGlibProxy.getInstance().getProxy(new UserImpl().getClass()).deleteById(1);
	}
}
