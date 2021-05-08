package com.kyle.practicealgorithm.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//다음 반복되는 문자가 나올때까지 부분문자의 최대길이를 구하는 문제다.
//중복확인을 위해 해당 문자를 set에 추가하여 해당 문자의 중복 여부를 판단한다
//set에 add할때 결과값으로 해당 값이 중복 여부를 boolean타입으로 확인할 수 있는 점을 활용하면 굳이 contains을 사용할 필요가 없다
//이중포문이 아닌 방법으로도 풀이가 가능하다. <- set 을 초기화하는 것이 아닌 중복이 없는 부분까지 삭제를 하는 부분으로
public class LongestSubstringWithoutRepeatingCharaters {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!characterSet.add(c)) {
                    maxLength = maxLength < j - i ? j - i : maxLength;
                    characterSet = new HashSet<>();
                    break;
                }
                maxLength = maxLength < j - i + 1? j - i + 1: maxLength;
            }
        }

        return maxLength;
    }


    //lengthOfLongestSubstring : runtime 61ms, memory 39.4mb
    //better solution : runtime 5ms, memory 39 mb

    //better solution
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }


    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));
        String s2 = "bbbb";
        System.out.println(lengthOfLongestSubstring(s2));
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
        String s4 = "";
        System.out.println(lengthOfLongestSubstring(s4));
        String s5 = "a";
        System.out.println(lengthOfLongestSubstring(s5));

        String s6 = "au";
        System.out.println(lengthOfLongestSubstring(s6));

    }
}
