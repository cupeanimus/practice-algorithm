package com.kyle.practicealgorithm.codility;

public class FlogJump {

    public int solution(int X, int Y, int D) {
        int quotient = (Y - X) / D;
        boolean isRemain = (Y - X) % D > 0;

        return isRemain ? quotient : quotient+1;

    }

    public static void main(String[] args) {

    }
}
