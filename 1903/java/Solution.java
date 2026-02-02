import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("52", "5"),
                new TestCase("4206", ""),
                new TestCase("35427", "35427")
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.largestOddNumber(test.in);
            assert Objects.equals(test.expected, actual) : "largestOddNumber('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        for (; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

}