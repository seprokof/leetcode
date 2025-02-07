import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("A", 1),
                new TestCase("AB", 28),
                new TestCase("ZY", 701)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.titleToNumber(test.in);
            assert Objects.equals(test.expected, actual) : "titleToNumber('%s') == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }

}