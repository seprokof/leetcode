import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }, 3),
                new TestCase(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2 } }, 4),
                
                new TestCase(new int[][] { { 1, 2 }, { 1, 2 }, { 3, 3 }, { 1, 5 }, { 1, 5 } }, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxEvents(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "maxEvents(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int maxEvents(int[][] events) {
        int lastDay = 0;
        for (int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }
        Arrays.sort(events, (l, r) -> l[0] - r[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result = 0;
        for (int i = 1, j = 0; i <= lastDay; i++) {
            for (; j < events.length && events[j][0] <= i; j++) {
                queue.offer(events[j][1]);
            }
            while (!queue.isEmpty() && queue.peek() < i) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                queue.poll();
                result++;
            }
        }
        return result;
    }

}