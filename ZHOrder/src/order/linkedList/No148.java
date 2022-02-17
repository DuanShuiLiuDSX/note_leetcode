package order.linkedList;




/**
 * @author cz
 * @Description 排序链表
 * @date 2022/1/12 16:11
 **/


public class No148 {

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

    //  空间复杂度 o(1)
    public ListNode sortList(ListNode head) {
        ListNode top = new ListNode();

        // left、right 当前节点的左、右节点
        ListNode temp, current, right, left;
        left =head;
        current = head;
        right = current.next;
        top = head;
        temp = head;
        Boolean flag =true;

        while (right!=null){
            if (flag){
                left = current;
            }
            current = right;
            right = current.next;
            if (current.val >= left.val ){
                flag = true;
                continue;
            }else {
                while (true){
                    //寻找该插入的位置  temp为插入的前一个节点 top为后一个节点
                    if(current.val> top.val){
                        temp = top;
                        top = top.next;
                    }else {
                        break;
                    }
                }
                //在当 current应该作为第一个节点情况
                if(top == head){
                    current.next = top;
                    left.next = right;
                    head = current;
                    top = head;
                    flag = false;
                }else {
                    temp.next = current;
                    current.next = top;
                    left.next = right;
                    top=head;
                    flag = false;
                }
            }
        }
        return head;
    }

    // 归并排序
    public ListNode sortList_1(ListNode head){
        return sortList_1(head, null);
    }

    private ListNode sortList_1(ListNode head, ListNode tail) {
        if (head==null){
            return null;
        }
        if(head.next == tail){
            head.next=null;
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=tail){
            fast=fast.next;
            slow=slow.next;
            if(fast!=tail){
                fast= fast.next;
            }
        }
        ListNode mid=slow;
        ListNode l1 = sortList_1(head, mid);
        ListNode l2 = sortList_1(mid, tail);
        ListNode res = Merge(l1, l2);
        return res;
    }

    private ListNode Merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, t1 = l1, t2 = l2;
        while (t1!=null &&  t2!=null){
            if (t1.val<=t2.val){
                temp.next = t1;
                t1 = t1.next;
            }else {
                temp.next =t2;
                t2 = t2.next;
            }
            temp =temp.next;
        }
        if (t1==null){
            temp.next = t2;
        }else if (t2==null){
            temp.next = t1;
        }
        return dummyHead.next;

    }


    public static void main(String[] args) {
        No148 no148 = new No148();
        ListNode l5 = new ListNode(0, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(5, l3);
        ListNode l1 = new ListNode(-1, l2);
        ListNode listNode = no148.sortList(l1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
