import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase("abcd", 2, "bacd"),
                new TestCase("xyz", 3, "zyx"),
                new TestCase("hey", 1, "hey")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reversePrefix(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "reversePrefix('%s', %s) == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String reversePrefix(String s, int k) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                result[i] = s.charAt(k - 1 - i);
            } else {
                result[i] = s.charAt(i);
            }
        }
        return new String(result);
    }

}