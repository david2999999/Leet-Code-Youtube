public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int x: nums) {
            result ^= x;
        }

        return result;
    }
}