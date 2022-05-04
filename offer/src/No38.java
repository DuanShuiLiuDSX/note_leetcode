import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author cz
 * @Description 字符串的全排列 不含重复项、
 * @date 2022/4/23 16:19
 **/
public class No38 {
    public static class Solution {
        static StringBuilder subString = new StringBuilder(10);
        static ArrayList<String> res = new ArrayList<String>();
        static HashMap<String, String> map = new HashMap<String, String>();
        public static ArrayList<String> Permutation(String str) {
            fullSort(str.toCharArray());
            for (String value: map.values()) {
                res.add(value);
            }
            return  res;
        }

        public  static  void fullSort(char[] chars){
            if(chars.length==1){
                subString.append(chars);
                map.put(subString.toString(), subString.toString());
                subString.delete(subString.length()-1, subString.length());
            }else{
                for(int i=0; i<chars.length; i++){
                    if (i!=0) subString.delete(subString.length()-1, subString.length());
                    String tempString = new String(chars);
                    StringBuilder temp = new StringBuilder(tempString);
                    subString.append(chars[i]);
                    temp.delete(i,i+1);
                    fullSort(temp.toString().toCharArray());
                }
                subString.delete(subString.length()-1, subString.length());
            }
        }


    }

    // 官方题解
  public static   class Solution2 {
       static List<String> res = new LinkedList<>();
        static char[] c;
        public static String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }
       static void dfs(int x) {
            if(x == c.length - 1) {
                res.add(String.valueOf(c));      // 添加排列方案
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = x; i < c.length; i++) {
                if(set.contains(c[i])) continue; // 重复，因此剪枝
                set.add(c[i]);
                swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
                dfs(x + 1);                      // 开启固定第 x + 1 位字符
                swap(i, x);                      // 恢复交换
            }
        }
        static void swap(int a, int b) {
            char tmp = c[a];
            c[a] = c[b];
            c[b] = tmp;
        }


    }



    @Test
    public void test(){
        No38.Solution.Permutation(new String("abcd"));
    }

    @Test
    public void test1(){
        String[] strings = No38.Solution2.permutation(new String("abc"));
    }
}
