public class BuyAndSellStockWithCooldownBottomUp1DApproach {
    public int maxProfit(int[] prices) {
        int[] profit = new int[3];

        for (int i = prices.length - 1; i >= 0; i--) {
            int prev = 0;

            for (int s = 2; s >= 0; s--) {
                int cur = profit[s];

                if (s == 2) {
                    profit[s] = profit[0];
                } else if (s == 0) {
                    profit[s] = Math.max(prev - prices[i], profit[s]);
                } else { // s == 1
                    profit[s] = Math.max(prev + prices[i], profit[s]);
                }

                prev = cur;
            }
        }

        return profit[0];
    }
}