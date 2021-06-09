public class BestTimeToBuyAndSellStockIVBottomUp3DApproach {
    public int maxProfit(int k, int[] prices) {
        int[][][] profit = new int[prices.length + 1][2][k + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int s = 1; s >= 0; s--) {
                for (int j = 1; j <= k; j++) {
                    if (s == 0) {
                        profit[i][s][j] = Math.max(
                            profit[i + 1][1][j] - prices[i],
                            profit[i + 1][s][j]
                        );
                    } else {
                        profit[i][s][j] = Math.max(
                            profit[i + 1][0][j - 1] + prices[i],
                            profit[i + 1][s][j]
                        );
                    }
                }
            }
        }

        return profit[0][0][k];
    }
}