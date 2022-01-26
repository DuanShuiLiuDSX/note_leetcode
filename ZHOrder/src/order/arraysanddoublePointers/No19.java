package order.arraysanddoublePointers;


import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 双指针解法 删除链表倒数第N个节点
 *  双指针思路  first指针先走n步， 走完之后 first、second一起走
 *             first走到终点时候， second正好处于倒数第n个
 * @date 2022/1/7 13:56
 **/
public class No19 {

//      Definition for singly-linked list.
public class ListNode {
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

    /**
     * temp 的定义 用来解决 删除的是头节点的情况  eg [1, 2, 3] ,n==3
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode temp = new ListNode(-1, head);
            ListNode pre = head, after = temp;
            if (head.next==null)
                return null;

            for (int i = 0; i < n-1; i++) {
                pre = pre.next;
            }

            while (pre != null) {
                pre = pre.next;
                after = after.next;
            }
            after.next = after.next.next;

            return temp.next;
        }
    }


}
