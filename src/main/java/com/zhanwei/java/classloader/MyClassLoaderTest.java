package com.zhanwei.java.classloader;

public class MyClassLoaderTest {
	
	public static void main(String[] args) {
		
		MyClassLoader loader = new MyClassLoader();
		try {
			App app2 = new App();
			Class<?> clazz = loader.loadClass("com.zhanwei.java.classloader.App");
			Object app1 = clazz.newInstance();
			System.out.println(app1);
			System.out.println(app2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
