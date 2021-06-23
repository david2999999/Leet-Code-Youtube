public class HouseRobberBottomUpConstantSpaceApproach {
    public int rob(int[] nums) {
        int m1 = 0, m2 = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int m = Math.max(m2 + nums[i], m1);
            m2 = m1;
            m1 = m;
        }

        return m1;
    }
}