class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private boolean isOdd = false;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
    }

    public void addNum(int num) {
        if (!isOdd) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }

        isOdd = !isOdd;
    }

    public double findMedian() {
        if (isOdd) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */