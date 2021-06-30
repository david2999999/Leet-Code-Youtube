public class HouseRobberIIRecursiveApproach {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(
            rob(0, nums.length - 2, nums),
            rob(1, nums.length - 1, nums)
        );
    }

    private int rob(int i, int end, int[] nums) {
        if (i > end) return 0;

        return Math.max(
            rob(i + 2, end, nums) + nums[i],
            rob(i + 1, end, nums)
        );
    }
}