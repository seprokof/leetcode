import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 5, 1, 3, 4, 7 }, 3, new int[] { 2, 3, 5, 4, 1, 7 }),
                new TestCase(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4, new int[] { 1, 4, 2, 3, 3, 2, 4, 1 }),
                new TestCase(new int[] { 1, 1, 2, 2 }, 2, new int[] { 1, 2, 1, 2 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.shuffle(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "shuffle(%s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0, j = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[j];
            } else {
                result[i] = nums[j + n];
                j++;
            }
        }
        return result;
    }

}