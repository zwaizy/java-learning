package com.zhanwei.java.singleTon;

/**
 * ${DESCRIPTION}
 *
 * @author zhanwei
 * @create 2018-03-05 15:36
 **/
public class SingleTon {

    private SingleTon (){}

    public static SingleTon getInstance(){
        return SingleTonHolder.singleTon;
    }

    private static class SingleTonHolder{
        private static SingleTon singleTon = new SingleTon();
    }
}
