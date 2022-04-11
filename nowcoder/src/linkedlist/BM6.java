package linkedlist;

/**
 * @author cz
 * @Description 判断是否有环
 * @date 2022/3/25 9:42
 **/
public class BM6 {
    /**
     * 快慢指针  最优解
     * hash    空间复杂度 O（n）
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head==null) return false;
            if (head.next==null) return false;
            ListNode fast = head;
            ListNode slow =head;
            slow=slow.next;
            fast=fast.next.next;
            while (fast!=null && fast.next!=null  ){
                if(slow==fast) return true;
                slow=slow.next;
                fast=fast.next.next;
            }
            return false;
        }
    }
}
