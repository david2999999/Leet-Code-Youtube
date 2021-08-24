public class LongestIncreasingPathMemoizationApproach {
    private int[][] DIRECTIONS = {
        { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int result = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                result = Math.max(result, longestIncreasingPath(r, c, matrix, memo));
            }
        }

        return result;
    }

    private int longestIncreasingPath(int r, int c, int[][] matrix, int[][] memo) {
        if (memo[r][c] != 0) return memo[r][c];

        int maxPath = 0;

        for (int[] d: DIRECTIONS) {
            int nr = r + d[0], nc = c + d[1];

            if (nr < 0 || nr >= matrix.length || nc < 0 || nc >= matrix[nr].length ||
                matrix[nr][nc] <= matrix[r][c]) continue;

            maxPath = Math.max(maxPath, longestIncreasingPath(nr, nc, matrix, memo));
        }

        return memo[r][c] = maxPath + 1;
    }
}