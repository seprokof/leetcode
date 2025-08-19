import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 0, 0, 2, 0, 0, 4 }, 6L),
                new TestCase(new int[] { 0, 0, 0, 2, 0, 0 }, 9L),
                new TestCase(new int[] { 2, 10, 2019 }, 0L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.zeroFilledSubarray(test.in);
            assert test.expected == actual : "zeroFilledSubarray(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public long zeroFilledSubarray(int[] nums) {
        long result = 0L;
        long currentZerosCount = 0L;
        for (int num : nums) {
            if (num == 0) {
                result += ++currentZerosCount;
            } else {
                currentZerosCount = 0L;
            }
        }
        return result;
    }

}