import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, String expected) {}

        TestCase[] tests = {
                new TestCase("abc", "bba", "bca"),
                new TestCase("leet", "code", "eelt"),
                new TestCase("baba", "bbaa", "")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.lexGreaterPermutation(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "lexGreaterPermutation('%s', '%s') == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String lexGreaterPermutation(String s, String target) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[target.charAt(i) - 'a']--;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int j = target.charAt(i) - 'a';
            frequency[j]++;
            boolean missing = false;
            for (int k = 0; k < 26; k++) {
                if (frequency[k] < 0) {
                    missing = true;
                    break;
                }
            }
            if (missing) {
                continue;
            }
            for (int k = j + 1; k < 26; k++) {
                if (frequency[k] > 0) {
                    StringBuilder result = new StringBuilder();
                    result.append(target.substring(0, i));
                    result.append((char) ('a' + k));
                    frequency[k]--;
                    for (int g = 0; g < 26; g++) {
                        char ch = (char) ('a' + g);
                        for (; frequency[g] > 0; frequency[g]--) {
                            result.append(ch);
                        }
                    }
                    return result.toString();
                }
            }
        }
        return "";
    }

}