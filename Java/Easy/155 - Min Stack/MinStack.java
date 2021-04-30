public class MinStack {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack2.isEmpty() || stack2.peek() >= val) {
            stack2.push(val);
        }

        stack1.push(val);
    }

    public void pop() {
        int x = stack1.pop();

        if (stack2.peek() == x) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}