public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum2(int i, int[] candidates, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target || (i != j && candidates[j] == candidates[j - 1])) continue;

            comb.add(candidates[j]);
            combinationSum2(j + 1, candidates, target - candidates[j], comb, result);
            comb.remove(comb.size() - 1);
        }
    }
}