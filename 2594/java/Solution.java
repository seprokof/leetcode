import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 2, 3, 1 }, 10, 16L),
                new TestCase(new int[] { 5, 1, 8 }, 6, 16L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.repairCars(test.in1, test.in2);
            assert test.expected == actual : "repairCars(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public long repairCars(int[] ranks, int cars) {
        int minRank = Integer.MAX_VALUE;
        int maxRank = Integer.MIN_VALUE;
        for (int r : ranks) {
            minRank = Math.min(r, minRank);
            maxRank = Math.max(r, maxRank);
        }
        int[] rankFrequency = new int[maxRank + 1];
        for (int r : ranks) {
            rankFrequency[r]++;
        }

        long minTime = 1L;
        long maxTime = (long) minRank * cars * cars;
        while (minTime < maxTime) {
            long midTime = minTime + (maxTime - minTime) / 2;
            long countRepaired = 0;
            for (int r = 1; r < rankFrequency.length; r++) {
                countRepaired += rankFrequency[r] * (long) Math.sqrt(midTime / r);
            }
            if (countRepaired >= cars) {
                maxTime = midTime;
            } else {
                minTime = midTime + 1;
            }
        }
        return minTime;
    }

}