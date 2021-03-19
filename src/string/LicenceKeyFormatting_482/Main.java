package string.LicenceKeyFormatting_482;

/**
 * You are given a license key represented as a string S which consists only
 * alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
 * <p>
 * Given a number K, we would want to reformat the strings such that each group
 * contains exactly K characters, except for the first group which could be shorter
 * than K, but still must contain at least one character. Furthermore, there must
 * be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 * <p>
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 */
public class Main {
    public static void main(String[] args) {

        String t = "5F3Z-2e-9-w";
        int k = 4;
        System.out.println(licenseKeyFormatting(t, k)); // "5F3Z-2E9W"
        t = "2";
        k = 2;
        System.out.println(licenseKeyFormatting(t, k)); // 2


    }

    public static String licenseKeyFormatting(String S, int K) {
        int realLength = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                realLength--;
            }
        }

        int count = 0;
        int firstGrLen = realLength % K;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            if (firstGrLen > 0) {
                firstGrLen--;
                b.append(Character.toUpperCase(c));
                if (firstGrLen == 0 && i != realLength - 1) b.append('-');
                continue;
            }

            if (count == K) {
                b.append('-');
                count = 0;
            }

            b.append(Character.toUpperCase(c));
            count++;
        }

        return b.toString();
    }
}
