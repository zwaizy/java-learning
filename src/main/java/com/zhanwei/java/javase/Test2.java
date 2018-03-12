package com.zhanwei.java.javase;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

/**
 * ${DESCRIPTION}
 *
 * @author zhanwei
 * @create 2018-03-12 13:35
 **/
public class Test2 extends Thread{
    public static void main(String[] args) {

        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        ThreadTest t3 = new ThreadTest("C");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
    }
}


class ThreadTest extends Thread {
    private String name;

    ThreadTest(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("thread:"+name);
    }
}