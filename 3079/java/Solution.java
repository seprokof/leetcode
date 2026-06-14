import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 6),
                new TestCase(new int[] { 10, 21, 31 }, 66)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumOfEncryptedInt(test.in);
            assert test.expected == actual : "sumOfEncryptedInt(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int maxDigit = 0;
            int countDigits = 0;
            while (num > 0) {
                maxDigit = Math.max(maxDigit, num % 10);
                countDigits++;
                num /= 10;
            }
            int encrypted = 0;
            for (int i = 0; i < countDigits; i++) {
                encrypted = encrypted * 10 + maxDigit;
            }
            sum += encrypted;
        }
        return sum;
    }

}