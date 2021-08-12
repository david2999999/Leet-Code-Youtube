public class BuyAndSellStockWithCooldownRecursiveApproach {
    public int maxProfit(int[] prices) {
        return maxProfit(0, 0, prices);
    }

    private int maxProfit(int i, int s, int[] prices) {
        if (i >= prices.length) return 0;
        if (s == 2) return maxProfit(i + 1, 0, prices);

        if (s == 0) {
            return Math.max(
                maxProfit(i + 1, 1, prices) - prices[i],
                maxProfit(i + 1, s, prices)
            );
        } else {
            return Math.max(
                maxProfit(i + 1, 2, prices) + prices[i],
                maxProfit(i + 1, s, prices)
            );
        }
    }
}