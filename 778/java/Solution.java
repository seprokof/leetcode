import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 0, 2 }, { 1, 3 } }, 3),
                new TestCase(new int[][] { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 }, { 10, 9, 8, 7, 6 } }, 16)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.swimInWater(test.in);
            assert test.expected == actual : "swimInWater(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((l, r) -> l[2] - r[2]);
        int[][] directions = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[] { 0, 0, grid[0][0] });
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (x < 0 || x > n - 1 || y < 0 || y > n - 1 || visited[y][x]) {
                    continue;
                }
                int maxWater = Math.max(current[2], grid[y][x]);
                if (x == n - 1 && y == n - 1) {
                    return maxWater;
                }
                queue.offer(new int[] { x, y, maxWater });
                visited[y][x] = true;
            }
        }
        return -1;
    }

}