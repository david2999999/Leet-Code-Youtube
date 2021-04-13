public class MaximalSquareBottomUp1DArrayApproach {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length, maxLength = 0;
        int[] length = new int[n + 1];

        for (int r = m - 1; r >= 0; r--) {
            int prev = 0;

            for (int c = n - 1; c >= 0; c--) {
                if (matrix[r][c] == '0') {
                    prev = length[c];
                    length[c] = 0;
                    continue;
                }

                int cur = length[c];
                length[c] = Math.min(
                    length[c],
                    Math.min(length[c + 1], prev)
                ) + 1;

                maxLength = Math.max(maxLength, length[c]);
                prev = cur;
            }
        }

        return maxLength * maxLength;
    }
}