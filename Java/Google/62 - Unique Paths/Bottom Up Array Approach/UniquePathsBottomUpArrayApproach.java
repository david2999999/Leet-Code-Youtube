public class UniquePathsBottomUpArrayApproach {
    public int uniquePaths(int m, int n) {
        int[] ways = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    ways[j] = 1;
                    continue;
                }

                ways[j] = ways[j - 1] + ways[j];
            }
        }

        return ways[n];
    }
}