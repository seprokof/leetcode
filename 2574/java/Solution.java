import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 10, 4, 8, 3 }, new int[] { 15, 1, 11, 22 }),
                new TestCase(new int[] { 1 }, new int[] { 0 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.leftRightDifference(test.in);
            assert Arrays.equals(test.expected, actual) : "leftRightDifference(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] leftRightDifference(int[] nums) {
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int leftSum = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            result[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return result;
    }

}