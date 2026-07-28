import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("z", "z"),
                new TestCase("babab", "abbba"),
                new TestCase("daccad", "acddca")                
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.smallestPalindrome(test.in);
            assert Objects.equals(test.expected, actual) : "smallestPalindrome('%s') == '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String smallestPalindrome(String s) {
        int len = s.length();
        int[] frequency = new int[26];
        for (int i = 0; i < len; i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        char[] result = new char[len];
        int i = 0;
        for (int j = 0; j < 26; j++) {
            while (frequency[j] > 0) {
                char ch = (char) ('a' + j);
                if (frequency[j] % 2 == 0) {
                    result[i] = ch;
                    result[len - 1 - i] = ch;
                    frequency[j] -= 2;
                    i++;
                } else {
                    result[len / 2] = ch;
                    frequency[j]--;
                }
            }
        }
        return new String(result);
    }

}