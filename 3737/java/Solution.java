import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 3 }, 2, 5),
                new TestCase(new int[] { 1, 1, 1, 1 }, 1, 10),
                new TestCase(new int[] { 1, 2, 3 }, 4, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countMajoritySubarrays(test.in1, test.in2);
            assert test.expected == actual : "countMajoritySubarrays(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int targetCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    targetCount++;
                }
                if (targetCount > (j + 1 - i) / 2) {
                    result++;
                }
            }
        }
        return result;
    }

}