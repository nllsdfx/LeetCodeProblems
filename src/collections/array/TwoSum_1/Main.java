package collections.array.TwoSum_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class Main {
    public static void main(String[] args) {
        int target = 9;
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, target))); // [1, 0]
        target = 0;
        arr = new int[]{-3, 4, 3, 90};
        System.out.println(Arrays.toString(twoSum(arr, target))); // [2, 0]
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (m.containsKey(complement)) {
                return new int[]{i, m.get(complement)};
            }
            m.put(nums[i], i);
        }

        throw new RuntimeException("Not possible situation!");
    }
}
