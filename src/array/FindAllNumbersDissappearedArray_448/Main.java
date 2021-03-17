package array.FindAllNumbersDissappearedArray_448;

import java.util.Arrays;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class Main {
    public static void main(String[] args) {
        //[4,3,2,7,8,2,3,1]
        int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] b = Arrays.copyOf(a, a.length);
        System.out.println(Solution1.findDisappearedNumbers(a)); // 5, 6 no extra space, but array modification
        System.out.println(Solution2.findDisappearedNumbers(b)); // 5, 6 O(n) extra space, no array modification
    }


}
