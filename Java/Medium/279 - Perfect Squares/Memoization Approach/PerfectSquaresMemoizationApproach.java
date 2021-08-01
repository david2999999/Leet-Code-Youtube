public class PerfectSquaresMemoizationApproach {
    public int numSquares(int n) {
        return numSquares(n, new int[n + 1]);
    }

    private int numSquares(int n, int[] memo) {
        if (n == 0) return 0;
        if (memo[n] != 0) return memo[n];

        int minSquares = Integer.MAX_VALUE;

        for (int k = 1; k * k <= n; k++) {
            minSquares = Math.min(minSquares, numSquares(n - k * k, memo) + 1);
        }

        return memo[n] = minSquares;
    }
}