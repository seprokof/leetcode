import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 11, 10, 1, 3 }, 10, 3),
                new TestCase(new int[] { 1, 1, 2, 4, 9 }, 1, 0),
                new TestCase(new int[] { 1, 1, 2, 4, 9 }, 9, 4)                
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in1, test.in2);
            assert test.expected == actual : "minOperations(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minOperations(int[] nums, int k) {
        int result = 0;
        for (int num : nums) {
            if (num < k) {
                result++;
            }
        }
        return result;
    }

}