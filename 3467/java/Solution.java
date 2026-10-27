import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 3, 2, 1 }, new int[] { 0, 0, 1, 1 }),
                new TestCase(new int[] { 1, 5, 1, 4, 2 }, new int[] { 0, 0, 1, 1, 1 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.transformArray(Arrays.copyOf(test.in, test.in.length));
            assert Arrays.equals(test.expected, actual) : "transformArray(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] transformArray(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                nums[i++] = 0;
            }
        }
        while (i < nums.length) {
            nums[i++] = 1;
        }
        return nums;
    }

}