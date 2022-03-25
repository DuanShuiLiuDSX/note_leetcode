package string;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 验证ip地址
 * @date 2022/3/17 21:26
 **/
public class BM85 {
    public static class Solution {
        /**
         * 验证IP地址
         * @param IP string字符串 一个IP地址字符串
         * @return string字符串
         */
        public String solve(String IP) {
            if (IP == null || IP.length() == 0) return "Neither";
            if (isIPv4(IP)) return "IPv4";
            if (isIPv6(IP)) return "IPv6";
            return "Neither";
        }

        public boolean isIPv4(String IP){
            String[] ips = IP.split("\\.");
            if (ips.length != 4) return false;
            if (IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return false;
            for (int i = 0 ; i < ips.length ; i ++)
                if (!isIPv4Group(ips[i])) return false;
            return true;
        }

        private boolean isIPv4Group(String IPG){
            if (IPG == null || IPG.length() == 0 || IPG.length() > 3) return false;
            for (int i = 0 ; i < IPG.length();  i++)
                if (!('0' <= IPG.charAt(i) && IPG.charAt(i) <= '9'))  return false;
            int x = Integer.valueOf(IPG);
            if (x< 0 || x > 255 || (IPG.charAt(0) == '0' && IPG.length() > 1))
                return false;
            return true;
        }

        public boolean isIPv6(String IP){
            String[] ips = IP.split(":");
            if (ips.length != 8) return false;
            if (IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') return false;
            for (int i = 0 ; i < ips.length ; i ++){

                if (!isIPv6Group(ips[i])) return false;
            }
            return true;
        }

        private boolean isIPv6Group(String IPG){
            if (IPG == null || IPG.length() == 0 || IPG.length() > 4) return false;
            for (int i = 0 ; i < IPG.length(); i++)
                if (!('0' <= IPG.charAt(i) && IPG.charAt(i) <= '9' || 'a' <= IPG.charAt(i) && IPG.charAt(i) <= 'f' || 'A' <= IPG.charAt(i) && IPG.charAt(i) <='F'))
                    return false;
            return true;
        }
    }


    public static void main(String[] args) {
//        Solution.solve("2001:db8:85a3:0::8a2E:0370:7334");
    }
}
