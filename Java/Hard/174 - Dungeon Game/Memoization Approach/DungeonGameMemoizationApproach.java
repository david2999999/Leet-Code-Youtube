public class DungeonGameMemoizationApproach {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] memo = new int[m][n];
        return calculateMinimumHP(0, 0, dungeon, m, n, memo);
    }

    private int calculateMinimumHP(int r, int c, int[][] dungeon, int m, int n, int[][] memo) {
        if ((r == m && c == n - 1) || (r == m - 1 && c == n)) return 1;
        if (r >= m || c >= n) return Integer.MAX_VALUE;
        if (memo[r][c] != 0) return memo[r][c];

        int hp1 = calculateMinimumHP(r, c + 1, dungeon, m, n, memo);
        int hp2 = calculateMinimumHP(r + 1, c, dungeon, m, n, memo);
        int health = Math.min(hp1, hp2) - dungeon[r][c];

        return memo[r][c] = health > 0 ? health : 1;
    }
}