import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, new int[] { 1, 2, 4 }),
                new TestCase(new int[] { 4, 3, 2, 1 }, new int[] { 4, 3, 2, 2 }),
                new TestCase(new int[] { 9 }, new int[] { 1, 0 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.plusOne(Arrays.copyOf(test.in, test.in.length));
            assert Arrays.equals(test.expected, actual) : "plusOne(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

}