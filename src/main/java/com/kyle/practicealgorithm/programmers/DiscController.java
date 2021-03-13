package com.kyle.practicealgorithm.programmers;

import java.util.*;


public class DiscController {
    /*디스크 컨트롤러

        프로그래머스의 힙 관련 알고리즘 문제이며
        전공하며 배운 작업 스케쥴링 알고리즘중 최소 작업 시간 스케쥴링인 SJF에 해당한다.
        접근 방법은 실행이후 대기중인 작업들 중 가장 작업시간이 짧은 것 부터 진행하는 것이다
        그럼 전 작업 리스트를 한번에 다 넣고 요청시간을 기준으로 오름차순한다.
        이후 현재시간 이전의 작업 들 중 작업시간이 가장 짧은 작업을 실행한다.
    */
    static class Job {
        private int requestTime;
        private int workingTime;

        public Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }


    public static int solution(int[][] jobs) {
        LinkedList<Job> listJob = new LinkedList<>();

        //요청시간 오름차순 정렬

        //queue에 담기위해 객체화 한다. int[][]로 만든 다음 솔팅이 가능하다면 이 작업이 필요없겠지만 시도해봤으나 먼 길을 가는 것 같아 객체화 하였다.
        for (int[] job : jobs) {
            listJob.add(new Job(job[0], job[1]));
        }

        PriorityQueue<Job> queue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.workingTime - o2.workingTime;
            }
        });

        int answer = 0;
        int count = 0;
        int time = listJob.peek().requestTime;

        while (count < jobs.length) {
            while (!listJob.isEmpty() && listJob.peek().requestTime <= time) {
                queue.offer(listJob.poll());
            }
            if (!queue.isEmpty()) {
                Job job = queue.poll();
                time += job.workingTime;
                answer += time - job.requestTime;
                count++;
            } else {
                time++;
            }
        }

        return answer / count;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int answer = solution(jobs);
        System.out.println(answer == 9);

    }
}
