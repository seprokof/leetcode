import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 3, 5, 9 }, 2, 5),
                new TestCase(new int[] { 2, 7, 9, 3, 1 }, 2, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minCapability(test.in1, test.in2);
            assert test.expected == actual : "minCapability(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minCapability(int[] nums, int k) {
        int min = 1;
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            int robCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    robCount++;
                    i++;
                }
            }
            if (robCount >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

}