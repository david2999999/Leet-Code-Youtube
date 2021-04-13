public class IntervleavingStringBottomUp2DMatrixApproach {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] canInterleave = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() && j == s2.length()) {
                    canInterleave[i][j] = true;
                    continue;
                }

                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
                    if (canInterleave[i + 1][j]) {
                        canInterleave[i][j] = true;
                        continue;
                    }
                }

                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
                    if (canInterleave[i][j + 1]) {
                        canInterleave[i][j] = true;
                        continue;
                    }
                }
            }
        }

        return canInterleave[0][0];
    }
}