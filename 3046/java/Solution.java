import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 2, 2, 3, 4 }, true),
                new TestCase(new int[] { 1, 1, 1, 1 }, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isPossibleToSplit(test.in);
            assert test.expected == actual : "isPossibleToSplit(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean isPossibleToSplit(int[] nums) {
        int[] frequency = new int[101];
        for (int num : nums) {
            if (++frequency[num] > 2) {
                return false;
            }
        }
        return true;
    }

}