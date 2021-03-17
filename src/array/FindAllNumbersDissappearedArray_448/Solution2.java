package array.FindAllNumbersDissappearedArray_448;

import java.util.ArrayList;
import java.util.List;

// space O(n), original array immutable
public class Solution2 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;

        int[] l = new int[n];

        for (int num : nums) {
            l[num - 1] = n;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (l[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
