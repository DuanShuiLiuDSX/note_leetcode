package com.order.arraysanddoublePointers;

/**
 * @author cz
 * @Description 环形链表2
 * @date 2022/1/7 9:43
 **/
public class No142 {

//    Definition for singly-linked list.

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            //先判断是否有环
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            // 得到环中的相遇点
            ListNode temp = fast;
            // 记录环的节点  再减去1
            int count = 0;
            while (fast.next != temp) {
                fast = fast.next;
                count++;
            }
            // 将fast 回到头结点 让fast先走 环节点-1 的数量的节点 即count
            fast = head;
            while (count > 0) {
                fast = fast.next;
                count--;
            }
            //整体思路 寻找倒数第n个节点 n的值==环的节点的数量 让 fast 与 slow 相差 count个节点 即 slow为所求的节点
            // 将slow也指向 头节点  当fast走完一遍（这里一遍指的是 从第一个节点到最后一个节点）
            // slow因为落后count个节点 当fast走到最后一个  slow刚好走到入口节点（同时也是循环节点的第一个节点）
            slow = head;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

        }
    }
}
