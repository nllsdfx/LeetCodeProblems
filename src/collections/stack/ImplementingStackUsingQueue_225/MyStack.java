package collections.stack.ImplementingStackUsingQueue_225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/implement-stack-using-queues/description/">description</a>
 */
public class MyStack {

	private final Queue<Integer> q1;
	private final Queue<Integer> q2;

	public MyStack() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	public void push(int x) {
		if (!q2.isEmpty()) {
			q2.add(x);
		} else {
			q1.add(x);
		}
	}

	public int pop() {
		return top(true);
	}

	public int top() {
		return top(false);
	}

	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}

	private int top(boolean pop) {
		if (!q1.isEmpty()) {
			return move(q1, q2, pop);
		} else {
			return move(q2, q1, pop);
		}
	}

	private int move(Queue<Integer> q1, Queue<Integer> q2, boolean pop) {
		int k = 0;
		int size = q1.size();

		while (!q1.isEmpty()) {
			if (k == size - 1) {
				var head = q1.poll();
				if (pop) {
					return head;
				}
				q2.add(head);
				return head;
			}
			q2.add(q1.poll());
			k++;
		}

		return 0;
	}
}
