package com.zhanwei.java.javase;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author zhanwei
 * @create 2018-03-12 17:04
 **/
public class test {


    public static void main(String[] args) {
        Integer a = 1,b = 2;

        swap(a,b);
        System.out.println(a + ",,," + b);

    }

    private static void swap(Integer a, Integer b) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(a);
        stack.add(b);
        a = stack.pop();
        b = stack.pop();
//        System.out.println(a + ",," + b);
    }

    private static void swap2(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
//        System.out.println(a + ",," + b);
    }

    public static void change(Integer a, Integer b) {

//        System.out.println("交换后：a="+b+",b="+a);
//        System.exit(0);
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true); //取消访问修饰符
            //public final class Field extends AccessibleObject implements Member
            //值为 true 则指示反射的对象在使用时应该取消 Java语言访问检查。
            //值为 false 则指示反射的对象应该实施 Java语言访问检查。
            //修改常量（final）
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            //交换
            int temp = b;
            field.set(b, a);
            field.set(a, new Integer(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
