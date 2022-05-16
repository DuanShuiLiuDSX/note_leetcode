package backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description 分割回文串
 * @date 2022/5/16 15:14
 **/
public class LC131 {
    List<List<String>> res = new ArrayList<>();
    List<String> subRes = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        backstrack(s, 0, n);
        return res;
    }

    public void backstrack(String s,  int startIndex, int n){
        if (startIndex==n){
            res.add(new ArrayList<>(subRes));
            return;
        }
        for (int i=startIndex; i<n; i++){
            if (isPalindrome(s.substring(startIndex, i+1))){
                subRes.add(new String(s.substring(startIndex,i+1)));
            }else {
                /**
                 *  eg s="aba"  i==1时  这时候 ab, 所以不能break; 要continue
                 */
                continue;
            }
            backstrack(s, i+1, n);
            subRes.remove(subRes.size()-1);
        }
    }

    public boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        int left=0, right=chars.length-1;
        while (left<right){
            if(chars[left++]!= chars[right--]) return false;
        }
        return true;
    }

    @Test
    public void test(){
        LC131 lc131 = new LC131();
        lc131.partition("aba");
    }
}
