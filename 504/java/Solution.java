import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, String expected) {}

        TestCase[] tests = {
                new TestCase(100, "202"),
                new TestCase(-7, "-10")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.convertToBase7(test.in);
            assert Objects.equals(test.expected, actual) : "convertToBase7(%s) == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegative = num < 0;
        StringBuilder result = new StringBuilder();
        num = Math.abs(num);
        while (num != 0) {
            result.append(num % 7);
            num /= 7;
        }
        if (isNegative) {
            result.append("-");
        }
        return result.reverse().toString();
    }

}