package com.zhanwei.java.javase;

import java.util.ArrayList;
import java.util.List;

public class StringTest {
	
	public static void main(String[] args) {
		String s1 = "ab" + "cd";
		String s2 =  "abcd";
		System.out.println(s1 == s2 + s1.equals(s2));
		
		List<String> list = new ArrayList<String>(){@Override
		public boolean add(String e) {
			// TODO Auto-generated method stub
			return super.add("111");
		}};
		List<String> list2 = new ArrayList<String>(){{add("2322");}};
	}

}
