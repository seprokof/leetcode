import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private final Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        int top = pop();
        queue.offer(top);
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
