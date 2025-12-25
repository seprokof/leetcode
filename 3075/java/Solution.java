import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 2, 4L),
                new TestCase(new int[] { 1, 1, 1, 1 }, 2, 1L),
                new TestCase(new int[] { 2, 3, 4, 5 }, 1, 5L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.maximumHappinessSum(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert test.expected == actual : "maximumHappinessSum(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long result = 0L;
        for (int i = happiness.length - 1, j = k; j > 0; i--, j--) {
            int value = happiness[i] - (happiness.length - 1 - i);
            if (value <= 0) {
                break;
            }
            result += value;
        }
        return result;
    }

}