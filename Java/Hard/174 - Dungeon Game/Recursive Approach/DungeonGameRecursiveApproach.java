public class DungeonGameRecursiveApproach {
    public int calculateMinimumHP(int[][] dungeon) {
        return calculateMinimumHP(0, 0, dungeon, dungeon.length, dungeon[0].length);
    }

    private int calculateMinimumHP(int r, int c, int[][] dungeon, int m, int n) {
        if ((r == m && c == n - 1) || (r == m - 1 && c == n)) return 1;
        if (r >= m || c >= n) return Integer.MAX_VALUE;

        int hp1 = calculateMinimumHP(r, c + 1, dungeon, m, n);
        int hp2 = calculateMinimumHP(r + 1, c, dungeon, m, n);
        int health = Math.min(hp1, hp2) - dungeon[r][c];

        return health > 0 ? health : 1;
    }
}