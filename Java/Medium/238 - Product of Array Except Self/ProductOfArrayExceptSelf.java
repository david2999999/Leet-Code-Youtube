public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = product;
            product *= nums[i];
        }

        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }

        return answer;
    }
}