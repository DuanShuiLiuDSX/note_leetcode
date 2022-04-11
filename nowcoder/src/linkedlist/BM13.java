package linkedlist;

import java.util.ArrayList;

/**
 * @author cz
 * @Description
 * @date 2022/3/30 9:32
 **/
public class BM13 {
    public class Solution {
        /**
         *  借助 动态数组存储  然后两端遍历
         * @param head ListNode类 the head
         * @return bool布尔型
         */
        public boolean isPail (ListNode head) {
            // write code here
            ArrayList<ListNode> arrayList = new ArrayList<>();
            while(head!=null){
                arrayList.add(head);
                head=head.next;
            }
            int size=arrayList.size();
            for(int i=0; i<size/2; i++){
                if(arrayList.get(i).val!=arrayList.get(size-1-i).val)
                    return false;
            }
            return true;
        }
    }
}
