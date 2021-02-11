public class UniquePathsBottomUp2DMatrixApproach {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) continue;

                if (r == m - 1 && c == n - 1) {
                    paths[r][c] = 1;
                    continue;
                }

                if (r != m - 1) paths[r][c] += paths[r + 1][c];
                if (c != n - 1) paths[r][c] += paths[r][c + 1];
            }
        }

        return paths[0][0];
    }
}