/**
 * @author cz
 * @Description 复杂链表的复制
 * @date 2022/4/21 21:13
 **/
public class No35 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     *  先在原链表的 每一个链表后面 复制一个相同的节点， 并修改链表为以下：
     *  如 原链表 A B C D    复制为 A A1 B B1 C C1 D D1
     *  再遍历链表 找到random的指向
     *  再把原来的链表 指回原来的节点
     */

    public class Solution {
        public RandomListNode Clone(RandomListNode pHead) {

            if (pHead == null){
                return null;
            }
            RandomListNode node = pHead;
            while (node != null) {
                RandomListNode copy = new RandomListNode(node.label);
                copy.next = node.next;
                node.next = copy;
                node = copy.next;
            }
            node = pHead;
            while (node != null) {
                if (node.random != null) {
                    node.next.random = node.random.next;
                }
                node = node.next.next;
            }
            node=pHead;
            RandomListNode root=pHead.next;
            RandomListNode tmp=root;
            while(node!=null){
                node.next=tmp.next;
                tmp.next=node.next==null?null:node.next.next;
                node=node.next;
                tmp=tmp.next;
            }
            return root;

        }
    }
}


