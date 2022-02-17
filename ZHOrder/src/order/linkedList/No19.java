package order.linkedList;

/**
 * @author cz
 * @Description 删除链表倒数第n个节点
 * 双指针解法， 第一个指针先走n个节点，
 * 然后两个指针再一起出发，当第一个指针走到尾节点时，第二个指针和第一个刚好相差n个节点
 *
 * @date 2022/2/16 15:43
 **/
public class No19 {

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

    /**
     * 最优解法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 双指针的思想
        // 定义一个快指针,定义一个慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 先让快指针走n步
        while(n--!=0){
            fast=fast.next;
        }
        // 如果快指针走到了最后说明删除的是第一个节点,就返回head.next就好
        if(fast==null){
            return head.next;
        }
        // 使得slow每次都是在待删除的前一个节点, 所以要先让fast先走一步
        fast=fast.next;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        // 因为已经保证了是待删除节点的前一个节点, 直接删除即可
        slow.next=slow.next.next;
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //多定义一个节点 来解决 删除头节点的情况
        ListNode temp = new ListNode(-1, head);
        ListNode pre = head, after = temp;

        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }

        // 如果判断条件用 pre.next!=null 会出现空指针异常
        while (pre != null) {
            pre = pre.next;
            after = after.next;
        }
        after.next = after.next.next;

        return temp.next;
    }

    public static void main(String[] args) {
        No19 no19 = new No19();
        ListNode l3= new ListNode(3, null);
        ListNode l2= new ListNode(2, l3);
        ListNode l1= new ListNode(1, l2);

        ListNode res = no19.removeNthFromEnd(l1, 1);

    }
}
