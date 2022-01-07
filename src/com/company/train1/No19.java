package com.company.train1;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 10:44
 **/
public class No19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int count=1;
            ListNode index =head, temp=head;
            while(index.next != null){
                count++;
                index = index.next;
            }
            if(count==n){
                return head.next;
            }
            for(int i=0; i<(count-n)-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }
    }
}
