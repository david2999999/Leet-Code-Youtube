public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> merged = new ArrayList<>();

        for (int[] cur: intervals) {
            if (merged.isEmpty()) {
                merged.add(cur);
                continue;
            }

            int[] prev = merged.remove(merged.size() - 1);

            if (cur[0] <= prev[1]) {
                merged.add(new int[] { prev[0], Math.max(cur[1], prev[1]) });
            } else {
                merged.add(prev);
                merged.add(cur);
            }
        }

        return convertToArray(merged);
    }

    private int[][] convertToArray(List<int[]> merged) {
        int[][] result = new int[merged.size()][];

        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }

        return result;
    }
}