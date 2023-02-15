package hackerRankProblems;

public class maxProfitSingleTrade {

    public int maxProfit(int[] prices) {
        int leastPrice = Integer.MAX_VALUE;
        int overallProfit = 0;
        int currentProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastPrice) {
                leastPrice = prices[i];
            }
            currentProfit = prices[i] - leastPrice;
            if (overallProfit < currentProfit) {
                overallProfit = currentProfit;
            }
        }
        return overallProfit;
    }
}
