package com.example.test;


import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: Test
 * @Description: 测试相关
 * @Author: CZJ
 * @Date: 2022/3/8
 */
public class Test {

    public static void main(String[] args) {
        String str = "883hh334h4221bnd33";
        Pattern p = Pattern.compile("[1-9]{3}");
        Matcher m = p.matcher(str);
        while(m.find()) {
            System.out.println(m.group(0));
        }
    }

}

class Animal<T> {

}

class Cat<T> extends Animal<T> implements Serializable {

}

class Apple implements Serializable {

}

class Other<T extends Animal, Serializable> {

}


