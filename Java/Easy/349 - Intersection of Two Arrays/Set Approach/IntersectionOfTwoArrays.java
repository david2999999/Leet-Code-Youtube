public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>(), intersections = new HashSet<>();

        for (int x: nums1) seen.add(x);

        for (int x: nums2) {
            if (seen.contains(x)) intersections.add(x);
        }

        return convertToArray(intersections);
    }

    private int[] convertToArray(Set<Integer> set) {
        int[] result = new int[set.size()];
        int i = 0;

        for (int x: set) result[i++] = x;

        return result;
    }
}