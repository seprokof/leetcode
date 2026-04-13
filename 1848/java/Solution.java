import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 5, 3, 1),
                new TestCase(new int[] { 1 }, 1, 0, 0),
                new TestCase(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 1, 0, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.getMinDistance(test.in1, test.in2, test.in3);
            assert test.expected == actual : "getMinDistance(%s, %s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, test.in3, actual, test.expected);
        }
    }

    public int getMinDistance(int[] nums, int target, int start) {
        int minDistanceToEnd = Math.min(start, nums.length - start - 1);
        for (int i = 0; i < minDistanceToEnd; i++) {
            if (nums[start - i] == target || nums[start + i] == target) {
                return i;
            }
        }
        for (int i = start - minDistanceToEnd; i >= 0; i--) {
            if (nums[i] == target) {
                return start - i;
            }
        }
        for (int i = start + minDistanceToEnd; i < nums.length; i++) {
            if (nums[i] == target) {
                return i - start;
            }
        }
        return -1;
    }

}