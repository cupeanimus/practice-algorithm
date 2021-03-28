package com.kyle.practicealgorithm.programmers;



//다른 코드를 조금 참조했다.
//dfs혹은 bfs 문제라서 노드를 만들거나 스택 혹은 큐를 만들어서 풀어야 하나 생각했는데
//단순 비교로 체크하는식으로 풀이한 소스가 많았다.
//개수가 많지 않기 때문에 전체를 계속 검색했기 때문이다.
//스택이나 큐를 이용하여 다시 풀어봐야겠다.
public class WordConversion {
    static int count = 51;

    public static int solution(String begin, String target, String[] words) {

        dfs(new boolean[words.length], 0, begin, target, words);

        return count==51?0:count;
    }

    public static void dfs(boolean[] visited,int cnt,String begin,String target,String[] words){

        if(begin.equals(target)){
            if(count>cnt)
                count=cnt;
            return;
        }

        for(int i=0;i<words.length;i++){
            if(!visited[i] && check(begin,words[i])){
                visited[i]=true;
                dfs(visited,cnt+1,words[i],target,words);
                visited[i]=false;
            }
        }

    }
    public static boolean check(String presentWord, String nextWord) {
        int count = 0;
        for(int i = 0; i < presentWord.length(); i++) {
            if(presentWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }



    public static void main(String[] args) {
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        solution("hit","cog",words);

    }
}
