public class IntervleavingStringBottomUpArrayApproach {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[] canInterleave = new boolean[s2.length() + 1];

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() && j == s2.length()) {
                    canInterleave[j] = true;
                    continue;
                }

                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
                    if (canInterleave[j]) {
                        continue;
                    }
                }

                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
                    if (canInterleave[j + 1]) {
                        canInterleave[j] = true;
                        continue;
                    }
                }

                canInterleave[j] = false;
            }
        }

        return canInterleave[0];
    }
}