package com.less.util;


public class CodeCl {
    void test(Integer i) {
        i = 2;
    }

    public static void main(String[] args) {
        Integer i = 1;
        new CodeCl().test(i);
        System.out.println(i);
    }

}

