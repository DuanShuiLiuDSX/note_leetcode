package linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cz
 * @Description 单链表排序
 * @date 2022/3/30 9:17
 **/
public class BM12 {
    public class Solution {
        /**
         *  优先队列 进行排序
         * @param head ListNode类 the head node
         * @return ListNode类
         */

        public ListNode sortInList (ListNode head) {
            // write code here
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val- o2.val;
                }
            });
            while (head!=null){
                queue.add(head);
                head=head.next;
            }
            ListNode res =queue.peek();
            while (queue.isEmpty()==false){
                queue.poll().next= queue.peek();
            }
            return res;

        }
    }
}
