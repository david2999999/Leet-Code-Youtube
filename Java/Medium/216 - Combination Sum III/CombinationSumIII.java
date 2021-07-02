public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(1, new ArrayList<>(), result, k, n);
        return result;
    }

    private void combinationSum3(int i, List<Integer> comb, List<List<Integer>> result, int k, int n) {
        if (k == comb.size()) {
            if (n == 0) result.add(new ArrayList<>(comb));

            return;
        }

        for (int j = i; j <= 9; j++) {
            if (j > n) break;

            comb.add(j);
            combinationSum3(j + 1, comb, result, k, n - j);
            comb.remove(comb.size() - 1);
        }
    }
}