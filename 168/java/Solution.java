import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, String expected) {}

        TestCase[] tests = {
                new TestCase(1, "A"),
                new TestCase(28, "AB"),
                new TestCase(701, "ZY")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.convertToTitle(test.in);
            assert Objects.equals(test.expected, actual) : "convertToTitle(%s) == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.insert(0, (char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.toString();
    }

}