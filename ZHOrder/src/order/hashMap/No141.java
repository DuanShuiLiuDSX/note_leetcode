package order.hashMap;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author cz
 * @Description 环形链表
 * @date 2022/2/24 13:23
 **/
public class No141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<ListNode>();
            while (head.next!=null){
                if (set.contains(head)==false){
                    set.add(head);
                }else {
                    return false;
                }
                head=head.next;
            }
            return true;
        }
    }
}
