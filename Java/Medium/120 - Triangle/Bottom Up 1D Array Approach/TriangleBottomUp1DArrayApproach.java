public class TriangleBottomUp1DArrayApproach {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] minSum = new int[triangle.size()];

        for (int r = triangle.size() - 1; r >= 0; r--) {
            int prev = (r == triangle.size() - 1) ? 0 : minSum[r + 1];

            for (int c = r; c >= 0; c--) {
                if (r == triangle.size() - 1) {
                    prev = minSum[c];
                    minSum[c] = triangle.get(r).get(c);
                    continue;
                }

                int cur = minSum[c];
                minSum[c] = Math.min(cur, prev) + triangle.get(r).get(c);
                prev = cur;
            }
        }

        return minSum[0];
    }
}