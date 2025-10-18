import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 3, 3, 4 }, 2, 6),
                new TestCase(new int[] { 4, 4, 4, 4 }, 1, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxDistinctElements(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert test.expected == actual : "maxDistinctElements(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int previous = Integer.MIN_VALUE;
        int result = 0;
        for (int num : nums) {
            int current = Math.max(num - k, previous + 1);
            if (current <= num + k) {
                result++;
                previous = current;
            }
        }
        return result;
    }

}