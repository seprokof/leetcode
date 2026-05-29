import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 10, 12, 13, 14 }, 1),
                new TestCase(new int[] { 1, 2, 3,  4 }, 1),
                new TestCase(new int[] { 999, 19, 199 }, 10)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minElement(test.in);
            assert test.expected == actual : "minElement(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int minElement(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            int digitSum = 0;
            for (; num > 0; num /= 10) {
                digitSum += num % 10;
            }
            result = Math.min(result, digitSum);
        }
        return result;
    }

}