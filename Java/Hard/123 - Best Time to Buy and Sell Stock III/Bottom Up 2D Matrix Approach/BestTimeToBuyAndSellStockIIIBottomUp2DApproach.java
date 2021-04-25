public class BestTimeToBuyAndSellStockIIIBottomUp2DApproach {
    public int maxProfit(int[] prices) {
        int[][] maxProfit = new int[2][3];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int state = 1; state >= 0; state--) {
                for (int t = 1; t <= 2; t++) {
                    if (state == 0) {
                        maxProfit[state][t] =
                            Math.max(maxProfit[1][t] - prices[i], maxProfit[state][t]);
                    } else {
                        maxProfit[state][t] =
                            Math.max(maxProfit[0][t - 1] + prices[i], maxProfit[state][t]);
                    }
                }
            }
        }

        return maxProfit[0][2];
    }
}