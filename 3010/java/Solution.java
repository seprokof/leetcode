import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 12 }, 6),
                new TestCase(new int[] { 5, 4, 3 }, 12),
                new TestCase(new int[] { 10, 3, 1, 1 }, 12)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumCost(test.in);
            assert test.expected == actual : "minimumCost(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int minimumCost(int[] nums) {
        int min1 = 51;
        int min2 = 51;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= min2) {
                if (nums[i] <= min1) {
                    min2 = min1;
                    min1 = nums[i];
                } else {
                    min2 = nums[i];
                }
            }
        }
        return nums[0] + min1 + min2;
    }

}