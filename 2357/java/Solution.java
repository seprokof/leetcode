import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 5, 0, 3, 5 }, 3),
                new TestCase(new int[] { 0 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumOperations(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "minimumOperations(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] - sum;
            if (val != 0) {
                sum += val;
                result++;
            }
        }
        return result;
    }

}