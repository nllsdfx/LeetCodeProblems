package string.CheckOneStringSwapCanMakeStringsEqual_1790;

/**
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a
 * string (not necessarily different) and swap the characters at these indices.
 * <p>
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of
 * the strings. Otherwise, return false.
 * s1.length == s2.length
 */
public class Main {

    public static void main(String[] args) {

        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2)); // true
        s1 = "attack";
        s2 = "defend";
        System.out.println(areAlmostEqual(s1, s2)); // false
        s1 = "kelb";
        s2 = "kelb";
        System.out.println(areAlmostEqual(s1, s2)); // true
        s1 = "aaaaaaaaaakooooooooooooooooo";
        s2 = "aaaaaaaaaajooooooooooooooooo";
        System.out.println(areAlmostEqual(s1, s2)); // false
        s1 = "banl";
        s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2)); // false
    }

    public static boolean areAlmostEqual(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int count = 0, idx1 = 0, idx2 = 0;

        for (int i = 0; i < c1.length; i++) {
            char a = c1[i];
            char b = c2[i];
            if (a != b) {
                count++;
                if (count == 1) idx1 = i;
                else if (count == 2) idx2 = i;
                else if (count > 2) return false;
            }
        }

        return (count == 0 || count == 2) && c1[idx1] == c2[idx2] && c1[idx2] == c2[idx1];
    }
}
