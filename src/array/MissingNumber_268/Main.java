package array.MissingNumber_268;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int[] nums1 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums2 = {0};
        System.out.println(missingNumber(nums));  // 2
        System.out.println(missingNumber(nums1)); // 8
        System.out.println(missingNumber(nums2)); // 1
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int invalidSum = 0;
        for (int num : nums) {
            invalidSum += num;
        }
        int validSum = n * (n + 1) / 2;
        return validSum - invalidSum;
    }
}
