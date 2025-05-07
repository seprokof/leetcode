import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 0, 4 }, { 4, 4 } }, 6),
                new TestCase(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 3),
                new TestCase(new int[][] { { 0, 1 }, { 1, 2 } }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minTimeToReach(test.in);
            assert test.expected == actual : "minTimeToReach(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] times = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }
        times[0][0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((l, r) -> l[2] - r[2]);
        queue.offer(new int[] { 0, 0, 0 });
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == n - 1 && current[1] == m - 1) {
                return current[2];
            }
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (x == -1 || x == n || y == -1 || y == m) {
                    continue;
                }
                int time = Math.max(moveTime[x][y], current[2]) + 1;
                if (time < times[x][y]) {
                    times[x][y] = time;
                    queue.offer(new int[] { x, y, times[x][y] });
                }
            }
        }
        return -1;
    }

}