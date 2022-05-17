import java.util.HashMap;
import java.util.Stack;

/**
 * @author cz
 * @Description 两个链表的第一个节点
 * @date 2022/5/9 9:09
 **/
public class No52 {

    /**
     * HashMap 存储 求解
     */
    public class Solution1 {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            HashMap<ListNode, Integer> map = new HashMap<>();
            while (pHead1 != null) {
                map.put(pHead1, 1);
                pHead1 = pHead1.next;
            }
            while (pHead2 != null) {
                if (map.get(pHead2) != null)
                    return pHead2;
                pHead2 = pHead2.next;
            }

            return null;
        }
    }

    // 栈的解法
    public class Solution2 {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            while(pHead1!=null){
                stack1.add(pHead1);
                pHead1 = pHead1.next;
            }
            while(pHead2!=null){
                stack2.add(pHead2);
                pHead2 = pHead2.next;
            }
            ListNode res = null;
            while(stack1.size()!=0 && stack2.size()!=0){
                if(stack1.peek() == stack2.peek())
                {
                    res  = stack1.pop();
                    stack2.pop();
                }else{
                    break;
                }
            }
            return res;
        }
    }

}
