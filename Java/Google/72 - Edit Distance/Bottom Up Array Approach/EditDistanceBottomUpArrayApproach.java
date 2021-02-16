public class EditDistanceBottomUpArrayApproach {
    public int minDistance(String word1, String word2) {
        int[] minOps = new int[word2.length() + 1];

        for (int i = word1.length(); i >= 0; i--) {
            int prev = 0;

            for (int j = word2.length(); j >= 0; j--) {
                if (i == word1.length() && j == word2.length()) continue;

                if (i == word1.length()) {
                    prev = minOps[j];
                    minOps[j] = word2.length() - j;
                    continue;
                }

                if (j == word2.length()) {
                    prev = minOps[j];
                    minOps[j] = word1.length() - i;
                    continue;
                }

                int cur = minOps[j];

                if (word1.charAt(i) == word2.charAt(j)) {
                    minOps[j] = prev;
                } else {
                    minOps[j] = Math.min(prev, Math.min(minOps[j], minOps[j + 1])) + 1;
                }

                prev = cur;
            }
        }

        return minOps[0];
    }
}