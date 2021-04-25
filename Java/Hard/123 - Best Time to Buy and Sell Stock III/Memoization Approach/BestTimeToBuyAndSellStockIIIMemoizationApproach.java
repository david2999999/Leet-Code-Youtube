public class BestTimeToBuyAndSellStockIIIMemoizationApproach {
    public int maxProfit(int[] prices) {
        int[][][] memo = new int[prices.length][2][3];

        for (int r = 0; r < memo.length; r++) {
            for (int c = 0; c < memo[r].length; c++) {
                Arrays.fill(memo[r][c], -1);
            }
        }

        return maxProfit(0, 0, 2, prices, memo);
    }

    private int maxProfit(int i, int s, int t, int[] prices, int[][][] memo) {
        if (i >= prices.length || t == 0) return 0;
        if (memo[i][s][t] != -1) return memo[i][s][t];

        if (s == 0) {
            return memo[i][s][t] = Math.max(
                maxProfit(i + 1, 1, t, prices, memo) - prices[i],
                maxProfit(i + 1, s, t, prices, memo)
            );
        } else {
            return memo[i][s][t] = Math.max(
                maxProfit(i + 1, 0, t - 1, prices, memo) + prices[i],
                maxProfit(i + 1, s, t, prices, memo)
            );
        }
    }
}