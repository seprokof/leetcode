import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 2, 1 }, 3),
                new TestCase(new int[] { 3, 1, 1, 2 }, 4),
                new TestCase(new int[] { 3, 1, 5, 4, 2 }, 7)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minNumberOperations(test.in);
            assert test.expected == actual : "minNumberOperations(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minNumberOperations(int[] target) {
        int result = target[0];
        for (int i = 1; i < target.length; i++) {
            result += Math.max(target[i] - target[i - 1], 0);
        }
        return result;
    }

}