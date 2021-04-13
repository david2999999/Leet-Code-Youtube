public class ZeroOneMatrix {
    private static final int MAX_DISTANCE = 10000;

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] distance = new int[m][n];

        for (int r = 0; r < m; r++) {
            Arrays.fill(distance[r], MAX_DISTANCE);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    distance[r][c] = 0;
                    continue;
                }

                if (r > 0) distance[r][c] = Math.min(distance[r][c], distance[r - 1][c] + 1);
                if (c > 0) distance[r][c] = Math.min(distance[r][c], distance[r][c - 1] + 1);
            }
        }

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r != m - 1) distance[r][c] = Math.min(distance[r][c], distance[r + 1][c] + 1);
                if (c != n - 1) distance[r][c] = Math.min(distance[r][c], distance[r][c + 1] + 1);
            }
        }

        return distance;
    }
}