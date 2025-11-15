import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, 3),
                new TestCase(new int[] { 3, 6, 9 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumOperations(test.in);
            assert test.expected == actual : "minimumOperations(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minimumOperations(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (num % 3 != 0) {
                result++;
            }
        }
        return result;
    }

}