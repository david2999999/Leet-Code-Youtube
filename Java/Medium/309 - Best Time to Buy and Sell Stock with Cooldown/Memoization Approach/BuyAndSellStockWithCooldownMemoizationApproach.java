public class BuyAndSellStockWithCooldownMemoizationApproach {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][3];

        for (int r = 0; r < memo.length; r++) Arrays.fill(memo[r], -1);

        return maxProfit(0, 0, prices, memo);
    }

    private int maxProfit(int i, int s, int[] prices, int[][] memo) {
        if (i >= prices.length) return 0;
        if (s == 2) return maxProfit(i + 1, 0, prices, memo);
        if (memo[i][s] != -1) return memo[i][s];

        if (s == 0) {
            return memo[i][s] = Math.max(
                maxProfit(i + 1, 1, prices, memo) - prices[i],
                maxProfit(i + 1, s, prices, memo)
            );
        } else {
            return memo[i][s] = Math.max(
                maxProfit(i + 1, 2, prices, memo) + prices[i],
                maxProfit(i + 1, s, prices, memo)
            );
        }
    }
}