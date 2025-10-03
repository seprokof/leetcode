import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("aaaabbbbcccc", "abccbaabccba"),
                new TestCase("rat", "art")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.sortString(test.in);
            assert Objects.equals(test.expected, actual) : "sortString('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String sortString(String s) {
        int[] frequency = new int[26];
        for (char letter : s.toCharArray()) {
            frequency[letter - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() != s.length()) {
            for (int i = 0; i < 26; i++) {
                if (frequency[i] > 0) {
                    frequency[i]--;
                    sb.append((char) ('a' + i));
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (frequency[i] > 0) {
                    frequency[i]--;
                    sb.append((char) ('a' + i));
                }
            }
        }
        return sb.toString();
    }

}