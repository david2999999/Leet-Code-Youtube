public class TriangleBottomUp2DMatrixApproach {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] minSum = new int[triangle.size()][triangle.size()];

        for (int r = triangle.size() - 1; r >= 0; r--) {
            for (int c = r; c >= 0; c--) {
                if (r == triangle.size() - 1) {
                    minSum[r][c] = triangle.get(r).get(c);
                    continue;
                }

                minSum[r][c] =
                        Math.min(minSum[r + 1][c], minSum[r + 1][c + 1]) + triangle.get(r).get(c);
            }
        }

        return minSum[0][0];
    }
}