public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = 0, count = 0;

        for (int num: nums) {
            if (count == 0) {
                majority = num;
                count = 1;
                continue;
            }

            count = (num == majority) ? count + 1 : count - 1;
        }

        return majority;
    }
}