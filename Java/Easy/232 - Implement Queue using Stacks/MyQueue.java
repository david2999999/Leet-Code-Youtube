class MyQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.s1 = new ArrayDeque<>();
        this.s2 = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        moveIfEmpty();

        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        moveIfEmpty();

        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void moveIfEmpty() {
        if (!s2.isEmpty()) return;

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */