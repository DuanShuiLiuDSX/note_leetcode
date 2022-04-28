import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author cz
 * @Description 最长不含重复字符的子字符串
 * @date 2022/4/26 19:35
 **/
public class No48 {

    //version 1
    public int lengthOfLongestSubstring (String s) {
        // write code here
        if(s==null) return 0;
        if(s.length()==1) return 1;
        int i=0, j=0, res= 0, count = 0;
        HashSet<Character> set = new HashSet<Character>();
        while(i<s.length()){
            while(j<s.length()){
                if(set.contains(s.charAt(j))==true){
                    i++;
                    j=i;
                    res = Math.max(res, count);
                    count=0;
                    set.clear();
                }else{
                    set.add(s.charAt(j));
                    j++;
                    count++;
                }
            }
            if(j==s.length()) return Math.max(res, count);
        }
        return res;
    }

    /**
     *  时间复杂度优化  dp解法
     *  leetcode 题解
     *  leetcode 保证输入为a到z的字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s==null) return 0;
        if(s.length()==1) return 1;
        int[] position = new int[26];
        int[] res = new int[s.length()];
        for (int i=0; i<26; i++){
            position[i]=-1;
        }
        res[0] =1;
        int max=res[0];
        position[s.charAt(0)- 'a'] =0;
        for (int i=1; i<s.length(); i++){
            if (position[s.charAt(i)-'a']==-1){
                res[i] = res[i-1]+1;
                position[s.charAt(i)-'a'] = i;
                max = Math.max(res[i], max);
            }else {
                int distance = i - position[s.charAt(i)-'a'];
                if (distance <= res[i-1]){
                    res[i] = distance;
                }else {
                    res[i] = res[i-1]+1;
                }
                position[s.charAt(i)-'a'] = i;
                max = Math.max(res[i], max);
            }
        }
        return max;
    }

    /**
     * nowcode 题解  输入含特殊字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s==null) return 0;
        if(s.length()==1) return 1;
        int[] res = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        res[0] =1;
        map.put(s.charAt(0), 0);
        int max=res[0];
        for (int i=1; i<s.length(); i++){
            char temp = s.charAt(i);
            if (map.containsKey(temp)==false){
                res[i] = res[i-1]+1;
                map.put(temp, i);
                max = Math.max(res[i], max);
            }else {
                int distance = i - map.get(temp);
                if (distance <= res[i-1]){
                    res[i] = distance;

                }else {
                    res[i] = res[i-1]+1;
                }
                map.put(temp, i);
                max = Math.max(res[i], max);
            }
        }
        return max;
    }


    @Test
    public void test(){
        No48 no48 = new No48();
//        no48.lengthOfLongestSubstring("dvdf");
        no48.lengthOfLongestSubstring2("abcabcbb");
    }
}
