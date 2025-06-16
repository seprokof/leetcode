import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 7, 1, 5, 4 }, 4),
                new TestCase(new int[] { 9, 4, 3, 2 }, -1),
                new TestCase(new int[] { 1, 5, 2, 10 }, 9)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumDifference(test.in);
            assert test.expected == actual : "maximumDifference(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int maximumDifference(int[] nums) {
        int result = -1;
        int low = 0;
        for (int i = 1; i < nums.length; i++) {
            if (low < i && nums[low] < nums[i]) {
                result = Math.max(result, nums[i] - nums[low]);
            } else {
                low = i;
            }
        }
        return result;
    }

}