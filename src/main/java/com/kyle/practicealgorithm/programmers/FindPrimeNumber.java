package com.kyle.practicealgorithm.programmers;


import java.util.*;

//소수 찾기
//주어진 수를 순서와 상관없이 조합해야함으로 순열 알고리즘으로 경우의 수를 구해야함
//소수인지 판별은 기존 소수 찾는 알고리즘을 참조했다(제곱근을 구한 후 해당 수까지 나눠보고 나누어떨어지지 않으면 true)
public class FindPrimeNumber {
    private static Set<String> permutationNumbers = new HashSet<>();
    private static List<Integer> primeNumbers = new ArrayList<>();
    private static int primeCount;

    public static int solution(String numbers) {
        int size = numbers.length();
        int answer = 0;

        List<Character> charaterNumbers = toCharacterList(numbers);

        List<Character> result = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            permutation(charaterNumbers, result, size, i);
        }

        return primeCount;
    }


    private static void permutation(List<Character> charaterNumbers, List<Character> result, int n, int r) {
        if (r == 0) {
            if (result.get(0) != '0') {
                StringBuffer stringBuffer = new StringBuffer();
                int size = result.size();
                for (int i = 0; i < size; i++) {
                    stringBuffer.append(result.get(i));
                }

                String permutationNumber = stringBuffer.toString();

                if (!permutationNumbers.contains(permutationNumber)) {
                    int num = Integer.parseInt(permutationNumber);
                    permutationNumbers.add(permutationNumber);

                    if (isPrime(num)) {
                        primeNumbers.add(num);
                        primeCount++;
                    }
                }
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            result.add(charaterNumbers.remove(i));
            permutation(charaterNumbers, result, n - 1, r - 1);
            charaterNumbers.add(i, result.remove(result.size() - 1));
        }
    }

    private static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }

        int sqrt = (int) Math.sqrt(num);

        if (num % 2 == 0 || num == 1) {
            return false;
        }

        for (int i = 3; i < sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Character> toCharacterList(String numbers) {
        List<Character> charaterNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            charaterNumbers.add(numbers.charAt(i));
        }

        return charaterNumbers;
    }

    public static void main(String[] args) {
        System.out.println(solution("17") == 3);
        System.out.println(solution("011") == 2);
    }


    //순열 알고리즘
    //1. Swap 함수를 이용해 구현 - 순서 없이 n 개중에서 r 개를 뽑는 경우
    static void per1(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            per1(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) { //두 배열의 값을 바꾸는 Swap 함수
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    //2. DFS를 이용해 구현  - 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    static void per2(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r); //순열 출력을 위한 print 함수
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                per2(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}
