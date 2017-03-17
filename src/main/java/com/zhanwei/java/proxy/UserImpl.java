package com.zhanwei.java.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserImpl implements User{

	public void save() {
		System.out.println("save user...");
	}

	public User getById(int id) {
		System.out.println("getById...");
		return null;
	}

	public void deleteById(int id) {
		System.out.println("deleteById...");
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		System.out.println(sdf.format(new Date()));
		
	}
}
