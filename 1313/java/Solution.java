import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 4, 4 }),
                new TestCase(new int[] { 1, 1, 2, 3 }, new int[] { 1, 3, 3 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.decompressRLElist(test.in);
            assert Arrays.equals(test.expected, actual) : "decompressRLElist(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                size += nums[i];
            }
        }
        int[] result = new int[size];
        int j = 0;
        for (int i = 1; i < nums.length; i += 2) {
            Arrays.fill(result, j, j + nums[i - 1], nums[i]);
            j += nums[i - 1];
        }
        return result;
    }

}