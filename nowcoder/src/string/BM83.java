package string;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description
 * @date 2022/3/17 19:53
 **/
public class BM83 {
    public  static class Solution {
        public static String trans(String s, int n) {
            // write code here
            String res = "";
            String[] strings = new String[n];
            int[] index = new int[n];
            int start=0;
            for(int i=0; i<n; i++){
                if(s.charAt(i)==' '){
                    index[start]=i;
                    if(start==0){
                        strings[start]=s.substring(0, i);
                    }else {
                        strings[start]=s.substring(index[start-1]+1, i);
                    }

                    start++;
                }
            }
            if (start==0){
                strings[start] = s;
            }else {
                strings[start] = s.substring(index[start-1]+1, s.length());
            }

            for(int i=start; i>=0; i--){
                char[] temp = strings[i].toCharArray();
                for(int j=0; j<strings[i].length(); j++){
                    if(strings[i].charAt(j) >='a' && strings[i].charAt(j)<= 'z')
                        temp[j]-=32;
                    if(strings[i].charAt(j) >='A' && strings[i].charAt(j)<= 'Z')
                        temp[j]+=32;
                }
                String s1 = String.valueOf(temp);
                res = res+s1;
                if(i!=0) {
                    res=res+" ";
                }
            }
            return res;
        }

        @Test
        public void Test(){
            Solution.trans("This is a sample",16);
        }
    }


}
