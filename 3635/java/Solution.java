import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[] in3, int[] in4, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 8 }, new int[] { 4, 1 }, new int[] { 6 }, new int[] { 3 }, 9),
                new TestCase(new int[] { 5 }, new int[] { 3 }, new int[] { 1 }, new int[] { 10 }, 14)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.earliestFinishTime(test.in1, test.in2, test.in3, test.in4);
            assert test.expected == actual : "earliestFinishTime(%s, %s, %s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(test.in3),
                    Arrays.toString(test.in4), actual, test.expected);
        }
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int lantToWaterMinTime = getMinTime(landStartTime, landDuration, waterStartTime, waterDuration);
        int waterToLandMinTime = getMinTime(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(lantToWaterMinTime, waterToLandMinTime);
    }

    private static int getMinTime(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int minEnd1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            minEnd1 = Math.min(minEnd1, start1[i] + duration1[i]);
        }
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            minTime = Math.min(minTime, Math.max(minEnd1, start2[i]) + duration2[i]);
        }
        return minTime;
    }

}