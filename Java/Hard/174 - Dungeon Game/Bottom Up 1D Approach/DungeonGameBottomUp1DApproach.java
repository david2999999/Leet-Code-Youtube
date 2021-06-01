public class DungeonGameBottomUp1DApproach {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] minHealth = new int[n + 1];

        for (int r = m; r >= 0; r--) {
            for (int c = n; c >= 0; c--) {
                if ((r == m - 1 && c == n) || (r == m && c == n - 1)) {
                    minHealth[c] = 1;
                    continue;
                }

                if (r >= m || c >= n) {
                    minHealth[c] = Integer.MAX_VALUE;
                    continue;
                }

                minHealth[c] = Math.min(minHealth[c + 1], minHealth[c]) - dungeon[r][c];

                if (minHealth[c] <= 0) minHealth[c] = 1;
            }
        }

        return minHealth[0];
    }
}