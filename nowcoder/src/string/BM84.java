package string;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 最长公共前缀
 * @date 2022/3/17 18:35
 **/
public class BM84 {
    public static class Solution {
        /**
         *
         * @param strs string字符串一维数组
         * @return string字符串
         */
        public static String longestCommonPrefix (String[] strs) {
            // write code here
            if (strs.length==0)
                return "";
            String res=strs[0];
            int minLen=res.length();
            for (int i = 1; i < strs.length; i++) {
                int temp=0;
                while (temp<res.length() && temp<strs[i].length()){
                    if (res.charAt(temp) == strs[i].charAt(temp)){
                        temp++;
                    }else {
                        break;
                    }
                }
                minLen = minLen<temp ? minLen : temp;
            }
            if (minLen==0)return "";
            return res.substring(0,minLen);
        }
    }
    @Test
    public void test(){
//        String[] strings = new String[]{"abca","abc","abca","abc","abcc"};
        String[] strings = new String[]{};
        Solution.longestCommonPrefix(strings);
    }

}

