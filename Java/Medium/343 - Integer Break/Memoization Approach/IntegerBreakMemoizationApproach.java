public class IntegerBreakMemoizationApproach {
    public int integerBreak(int n) {
        return integerBreak(n, new int[n + 1]);
    }

    private int integerBreak(int n, int[] memo) {
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n];

        int maxProduct = 0;

        for (int x = 1; x < n; x++) {
            int y = n - x;
            int p1 = integerBreak(x, memo);
            int p2 = integerBreak(y, memo);
            maxProduct = Math.max(maxProduct, Math.max(x, p1) * Math.max(y, p2));
        }

        return memo[n] = maxProduct;
    }
}