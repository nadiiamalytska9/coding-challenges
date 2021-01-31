package challenges.solution;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();

    public void enqueue(T value) {
        stackNewestOnTop.push(value);
    }

    public T peek() {
        prepare();
        return stackOldestOnTop.peek();
    }

    public T dequeue() {
        prepare();
        return stackOldestOnTop.pop();
    }

    private void prepare() {
        if (stackOldestOnTop.isEmpty())
            while (!stackNewestOnTop.isEmpty())
                stackOldestOnTop.push(stackNewestOnTop.pop());
    }
}
