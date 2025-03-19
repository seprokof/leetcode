import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 1, 1, 0, 0 }, 3),
                new TestCase(new int[] { 0, 1, 1, 1 }, -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "minOperations(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minOperations(int[] nums) {
        int opCount = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                opCount++;
            }
        }
        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) {
            opCount = -1;
        }
        return opCount;
    }

}