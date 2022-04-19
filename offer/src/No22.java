/**
 * @author cz
 * @Description 链表中倒数第K个节点
 * @date 2022/4/18 9:38
 **/
public class No22 {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head, slow = head;
            while (k > 0) {
                fast = fast.next;
                k--;
            }

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
        }
    }
}
