public class JumpGame {
    public boolean canJump(int[] nums) {
        int j = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= j) {
                j = i;
            }
        }

        return j == 0;
    }
}