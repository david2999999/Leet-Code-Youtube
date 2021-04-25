public class BestTimeToBuyAndSellStockIIIRecursiveApproach {
    public int maxProfit(int[] prices) {
        return maxProfit(0, 0, 2, prices);
    }

    private int maxProfit(int i, int s, int t, int[] prices) {
        if (i >= prices.length || t == 0) return 0;

        if (s == 0) {
            return Math.max(
                maxProfit(i + 1, 1, t, prices) - prices[i],
                maxProfit(i + 1, s, t, prices)
            );
        } else {
            return Math.max(
                maxProfit(i + 1, 0, t - 1, prices) + prices[i],
                maxProfit(i + 1, s, t, prices)
            );
        }
    }
}