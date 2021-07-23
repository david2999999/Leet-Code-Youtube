public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> nums[i2] - nums[i1]);
        int[] result = new int[nums.length - k + 1];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!maxHeap.isEmpty() && maxHeap.peek() < i - k + 1) maxHeap.poll();

            maxHeap.add(i);

            if (i >= k - 1) result[j++] = nums[maxHeap.peek()];
        }

        return result;
    }
}