import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, double expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2 }, { 3, 5 }, { 2, 2 } }, 2, 0.78333),
                new TestCase(new int[][] { { 2, 4 }, { 3, 9 }, { 4, 5 }, { 2, 10 } }, 4, 0.53485)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            double actual = (double) Math.round(s.maxAverageRatio(test.in1, test.in2) * 100_000) / 100_000;
            assert test.expected == actual : "maxAverageRatio(%s, %s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), test.in2, actual, test.expected);
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<RatioGain> queue = new PriorityQueue<>();
        for (int[] clazz : classes) {
            queue.offer(new RatioGain(clazz[0], clazz[1]));
        }
        for (; extraStudents > 0; extraStudents--) {
            RatioGain current = queue.poll();
            queue.offer(new RatioGain(current.pass() + 1, current.total() + 1));
        }
        double summ = 0d;
        while (!queue.isEmpty()) {
            RatioGain current = queue.poll();
            summ += current.getRatio();
        }
        return summ / classes.length;
    }

    private static record RatioGain(int pass, int total, double gain) implements Comparable<RatioGain> {

        RatioGain(int pass, int total) {
            this(pass, total, getGain(pass, total));
        }

        private static double getGain(int pass, int total) {
            return ((double) pass + 1) / (total + 1) - (double) pass / total;
        }

        @Override
        public int compareTo(RatioGain o) {
            return Double.compare(o.gain(), this.gain);
        }

        public double getRatio() {
            return (double) pass / total;
        }

    }

}