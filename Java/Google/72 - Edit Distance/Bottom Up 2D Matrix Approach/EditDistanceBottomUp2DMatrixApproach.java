public class EditDistanceBottomUp2DMatrixApproach {
    public int minDistance(String word1, String word2) {
        int[][] minOps = new int[word1.length() + 1][word2.length() + 1];

        for (int i = word1.length(); i >= 0; i--) {
            for (int j = word2.length(); j >= 0; j--) {
                if (i == word1.length() && j == word2.length()) continue;

                if (i == word1.length()) {
                    minOps[i][j] = word2.length() - j;
                    continue;
                }

                if (j == word2.length()) {
                    minOps[i][j] = word1.length() - i;
                    continue;
                }

                if (word1.charAt(i) == word2.charAt(j)) {
                    minOps[i][j] = minOps[i + 1][j + 1];
                } else {
                    minOps[i][j] = Math.min(
                            minOps[i + 1][j + 1],
                            Math.min(minOps[i + 1][j], minOps[i][j + 1])
                    ) + 1;
                }
            }
        }

        return minOps[0][0];
    }
}