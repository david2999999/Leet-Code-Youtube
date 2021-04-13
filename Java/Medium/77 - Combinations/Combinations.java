public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void combine(int i, int n, int k, List<Integer> comb, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int x = i; x <= n; x++) {
            comb.add(x);
            combine(x + 1, n, k - 1, comb, result);
            comb.remove(comb.size() - 1);
        }
    }
}