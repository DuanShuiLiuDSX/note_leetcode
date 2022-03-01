package order.stackAndQueue;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author cz
 * @Description MinStack
 * @date 2022/2/20 19:08
 **/
public class No155 {
    class MinStack {
        Stack<Integer> totalStack;
        Stack<Integer> minStack;

        public MinStack() {
            totalStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            totalStack.push(val);
            if (minStack.empty() || val <= minStack.peek()){
                minStack.push(val);
            }
        }

        public void pop() {
            // 如果val 用Integer  会出现-1024不等于-1024的情况
            // 注意包装类的==是先比较地址的
            int val = totalStack.pop();
            if(val == minStack.peek()){
                totalStack.pop();
            }
            // data.pop();

        }

        public int top() {
           return totalStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
