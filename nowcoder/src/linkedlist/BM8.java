package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author cz
 * @Description 链表中倒数第N个节点
 * @date 2022/3/29 9:03
 **/
public class BM8 {
    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param pHead ListNode类
         * @param k int整型
         * @return ListNode类
         */
        public static ListNode FindKthToTail (ListNode pHead, int k) {
            // write code here
            HashMap<Integer, ListNode> map= new HashMap<>();
            int count=1;
            while(pHead!=null){
                map.put(count, pHead);
                count++;
                pHead=pHead.next;
            }
            return map.get(count-k);
        }

        public static ListNode FindKthToTail1 (ListNode pHead, int k) {
            // write code here
            if(pHead==null) return null;
            ListNode fast=pHead, slow=pHead;
            int count=0;
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                count++;
            }
            int length=1;
            if(pHead.next==null){
                length=1;
            }else if(fast==null){
                length=count*2;
            }else{
                length=count*2+1;
            }
            while(length>k){
                pHead=pHead.next;
                length--;
            }
            return length==k? pHead : null;
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
        Solution.FindKthToTail1(l1,2);
    }
}
