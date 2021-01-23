public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int i = 0, profit = 0;

        while (i < prices.length) {
            while (i != prices.length - 1 && prices[i + 1] <= prices[i]) i++;

            int valley = prices[i];

            while (i != prices.length - 1 && prices[i + 1] >= prices[i]) i++;

            profit += (prices[i++] - valley);
        }

        return profit;
    }
}