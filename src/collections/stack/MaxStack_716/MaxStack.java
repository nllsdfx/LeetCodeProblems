package collections.stack.MaxStack_716;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @see <a href="https://leetcode.com/problems/max-stack/description/">description</a>
 */
class MaxStack {

	private final TreeSet<IdValue> stack;
	private final TreeSet<IdValue> maxStack;
	private int count;

	public MaxStack() {

		var comparator = new Comparator<IdValue>() {
			@Override
			public int compare(IdValue o1, IdValue o2) {
				return o2.id == o1.id ? o1.value - o2.value : o1.id - o2.id;
			}
		};

		stack = new TreeSet<>(comparator);
		maxStack = new TreeSet<>(comparator);
	}

	public void push(int x) {
		stack.add(new IdValue(count, x));
		maxStack.add(new IdValue(x, count));
		count++;
	}

	public int pop() {
		IdValue last = stack.pollLast();
		maxStack.remove(new IdValue(last.value, last.id));
		return last.value;
	}

	public int top() {
		return stack.last().value;
	}

	public int peekMax() {
		return maxStack.last().id;
	}

	public int popMax() {
		IdValue last = maxStack.pollLast();
		stack.remove(new IdValue(last.value, last.id));
		return last.id;
	}

	private class IdValue {
		private int id;
		private int value;

		private IdValue(int id, int value) {
			this.id = id;
			this.value = value;
		}
	}
}
