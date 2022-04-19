/**
 * @author cz
 * @Description 正则表达式匹配
 * @date 2022/4/17 18:13
 **/
public class No19 {
    // dp
    class Solution1 {
        public boolean isMatch(String A, String B) {
            int n = A.length();
            int m = B.length();
            boolean[][] f = new boolean[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    //分成空正则和非空正则两种
                    if (j == 0) {
                        f[i][j] = i == 0;
                    } else {
                        //非空正则分为两种情况 * 和 非*
                        if (B.charAt(j - 1) != '*') {
                            if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                                f[i][j] = f[i - 1][j - 1];
                            }
                        } else {
                            //碰到 * 了，分为看和不看两种情况
                            //不看
                            if (j >= 2) {
                                f[i][j] |= f[i][j - 2];
                            }
                            //看
                            if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                                f[i][j] |= f[i - 1][j];
                            }
                        }
                    }
                }
            }
            return f[n][m];
        }
    }

    // 递归解法
    class Solution {
        public boolean isMatch(String s, String p) {
            if (s.length() == 0) {
                if (p.length() % 2 != 0) return false;
                int index = 1;
                while (index < p.length()) {
                    if (p.charAt(index) == '*')
                        index += 2;
                    else
                        return false;
                }
                return true;
            }

            if (p.length() == 0) return false;
            char s1 = s.charAt(0), p1 = p.charAt(0), temp = ' ';
            if (p.length() > 1) temp = p.charAt(1);
            if (temp != '*') {
                if (s1 == p1 || p1 == '.') {
                    return isMatch(s.substring(1), p.substring(1));
                } else
                    return false;
            } else {
                if (s1 == p1 || p1 == '.') return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
                else return isMatch(s, p.substring(2));
            }
        }
    }
}
