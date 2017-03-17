package com.zhanwei.java.test2;

public class SequenceA implements Sequence{
	
	private int number = 0;
	
	public int getNumber() {
		return number++;
	}
	
}
