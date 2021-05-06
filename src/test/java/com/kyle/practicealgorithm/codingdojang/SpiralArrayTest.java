package com.kyle.practicealgorithm.codingdojang;

import org.junit.jupiter.api.Test;

class SpiralArrayTest {

    @Test
    void sprialArrayTest(){
        SpiralArray.spiralArraySample(6,5);
    }

    @Test
    void stringTest(){
        String a = "hello";
        String b = "hello";
        String c = new String("hello");

        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c));

        Integer i = 1;
        int o = 1;
        Long l = 1l;
        long k = 1l;
        System.out.println(i == o);
        System.out.println(i.equals(o));
        System.out.println(l == k);
        System.out.println(i.equals(l));
        System.out.println(i == k);
        System.out.println(o == k);
        System.out.println(o == l);

        System.out.println();

        //call by value
        int x = 10;
        int y = x;
        System.out.println(x);
        System.out.println(y);
        x += 10;
        System.out.println(x);
        System.out.println(y);

        y += 10;
        System.out.println(x);
        System.out.println(y);





    }

}