import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 连续子数组的最大和
 * @date 2022/5/10 20:34
 **/
public class No85 {
    public int[] FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int max=array[0];
        int left=0, right=0, begin=0, end=0, length=array.length;
        int[] dp = new int[length];
        dp[0]=array[0];
        for(int i=1; i<length; i++){
            right++;
            dp[i] = Math.max(array[i]+dp[i-1], array[i]);
            if (array[i]+dp[i-1] < array[i])
                left = i;
            // dp[i] ==max 的时候 才需要比较长度
            if (dp[i]>max || dp[i]==max && (right-left)>(end-begin)){
                begin=left;
                end=right;
                max = dp[i];
            }
        }
        int[] resArray = new int[end-begin+1];
        for(int i=begin; i<=end; i++){
            resArray[i-begin] = array[i];
        }
        return resArray;
    }

    public int[] FindGreatestSumOfSubArray1 (int[] array) {
        // write code here
        //记录到下标i为止的最大连续子数组和
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxsum = dp[0];
        //滑动区间
        int left = 0, right = 0;
        //记录最长的区间
        int resl = 0, resr = 0;
        for(int i = 1; i < array.length; i++){
            right++;
            //状态转移：连续子数组和最大值
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            //区间新起点
            if(dp[i - 1] + array[i] < array[i])
                left = right;
            //更新最大值
            if(dp[i] > maxsum || dp[i] == maxsum && (right - left ) > (resr - resl )){
                maxsum = dp[i];
                resl = left;
                resr = right;
            }
        }
        //取数组
        int[] res = new int[resr - resl + 1];
        for(int i = resl; i <= resr; i++)
            res[i - resl] = array[i];
        return res;
    }

    /**
     * 连续子数组的最大和 Ⅰ
     * @param nums
     * @return
     */
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i=1; i<nums.length; i++){
                if(dp[i-1]+nums[i]>nums[i])
                    dp[i] = dp[i-1]+nums[i];
                else
                    dp[i] = nums[i];
                res = Math.max(dp[i], res);
            }
            return res;
        }



    @Test
    public void test(){
        No85 no85 = new No85();
        no85.FindGreatestSumOfSubArray1(new int[]{-1,3,2,1,-2,-2,-3,0,3,2,1,-1});
        no85.maxSubArray(new int[]{-1,3,2,1,-2,-2,-3,0,3,2,1,-1});
    }
}

