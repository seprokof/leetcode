import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("egcfe", "efcfe"),
                new TestCase("abcd", "abba"),
                new TestCase("seven", "neven")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.makeSmallestPalindrome(test.in);
            assert Objects.equals(test.expected, actual) : "makeSmallestPalindrome('%s') == '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (arr[i] != arr[j]) {
                arr[i] = arr[j] = (char) Math.min(arr[i], arr[j]);
            }
        }
        return new String(arr);
    }

}