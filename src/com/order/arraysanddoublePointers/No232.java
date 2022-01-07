package com.order.arraysanddoublePointers;

import java.util.ArrayList;

/**
 * @author cz
 * @Description 回文链表
 * @date 2022/1/6 19:16
 **/
public class No232 {

//      Definition for singly-linked list.
public static class ListNode {
    int val;
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

    class Solution {
        public boolean isPalindrome(ListNode head) {
            boolean flag=true;
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (head != null){
                arrayList.add(head.val);
                head = head.next;
            }
            for (int i=0; i<(arrayList.size()/2); i++){
                if (arrayList.get(i)!= arrayList.get(arrayList.size()-i-1)){
                    flag =false;
                }
            }
            return flag;
        }
    }

    //最优解 快慢指针
    static class Solution1 {
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null){
                return true;
            }
            ListNode slow = head, fast = head;
            ListNode p1 = null, p2 = null;
            //p1、 p2的作用是 将前半部分的链表反转  while执行完 slow指到右半部分链表的第一个 [0,1,2,3, 4, 3,2,1,0] slow到4的位置
            while (fast != null && fast.next != null) {
                p1 = slow;
                slow = slow.next;
                fast = fast.next.next;
                p1.next = p2;
                p2 = p1;
            }
            //链表奇数个的情况，将slow后移动一位
            if (fast != null) {
                slow = slow.next;
            }
            while (p1 != null && slow != null) {
                if (p1.val != slow.val) {
                    return false;
                }
                p1 = p1.next;
                slow = slow.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode0 = new ListNode(0, listNode1);
        Solution1 solution1 = new Solution1();
        solution1.isPalindrome(listNode0);
    }
}
