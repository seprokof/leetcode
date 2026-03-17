import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 0, 2 }, new int[][] { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } }, 2),
                new TestCase(new int[] { 4, 3, 2, 1 }, new int[][] { { 1, 3, 2 }, { 0, 2, 1 } }, -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minZeroArray(test.in1, test.in2);
            assert test.expected == actual : "minZeroArray(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int k = 0;
        for (int[] query : queries) {
            if (isZero(nums)) {
                return k;
            }
            for (int i = query[0]; i <= query[1]; i++) {
                nums[i] -= query[2];
            }
            k++;
        }
        return isZero(nums) ? k : -1;
    }

    private static boolean isZero(int[] nums) {
        for (int n : nums) {
            if (n > 0) {
                return false;
            }
        }
        return true;
    }

}