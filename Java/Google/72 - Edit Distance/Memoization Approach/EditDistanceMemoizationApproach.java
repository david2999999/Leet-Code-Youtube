public class EditDistanceMemoizationApproach {
    public int minDistance(String word1, String word2) {
        return minDistance(0, 0, word1, word2, new int[word1.length()][word2.length()]);
    }

    private int minDistance(int i, int j, String word1, String word2, int[][] memo) {
        if (i == word1.length() && j == word2.length()) return 0;
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;
        if (memo[i][j] != 0) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = minDistance(i + 1, j + 1, word1, word2, memo);
        } else {
            return memo[i][j] = Math.min(
                minDistance(i, j + 1, word1, word2, memo),
                Math.min(
                        minDistance(i + 1, j, word1, word2, memo),
                        minDistance(i + 1, j + 1, word1, word2, memo)
                )
            ) + 1;
        }
    }
}