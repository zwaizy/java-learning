package com.zhanwei.java.javase;

/**
 * ${DESCRIPTION}
 *
 * @author zhanwei
 * @create 2018-03-05 15:44
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,6,7,88,99,100};
        System.out.println(binarySearch(arr,7));
    }

    private static int binarySearch(int[] arr,int des) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high)/2;
            if (des == arr[middle]){
                return middle;
            }else if(des > arr[middle]){
                low = middle + 1;
            }else{
                high = middle -1;
            }
        }
        return -1;
    }
}
