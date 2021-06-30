public class HouseRobberIIMemoizationApproach {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] memo = new int[nums.length];

        Arrays.fill(memo, -1);
        int m1 = rob(0, nums.length - 2, nums, memo);

        Arrays.fill(memo, -1);
        int m2 = rob(1, nums.length - 1, nums, memo);

        return Math.max(m1, m2);
    }

    private int rob(int i, int end, int[] nums, int[] memo) {
        if (i > end) return 0;
        if (memo[i] != -1) return memo[i];

        return memo[i] = Math.max(
                rob(i + 2, end, nums, memo) + nums[i],
                rob(i + 1, end, nums, memo)
        );
    }
}