package string.UniqueEmailAdresses_929;

import java.util.HashSet;
import java.util.Set;

/**
 * Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
 *
 * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
 *
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 *
 * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 * It is possible to use both of these rules at the same time.
 *
 * Given an array of strings emails where we send one email to each email[i], return the number of different addresses that actually receive mails.
 */
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
