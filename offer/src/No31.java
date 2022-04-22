import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author cz
 * @Description 栈的压入、弹出序列
 * @date 2022/4/21 19:26
 **/
public class No31 {
    public static class Solution {
        /**
         *  用Map 存储 pushA的值 和 元素对应的下标
         *  遍历popA 若 Map 中有 popA的值
         *  将 pushA中 该元素 以及之前的元素 入栈， 将Map中 对应的元素删除
         *  然后弹栈 逐一对比
         * @param pushA
         * @param popA
         * @return
         */
        public static boolean IsPopOrder(int[] pushA, int[] popA) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int i = 0; i < pushA.length; i++) {
                hashMap.put(pushA[i], i);
            }

            for (int i = 0; i < popA.length; i++) {
                if (hashMap.containsKey(popA[i])) {
                    int tempIndex =0;
                    for (int j = index; j <= hashMap.get(popA[i]); j++) {
                        stack.push(pushA[j]);
                        tempIndex = j;
                    }
                    // 这边要先 压栈完 再删除 不然会 空指针异常
                    for (int j=index; j<=tempIndex; j++){
                        hashMap.remove(pushA[j]);
                    }
                    index = tempIndex+1;
                }
                if(stack.isEmpty()==true) return false;
                if (stack.pop() == popA[i]) continue;
                else return false;
            }
            return true;
        }
    }

    @Test
    public void test(){
        System.out.println();
        No31.Solution.IsPopOrder(new int[]{1,2,3,4,5},  new int[]{4,5,3,2,1});
    }
}
