package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author cz
 * @Description 两个链表的第一个节点
 * @date 2022/3/29 9:43
 **/
public class BM10 {
    public static class Solution {
        /**
         * HashMap 存储遍历过的每个节点
         * @param pHead1
         * @param pHead2
         * @return
         */
        public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            HashMap<ListNode, Integer> map = new HashMap<>();
            while(pHead1!=null){
                map.put(pHead1,1);
                pHead1=pHead1.next;
            }
            while(pHead2!=null){
                if(map.get(pHead2)!=null)
                    return pHead2;
                pHead2=pHead2.next;
            }
            return null;
        }

        /**
         *  遍历 pHead1 pHead2 的长度 从剩下的共同长度开始比较
         * @param pHead1
         * @param pHead2
         * @return
         */
        public static ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
            ListNode p1=pHead1, p2=pHead2;
            int len1=0, len2=0;
            while(p1!=null){
                len1++;
                p1=p1.next;
            }
            while(p2!=null){
                len2++;
                p2=p2.next;
            }
            if(len1>len2){
                while(len1>len2){
                    pHead1=pHead1.next;
                    len1--;
                }
            }else{
                while(len2>len1){
                    pHead2=pHead2.next;
                    len2--;
                }
            }
            while(pHead1!=null){
                if(pHead1==pHead2)
                    return pHead1;
                pHead1=pHead1.next;
                pHead2=pHead2.next;
            }
            return null;
        }
    }

    @Test
    public void test(){
        ListNode l5=new ListNode(5);
        ListNode l4=new ListNode(4);
        ListNode l3=new ListNode(3);
        ListNode l2=new ListNode(2);
        ListNode l1=new ListNode(1);
        l1.next=null; l2.next=l3; l3.next=l4; l4.next=l5; l5.next=null;
        Solution.FindFirstCommonNode(l1, l2);
    }
}
