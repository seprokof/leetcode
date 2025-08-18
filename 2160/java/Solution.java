import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(2932, 52),
                new TestCase(4009, 13)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumSum(test.in);
            assert test.expected == actual : "minimumSum(%s) = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int minimumSum(int num) {
        int[] digits = new int[4];
        for (int i = 0; num > 0; i++, num /= 10) {
            digits[i] = num % 10;
        }
        Arrays.sort(digits);
        return digits[0] * 10 + digits[2] + digits[1] * 10 + digits[3];
    }

}