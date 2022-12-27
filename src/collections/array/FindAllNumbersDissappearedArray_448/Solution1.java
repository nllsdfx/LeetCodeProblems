package collections.array.FindAllNumbersDissappearedArray_448;

import java.util.ArrayList;
import java.util.List;

/**
 * Array is modified
 */
public class Solution1 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;

        for (int x : nums) {
            int idx = x > 0 ? x - 1 : -x - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
