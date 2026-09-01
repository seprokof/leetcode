import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(10, new int[][] { { 0, 3 }, { 2, 5 }, { 0, 9 }, { 1, 15 } }, 1),
                new TestCase(26, new int[][] { { 1, 1 }, { 3, 7 }, { 2, 12 }, { 7, 17 } }, 3),
                new TestCase(2, new int[][] { { 0, 10 }, { 1, 20 } }, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.hardestWorker(test.in1, test.in2);
            assert test.expected == actual : "hardestWorker(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int hardestWorker(int n, int[][] logs) {
        int start = 0;
        int maxTime = 0;
        int worker = logs[0][0];
        for (int[] log : logs) {
            int time = log[1] - start;
            if (time > maxTime) {
                maxTime = time;
                worker = log[0];
            } else if (time == maxTime) {
                worker = Math.min(worker, log[0]);
            }
            start = log[1];
        }
        return worker;
    }

}