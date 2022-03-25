package linkedlist;

/**
 * @author cz
 * @Description 反转链表
 * @date 2022/3/23 9:08
 **/
public class BM1 {

    public ListNode ReverseList(ListNode head) {
        if(head==null)return head;
        if(head.next==null) return head;
        ListNode pre = head, cur=head.next;
        ListNode next = cur.next;
        while (next!=null){
            cur.next=pre;
            pre=cur;
            cur=next;
            next=cur.next;
        }
        cur.next = pre;
        head.next=null;
        return cur;
    }

    /**
     * 标准解
     * @param head
     * @return
     */
    public ListNode ReverseList1(ListNode head) {
       ListNode reversedHead=null;
       ListNode curNode=head;
       ListNode preNode=null;
       while (curNode!=null){
           ListNode nextNode = curNode.next;
           if (nextNode==null)
               reversedHead=curNode;
           curNode.next=preNode;
           preNode=curNode;
           curNode=nextNode;
       }
       return reversedHead;
    }

    /**
     * 递归反转链表
     */
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 利用递归 来将head一直往前移动
        ListNode newHead = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        //得到新的头节点之后 每次都返回这个节点
        return newHead;
    }
}
