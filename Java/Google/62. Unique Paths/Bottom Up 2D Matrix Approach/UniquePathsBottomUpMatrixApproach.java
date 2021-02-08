public class UniquePathsBottomUpMatrixApproach {
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    ways[i][j] = 1;
                    continue;
                }

                ways[i][j] = ways[i][j - 1] + ways[i - 1][j];
            }
        }

        return ways[m][n];
    }
}