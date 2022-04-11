package order.linkedList;

/**
 * @author cz
 * @Description
 * @date 2022/3/25 12:20
 **/
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
