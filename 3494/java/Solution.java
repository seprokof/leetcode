import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 5, 2, 4 }, new int[] { 5, 1, 4, 2 }, 110L),
                new TestCase(new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 }, 5L),
                new TestCase(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2 }, 21L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.minTime(test.in1, test.in2);
            assert test.expected == actual : "minTime(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] freeTime = new long[n];
        for (int j = 0; j < mana.length; j++) {
            long currentTime = 0L;
            for (int i = 0; i < n; i++) {
                currentTime = Math.max(currentTime, freeTime[i]) + skill[i] * mana[j] * 1L;
            }
            freeTime[n - 1] = currentTime;
            for (int i = n - 2; i >= 0; i--) {
                freeTime[i] = freeTime[i + 1] - skill[i + 1] * mana[j] * 1L;
            }
        }
        return freeTime[n - 1];
    }

}