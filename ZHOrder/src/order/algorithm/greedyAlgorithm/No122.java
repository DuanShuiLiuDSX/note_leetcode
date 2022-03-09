package order.algorithm.greedyAlgorithm;

/**
 * @author cz
 * @Description 买卖股票的最好时机
 * @date 2022/3/2 9:05
 **/
public class No122 {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit=0, buy=prices[0];
            for (int i=1; i<prices.length; i++){
                if (prices[i] < buy){
                    buy = prices[i];
                }else if (prices[i] > buy){
                    profit += prices[i] -buy;
                    buy = prices[i];
                }

            }

            return profit;
        }
    }
}
