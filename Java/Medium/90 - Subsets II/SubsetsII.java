public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDup(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void subsetsWithDup(int i, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int j = i; j < nums.length; j++) {
            if (j != i && nums[j] == nums[j - 1]) continue;

            subset.add(nums[j]);
            subsetsWithDup(j + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}