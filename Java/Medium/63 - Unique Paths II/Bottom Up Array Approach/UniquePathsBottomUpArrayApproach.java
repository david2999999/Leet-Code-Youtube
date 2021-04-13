public class UniquePathsBottomUpArrayApproach {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] paths = new int[n];

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) {
                    paths[c] = 0;
                    continue;
                }

                if (r == m - 1 && c == n - 1) {
                    paths[c] = 1;
                    continue;
                }

                int cur = paths[c];
                paths[c] = 0;

                if (r != m - 1) paths[c] += cur;
                if (c != n - 1) paths[c] += paths[c + 1];
            }
        }

        return paths[0];
    }
}