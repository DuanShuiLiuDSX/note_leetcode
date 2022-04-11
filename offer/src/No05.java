import org.junit.jupiter.api.Test;

import java.nio.file.Path;

/**
 * @author cz
 * @Description 替换空格
 * @date 2022/4/8 10:52
 **/


public class No05 {
    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 如果题意 给的是ArrayList 用双指针 可以 O(n)时间     O(1)空间
         *
         * 双指针 从尾 到头 开始遍历
         * @param s string字符串
         * @return string字符串
         */
        public static String replaceSpace (String s) {
            // write code here
            int count=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==' ') count++;
            }
            int p1=s.length()-1, p2=p1+count*2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.setLength(p2+1);
            while (p1>=0){
                if (s.charAt(p1)!=' '){
                    stringBuilder.setCharAt(p2, s.charAt(p1));
                    p2--; p1--;
                }else {
                    stringBuilder.setCharAt(p2--, '0');
                    stringBuilder.setCharAt(p2--, '2');
                    stringBuilder.setCharAt(p2--, '%');
                    p1--;
                }
            }
            return stringBuilder.toString();
        }

        @Test
        public void test(){
            Solution.replaceSpace(new String("aaa bbb ccc"));
        }
    }
}
