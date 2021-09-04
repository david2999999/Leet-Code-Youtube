public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = getFrequency(nums1);
        List<Integer> intersections = new ArrayList<>();

        for (int x: nums2) {
            if (map.containsKey(x) && map.get(x) > 0) {
                intersections.add(x);
                map.put(x, map.get(x) - 1);
            }
        }

        return convertToArray(intersections);
    }

    private int[] convertToArray(List<Integer> list) {
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private Map<Integer, Integer> getFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x: nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return map;
    }
}