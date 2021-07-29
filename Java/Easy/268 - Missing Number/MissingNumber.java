public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length, sum = 0;

        for (int x: nums) sum += x;

        return (n * (n + 1)) / 2 - sum;
    }
}