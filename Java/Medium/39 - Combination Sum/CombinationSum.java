public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int i, int[] candidates, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) continue;

            comb.add(candidates[j]);
            combinationSum(j, candidates, target - candidates[j], comb, result);
            comb.remove(comb.size() - 1);
        }
    }
}