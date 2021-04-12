public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = getElementAndFrequency(nums);

        for (int x: map.keySet()) {
            if (map.get(x) == 1) return x;
        }

        return -1;
    }

    private Map<Integer, Integer> getElementAndFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }
}