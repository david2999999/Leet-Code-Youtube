public class BestTimeToBuyAndSellStockIVRecursiveApproach {
    public int maxProfit(int k, int[] prices) {
        return maxProfit(0, 0, k, prices);
    }

    private int maxProfit(int i, int s, int k, int[] prices) {
        if (i >= prices.length || k == 0) return 0;

        if (s == 0) {
            return Math.max(
                maxProfit(i + 1, 1, k, prices) - prices[i],
                maxProfit(i + 1, s, k, prices)
            );
        } else {
            return Math.max(
                maxProfit(i + 1, 0, k - 1, prices) + prices[i],
                maxProfit(i + 1, s, k, prices)
            );
        }
    }
}