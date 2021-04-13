public class MaximalSquareMemoizationApproach {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int[][] memo = new int[matrix.length][matrix[0].length];
        int maxLength = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                maxLength = Math.max(maxLength, maximalSquare(r, c, matrix, memo));
            }
        }

        return maxLength * maxLength;
    }

    private int maximalSquare(int r, int c, char[][] matrix, int[][] memo) {
        if (r >= matrix.length || c >= matrix[r].length || matrix[r][c] != '1') return 0;
        if (memo[r][c] != 0) return memo[r][c];

        return memo[r][c] = Math.min(
            maximalSquare(r, c + 1, matrix, memo),
            Math.min(
                maximalSquare(r + 1, c, matrix, memo),
                maximalSquare(r + 1, c + 1, matrix, memo)
            )
        ) + 1;
    }
}