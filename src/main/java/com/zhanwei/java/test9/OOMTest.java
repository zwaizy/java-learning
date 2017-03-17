package com.zhanwei.java.test9;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {
	
	private static int[] generate1M(){
		return new int[1024*256];
	}
	
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		for(int i=0;i<100;i++){
			if(i==0){
				try {
					Thread.sleep(20*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				try {
					Thread.sleep(4*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(generate1M());
		}
	}

}
