public class StoneGameBottomUp3DApproach {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][][] score = new int[n][n][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int p = 1; p >= 0; p--) {
                    if (i > j) continue;
                    if (i == j) {
                        score[i][j][p] = (p == 0) ? piles[i] : -piles[i];
                        continue;
                    }

                    if (p == 0) {
                        score[i][j][p] = Math.max(
                            score[i + 1][j][1] + piles[i],
                            score[i][j - 1][1] + piles[j]
                        );
                    } else {
                        score[i][j][p] = Math.min(
                            score[i + 1][j][0] - piles[i],
                            score[i][j - 1][0] - piles[j]
                        );
                    }
                }
            }
        }

        return score[0][n - 1][0] > 0;
    }
}