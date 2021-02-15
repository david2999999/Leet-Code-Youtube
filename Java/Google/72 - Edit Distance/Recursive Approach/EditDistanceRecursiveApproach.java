public class EditDistanceRecursiveApproach {
    public int minDistance(String word1, String word2) {
        return minDistance(0, 0, word1, word2);
    }

    private int minDistance(int i, int j, String word1, String word2) {
        if (i == word1.length() && j == word2.length()) return 0;
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistance(i + 1, j + 1, word1, word2);
        } else {
            return Math.min(
                    minDistance(i, j + 1, word1, word2),
                    Math.min(
                        minDistance(i + 1, j, word1, word2),
                        minDistance(i + 1, j + 1, word1, word2)
                    )
            ) + 1;
        }
    }
}