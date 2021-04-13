public class TriangleMemoizationApproach {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(0, 0, triangle, new int[triangle.size()][triangle.size()]);
    }

    private int minimumTotal(int r, int c, List<List<Integer>> triangle, int[][] memo) {
        if (r == triangle.size() - 1) return triangle.get(r).get(c);
        if (memo[r][c] != 0) return memo[r][c];

        int sum1 = minimumTotal(r + 1, c , triangle, memo);
        int sum2 = minimumTotal(r + 1, c + 1, triangle, memo);

        return memo[r][c] = Math.min(sum1, sum2) + triangle.get(r).get(c);
    }
}