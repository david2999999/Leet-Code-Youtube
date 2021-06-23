public class BestTimeToBuyAndSellStockIVMemoizationApproach {
    public int maxProfit(int k, int[] prices) {
        int[][][] memo = new int[prices.length][2][k + 1];

        for (int r = 0; r < memo.length; r++) {
            for (int c = 0; c < memo[r].length; c++) {
                Arrays.fill(memo[r][c], -1);
            }
        }

        return maxProfit(0, 0, k, prices, memo);
    }

    private int maxProfit(int i, int s, int k, int[] prices, int[][][] memo) {
        if (i >= prices.length || k == 0) return 0;
        if (memo[i][s][k] != -1) return memo[i][s][k];

        if (s == 0) {
            return memo[i][s][k] = Math.max(
                maxProfit(i + 1, 1, k, prices, memo) - prices[i],
                maxProfit(i + 1, s, k, prices, memo)
            );
        } else {
            return memo[i][s][k] = Math.max(
                maxProfit(i + 1, 0, k - 1, prices, memo) + prices[i],
                maxProfit(i + 1, s, k, prices, memo)
            );
        }
    }
}