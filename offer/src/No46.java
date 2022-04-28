import java.util.Arrays;

/**
 * @author cz
 * @Description 数字翻译成字符串
 * @date 2022/4/26 11:41
 **/
public class No46 {
    /**
     * now coder 题型 a->1 递归条件和 a->0 不一样
     * @param nums
     * @return
     */
    public int solve (String nums) {
        // write code here
        //排除0
        if(nums.equals("0"))
            return 0;
        //排除只有一种可能的10 和 20
        if(nums == "10" || nums == "20")
            return 1;
        //当0的前面不是1或2时，无法译码，0种
        for(int i = 1; i < nums.length(); i++){
            if(nums.charAt(i) == '0')
                if(nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2')
                    return 0;
        }
        int[] dp = new int[nums.length() + 1];
        //辅助数组初始化为1
        Arrays.fill(dp, 1);
        for(int i = 2; i <= nums.length(); i++){
            //在11-19，21-26之间的情况
            if((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) != '0') || (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) > '0' && nums.charAt(i - 1) < '7'))
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[nums.length()];
    }

    /**
     *  a起始6为0  题型 leetcode
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String nums = String.valueOf(num);
        if (nums == null && nums.length() == 0) return 0;
        int len = nums.length();
        int[] res = new int[len];
        res[len - 1] = 1;
        if (len >= 2) {
            int temp = (nums.charAt(len - 2) - '0')*10 + (nums.charAt(len - 1)-'0');
            if ( temp >= 10 && temp<= 25)
                res[len - 2] = res[len - 1] + 1;
            else
                res[len - 2] = 1;
            for (int i = len - 3; i >= 0; i--) {
                temp = (nums.charAt(i) - '0')*10 + (nums.charAt(i + 1)-'0');
                if (temp >= 10 && temp<= 25)
                    res[i] = res[i + 1] + res[i + 2];
                else res[i] = res[i + 1 ];
            }
        }
        return res[0];
    }

    public static void main(String[] args) {
        No46 no46 = new No46();
        no46.translateNum(220);
    }
}
