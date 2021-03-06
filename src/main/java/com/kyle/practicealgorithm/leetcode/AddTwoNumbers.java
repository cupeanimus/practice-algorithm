package com.kyle.practicealgorithm.leetcode;

public class AddTwoNumbers {


    public static class ListNode {
        private int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

/*    shallow copy를 통해 노드가 완성되는 이유와 두 노드를 사용해야하는 이유는
    처음 기록될 노드에 주소를 복사하고
    다음 노드 값 등록후 노드 주소를 초기화하기 때문에 기준 노드는 그대로 유지되면서
    복사한 다음 노드들이 계속 추가되는 것이다.*/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode answer = node;

        int plus = 0;
        while (l1 != null && l2 != null) {
            int sumVal = plus;

            if (l1 != null) {
                sumVal += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sumVal += l2.val;
                l2 = l2.next;
            }

            plus = (sumVal) / 10;
            sumVal %= 10;

            node.next = new ListNode(sumVal);
            node = node.next;
        }

        if(plus > 0) {
            node.next = new ListNode(plus);
        }

        return answer.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        ListNode l1 = node;

        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;

        node = new ListNode();
        ListNode l2 = node;

        node.next = new ListNode(5);
        node = node.next;
        node.next = new ListNode(6);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;

        ListNode answer = addTwoNumbers(l1.next, l2.next);
        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }

    }


}
