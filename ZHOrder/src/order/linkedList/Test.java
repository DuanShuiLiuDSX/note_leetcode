package order.linkedList;

import java.util.Arrays;

/**
 * @author cz
 * @Description 性能测试
 * @date 2022/1/13 17:17
 **/

public class Test {

    public static class ListNode {
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

    // 归并排序
    public ListNode sortList_1(ListNode head){
        return sortList_1(head, null);
    }

    private ListNode sortList_1(ListNode head, ListNode tail) {
        if (head==null){
            return null;
        }
        if(head.next == tail){
            head.next=null;
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=tail){
            fast=fast.next;
            slow=slow.next;
            if(fast!=tail){
                fast= fast.next;
            }
        }
        ListNode mid=slow;
        ListNode l1 = sortList_1(head, mid);
        ListNode l2 = sortList_1(mid, tail);
        ListNode res = Merge(l1, l2);
        return res;
    }

    private ListNode Merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, t1 = l1, t2 = l2;
        while (l1!=null &&  l2!=null){
            if (l1.val<=l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next =l2;
                l2 = l2.next;
            }
            if (l1==null){
                temp.next = l2;
            }else if (l2==null){
                temp.next = l1;
            }
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        Test t1= new Test();
        ListNode l1= new ListNode(0);
        ListNode l2= new ListNode(0, l1);
        ListNode l3= new ListNode(3, l2);
        t1.sortList_1(l3);
    }
}


