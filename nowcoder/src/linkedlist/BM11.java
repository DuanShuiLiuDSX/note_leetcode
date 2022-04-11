package linkedlist;

import java.util.ArrayList;

/**
 * @author cz
 * @Description 链表相加
 * @date 2022/3/29 12:19
 **/
public class BM11 {
    public class Solution {
        /**
         * 思路 按位加 得到的进位用temp存储 得到的每一位存储在 resArray
         * 遍历resArray 并进行节点的构造
         *
         * @param head1 ListNode类
         * @param head2 ListNode类
         * @return ListNode类
         */
        public ListNode addInList (ListNode head1, ListNode head2) {
            // write code here
            ArrayList<Integer> a1= new ArrayList<>();
            ArrayList<Integer> a2= new ArrayList<>();
            ArrayList<Integer> resArray= new ArrayList<>();
            while(head1!=null){
                a1.add(head1.val);
                head1=head1.next;
            }
            while(head2!=null){
                a2.add(head2.val);
                head2=head2.next;
            }
            int count1=a1.size(), count2=a2.size();
            int temp=0;
            while(count1>0 && count2>0){
                int addNum = a1.get(count1-1)+a2.get(count2-1)+temp;
                resArray.add(addNum%10);
                temp=addNum/10;
                count1--;
                count2--;
            }
            while(count1>0){
                int addNum = a1.get(count1-1)+temp;
                resArray.add(addNum%10);
                temp=addNum/10;
                count1--;
            }
            while(count2>0){
                int addNum = a2.get(count2-1)+temp;
                resArray.add(addNum%10);
                temp=addNum/10;
                count2--;
            }
            if(temp!=0)resArray.add(temp);
            int count=resArray.size();
            ListNode dummy= new ListNode(0);
            ListNode resNode=dummy;
            for(int i=count-1; i>=0; i--){
                ListNode tempNode = new ListNode(resArray.get(i));
                dummy.next=tempNode;
                dummy=dummy.next;
            }
            return resNode.next;
        }
    }
}
