public class UniquePathsRecursiveApproach {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(0, 0, obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
    }

    private int uniquePathsWithObstacles(int r, int c, int[][] grid, int m, int n) {
        if (r >= m || c >= n || grid[r][c] == 1) return 0;
        if (r == m - 1 && c == n - 1) return 1;

        return uniquePathsWithObstacles(r, c + 1, grid, m, n) +
               uniquePathsWithObstacles(r + 1, c, grid, m, n);
    }
}