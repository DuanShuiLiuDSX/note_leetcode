package linkedlist;

/**
 * @author cz
 * @Description 链表索引的奇偶排序
 * @date 2022/3/30 10:10
 **/
public class BM14 {
    /**
     *  解法 三指针  一个指向偶数索引 一个指向奇数索引 一个指向下一轮的下一个节点
     * @param head
     * @return
     */
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head==null || head.next==null || head.next.next==null) return head;
        // num of nodes>=3
        ListNode res = head;
        ListNode nextHead=head.next;
        ListNode evenNode=nextHead, oddNode=nextHead.next;
        ListNode nextNode=oddNode.next;
        while(oddNode!=null && head.next!=null){
            head.next=oddNode;
            head=oddNode;
            if(nextNode!=null)
                oddNode=nextNode.next;

            evenNode.next=nextNode;
            evenNode=nextNode;
            if(oddNode!=null)
                nextNode=oddNode.next;
        }
        head.next=nextHead;
        return res;
    }
}
