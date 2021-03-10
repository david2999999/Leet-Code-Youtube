public class DistinctSubsequencesRecursiveApproach {
    public int numDistinct(String s, String t) {
        return numDistinct(s, t, 0, 0);
    }

    private int numDistinct(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        int subsequences = numDistinct(s, t, i + 1, j);

        if (s.charAt(i) == t.charAt(j)) {
            subsequences += numDistinct(s, t, i + 1, j + 1);
        }

        return subsequences;
    }
}