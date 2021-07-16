public class StoneGameBottomUp2DApproach {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] score = new int[n][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int prev = 0;

                for (int p = 1; p >= 0; p--) {
                    if (i > j) continue;
                    if (i == j) {
                        prev = score[j][p];
                        score[j][p] = (p == 0) ? piles[i] : -piles[i];
                        continue;
                    }

                    int cur = score[j][p];

                    if (p == 0) {
                        score[j][p] = Math.max(
                            prev + piles[i],
                            score[j - 1][1] + piles[j]
                        );
                    } else {
                        score[j][p] = Math.min(
                            score[j][0] - piles[i],
                            score[j - 1][0] - piles[j]
                        );
                    }

                    prev = cur;
                }
            }
        }

        return score[n - 1][0] > 0;
    }
}