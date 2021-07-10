public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int m1 = nums[0], m2 = nums[0], c1 = 0, c2 = 0;
        List<Integer> majorities = new ArrayList<>();

        for (int num: nums) {
            if (num == m1) {
                c1++;
            } else if (num == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = num;
                c2 = 1;
            } else {
                c1--; c2--;
            }
        }

        if (isMajority(m1, nums)) majorities.add(m1);
        if (m1 != m2 && isMajority(m2, nums)) majorities.add(m2);

        return majorities;
    }

    private boolean isMajority(int x, int[] nums) {
        int count = 0;

        for (int num: nums) {
            if (num == x) count++;
        }

        return count > nums.length / 3;
    }
}