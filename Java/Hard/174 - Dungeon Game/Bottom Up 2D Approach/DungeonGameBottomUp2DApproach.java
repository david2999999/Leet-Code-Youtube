public class DungeonGameBottomUp2DApproach {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] minHealth = new int[m + 1][n + 1];

        for (int r = m; r >= 0; r--) {
            for (int c = n; c >= 0; c--) {
                if ((r == m - 1 && c == n) || (r == m && c == n - 1)) {
                    minHealth[r][c] = 1;
                    continue;
                }

                if (r >= m || c >= n) {
                    minHealth[r][c] = Integer.MAX_VALUE;
                    continue;
                }

                minHealth[r][c] = Math.min(minHealth[r][c + 1], minHealth[r + 1][c]) - dungeon[r][c];

                if (minHealth[r][c] <= 0) minHealth[r][c] = 1;
            }
        }

        return minHealth[0][0];
    }
}