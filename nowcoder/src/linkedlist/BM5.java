package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author cz
 * @Description 合并k个有序的排序序列
 * @date 2022/3/25 10:18
 **/
public class BM5 {
    public static class Solution {
        public static ListNode mergeKLists(ArrayList<ListNode> lists) {
            ListNode head = new ListNode(1001);
            ListNode res=head;
            ListNode min = lists.get(0);
            int minIndex=0;

            while (lists.size()!=1){

                for (int i = 0; i < lists.size(); i++) {
                    if (lists.get(i)==null) {
                        lists.remove(i);
                        continue;
                    }
                    if (lists.get(i).val < min.val){
                        min=lists.get(i);
                        minIndex=i;
                    }
                }

                head.next=lists.get(minIndex);
                head=head.next;
                lists.set(minIndex, lists.get(minIndex).next);

                min = lists.get(minIndex);
                while (min==null){
                    for (int i = 0; i < lists.size(); i++) {
                        if (lists.get(i)==null) {
                            lists.remove(i);
                            continue;
                        }
                        min=lists.get(i);
                        minIndex=i;
                    }
                }
            }
            head.next=lists.get(0);
            return res.next;
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
        ArrayList<ListNode> arrayList = new ArrayList<ListNode>();
        arrayList.add(l2);
        arrayList.add(l1);
        Solution.mergeKLists(arrayList);
    }

}
