import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, -2, 1, 1 }, new int[] { 1, 1, 1, 3 }),
                new TestCase(new int[] { -1, 4, -1 }, new int[] { -1, -1, 4 })
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.constructTransformedArray(test.in);
            assert Arrays.equals(test.expected, actual) : "constructTransformedArray(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = nums[((i + nums[i]) % len + len) % len];
        }
        return result;
    }

}