package linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 链表内指定区间反转
 * @date 2022/3/23 9:49
 **/
public  class BM2 {
    public static class Solution {
        /**
         *
         * @param head ListNode类
         * @param m int整型
         * @param n int整型
         * @return ListNode类
         */
        public static ListNode reverseBetween (ListNode head, int m, int n) {
            // write code here
            if(m==n)
                return head;
            int index=m-1;
            ListNode first = head;
            ListNode index1 = head;
            while(index>0){
                if(index==1){
                    index1=first;
                }
                first=first.next;
                index--;
            }

            ListNode pre=first;
            ListNode index2=first;
            ListNode cur=first.next;
            ListNode next=cur.next;
            int cout = n-m;
            while(cout>1){
                cur.next=pre;
                pre=cur;
                cur=next;
                next=cur.next;
                cout--;
            }
            cur.next=pre;
            if(index2==index1){
                index1.next=next;
                return cur;
            }else{
                index1.next=cur;
                index2.next=next;
                return head;
            }

        }
    }

    @Test
    public void test(){
        ListNode l5=new ListNode(5);
        ListNode l4=new ListNode(4);
        ListNode l3=new ListNode(3);
        ListNode l2=new ListNode(2);
        ListNode l1=new ListNode(1);
        l1.next=l2; l2.next=l3; l3.next=l4; l4.next=l5; l5.next=null;
        BM2.Solution.reverseBetween(l1, 2,4);
    }
}
