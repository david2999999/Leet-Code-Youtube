public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int r = 1; r <= rowIndex; r++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);

            for (int i = 1; i < prev.size(); i++) {
                cur.add(prev.get(i - 1) + prev.get(i));
            }

            cur.add(1);
            prev = cur;
        }

        return prev;
    }
}