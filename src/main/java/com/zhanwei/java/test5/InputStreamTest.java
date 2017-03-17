package com.zhanwei.java.test5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class InputStreamTest {
	
	public static void main(String[] args) {
//		fileInputStreamTest();
		
		
		fileReadTest();
	}

	private static void fileReadTest() {
		Reader r = null;
		try {
			r = new FileReader(new File("src/main/resources/1.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int length = 0;
		char[] chr = new char[1024];
		try {
			while((length = r.read(chr)) != -1){
				System.out.println(new String(chr,0,length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		
	}

	private static void fileInputStreamTest(){
		InputStream in = null;
		try {
			in = new FileInputStream(new File("src/main/resources/1.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定的文件!");
			System.exit(1);
		}
		
		int length = 0;
		int num = 0;
		try {
			while((length = in.read())!= -1){
				System.out.println("read:"+length);
				num ++;
			}
			System.out.println();
			System.out.println("num:"+num);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
