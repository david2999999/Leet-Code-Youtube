public class MinPathSumBottomUp2DMatrixApproach {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m][n];

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r == m - 1 && c == n - 1) {
                    minSum[r][c] = grid[r][c];
                    continue;
                }

                minSum[r][c] = Integer.MAX_VALUE;

                if (r != m - 1) minSum[r][c] = Math.min(minSum[r][c], minSum[r + 1][c] + grid[r][c]);
                if (c != n - 1) minSum[r][c] = Math.min(minSum[r][c], minSum[r][c + 1] + grid[r][c]);
            }
        }

        return minSum[0][0];
    }
}