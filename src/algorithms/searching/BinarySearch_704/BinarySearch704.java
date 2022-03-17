package algorithms.searching.BinarySearch_704;

/**
 * Given an array of integers nums which is sorted in ascending order,
 * an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch704 {

	public static void main(String[] args) {
		int[] arr = {-1, 0, 3, 5, 9, 12};
		System.out.printf("Target 2 is not found in array: %b%n", binarySearch(arr, 2) == -1);
		System.out.printf("Target 9 is found in array at index %d%n", binarySearch(arr, 9));
	}

	/**
	 * Searches for an index of a target number in a given array.
	 *
	 * @param arr    array to search through
	 * @param target the number we want to find in an array
	 * @return found number's index or -1 if not found
	 */
	public static int binarySearch(int[] arr, int target) {

		int minIdx = 0;
		int maxIdx = arr.length - 1;

		while (minIdx <= maxIdx) {
			int idx = (minIdx + maxIdx) / 2;
			int current = arr[idx];
			if (target == current) {
				return idx;
			} else if (target < current) {
				maxIdx = idx - 1;
			} else {
				minIdx = idx + 1;
			}
		}

		return -1;
	}

}
