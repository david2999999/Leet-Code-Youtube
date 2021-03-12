public class DistinctSubsequencesBottomUp2DMatrixApproach {
    public int numDistinct(String s, String t) {
        int[][] subsequences = new int[s.length() + 1][t.length() + 1];

        for (int i = s.length(); i >= 0; i--) {
            for (int j = t.length(); j >= 0; j--) {
                if (j == t.length()) {
                    subsequences[i][j] = 1;
                    continue;
                }

                if (i == s.length()) continue;

                subsequences[i][j] += subsequences[i + 1][j];

                if (s.charAt(i) == t.charAt(j)) {
                    subsequences[i][j] += subsequences[i + 1][j + 1];
                }
            }
        }

        return subsequences[0][0];
    }
}