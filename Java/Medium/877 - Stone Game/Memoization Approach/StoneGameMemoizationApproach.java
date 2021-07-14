public class StoneGameMemoizationApproach {
    public boolean stoneGame(int[] piles) {
        int[][][] memo = new int[2][piles.length][piles.length];
        return stoneGame(piles, 0, 0, piles.length - 1, memo) > 0;
    }

    private int stoneGame(int[] piles, int p, int i, int j, int[][][] memo) {
        if (i > j) return 0;
        if (memo[p][i][j] != 0) return memo[p][i][j];

        if (p == 0) {
            return memo[p][i][j] = Math.max(
                stoneGame(piles, 1, i + 1, j, memo) + piles[i],
                stoneGame(piles, 1, i, j - 1, memo) + piles[j]
            );
        } else {
            return memo[p][i][j] = Math.min(
                stoneGame(piles, 0, i + 1, j, memo) - piles[i],
                stoneGame(piles, 0, i, j - 1, memo) - piles[j]
            );
        }
    }
}