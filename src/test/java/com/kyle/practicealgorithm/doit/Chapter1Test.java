package com.kyle.practicealgorithm.doit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Chapter1Test {


    @Test
    void q7Test(){
        int result = q7(7);
        assertEquals(result,28);
    }

    @Test
    void q8Test(){
        int result = q8(10);
        assertEquals(result,55);
    }

    int q7(int n){
        int total = 0;
        while (n > 0){
            total += n;
            n--;
        }
        return total;
    }

    int q8(int n){
        int multiple = n/2;

        return (1+n)*n/2;

    }

}