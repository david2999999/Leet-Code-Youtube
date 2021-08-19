public class CoinChangeMemoizationApproach {
    private static final int MAX_AMOUNT = 10000;

    public int coinChange(int[] coins, int amount) {
        int minCoins = minCoins(coins, amount, new int[amount + 1]);
        return minCoins <= MAX_AMOUNT ? minCoins : -1;
    }

    private int minCoins(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];

        int minCoins = MAX_AMOUNT + 1;

        for (int c: coins) {
            if (c > amount) continue;

            minCoins = Math.min(minCoins, minCoins(coins, amount - c, memo) + 1);
        }

        return memo[amount] = minCoins;
    }
}