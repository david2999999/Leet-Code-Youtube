public class MinPathSumRecursiveApproach {
    public int minPathSum(int[][] grid) {
        return minPathSum(0, 0, grid);
    }

    private int minPathSum(int r, int c, int[][] grid) {
        if (r == grid.length - 1 && c == grid[r].length - 1) return grid[r][c];

        int minSum = Integer.MAX_VALUE;

        if (r != grid.length - 1) {
            minSum = Math.min(minSum, minPathSum(r + 1, c, grid) + grid[r][c]);
        }

        if (c != grid[r].length - 1) {
            minSum = Math.min(minSum, minPathSum(r, c + 1, grid) + grid[r][c]);
        }

        return minSum;
    }
}