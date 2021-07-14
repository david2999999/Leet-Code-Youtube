public class StoneGameRecursiveApproach {
    public boolean stoneGame(int[] piles) {
        return stoneGame(piles, 0, 0, piles.length - 1) > 0;
    }

    private int stoneGame(int[] piles, int p, int i, int j) {
        if (i > j) return 0;

        if (p == 0) {
            return Math.max(
                stoneGame(piles, 1, i + 1, j) + piles[i],
                stoneGame(piles, 1, i, j - 1) + piles[j]
            );
        } else {
            return Math.min(
                stoneGame(piles, 0, i + 1, j) - piles[i],
                stoneGame(piles, 0, i, j - 1) - piles[j]
            );
        }
    }
}