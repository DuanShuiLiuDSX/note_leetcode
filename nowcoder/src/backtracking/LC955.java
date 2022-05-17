package backtracking;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description
 * @date 2022/5/12 10:24
 **/
public class LC955 {

        public int minDeletionSize(String[] strs) {
            int res=0;
            char[][] chars = new char[strs.length][strs[0].length()];
            for(int i=0; i<strs.length; i++){
                char[] subStr = strs[i].toCharArray();
                for (int j=0; j<subStr.length; j++){
                    chars[i][j] = subStr[j];
               }
             }

            for (int i=0; i<strs[0].length(); i++){
                int temp = chars[0][i] - 'a';
                for (int j=1; j<strs.length; j++){
                    if (temp < chars[j][i]-'a') temp = chars[j][i]-'a';
                    else if (temp > chars[j][i]-'a'){
                        res++;
                        break;
                    }
                }
            }
        return res;
        }

    @Test
    public void test(){
        LC955 no955 = new LC955();
        String[] strings = new String[]{"cbad","dafe","ghif"};
        no955.minDeletionSize(strings);
    }
}
