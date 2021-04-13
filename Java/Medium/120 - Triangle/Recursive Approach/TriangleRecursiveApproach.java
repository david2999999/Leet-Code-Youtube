public class TriangleRecursiveApproach {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(0, 0, triangle);
    }

    private int minimumTotal(int r, int c, List<List<Integer>> triangle) {
        if (r == triangle.size() - 1) return triangle.get(r).get(c);

        int sum1 = minimumTotal(r + 1, c , triangle);
        int sum2 = minimumTotal(r + 1, c + 1, triangle);

        return Math.min(sum1, sum2) + triangle.get(r).get(c);
    }
}