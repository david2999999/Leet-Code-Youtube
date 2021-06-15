public class HouseRobberBottomUpArrayApproach {
    public int rob(int[] nums) {
        int[] money = new int[nums.length + 2];

        for (int i = nums.length - 1; i >= 0; i--) {
            money[i] = Math.max(money[i + 2] + nums[i], money[i + 1]);
        }

        return money[0];
    }
}