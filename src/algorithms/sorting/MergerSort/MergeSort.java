package algorithms.sorting.MergerSort;

import java.util.Arrays;

/**
 * Implement merger sort algorithm.
 */
public class MergeSort {

	public static void main(String[] args) {

		int[] arr = {5, 3, 1, 9, -1};
		System.out.println(Arrays.toString(mergeSort(arr)));
	}

	public static int[] mergeSort(int[] arr) {

		if (arr.length <= 1) {
			return arr;
		}

		int[] subArr1 = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
		int[] subArr2 = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

		return merge(subArr1, subArr2);
	}

	private static int[] merge(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int i = 0, k = 0, j = 0;
		while (i <= a.length - 1 && k <= b.length - 1) {
			if (a[i] < b[k]) {
				res[j++] = a[i++];
			} else {
				res[j++] = b[k++];
			}
		}

		while (i <= a.length - 1) {
			res[j++] = a[i++];
		}

		while (k <= b.length - 1) {
			res[j++] = b[k++];
		}
		return res;
	}

}
