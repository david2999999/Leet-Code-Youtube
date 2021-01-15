public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int num: nums) {
            sum = Math.max(sum, 0) + num;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}