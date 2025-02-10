import java.util.Stack;

class MyQueue {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        if (empty()) {
            stack2.push(x);
        } else {
            stack1.push(x);
        }
    }

    public int pop() {
        if (stack2.isEmpty()) {
            move();
        }
        return stack2.pop();
    }

    private void move() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int peek() {
        if (stack2.isEmpty()) {
            move();
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
