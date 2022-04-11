package linkedlist;

/**
 * @author cz
 * @Description 删除链表中的重复节点i
 * @date 2022/3/30 10:24
 **/
public class BM15 {
    public class Solution {
        /**
         *
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode deleteDuplicates (ListNode head) {
            // write code here
            if(head==null) return head;
            ListNode res=head, next=head.next;
            int temp=head.val;
            while(next!=null){
                if(next.val==temp){
                    head.next=next.next;
                    if(head.next!=null){
                        next=head.next;
                    }else{
                        next=null;
                    }
                    continue;
                }
                head=head.next;
                temp=head.val;
                next=next.next;
            }
            return res;
        }
    }
}
