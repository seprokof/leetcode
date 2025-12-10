import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 2),
                new TestCase(new int[] { 3, 3, 3, 4, 4, 4 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countPermutations(test.in);
            assert test.expected == actual : "countPermutations(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    private static final long MODULO = 1_000_000_007L;

    public int countPermutations(int[] complexity) {
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        long result = 1L;
        for (int i = 2; i < complexity.length; i++) {
            result = result * i % MODULO;
        }
        return (int) result;
    }

}