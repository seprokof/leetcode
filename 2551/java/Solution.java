import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 5, 1 }, 2, 4L),
                new TestCase(new int[] { 1, 3 }, 2, 0L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.putMarbles(test.in1, test.in2);
            assert test.expected == actual : "putMarbles(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public long putMarbles(int[] weights, int k) {
        int[] pairWeights = new int[weights.length - 1];
        for (int i = 0; i < pairWeights.length; i++) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairWeights);
        long result = 0L;
        for (int i = 0; i < k - 1; i++) {
            result += pairWeights[weights.length - 2 - i] - pairWeights[i];
        }
        return result;
    }

}