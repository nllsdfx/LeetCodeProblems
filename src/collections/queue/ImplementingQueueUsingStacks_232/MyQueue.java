package collections.queue.ImplementingQueueUsingStacks_232;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/implement-queue-using-stacks/description/">description</a>
 */
class MyQueue {

    private final Stack<Integer> addStack;
    private final Stack<Integer> removeStack;

    public MyQueue() {
        this.addStack = new Stack<>();
        this.removeStack = new Stack<>();
    }

    public void push(int x) {

        while (!removeStack.isEmpty()) {
            addStack.push(removeStack.pop());
        }

        addStack.push(x);
    }

    public int pop() {

        while (!addStack.isEmpty()) {
            removeStack.push(addStack.pop());
        }

        return removeStack.pop();
    }

    public int peek() {

        while (!addStack.isEmpty()) {
            removeStack.push(addStack.pop());
        }

        return removeStack.peek();
    }

    public boolean empty() {
        return removeStack.empty() && addStack.empty();
    }
}