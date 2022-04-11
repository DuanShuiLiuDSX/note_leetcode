package order.linkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author cz
 * @Description 合并K个升序链表
 * @date 2022/3/25 12:19
 **/
public class No23 {
    static class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0) return null;
            int nullNumber=0;
            for (int i =0; i<lists.length; i++){
                if (lists[i]==null)
                    nullNumber++;
            }
            if (nullNumber == lists.length) return lists[0];
            ListNode head = new ListNode(1001, null);
            ListNode res=head;
            ListNode min = lists[0];
            int minIndex=0;

            while (min !=null || res.next==null){
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i]==null) {
                        continue;
                    }
                    if (min==null || lists[i].val < min.val){
                        min=lists[i];
                        minIndex=i;
                    }
                }

                head.next=lists[minIndex];
                head=head.next;
                lists[minIndex] = lists[minIndex].next;

                min = lists[minIndex];
                while (min==null){
                    int count=0;
                    for (int i = 0; i < lists.length; i++) {
                        count++;
                        if (lists[i]==null) {
                            continue;
                        }

                        min=lists[i];
                        minIndex=i;
                        break;
                    }
                    if(min==null && count==lists.length) break;
                }
            }
            head.next=lists[0];
            return res.next;
        }
    }

    /**
     * 两两合并  每次合并当前的 和 List[i]
     */
    static class Solution1{
        public static ListNode mergeKLists(ListNode[] lists) {
            ListNode ans = null;
            for (int i=0; i<lists.length; i++){
                ans = mergeTwoLists(ans, lists[i]);
            }
            return ans;
        }

        private static ListNode mergeTwoLists(ListNode ans, ListNode list) {
            ListNode dummy = new ListNode(10001, null);
            ListNode curHead = dummy;
//            ListNode next1=ans, next2=list;
            while (ans!=null &&  list!=null){
                if (ans.val< list.val){
                    curHead.next=ans;
                    ans=ans.next;
                }else {
                    curHead.next=list;
                    list=list.next;
                }
                curHead=curHead.next;
            }

            curHead.next= ans==null ? list :ans;
            return dummy.next;
        }
    }

    /**
     *  优先队列
     */
    static class Solution2{
        public static ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0 || lists==null) return null;
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val-o2.val;
                }
            });

            for (int i=0; i<lists.length; i++){
                // 处理 [ [], [1,3]  ] 类似的情况
                if (lists[i]!=null){
                    priorityQueue.add(lists[i]);
                }
            }
            ListNode dummy = new ListNode(0, null);
            ListNode cur = dummy;
            while (priorityQueue.isEmpty()!= true){
                cur.next=priorityQueue.poll();
                cur=cur.next;
                // 如果还有下个节点 接着排进优先队列中
                if (cur.next!=null) priorityQueue.add(cur.next);
            }
            return dummy.next;
        }
    }

    @Test
    public void test(){
        ListNode l5=new ListNode(5);
        ListNode l4=new ListNode(4);
        ListNode l3=new ListNode(3);
        ListNode l2=new ListNode(2);
        ListNode l1=new ListNode(1);
        l1.next=l4; l2.next=l3; l3.next=null; l4.next=l5; l5.next=null;
        ListNode[] listNodes = new ListNode[]{l2, l1};
        ListNode[] listNodes2 = new ListNode[]{null, l5};
        Solution.mergeKLists(listNodes2);
        Solution1.mergeKLists(listNodes);
        Solution2.mergeKLists(listNodes);
    }
}
