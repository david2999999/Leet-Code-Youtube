public class HouseRobberRecursiveApproach {
    public int rob(int[] nums) {
        return rob(0, nums);
    }

    private int rob(int i, int[] nums) {
        if (i >= nums.length) return 0;

        return Math.max(
            rob(i + 2, nums) + nums[i],
            rob(i + 1, nums)
        );
    }
}