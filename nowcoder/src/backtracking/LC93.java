package backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description 复原ip地址
 * @date 2022/5/17 9:21
 **/
public class LC93 {
    List<String> res = new ArrayList<>();
    StringBuffer subRes = new StringBuffer();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() <4 || s.length()>12) return res;
        // pointNum 来记录 小数点的个数
        backstrack(s, 0,  0);
        return res;
    }

    private void backstrack(String s, int startIndex, int pointNum){
        if(subRes.length()== (s.length()+4) && pointNum==4 ){
            StringBuffer temp = new StringBuffer(subRes);
            temp.delete(temp.length()-1, temp.length());
            res.add(temp.toString());
            return;
        }

        for(int i=startIndex; i<s.length(); i++){
            // 还可以再详细剪枝
            if (pointNum>3) break;

            // 判断是否满足为ip数字的条件
            String subString  = s.substring(startIndex, i+1);
            if (subString.length()>3) break;
            if (subString.charAt(0)=='0' && subString.length()>1) break;
            if (Integer.valueOf(subString)>255) break;

            subRes.append(subString);
            subRes.append(".");
            backstrack(s, i+1,  ++pointNum);
            subRes.delete(subRes.length()-(i-startIndex+1) -1 , subRes.length());
            pointNum--;
        }
    }

    @Test
    public void test(){
        LC93 lc93 = new LC93();
        lc93.restoreIpAddresses("10123");
    }
}
