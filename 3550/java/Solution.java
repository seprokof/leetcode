import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 2 }, 2),
                new TestCase(new int[] { 1, 10, 11 }, 1),
                new TestCase(new int[] { 1, 2, 3 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.smallestIndex(test.in);
            assert test.expected == actual : "smallestIndex(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int digitSum = 0;
            int value = nums[i];
            while (value != 0) {
                digitSum += value % 10;
                value /= 10;
            }
            if (digitSum == i) {
                return i;
            }
        }
        return -1;
    }

}