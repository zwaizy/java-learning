package com.zhanwei.java.test1;

public class Clazz {

	public static void main(String[] args) throws Exception {
		Class<Cat> c = Cat.class;
		Class<Dog> g = (Class<Dog>) Class.forName("com.zhanwei.java.test1.Dog");
   	}
}

class Cat {
	static{
		System.out.println("cat is load");
	}
}

class Dog{
	static {
		System.out.println("dog is load");
	}
}
