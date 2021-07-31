public class PerfectSquaresRecursiveApproach {
    public int numSquares(int n) {
        if (n == 0) return 0;

        int minSquares = Integer.MAX_VALUE;

        for (int k = 1; k * k <= n; k++) {
            minSquares = Math.min(minSquares, numSquares(n - k * k) + 1);
        }

        return minSquares;
    }
}