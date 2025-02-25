import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 4 }, 2, 4),
                new TestCase(new int[] { 1, 2 }, 2, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findPoisonedDuration(test.in1, test.in2);
            assert test.expected == actual : "findPoisonedDuration(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            result += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return result + duration;
    }

}