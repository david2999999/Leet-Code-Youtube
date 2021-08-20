public class CoinChangeBottomUpArrayApproach {
    private static final int MAX_AMOUNT = 10000;

    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];

        for (int a = 1; a <= amount; a++) {
            minCoins[a] = MAX_AMOUNT + 1;

            for (int c: coins) {
                if (c > a) continue;

                minCoins[a] = Math.min(minCoins[a], minCoins[a - c] + 1);
            }
        }

        return minCoins[amount] <= MAX_AMOUNT ? minCoins[amount] : -1;
    }
}