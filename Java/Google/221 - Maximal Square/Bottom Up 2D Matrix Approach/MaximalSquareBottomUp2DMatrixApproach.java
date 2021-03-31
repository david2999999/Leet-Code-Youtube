public class MaximalSquareBottomUp2DMatrixApproach {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length, maxLength = 0;
        int[][] length = new int[m + 1][n + 1];

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (matrix[r][c] == '0') continue;

                length[r][c] = Math.min(
                    length[r + 1][c],
                    Math.min(length[r][c + 1], length[r + 1][c + 1])
                ) + 1;

                maxLength = Math.max(maxLength, length[r][c]);
            }
        }

        return maxLength * maxLength;
    }
}