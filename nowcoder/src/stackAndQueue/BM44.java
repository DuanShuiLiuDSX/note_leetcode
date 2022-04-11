package stackAndQueue;

/**
 * @author cz
 * @Description 括号匹配
 * @date 2022/4/7 19:46
 **/
import java.util.*;


public class BM44 {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        Stack<String> stack = new Stack<String>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)!='}' && s.charAt(i)!=']' && s.charAt(i)!=')'){
                stack.push(String.valueOf(s.charAt(i)));
            }else {
                if (s.charAt(i)=='}'){
                    if (stack.pop().equals(String.valueOf('{'))) continue;
                }

                if (s.charAt(i)==']'){
                    if (stack.pop().equals(String.valueOf('['))) continue;
                }

                if (s.charAt(i)==')'){
                    if (stack.pop().equals(String.valueOf('('))) continue;
                }

                return false;
            }
        }
        return true;
    }
}
