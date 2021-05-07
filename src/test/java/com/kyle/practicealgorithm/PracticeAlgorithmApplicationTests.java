package com.kyle.practicealgorithm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PracticeAlgorithmApplicationTests {

    @Test
    void contextLoads() {
        int[] a = new int[3];
        a[3] = 4;
        System.out.println(a[3]);
    }

    @Test
    void arraySortTest(){
        int[] ints = new int[]{1,4,9,6,2};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    void containsTest(){
        String a = "abcde";
        List<Character> l = new ArrayList<>();
        l.add('a');
        l.add('b');
        l.add('c');
        l.add('d');
        l.add('e');
        String b = "apple";
        for (int i = 0; i < b.length(); i++) {
            System.out.println(l.contains(b.charAt(i)));
        }
    }

    @Test
    void longCompare(){
        Long a = 1l;
        Long b = 23l;
        System.out.println(a >= b);

    }

    @Test
    void convertToListTest(){
        int[] nums = new int[]{2, 7, 11, 15};
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    @Test
    void divisionTest(){
        int a = 12;
        int b = 3;

        System.out.println(a/10);
        System.out.println(b/10);
    }

}
