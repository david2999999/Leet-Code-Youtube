public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void subsets(int i, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            subsets(j + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}