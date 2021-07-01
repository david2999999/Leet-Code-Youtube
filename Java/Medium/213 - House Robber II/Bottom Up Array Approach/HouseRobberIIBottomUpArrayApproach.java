public class HouseRobberIIBottomUpArrayApproach {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(
            rob(0, nums.length - 2, nums),
            rob(1, nums.length - 1, nums)
        );
    }

    private int rob(int start, int end, int[] nums) {
        int[] money = new int[nums.length + 2];

        for (int i = end; i >= start; i--) {
            money[i] = Math.max(
                money[i + 2] + nums[i],
                money[i + 1]
            );
        }

        return money[start];
    }
}