public class MinPathSumBottomUpArrayApproach {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] minSum = new int[n];

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r == m - 1 && c == n - 1) {
                    minSum[c] = grid[r][c];
                    continue;
                }

                int cur = minSum[c];
                minSum[c] = Integer.MAX_VALUE;

                if (r != m - 1) minSum[c] = Math.min(minSum[c], cur + grid[r][c]);
                if (c != n - 1) minSum[c] = Math.min(minSum[c], minSum[c + 1] + grid[r][c]);
            }
        }

        return minSum[0];
    }
}