package backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description 电话号码的组合
 * @date 2022/5/16 10:27
 **/
public class LC17 {
    List<String> res = new ArrayList<>();
    StringBuffer subRes = new StringBuffer();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",""};
    public List<String> letterCombinations(String digits) {
        if(digits=="" || digits==null ) return res;
        digits +="0";
        char[] charDigits = digits.toCharArray();
        int n = charDigits.length;
        if(n==1) return res;

        int begin = charDigits[0]-'0';
        backstrack(0, charDigits, n-1, map[begin]);
        return res;
    }

    public void backstrack(int begin, char[] digits, int n, String cur){

        if(subRes.length()==n){
            res.add(new String(subRes.toString()));
            return;
        }
        char[] charCur = cur.toCharArray();
        for(int i=0; i<charCur.length; i++){
            subRes.append(String.valueOf(charCur[i]));
            if(begin+1<=n){
                backstrack(begin+1, digits, n, map[ digits[begin+1] -'0']);
            }
            subRes.delete(subRes.length()-1, subRes.length());
        }
    }

    @Test
    public void test(){
        LC17 lc17 = new LC17();
        lc17.letterCombinations("25");
    }
}
