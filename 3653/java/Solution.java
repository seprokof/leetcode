import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 1 }, new int[][] { { 0, 2, 1, 4 } }, 4),
                new TestCase(new int[] { 2, 3, 1, 5, 4 }, new int[][] { { 1, 4, 2, 3 }, { 0, 2, 1, 2 } }, 31)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.xorAfterQueries(test.in1, test.in2);
            assert test.expected == actual : "xorAfterQueries(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    private static final int MODULO = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int) ((nums[idx] * 1L * v) % MODULO);
            }
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}