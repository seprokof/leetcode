import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 9, 7 }, 5, 4),
                new TestCase(new int[] { 4, 1, 3 }, 4, 0),
                new TestCase(new int[] { 3, 2 }, 6, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in1, test.in2);
            assert test.expected == actual : "minOperations(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }

}