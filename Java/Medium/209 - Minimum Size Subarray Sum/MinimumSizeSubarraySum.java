public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i++];
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}