package com.zhanwei.java.classloader;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		
		String className = name.substring(name.lastIndexOf(".")+1)+".class";
		
		InputStream in = getClass().getResourceAsStream(className);
		if(in == null){
			super.loadClass(name);
		}
		
		try {
			byte[] bye = new byte[in.available()];
			in.read(bye);
			
			defineClass(name, bye, 0, bye.length);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return super.loadClass(name);
	}
	
}

