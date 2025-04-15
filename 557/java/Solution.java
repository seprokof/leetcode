import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
                new TestCase("Mr Ding", "rM gniD")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reverseWords(test.in);
            assert Objects.equals(test.expected, actual) : "reverseWords('%s') == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int start = 0;
        for (int i = start; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = ++i;
            }
        }
        reverse(str, start, str.length - 1);
        return String.valueOf(str);
    }

    private static void reverse(char[] str, int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            char temp = str[start + i];
            str[start + i] = str[end - i];
            str[end - i] = temp;
        }
    }

}