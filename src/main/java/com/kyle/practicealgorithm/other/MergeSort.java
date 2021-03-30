package com.kyle.practicealgorithm.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeSort {

    public static List<Integer> mergeSort(List<Integer> values) {
        if (values.size() < 2){
            return values;
        }
        List<Integer> lefgHalf = values.subList(0, values.size()/2);
        List<Integer> rightHalf = values.subList(values.size()/2, values.size());

        return merge(mergeSort(lefgHalf), mergeSort(rightHalf));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;

        List<Integer> merged = new ArrayList<>(left.size() + right.size()); //사이즈를 미리 정하는게 큰 차이가 있나??

        while (leftPtr < left.size() && rightPtr < right.size()){
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            }else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }


        while (leftPtr < left.size()){
            merged.add(left.get(leftPtr));
            leftPtr++;
        }

        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }

        return merged;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add((int) (Math.random()*100000)+1);
        }
        System.out.println(numbers);


        System.out.println(mergeSort(numbers));

//        Collections.sort(numbers);
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(numbers);
    }
}
