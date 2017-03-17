package com.zhanwei.java.proxy;

public interface User {

	void save();
	
	User getById(int id);
	
	void deleteById(int id);
	
}
