package algorithms.dsu;

import java.util.Arrays;

/**
 * Write a simple Union-Find algorithm.
 *
 * @see <a href="https://leetcode.com/discuss/general-discussion/1072418/Disjoint-Set-Union-(DSU)Union-Find-A-Complete-Guide">description</a>
 */
public class DisjointUnionSet {

	private final int[] array;
	private final int[] sizes;

	/**
	 * Fills array from 0 to n.
	 *
	 * @param n upper limit (exclusive).
	 */
	DisjointUnionSet(int n) {
		this.array = new int[n];
		this.sizes = new int[n];
		for (int i = 0; i < n; i++) {
			this.array[i] = i;
			this.sizes[i] = 1;
		}
	}

	/**
	 * Connects a and b in disjoint set.
	 *
	 * @param a a
	 * @param b b
	 */
	void union(int a, int b) {
		if (sizes[a] <= sizes[b]) {
			array[a] = getRootOf(b);
			sizes[b] += sizes[a];
		} else {
			array[b] = getRootOf(a);
			sizes[a] += sizes[b];
		}
	}

	/**
	 * Check whether a and b are connected.
	 *
	 * @param a first number
	 * @param b second number
	 * @return if a and b are connected or not.
	 */
	boolean areConnected(int a, int b) {
		return getRootOf(a) == getRootOf(b);
	}

	/**
	 * Finds the root of a given number.
	 * When in travel up to the root, also assigns
	 * for each leaf a "main" root (weightning).
	 *
	 * @param x a number
	 * @return the root of its number.
	 */
	private int getRootOf(int x) {

		if (array[x] == x) {
			return x;
		}

		return array[x] = getRootOf(array[x]);
	}

	public int[] getSet() {
		return array;
	}

	public static void main(String[] args) {
		// some trivial tests
		var uf = new DisjointUnionSet(10);
		System.out.printf("Before union = {%s}%n", Arrays.toString(uf.getSet()));
		uf.union(0, 1);
		System.out.printf("union [0, 1] = {%s}%n", Arrays.toString(uf.getSet()));
		uf.union(2, 3);
		System.out.printf("union [2, 3] = {%s}%n", Arrays.toString(uf.getSet()));
		uf.union(4, 5);
		System.out.printf("union [4, 5] = {%s}%n", Arrays.toString(uf.getSet()));
		uf.union(6, 7);
		System.out.printf("union [6, 7] = {%s}%n", Arrays.toString(uf.getSet()));
		uf.union(8, 9);
		System.out.printf("union [8, 9] = {%s}%n", Arrays.toString(uf.getSet()));

		System.out.printf("0 and 1 connected - %b%n", uf.areConnected(0, 1));
		System.out.printf("1 and 2 connected - %b%n", uf.areConnected(1, 2));

		uf.union(1, 9);
		System.out.printf("union [1, 9] = {%s}%n", Arrays.toString(uf.getSet()));
		System.out.printf("0 and 9 connected - %b%n", uf.areConnected(0, 9));
		System.out.printf("1 and 9 connected - %b%n", uf.areConnected(1, 9));
		System.out.printf("0 and 8 connected - %b%n", uf.areConnected(0, 8));
		System.out.printf("1 and 8 connected - %b%n", uf.areConnected(1, 8));
		System.out.printf("8 and 9 are still connected - %b%n", uf.areConnected(8, 9));

		uf.union(6, 9);
		System.out.printf("union [6, 9] = {%s}%n", Arrays.toString(uf.getSet()));
		System.out.printf("1 and 6 connected - %b%n", uf.areConnected(1, 6));
		System.out.printf("4 and 6 connected - %b%n", uf.areConnected(4, 6));

	}

}
