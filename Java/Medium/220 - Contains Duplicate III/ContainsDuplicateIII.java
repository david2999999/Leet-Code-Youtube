public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            Integer ceiling = set.ceiling(x);

            if (ceiling != null && Math.abs((long) ceiling - x) <= t) return true;

            Integer floor = set.floor(x);

            if (floor != null && Math.abs(x - (long) floor) <= t) return true;

            set.add(x);

            if (set.size() > k) set.remove(nums[i - k]);
        }

        return false;
    }
}