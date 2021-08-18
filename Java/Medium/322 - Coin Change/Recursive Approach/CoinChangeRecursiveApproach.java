public class CoinChangeRecursiveApproach {
    private static final int MAX_AMOUNT = 10000;

    public int coinChange(int[] coins, int amount) {
        int minCoins = minCoins(coins, amount);
        return minCoins <= MAX_AMOUNT ? minCoins : -1;
    }

    private int minCoins(int[] coins, int amount) {
        if (amount == 0) return 0;

        int minCoins = MAX_AMOUNT + 1;

        for (int c: coins) {
            if (c > amount) continue;

            minCoins = Math.min(minCoins, minCoins(coins, amount - c) + 1);
        }

        return minCoins;
    }
}