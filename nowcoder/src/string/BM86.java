package string;

/**
 * @author cz
 * @Description
 * @date 2022/3/17 20:36
 **/
public class BM86 {

    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 计算两个数之和
         * @param s string字符串 表示第一个整数
         * @param t string字符串 表示第二个整数
         * @return string字符串
         */
        public static String solve (String s, String t) {
            // write code here
            int step=0;
            int len1=s.length(), len2=t.length();
            if (s.length() <= t.length()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = t.length()-1; i >= (len2 - len1); i--) {
                    int s1 = (int) s.charAt(i - (len2 - len1)) - (int)('0');
                    int t1 = (int)t.charAt(i) - (int)('0');
                    int temp1 = s1 + t1;
                    temp1 += step;
                    step = temp1 / 10;
                    stringBuilder.append(temp1 % 10);
                }
                for (int i=(t.length() - s.length())-1; i>=0; i--){
                    int temp2 = (int) t.charAt(i) + step- (int)('0');
                    step = temp2/10;
                    stringBuilder.append(temp2%10);
                }
                if (step!=0)
                    stringBuilder.append(step);
                stringBuilder.reverse();
                System.out.println(stringBuilder.toString());
                return stringBuilder.toString();
            }else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = s.length()-1; i >= (len1 - len2); i--) {
                    int t1 = (int) t.charAt(i - (len1 - len2)) - (int)('0');
                    int s1 = (int)s.charAt(i) - (int)('0');
                    int temp1 = s1 + t1;
                    temp1 += step;
                    step = temp1 / 10;
                    stringBuilder.append(temp1 % 10);
                }
                for (int i=(s.length() - t.length())-1; i>=0; i--){
                    int temp2 = (int) s.charAt(i) + step- (int)('0');
                    step = temp2/10;
                    stringBuilder.append(temp2%10);
                }
                if (step!=0)
                    stringBuilder.append(step);
                stringBuilder.reverse();
                System.out.println(stringBuilder.toString());
                return stringBuilder.toString();
            }
        }
    }

    public static void main(String[] args) {
     Solution.solve("994","99");
    }


}
