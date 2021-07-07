class MyStack {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.add(x);
        this.rotate();
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return this.queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.isEmpty();
    }

    private void rotate() {
        int n = queue.size();

        while (n - 1 != 0) {
            queue.add(queue.poll());
            n--;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */