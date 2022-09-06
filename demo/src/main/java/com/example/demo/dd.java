package com.example.demo;

public class dd {

    public static void main(String[] args) {
        int a = 200;
        Integer b = 200;
        Integer c = new Integer(200);
        Integer d = new Integer(200);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(c == d);
    }
}
