import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } }, 2),
                new TestCase(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } }, 1),
                new TestCase(new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } }, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.closedIsland(test.in);
            assert test.expected == actual : "closedIsland(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0 && !visited[row][col] && bfs(row, col, visited, grid)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static final int[][] DIRECTIONS = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    private static boolean bfs(int row, int col, boolean[][] visited, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { col, row });
        visited[row][col] = true;
        boolean closedIsland = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int x = pos[0] + direction[0];
                int y = pos[1] + direction[1];
                if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length) {
                    closedIsland = false;
                } else if (grid[y][x] == 0 && !visited[y][x]) {
                    queue.offer(new int[] { x, y });
                    visited[y][x] = true;
                }
            }
        }
        return closedIsland;
    }

}