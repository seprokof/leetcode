import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, 2, true),
                new TestCase(new int[] { 1, 0, 0, 1, 0, 1 }, 2, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.kLengthApart(test.in1, test.in2);
            assert test.expected == actual : "kLengthApart(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public boolean kLengthApart(int[] nums, int k) {
        int prevOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prevOne > -1 && i - 1 - prevOne < k) {
                    return false;
                }
                prevOne = i;
            }
        }
        return true;
    }

}