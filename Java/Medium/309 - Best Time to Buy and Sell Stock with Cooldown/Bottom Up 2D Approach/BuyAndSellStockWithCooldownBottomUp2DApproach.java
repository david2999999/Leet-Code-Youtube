public class BuyAndSellStockWithCooldownMemoizationApproach {
    public int maxProfit(int[] prices) {
        int[][] profit = new int[prices.length + 1][3];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int s = 2; s >= 0; s--) {
                if (s == 2) {
                    profit[i][s] = profit[i + 1][0];
                } else if (s == 0) {
                    profit[i][s] = Math.max(
                        profit[i + 1][1] - prices[i],
                        profit[i + 1][s]
                    );
                } else {
                    profit[i][s] = Math.max(
                        profit[i + 1][2] + prices[i],
                        profit[i + 1][s]
                    );
                }
            }
        }

        return profit[0][0];
    }
}