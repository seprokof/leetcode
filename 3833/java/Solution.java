import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 4, 3 }, 2),
                new TestCase(new int[] { 4, 1, 2 }, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.dominantIndices(test.in);
            assert test.expected == actual : "dominantIndices(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int dominantIndices(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum -= nums[i];
            double avg = sum / (nums.length - 1 - i);
            if (nums[i] > avg) {
                result++;
            }
        }
        return result;
    }

}