package com.company.train1;

/**
 * @author cz
 * @Description  最优解法 快慢指针
 * @date 2021/12/15 9:54
 **/
public class No876 {


     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    static class Solution {
        public ListNode middleNode(ListNode head) {
            int count=1;
            ListNode index = new ListNode();
            index = head;
            while (index.next!=null){
                count++;
                index = index.next;
            }
            for(int i=0; i<=(count/2); i++){
                index = head.next;
                head = head.next;
            }
            return index;
        }
    }

    /**
     * 快慢指针解法
     */
    static class Solution2 {
        public ListNode middleNode(ListNode head) {
            ListNode fast=head, slow =head;
            //  注意判断条件的写法
            while (fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        Solution solution =  new Solution();
        solution.middleNode(listNode1);
    }
}
