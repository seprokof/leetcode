import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int[] in3, int[] in4, int expected) {}

        TestCase[] tests = {
                new TestCase(5, 1, new int[] { 1, 3 }, new int[] { 2, 5 }, 2),
                new TestCase(10, 1, new int[] { 0, 2, 9 }, new int[] { 1, 4, 10 }, 6),
                new TestCase(5, 2, new int[] { 0, 1, 2, 3, 4 }, new int[] { 1, 2, 3, 4, 5 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxFreeTime(test.in1, test.in2, test.in3, test.in4);
            assert test.expected == actual : "maxFreeTime(%s, %s, %s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    Arrays.toString(test.in3), Arrays.toString(test.in4), actual, test.expected);
        }
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int totalDuration = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            totalDuration += endTime[i] - startTime[i];
            int left = i <= k - 1 ? 0 : endTime[i - k];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            max = Math.max(max, right - left - totalDuration);
            if (i >= k - 1) {
                totalDuration -= endTime[i - k + 1] - startTime[i - k + 1];
            }
        }
        return max;
    }

}