package com.kyle.practicealgorithm.remoteinterview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ReverseSentences {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        List<String> sentences = new LinkedList<>();

        for(int i = 0; i < n; i++){
            sentences.add(br.readLine());
        }

        for(String sentence : sentences ) {
            String[] arryedSentence = sentence.split(" ");
            StringBuffer reversedSentence = new StringBuffer();
            int lastIndex = arryedSentence.length-1;
            reversedSentence.append(arryedSentence[lastIndex]);
            for(int i = lastIndex-1; i >= 0; i--) {
                reversedSentence.append(" ").append(arryedSentence[i]);
            }
            String a = new String(reversedSentence);
            System.out.println(reversedSentence);
        }
    }
}
