package order.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.jar.JarEntry;

/**
 * @author cz
 * @Description 每日温度
 * @date 2022/2/21 8:35
 **/
public class No739 {
    // 时间复杂度 O(nxn)  效率低下
    public int[] dailyTemperatures(int[] temperatures) {
        for (int i = 0; i < (temperatures.length-1); i++) {
            for (int j = i+1; j < temperatures.length ; j++) {
                if (temperatures[j]<=temperatures[i]){
                    continue;
                }else {
                    temperatures[i]=j-i;
                }
            }
        }
        temperatures[temperatures.length-1]=0;
        return temperatures;
    }

    //栈做法
    //维护一个自低向上的 递减的栈 用来存储下标
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            // 若栈不为空 且 当前元素大于 栈顶的元素对应的值 则当前元素的位置是 栈顶位置第一次遇到升温的天数
            while (!stack.empty() && temp > temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i-index;
            }
            stack.push(i);
        }
        return res;
    }

    //最优解法，动态规划
}
