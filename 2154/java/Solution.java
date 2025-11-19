import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 3, 6, 1, 12 }, 3, 24),
                new TestCase(new int[] { 2, 7, 9 }, 4, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findFinalValue(test.in1, test.in2);
            assert test.expected == actual : "findFinalValue(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int findFinalValue(int[] nums, int original) {
        boolean[] values = new boolean[1001];
        for (int num : nums) {
            values[num] = true;
        }
        while (original < 1001 && values[original]) {
            original *= 2;
        }
        return original;
    }

}