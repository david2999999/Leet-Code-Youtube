public class UniquePathsMemoizationApproach {
    public int uniquePaths(int m, int n) {
        return uniquePaths(m, n, new int[m + 1][n + 1]);
    }

    private int uniquePaths(int m, int n, int[][] memo) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        if (memo[m][n] != 0) return memo[m][n];

        return memo[m][n] = uniquePaths(m, n - 1, memo) +
                            uniquePaths(m - 1, n, memo);
    }
}