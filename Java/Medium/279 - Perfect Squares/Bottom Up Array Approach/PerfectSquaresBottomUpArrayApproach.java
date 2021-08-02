public class PerfectSquaresBottomUpArrayApproach {
    public int numSquares(int n) {
        int[] minSquares = new int[n + 1];

        for (int m = 1; m <= n; m++) {
            minSquares[m] = Integer.MAX_VALUE;

            for (int k = 1; k * k <= m; k++) {
                minSquares[m] = Math.min(minSquares[m], minSquares[m - k * k] + 1);
            }
        }

        return minSquares[n];
    }
}