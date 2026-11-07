import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 3, 2 }, new int[] { 1, 2, 3, 2, 1, 2 }, new int[] { 2, 2, 0, 2, 1, 2 }),
                new TestCase(new int[] { 5, 1, 4, 3, 2 }, new int[] { 2, 1, 2, 4, 5, 2, 1 }, new int[] { 1, 4, 1, 4, 1, 3, 2 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.assignTasks(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "assignTasks(%s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        Comparator<int[]> comparator = (l, r) -> l[0] == r[0] ? l[1] - r[1] : l[0] - r[0];
        PriorityQueue<int[]> free = new PriorityQueue<>(comparator); // server weight, server index
        for (int i = 0; i < servers.length; i++) {
            free.offer(new int[] { servers[i], i });
        }
        int time = 0;
        PriorityQueue<int[]> busy = new PriorityQueue<>(comparator); // task end time, server index
        int[] result = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);
            freeServers(busy, free, servers, time);
            if (free.isEmpty()) {
                time = busy.peek()[0];
                freeServers(busy, free, servers, time);
            }
            int[] server = free.poll();
            int serverIdx = server[1];
            result[i] = serverIdx;
            busy.offer(new int[] { time + tasks[i], serverIdx });
        }
        return result;
    }

    private static void freeServers(PriorityQueue<int[]> busy, PriorityQueue<int[]> free, int[] servers, int time) {
        while (!busy.isEmpty() && busy.peek()[0] <= time) {
            int serverIdx = busy.poll()[1];
            free.offer(new int[] { servers[serverIdx], serverIdx });
        }
    }

}