import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase("abcdefg", 2, "bacdfeg"),
                new TestCase("abcd", 2, "bacd")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reverseStr(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "reverseStr(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += k * 2) {
            int start = i;
            int end = Math.min(s.length() - 1, start + k - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
        return String.valueOf(chars);
    }

}