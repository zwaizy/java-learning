package com.zhanwei.java.test5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	public static void main(String[] args) {
		try {
			// 获取maven工程的resource的路径，这个获得的是绝对路径
			String path = FileChannelTest.class.getResource("/").getPath();
			// 文件存放在resource目录下
			String file = "1.txt";
			RandomAccessFile randomAccessFile = new RandomAccessFile(path + file, "rw");
			// 创建channel
			FileChannel fileChannel = randomAccessFile.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(5000);
			// 从channel中读取数据到buffer
			int byteRead = fileChannel.read(byteBuffer);
			while (byteRead != -1) {
				byteBuffer.flip();
				while (byteBuffer.hasRemaining()) {
					System.out.println((char) byteBuffer.get());
				}
				byteBuffer.clear();
				byteRead = fileChannel.read(byteBuffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
