import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase(2, 3, "30"),
                new TestCase(2, 17, "98"),
                new TestCase(1, 10, "")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.maxSumOfSquares(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "maxSumOfSquares(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }
        StringBuilder result = new StringBuilder("9".repeat(sum / 9));
        sum %= 9;
        if (sum > 0) {
            result.append(sum);
        }
        result.append("0".repeat(num - result.length()));
        return result.toString();
    }

}