import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 7, 3, 6, 5, 6 }, 3),
                new TestCase(new int[] { 1, 2, 3 }, -1),
                new TestCase(new int[] { 2, 1, -1 }, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.pivotIndex(test.in);
            assert test.expected == actual : "pivotIndex(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int pivotIndex(int[] nums) {
        int rightSumm = Arrays.stream(nums).sum();
        int leftSumm = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSumm -= nums[i];
            if (leftSumm == rightSumm) {
                return i;
            }
            leftSumm += nums[i];
        }
        return -1;
    }

}