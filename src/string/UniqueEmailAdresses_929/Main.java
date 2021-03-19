package string.UniqueEmailAdresses_929;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails)); // 2
        /* */
        System.out.println(coolSolution(emails)); // 2

        emails = new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"};

        System.out.println(numUniqueEmails(emails)); // 1
        /* */
        System.out.println(coolSolution(emails)); // 1
    }

    public static int coolSolution(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '.') sb.deleteCharAt(i);
                if (c == '+') sb.delete(i, sb.indexOf("@"));
                if (c == '@' || c == '+') break;
            }
            unique.add(sb.toString());
        }

        return unique.size();
    }

    // first and ugly solution, but O(n * m) anyway.
    public static int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '.') {
                    continue;
                } else if (c == '+') {
                    while (c != '@') {
                        c = s.charAt(++i);
                    }
                    i -= 1;
                } else if (c == '@') {
                    while (i < s.length()) {
                        sb.append(s.charAt(i++));
                    }
                } else {
                    sb.append(c);
                }

            }
            unique.add(sb.toString());
        }

        return unique.size();
    }
}
