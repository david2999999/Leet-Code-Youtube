public class DistinctSubsequencesBottomUp1DArrayApproach {
    public int numDistinct(String s, String t) {
        int[] subsequences = new int[t.length() + 1];

        for (int i = s.length(); i >= 0; i--) {
            int prev = 0;

            for (int j = t.length(); j >= 0; j--) {
                if (j == t.length()) {
                    prev = subsequences[j];
                    subsequences[j] = 1;
                    continue;
                }

                if (i == s.length()) {
                    prev = subsequences[j];
                    subsequences[j] = 0;
                    continue;
                }

                int cur = subsequences[j];

                if (s.charAt(i) == t.charAt(j)) {
                    subsequences[j] += prev;
                }

                prev = cur;
            }
        }

        return subsequences[0];
    }
}