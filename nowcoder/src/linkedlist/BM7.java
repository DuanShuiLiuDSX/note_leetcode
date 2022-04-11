package linkedlist;

/**
 * @author cz
 * @Description 找到环的入口节点
 * @date 2022/3/28 16:39
 **/
public class BM7 {
    public class Solution {

        public ListNode EntryNodeOfLoop(ListNode pHead) {
            if (pHead.next==null) return null;
            ListNode fast=pHead.next.next;
            ListNode slow = pHead.next;
            int count=0;
            /**
             *  假设 非环的 长度为 x1 环的长度为x2
             *  fast: 2*count=x1+n*x2+temp  slow: count=x1+temp  temp表示在环中走过的长度
             *  count=n*x1  让head 先走count个节点
             *  res 从head出发 会相遇在 环的头节点
             *  res 的路程 x1 head的路程 x1+count=x1+n*x2  所以x2还是在环的头节点
             */
            while (fast!=null && fast.next!=null){
                count++;
                if (slow==fast)
                    break;
                fast=fast.next.next;
                slow=slow.next;
            }
            if (fast==null || fast.next==null)
                return null;
            ListNode res= pHead;
            while (count>0){
                pHead=pHead.next;
                count--;
            }
            while (pHead!=res){
                pHead=pHead.next;
                res=res.next;
            }
            return res;
        }
    }
}
