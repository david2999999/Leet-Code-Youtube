public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        generate(numRows, result);
        return result;
    }

    private List<Integer> generate(int r, List<List<Integer>> result) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);

        if (r == 1) {
            result.add(cur);
            return cur;
        }

        List<Integer> prev = generate(r - 1, result);

        for (int i = 1; i < prev.size(); i++) {
            cur.add(prev.get(i - 1) + prev.get(i));
        }

        cur.add(1);
        result.add(cur);

        return cur;
    }
}