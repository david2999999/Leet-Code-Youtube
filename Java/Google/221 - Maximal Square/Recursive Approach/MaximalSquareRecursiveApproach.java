public class MaximalSquareRecursiveApproach {
    public int maximalSquare(char[][] matrix) {
        int maxLength = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                maxLength = Math.max(maxLength, maximalSquare(r, c, matrix));
            }
        }

        return maxLength * maxLength;
    }

    private int maximalSquare(int r, int c, char[][] matrix) {
        if (r >= matrix.length || c >= matrix[r].length || matrix[r][c] != '1') return 0;

        return Math.min(
            maximalSquare(r, c + 1, matrix),
            Math.min(
                maximalSquare(r + 1, c, matrix),
                maximalSquare(r + 1, c + 1, matrix)
            )
        ) + 1;
    }
}