public class IntervleavingStringMemoizationApproach {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        return isInterleave(s1, s2, s3, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if (i == s1.length() && j == s2.length()) return true;
        if (memo[i][j] != null) return memo[i][j];

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            if (isInterleave(s1, s2, s3, i + 1, j, memo)) return memo[i][j] = true;
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            if (isInterleave(s1, s2, s3, i, j + 1, memo)) return memo[i][j] = true;
        }

        return memo[i][j] = false;
    }
}