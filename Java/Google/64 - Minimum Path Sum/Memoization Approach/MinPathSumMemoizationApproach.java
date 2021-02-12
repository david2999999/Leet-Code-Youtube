public class MinPathSumMemoizationApproach {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return minPathSum(0, 0, grid, new int[m][n]);
    }

    private int minPathSum(int r, int c, int[][] grid, int[][] memo) {
        if (r == grid.length - 1 && c == grid[r].length - 1) return grid[r][c];
        if (memo[r][c] != 0) return memo[r][c];

        int minSum = Integer.MAX_VALUE;

        if (r != grid.length - 1) {
            minSum = Math.min(minSum, minPathSum(r + 1, c, grid, memo) + grid[r][c]);
        }

        if (c != grid[r].length - 1) {
            minSum = Math.min(minSum, minPathSum(r, c + 1, grid, memo) + grid[r][c]);
        }

        return memo[r][c] = minSum;
    }
}