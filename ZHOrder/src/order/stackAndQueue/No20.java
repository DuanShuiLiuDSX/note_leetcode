package order.stackAndQueue;

import java.util.Stack;

/**
 * @author cz
 * @Description 括号匹配
 * @date 2022/2/19 9:11
 **/
public class No20 {
    public boolean isValid(String s) {
        Stack stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' ||s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else if (stack.empty()
                    || s.charAt(i) == '}' &&(char) stack.pop()!='{'
                    || s.charAt(i) == ']' && (char) stack.pop()!='['
                    || s.charAt(i) == ')' && (char) stack.pop()!='('){
                return false;
            }
//            // if冗余 可以简写成一个
            if (s.charAt(i) == '}' ||s.charAt(i) == ')' || s.charAt(i) == ']'){
                if (stack.empty()){
                    return false;
                }
                char temp = (char) stack.pop();
                if (s.charAt(i) == '}' && temp!='{'){
                    return false;
                }
                if (s.charAt(i) == ']' && temp!='['){
                    return false;
                }
                if (s.charAt(i) == ')' && temp!='('){
                    return false;
                }
            }
        }


        if (stack.empty()){
            return true;
        }
        else {
            return false;
        }
    }
}
