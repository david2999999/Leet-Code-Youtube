public class UniquePathsMemoizationApproach {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];

        for (int r = 0; r < memo.length; r++) {
            Arrays.fill(memo[r], -1);
        }

        return uniquePathsWithObstacles(0, 0, obstacleGrid, m, n, memo);
    }

    private int uniquePathsWithObstacles(int r, int c, int[][] grid, int m, int n, int[][] memo) {
        if (r >= m || c >= n || grid[r][c] == 1) return 0;
        if (r == m - 1 && c == n - 1) return 1;
        if (memo[r][c] != -1) return memo[r][c];

        return memo[r][c] = uniquePathsWithObstacles(r, c + 1, grid, m, n, memo) +
                uniquePathsWithObstacles(r + 1, c, grid, m, n, memo);
    }
}