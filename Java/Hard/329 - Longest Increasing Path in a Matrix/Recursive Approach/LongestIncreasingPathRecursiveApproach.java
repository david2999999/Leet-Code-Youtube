public class LongestIncreasingPathRecursiveApproach {
    private int[][] DIRECTIONS = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                result = Math.max(result, longestIncreasingPath(r, c, matrix));
            }
        }

        return result;
    }

    private int longestIncreasingPath(int r, int c, int[][] matrix) {
        int maxPath = 0;

        for (int[] d: DIRECTIONS) {
            int nr = r + d[0], nc = c + d[1];

            if (nr < 0 || nr >= matrix.length || nc < 0 || nc >= matrix[nr].length ||
                matrix[nr][nc] <= matrix[r][c]) continue;

            maxPath = Math.max(maxPath, longestIncreasingPath(nr, nc, matrix));
        }

        return maxPath + 1;
    }
}