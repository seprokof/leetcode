import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[][] in2, boolean expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 0, 1 }, new int[][] { { 0, 2 } }, true),
                new TestCase(new int[] { 4, 3, 2, 1 }, new int[][] { { 1, 3 }, { 0, 2 } }, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isZeroArray(test.in1, test.in2);
            assert test.expected == actual : "isZeroArray(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];
        for (int[] query : queries) {
            diff[query[0]]++;
            diff[query[1] + 1]--;
        }
        int curDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            curDiff += diff[i];
            if (nums[i] > curDiff) {
                return false;
            }
        }
        return true;
    }

}