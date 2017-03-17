package com.zhanwei.java.javase;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOTest {
	
	public static void main(String[] args) {
		
		InputStream in = null;
		
		try {
			in = new BufferedInputStream(new FileInputStream("test.txt"));
			
			byte[] bye = new byte[1024];
			int len = 0;
			while((len = in.read(bye)) != -1){
				for(int i=0;i<len;i++)
                    System.out.print((char)bye[i]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
		
	}

}
