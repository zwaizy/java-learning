package com.zhanwei.java.bigdatacaculate;

/**
 * ${DESCRIPTION}
 *
 * @author zhanwei
 * @create 2018-01-23 15:30
 **/
public class test {

    public static void main(String[] args) {
        int n = 5;
        int[] ints = new int[10];
        ints[ints.length-1] = 1;
        for(int i=1;i<=n;i++){
            ints = calculate(ints,i);
        }

        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

    static int[] calculate(int[] ints,int num){
        for (int i=0;i<ints.length;i++){
            ints[i]*=num;
        }

        for (int i=ints.length-1;i>0;i--) {
            ints[i - 1] += ints[i] / 10;
            ints[i] = ints[i] % 10;
        }

        return ints;
    }

}
