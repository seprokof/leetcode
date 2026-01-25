import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 90 }, 1, 0),
                new TestCase(new int[] { 9, 4, 1, 7 }, 2, 2)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumDifference(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert test.expected == actual : "minimumDifference(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 100_001;
        for (int i = 0; i <= nums.length - k; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }

}