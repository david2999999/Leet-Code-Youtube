public class BestTimeToBuyAndSellStockIIIBottomUp3DApproach {
    public int maxProfit(int[] prices) {
        int[][][] maxProfit = new int[prices.length + 1][2][3];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int state = 1; state >= 0; state--) {
                for (int t = 1; t <= 2; t++) {
                    if (state == 0) {
                        maxProfit[i][state][t] =
                            Math.max(maxProfit[i + 1][1][t] - prices[i], maxProfit[i + 1][state][t]);
                    } else {
                        maxProfit[i][state][t] =
                            Math.max(maxProfit[i + 1][0][t - 1] + prices[i], maxProfit[i + 1][state][t]);
                    }
                }
            }
        }

        return maxProfit[0][0][2];
    }
}