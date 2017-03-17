package com.zhanwei.java.test8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.image.codec.jpeg.ImageFormatException;

public class TestScaleImageUtils {
	
	
	public static void main(String[] args) {
		try {
			OutputStream out = new FileOutputStream(new File("D:\\test1.jpg"));
			InputStream in = new FileInputStream(new File("D:\\2.JPG"));
			InputStream in2 = ScaleImageUtils.resize(0.5f,".JPG", in);
			byte[] byt = new byte[1024];
			int length = 0;
			while((length = in2.read(byt)) != -1){
				out.write(byt, 0, length);
			}
			in2.close();
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
