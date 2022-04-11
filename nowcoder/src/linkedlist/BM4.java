package linkedlist;

/**
 * @author cz
 * @Description 合并两个排序的链表
 * @date 2022/3/25 9:35
 **/
public class BM4 {
    /**
     *  递归写法  缺点 空间复杂度为 O(N)
     */
    public class Solution {
        public ListNode Merge(ListNode list1,ListNode list2) {
            if (list1==null)return list2;
            else if (list2==null) return list1;
            ListNode newHead=null;
            if (list1.val < list2.val){
                newHead = list1;
                newHead.next = Merge(list1.next, list2);
            }else {
                newHead = list2;
                newHead.next = Merge(list1, list2.next);
            }
            return newHead;
        }

    }
}
