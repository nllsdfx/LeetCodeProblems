package algorithms.dsu.TheEarliestMomentWhenEveryoneBecomeFriends_1101;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are n people in a social group labeled from 0 to n - 1.
 * You are given an array logs where logs[i] = [timestampi, xi, yi] indicates
 * that xi and yi will be friends at the time timestampi.
 * <p>
 * Friendship is symmetric. That means if a is friends with b, then b is friends with a.
 * Also, person a is acquainted with a person b if a is friends with b, or a is a friend
 * of someone acquainted with b.
 * <p>
 * Return the earliest time for which every person became acquainted with every other person.
 * If there is no such earliest time, return -1.
 *
 * @see <a href=https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/">site</a>
 */
public class Solution {


	public static void main(String[] args) {

		int n = 6;

		int[][] logs = {
				{20190101, 0, 1},
				{20190104, 3, 4},
				{20190107, 2, 3},
				{20190211, 1, 5},
				{20190224, 2, 4},
				{20190301, 0, 3},
				{20190312, 1, 2},
				{20190322, 4, 5}
		};

		int time = new Solution().earliestAcq(logs, n);
		System.out.println(time);
		System.out.println(time == 20190301);

		int[][] logs1 = {
				{0, 1, 2},
				{2, 1, 3},
				{5, 0, 3},
				{7, 3, 2},
				{8, 2, 0},
				{9, 1, 0}
		};

		n = 4;
		time = new Solution().earliestAcq(logs1, n);
		System.out.println(time);
		System.out.println(time == 5);

		int[][] logs2 = {
				{5, 4, 3},
				{2, 0, 4},
				{1, 1, 2},
				{0, 0, 2},
				{3, 1, 4},
				{8, 2, 4},
				{6, 1, 0},
		};

		n = 5;
		time = new Solution().earliestAcq(logs2, n);
		System.out.println(time);
		System.out.println(time == 5);

	}

	public int earliestAcq(int[][] logs, int n) {
		int[] persons = new int[n];

		for (int i = 0; i < n; i++) {
			persons[i] = i;
		}

		UF uf = new UF(persons);

		Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));

		for (int[] log : logs) {
			int time = log[0];
			int x = log[1];
			int y = log[2];
			uf.unite(x, y);
			if (uf.allAreConnected()) {
				return time;
			}
		}


		return -1;
	}

	private static class UF {

		private final int[] array;
		private final int[] sizes;
		private int n;

		UF(int[] array) {
			this.array = array;
			this.sizes = new int[array.length];
			Arrays.fill(sizes, 1);
			n = array.length;
		}

		int getRootOf(int x) {
			if (array[x] == x) {
				return x;
			} else {
				return array[x] = getRootOf(array[x]);
			}
		}

		void unite(int x, int y) {

			int xRoot = getRootOf(x);
			int yRoot = getRootOf(y);

			if (xRoot != yRoot) {
				n--;
				if (sizes[xRoot] >= sizes[yRoot]) {
					array[yRoot] = xRoot;
					sizes[xRoot] += sizes[yRoot];
				} else {
					array[xRoot] = yRoot;
					sizes[yRoot] += sizes[xRoot];
				}
			}
		}

		boolean allAreConnected() {
			return n == 1;
		}

	}

}
