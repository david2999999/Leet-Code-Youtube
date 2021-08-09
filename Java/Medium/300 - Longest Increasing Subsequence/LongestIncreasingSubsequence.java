public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        int maxLength = 0;

        for (int j = 0; j < nums.length; j++) {
            length[j] = 1;

            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    length[j] = Math.max(length[j], length[i] + 1);
                }
            }

            maxLength = Math.max(maxLength, length[j]);
        }

        return maxLength;
    }
}