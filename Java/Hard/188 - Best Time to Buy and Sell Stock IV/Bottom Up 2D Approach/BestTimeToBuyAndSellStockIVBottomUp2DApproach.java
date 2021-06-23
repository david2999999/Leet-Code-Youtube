public class BestTimeToBuyAndSellStockIVBottomUp2DApproach {
    public int maxProfit(int k, int[] prices) {
        int[][] profit = new int[2][k + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int s = 1; s >= 0; s--) {
                for (int j = 1; j <= k; j++) {
                    if (s == 0) {
                        profit[s][j] = Math.max(
                            profit[1][j] - prices[i],
                            profit[s][j]
                        );
                    } else {
                        profit[s][j] = Math.max(
                            profit[0][j - 1] + prices[i],
                            profit[s][j]
                        );
                    }
                }
            }
        }

        return profit[0][k];
    }
}