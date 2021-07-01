public class HouseRobberIIBottomUpConstantSpaceApproach {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(
            rob(0, nums.length - 2, nums),
            rob(1, nums.length - 1, nums)
        );
    }

    private int rob(int start, int end, int[] nums) {
        int m2 = 0, m1 = 0;

        for (int i = end; i >= start; i--) {
            int m = Math.max(m2 + nums[i], m1);
            m2 = m1;
            m1 = m;
        }

        return m1;
    }
}