public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = 0;

            while (true) {
                if (x < 1 || x > n || x == nums[x - 1]) break;

                int y = nums[x - 1];
                nums[x - 1] = x;
                x = y;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return i + 1;
        }

        return n + 1;
    }
}