import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } }, 4),
                new TestCase(new int[][] { { 1, 3, 2 }, { 4, 5, 2 }, { 1, 5, 5 } }, 5),
                new TestCase(new int[][] { { 1, 5, 3 }, { 1, 5, 1 }, { 6, 6, 5 } }, 8)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxTwoEvents(test.in);
            assert test.expected == actual : "maxTwoEvents(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((l, r) -> l[1] - r[1]);
        Arrays.sort(events, (l, r) -> l[0] - r[0]);
        int maxItem = 0;
        int result = 0;
        for (int[] event : events) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] < event[0]) {
                maxItem = Math.max(maxItem, priorityQueue.poll()[2]);
            }
            result = Math.max(result, maxItem + event[2]);
            priorityQueue.offer(event);
        }
        return result;
    }

}