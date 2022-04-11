import java.util.Stack;

/**
 * @author cz
 * @Description 两个栈模拟队列
 * @date 2022/4/9 19:17
 **/
public class No9 {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.empty()){
                while (stack1.empty()==false){
                    stack2.add(stack2.pop());
                }
            }
            return stack2.pop();
        }
    }
}
