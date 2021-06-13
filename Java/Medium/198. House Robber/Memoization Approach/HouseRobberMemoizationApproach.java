public class HouseRobberMemoizationApproach {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(0, nums, memo);
    }

    private int rob(int i, int[] nums, int[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];

        return memo[i] = Math.max(
            rob(i + 2, nums, memo) + nums[i],
            rob(i + 1, nums, memo)
        );
    }
}