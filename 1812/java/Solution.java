import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("a1", false),
                new TestCase("h3", true),
                new TestCase("c7", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.squareIsWhite(test.in);
            assert Objects.equals(test.expected, actual) : "squareIsWhite('%s') = %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'a';
        int row = coordinates.charAt(1) - '0';
        return (col + row) % 2 == 0;
    }

}