package com.kyle.practicealgorithm.leetcode;

public class LongestPalindromicSubstring
{
    //회문 문제
    //앞으로 읽으나 뒤로 읽으나 같은 글자 중 가장 긴 문자를 찾는 문제
    //접근방법
    //점진적으로 증가하면서 i번째 문자와 같은 문자를 찾아 증가, 감소하며 비교
    // 케이스는 모두 통과했으나
    // 시간이 너무 걸림 아무래도 index of의 영향이 큰가봄

    //accepted line 23~24의 early return을 통해 해결하였다.

    //Runtime: 240 ms, faster than 25.95% of Java online submissions for Longest Palindromic Substring.
    //Memory Usage: 38.7 MB, less than 94.22% of Java online submissions for Longest Palindromic Substring.
   public static String longestPalindromicSubstring(String s) {
       if (s == null || s.length() <= 1) {
           return s;
       }
       String answer = "";
       for (int i = 0; i < s.length(); i++) {
           char targetChar = s.charAt(i);
           int beforeIndex = s.length();
           while (beforeIndex > -1) {
               int nextIndex = s.lastIndexOf(targetChar, beforeIndex);
               if (nextIndex <= i || answer.length() >= nextIndex - i +1) {
                   break;
               }
               String tempPalindromicSubstring = getPalindromicSubstring(s,i, nextIndex);
               answer = tempPalindromicSubstring.length() > answer.length() ? tempPalindromicSubstring : answer;
               beforeIndex = nextIndex -1;
           }
       }
       if (answer =="") {
           return String.valueOf(s.charAt(0));
       }
        return answer;
   }

    private static String getPalindromicSubstring(String s, int from, int end) {
       if (end == -1) {
           return "";
       }
       int f = from;
       int e = end;
       int middle = (from+end)/2;
       while (f <= middle && e >= middle && s.charAt(f) == s.charAt(e)) {
           f++;
           e--;
       }
       if (f == middle+1 || e == middle-1) {
           return s.substring(from, end+1);
       }
       return "";
    }

    //other case
    //나의 접근법은 양 끝을 기준으로 점차적으로 줄이며 비교를 하였는데
    //비슷하지만 효율적으로 중앙값을 기준으로 점차적으로 같은크기까지 확장하는 방법이 있었다.

    //Runtime: 24 ms, faster than 77.74% of Java online submissions for Longest Palindromic Substring.
    //Memory Usage: 38.8 MB, less than 89.56% of Java online submissions for Longest Palindromic Substring.

    //메모리 사용에선 효율적이었으나 속도에서 아주 차이가 나는것을 확인할 수 있었다.
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        String example1 = "babad";
        System.out.println("bab".equals(longestPalindromicSubstring(example1)));
        String example2 = "cbbd";
        System.out.println("bb".equals(longestPalindromicSubstring(example2)));
        String example3 = "a";
        System.out.println("a".equals(longestPalindromicSubstring(example3)));
        String example4 = "ac";
        System.out.println("a".equals(longestPalindromicSubstring(example4)));


        System.out.println(longestPalindrome(example1));
        System.out.println("bab".equals(longestPalindrome(example1)) || "aba".equals(longestPalindrome(example1)));
        System.out.println(longestPalindrome(example2));
        System.out.println("bb".equals(longestPalindrome(example2)));
        System.out.println(longestPalindrome(example3));
        System.out.println("a".equals(longestPalindrome(example3)));
        System.out.println(longestPalindrome(example4));
        System.out.println("a".equals(longestPalindrome(example4)) || "c".equals(longestPalindrome(example4)));
    }

}
