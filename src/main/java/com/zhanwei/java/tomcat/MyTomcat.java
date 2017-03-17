package com.zhanwei.java.tomcat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcat {
	
	private int port = 8090;
	
	private int count = 0;
	
	public MyTomcat(){}
	
	public void start(){
		ServerSocket ss = null;
		Socket s = null;
		OutputStream out = null;
		
		try {
			ss = new ServerSocket(port);
			System.out.println("tomcat 已经启动，监听端口："+this.port);
			while(true){
				try {
					s = ss.accept();
					out = s.getOutputStream();
					out.write("hello tomcat111".getBytes());
					out.write(count++);
					out.flush();
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					try {
						out.close();
						s.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			
		} 
	}

	public MyTomcat(int port) {
		super();
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	public static void main(String[] args) {
		
		MyTomcat tomcat = new MyTomcat();
		tomcat.start();
		
	}
	

}
