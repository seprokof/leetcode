import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[][] in2, boolean[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 4, 1, 2, 6 }, new int[][] { { 0, 4 } }, new boolean[] { false }),
                new TestCase(new int[] { 4, 3, 1 ,6 }, new int[][] { { 0, 2 }, { 2, 3 } }, new boolean[] { false, true } )
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean[] actual = s.isArraySpecial(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "isArraySpecial(%s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.deepToString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] violations = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            violations[i] = ((nums[i] % 2 == nums[i - 1] % 2) ? 1 : 0) + violations[i - 1];
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = violations[queries[i][1]] - violations[queries[i][0]] == 0;
        }
        return result;
    }

}