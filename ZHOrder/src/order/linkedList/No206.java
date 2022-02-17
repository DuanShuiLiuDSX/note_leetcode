package order.linkedList;

/**
 * @author cz
 * @Description 反转链表
 * @date 2022/2/17 13:32
 **/
public class No206 {
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

    public ListNode reverseList(ListNode head) {
        ListNode pre =head;
        if (pre==null)
            return pre;
        ListNode cur=pre.next;
        if (cur==null)
            return pre;
        ListNode next = cur.next;
        if (next==null){
            cur.next=pre;
            return cur;
        }
        pre.next=null;
        while (next!=null){
            cur.next=pre;
            pre=cur;
            cur=next;
            next=cur.next;
        }
        cur.next=pre;
        return cur;
    }
}
