package order.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cz
 * @Description 合并两个有序链表
 * @date 2022/2/19 9:59
 **/
public class No21 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        Queue queue1 = new LinkedList<ListNode>();
//        Queue queue2 = new LinkedList<ListNode>();
//        while (list1!=null){
//            queue1.offer(list1);
//            list1 = list1.next;
//        }
//        while (list2!=null){
//            queue2.offer(list2);
//            list2 = list2.next;
//        }
//
        if (list1==null){
            return list2;
        }else if (list2==null){
            return list1;
        }else if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
