import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(10, 4),
                new TestCase(1, 0),
                new TestCase(2, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.rotatedDigits(test.in);
            assert Objects.equals(test.expected, actual) : "rotatedDigits(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int rotatedDigits(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                result++;
            }
        }
        return result;
    }

    private static boolean isGood(int num) {
        boolean isChanged = false;
        for (; num > 0; num /= 10) {
            int digit = num % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            } else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isChanged = true;
            }
        }
        return isChanged;
    }

}