package com.zhanwei.java.javase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${DESCRIPTION}
 *
 * @author zhanwei
 * @create 2018-02-05 16:04
 **/
public class HashSetTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        System.out.println(map.put("1", "11"));
        System.out.println(map.put("1", "22"));
        System.out.println(map.get("1"));
//        System.out.println(map.putIfAbsent("1", "11"));
//        System.out.println(map.putIfAbsent("1", "22"));
//        System.out.println(map.get("1"));

//        HashSet<Integer> set = new HashSet<Integer>();
//        set.add(1);
//        set.add(1);
//        set.add(1);
//        System.out.println(set.size());
//        HashMap<String,String> map = new HashMap<String, String>();
//        map.put("1","a");
//        map.put("1","b");
//        System.out.println(map);
//        map.put("1","c");
    }
}
